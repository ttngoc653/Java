import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

class ThreadGetConversation extends Thread{
	private DefaultListModel<String> dlm;
	private Socket sk;
	public ThreadGetConversation(DefaultListModel<String> _dlm, Socket _sk) {
		dlm = _dlm;
		sk = _sk;
	}
	public void run() {
		
	}
}

@SuppressWarnings("serial")
public class MainChat extends JFrame {
	private JCustomTextField txtAddUser;
	private JCustomTextField txtMessenger;
	private JList<String> listUser;
	private JList<String> listMessenger;
	private DefaultListModel<String> dlmMessenger = new DefaultListModel<>();
	private DefaultListModel<String> dlmUser = new DefaultListModel<>();
	protected String user_selected = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainChat frame = new MainChat(null, "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainChat(Socket sk, String user) {
		setTitle("Chat of " + user);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);
		
		txtAddUser = new JCustomTextField();
		txtAddUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(!txtAddUser.getText().equals("") && arg0.getKeyCode() == KeyEvent.VK_ENTER && !searchItemsUser(dlmUser,txtAddUser.getText())) {
					dlmUser.addElement(txtAddUser.getText());
					txtAddUser.setText("");
				}
			}

			private boolean searchItemsUser(DefaultListModel<String> dlm,String userAdd) {
				for (int i = 0; i < dlm.getSize(); i++)
					if(dlm.get(i).equals(userAdd)) return true;
				return false;
			}
		});
		txtAddUser.setBounds(0, 0, 150, 20);
		getContentPane().add(txtAddUser);
		txtAddUser.setColumns(10);
		txtAddUser.setPlaceholder("Thêm nick/nhóm chat (cách dấu ',')...");
		
		listUser = new JList<String>(dlmUser);
		listUser.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				user_selected  = listUser.getSelectedValue();
				
				
			}
		});
		listUser.setBounds(0, 19, 149, 542);
		getContentPane().add(listUser);
		
		txtMessenger = new JCustomTextField();
		txtMessenger.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (!txtMessenger.getText().equals("") && arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					dlmMessenger.addElement(user +": " + txtMessenger.getText());
					
					sendToServer();
				}
			}

			private void sendToServer() {
				if(user_selected.equals("")) return;
				try {
					DataOutputStream out = new DataOutputStream(sk.getOutputStream());
					out.writeUTF(user + ": " + txtMessenger.getText() + "\t_-_\t" + dlmUser + ", " + user);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		txtMessenger.setBounds(150, 541, 434, 20);
		getContentPane().add(txtMessenger);
		txtMessenger.setColumns(10);
		txtMessenger.setPlaceholder("Tin nhắn của bạn...");
		
		listMessenger = new JList<String>(dlmMessenger);
		listMessenger.setBounds(150, 0, 434, 540);
		getContentPane().add(listMessenger);
	}
}