import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.ListSelectionListener;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class MainChat extends JFrame {
	private JCustomTextField txtAddUser;
	private JCustomTextField txtMessenger;
	private JList<String> listUser;
	private JList<String> listMessenger;
	private JScrollPane scpUser;
	private JScrollPane scpMessenger;
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
		addWindowListener(new WindowAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void windowActivated(WindowEvent arg0) {
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
					
					String temp = in.readLine().trim();
					//System.out.println(temp);
					ArrayList<String> node = (ArrayList<String>)new Gson().fromJson(temp,new TypeToken<ArrayList<String>>() {}.getType());
					if(node != null)
						for (String string : node) {
							dlmUser.addElement(string);
						}
					
					new Thread() {
						public void run() {
							while(true) {
								// user_selected
								try {
									String temp = in.readLine();
									
									if(temp==null) ;
									else if(temp.indexOf("\t_-_\t")==-1) ;
									else if(temp.split("\t_-_\t")[1].equals(user_selected)) {
										dlmMessenger.addElement(temp.split("\t_-_\t")[0]);
										PrintStream out = new PrintStream(sk.getOutputStream());
										out.println("okay");
										out.flush();
										out.close();
									}else if(dlmUser.indexOf(temp.split("\t_-_\t")[1]) != -1) {
										dlmUser.addElement(temp.split("\t_-_\t")[1]);
									}
								} catch (Exception e) {
									e.printStackTrace();
									//return;
								}
							}
						};
					}.start();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					sk.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setTitle("Chat of " + user);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);
		
		txtAddUser = new JCustomTextField();
		txtAddUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(!txtAddUser.getText().equals("") && arg0.getKeyCode() == KeyEvent.VK_ENTER && !searchItemsUser(dlmUser,txtAddUser.getText())) {
					dlmUser.addElement(user+", "+txtAddUser.getText());
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
		txtAddUser.setToolTipText("Thêm nick/nhóm chat (cách dấu ',')...");
		
		listUser = new JList<String>(dlmUser);
		
		
		listUser.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				user_selected  = listUser.getSelectedValue();
			}
		});
		listUser.setBounds(0, 19, 149, 542);
		// getContentPane().add(listUser);
		
		scpUser = new JScrollPane();
		scpUser.setBounds(0, 19, 150, 542);
		scpUser.getViewport().add(listUser);
		getContentPane().add(scpUser);
		
		txtMessenger = new JCustomTextField();
		txtMessenger.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (!txtMessenger.getText().equals("") && arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					//dlmMessenger.addElement(user +": " + txtMessenger.getText());
					
					sendToServer();
					txtMessenger.setText("");
				}
			}

			private void sendToServer() {
				if(user_selected.equals("")) return;
				try {
					PrintStream out = new PrintStream(sk.getOutputStream());
					System.out.println("sap gui tin qua ");
					out.println(user + ": " + txtMessenger.getText() + "\t_-_\t" + user_selected);
					System.out.println("da gui tin nhan cho server");
				} catch (Exception e) {
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
		
		scpMessenger = new JScrollPane();
		scpMessenger.setBounds(148, 0, 436, 543);
		scpMessenger.getViewport().add(listMessenger);
		getContentPane().add(scpMessenger);
		
	}
}