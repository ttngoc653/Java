import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

class User{
	public String name;
	public Socket socket;
	
	public User(String name,Socket sk) {
		this.name = name;
		this.socket = sk;
	}
}

class Conversation{
	public String users;
	public List<String> messengers;
	
	public Conversation(String _users, List<String> _messengers) {
		users = _users;
		messengers = _messengers;
	}
}

class ThreadLogin extends Thread {
	private ServerSocket server;
	private Socket sk;
	
	List<User> list_user;
	List<Conversation> list_conversation;
	private Gson gson;
	
	public ThreadLogin(List<User> users, List<Conversation> conversations) {
		list_user = users;
		list_conversation = conversations;
	}
	
	@Override
	public void run() {
			try {
				server = new ServerSocket(8605);
				System.out.println("IP OF SERVER: " + InetAddress.getLocalHost().getHostAddress());

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("ERROR WHEN CREATE SERVER CHAT!");
				return;
			}
			
			
			while(true) {
				try {
					sk = server.accept();
					//System.out.println(sk.getPort() + " - "+ sk.getInetAddress().getHostAddress() +" - "+sk.getLocalAddress().getHostAddress());
					//System.out.println("da tiep nhan");
					
					BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream(),"UTF-8"));
				    
					gson=new Gson();
				    //java.lang.reflect.Type type=new TypeToken<ArrayList<String>>(){}.getType();
					String user_name = gson.fromJson(in.readLine(),String.class).trim();
					
					System.out.println("Received: "+user_name);
					
					Boolean equal = false;
					for (User user : list_user)
						if(user.name.equalsIgnoreCase(user_name))
							equal = true;
					
					PrintStream out = new PrintStream(sk.getOutputStream());
					out.println(gson.toJson((!equal ? "y" : "n"), String.class));
					out.flush();
					if(equal) sk.close();
					else {
						System.out.println("Added " + user_name + "to  server!");
						list_user.add(new User(user_name,sk));
						
						List<String> conversastion_name = new ArrayList<>();
						
						for (Conversation conversation : list_conversation)
							for(int i=0;i< conversation.users.split(", ").length;i++)
								if(conversation.users.split(", ")[i].equals(user_name))
									conversastion_name.add(conversation.users);
						
					    out.println(gson.toJson(conversastion_name));
						out.flush();
					    System.out.println(user_name + "đã vào lấy tin nhắn");
						ThreadReceiveMessenge th = new ThreadReceiveMessenge(user_name, sk, list_user, list_conversation);
						th.start();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
}

class ThreadReceiveMessenge extends Thread {
	private Gson gson = new Gson();
	
	public ThreadReceiveMessenge(String user, Socket sk, List<User> list, List<Conversation> conversations) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));  
		
		while(true) {
			try {
				System.out.println("cho tin chuyen ve cua "+user);
				String info = in.readLine();
				System.out.println(info);
				if(info.split("\t_-_\t").length == 2) {
					sentInfoMessenges(list,info);
					
					for(int i =0 ;i<conversations.size();i++) {
						if(conversations.get(i).users.equals(info.split("\t_-_\t")[1])) {
							conversations.get(i).messengers.add(info.split("\t_-_\t")[0]);
							// return;
						}
					}
					List<String> messen = new ArrayList<>();
					messen.add(info.split(" \t\t ")[0]);
					
					Conversation cvs= new Conversation(info.split("\t_-_\t")[1], messen);
					conversations.add(cvs);
				} else {
					PrintStream out = new PrintStream(sk.getOutputStream());
					for(int i =0 ;i<conversations.size();i++) {
						if(conversations.get(i).users.equals(info.split("\t_-_\t")[1])) {
							out.println(gson.toJson(conversations.get(i).messengers));
							out.flush();
							break;
						}
					}
					out.println(gson.toJson(new ArrayList<String>()));
					out.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
				list.remove(new User(user,sk));
				return;
			}
		}
	}
	private void sentInfoMessenges(List<User> list, String info) {
		for (String str : info.split("\t_-_\t")[1].split(", ")) {
			PrintStream out;
			
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).name.equalsIgnoreCase(str.trim())) {
					try {
						out = new PrintStream(list.get(i).socket.getOutputStream());
						System.out.println(list.get(i).name + " - " + info);
						out.println(info);
						out.flush();
						BufferedReader in = new BufferedReader(new InputStreamReader(list.get(i).socket.getInputStream()));
						System.out.println(in.readLine());
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

public class mainServer {
	public static void main(String[] args) {
		List<User> user = new ArrayList<>();
		List<Conversation> conversation = new ArrayList<>();
		
		ThreadLogin login = new ThreadLogin(user, conversation);
		login.start();
	}

}
