import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
	
	public ThreadLogin(List<User> users, List<Conversation> conversations) {
		list_user = users;
		list_conversation = conversations;
	}
	
	@Override
	public void run() {
		try {
			server = new ServerSocket(8605);
			
			System.out.println("IP OF SERVER: " + InetAddress.getLocalHost().getHostAddress());
			
			while(true) {
				sk = server.accept();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));  
				String user_name = in.readLine();
				
				Boolean equal = false;
				for (User user : list_user)
					if(user.name.equalsIgnoreCase(user_name))
						equal = true;
				
				DataOutputStream out = new DataOutputStream(sk.getOutputStream());
				out.writeUTF(equal ? "y" : "n");
				if(equal) sk.close();
				else {
					list_user.add(new User(user_name,sk));
					ThreadReceiveMessenge th = new ThreadReceiveMessenge(sk, list_user);
					th.run();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ThreadReceiveMessenge extends Thread {
	public ThreadReceiveMessenge(Socket sk, List<User> list) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));  
		
		while(true) {
			try {
				String info = in.readLine();
				
				//format info: "<user sent messenger>: <content messenger> \t <group receive messenger>"
				sentInfoMessenges(list,info);
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
						out.writeUTF(info);
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
