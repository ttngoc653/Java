import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
			}
			
			
			while(true) {
				try {
					sk = server.accept();
	
					//System.out.println("da tiep nhan");
					
					BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream(),"UTF-8"));
				    
					gson=new Gson();
				    //java.lang.reflect.Type type=new TypeToken<ArrayList<String>>(){}.getType();
					String user_name = gson.fromJson(in.readLine(),String.class);
					
					System.out.println("da tiep nhan "+user_name);
					
					Boolean equal = false;
					for (User user : list_user)
						if(user.name.equalsIgnoreCase(user_name))
							equal = true;
					
					DataOutputStream out = new DataOutputStream(sk.getOutputStream());
					out.writeBytes((equal ? "y" : "n")+'n');
					if(equal) sk.close();
					else {
						list_user.add(new User(user_name,sk));
						ThreadReceiveMessenge th = new ThreadReceiveMessenge(sk, list_user, list_conversation);
						th.run();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
}

class ThreadReceiveMessenge extends Thread {
	public ThreadReceiveMessenge(Socket sk, List<User> list, List<Conversation> conversations) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));  
		
		while(true) {
			try {
				String info = in.readLine();
				
				if(info.split("\t_-_\t").length == 2) {
				//format info: "<user sent messenger>: <content messenger> \t\t <group receive messenger>"
					sentInfoMessenges(list,info);
					
					for(int i =0 ;i<conversations.size();i++) {
						if(conversations.get(i).users.equals(info.split("\t_-_\t")[1])) {
							conversations.get(i).messengers.add(info.split("\t_-_\t")[0]);
							break;
						}
					}
					List<String> messen = new ArrayList<>();
					messen.add(info.split(" \t\t ")[0]);
					
					Conversation cvs= new Conversation(info.split("\t_-_\t")[1]+", "+info.split(": ")[0], messen);
					conversations.add(cvs);
				} else {
					DataOutputStream out = new DataOutputStream(sk.getOutputStream());
					for(int i =0 ;i<conversations.size();i++) {
						if(conversations.get(i).users.equals(info.split("\t_-_\t")[1])) {
							for (int j = conversations.get(i).messengers.size(); j >= 0; j--) {
								out.writeUTF(conversations.get(i).messengers.get(i));
							}
							out.writeUTF("end");
							break;
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void sentInfoMessenges(List<User> list, String info) {
		for (String str : info.split(" \t ")[1].split(",")) {
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).name.equalsIgnoreCase(str)) {
					DataOutputStream out;
					try {
						out = new DataOutputStream(list.get(i).socket.getOutputStream());
						out.writeUTF(info+", "+info.split(": ")[0]);
						out.close();
					} catch (IOException e) {
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
		login.run();
	}

}
