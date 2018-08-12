import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class LogIn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIP;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("K\u1EBFt n\u1ED1i Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblaChIp = new JLabel("\u0110\u1ECBa ch\u1EC9 IP server:");
		lblaChIp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaChIp.setBounds(10, 55, 132, 17);
		contentPane.add(lblaChIp);
		
		JLabel lblNickNameCa = new JLabel("Nick name c\u1EE7a b\u1EA1n:");
		lblNickNameCa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNickNameCa.setBounds(10, 89, 132, 17);
		contentPane.add(lblNickNameCa);
		
		txtIP = new JTextField();
		txtIP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIP.setBounds(152, 52, 220, 23);
		contentPane.add(txtIP);
		txtIP.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(152, 86, 220, 23);
		contentPane.add(txtName);
		
		JButton btnVoChatNgay = new JButton("V\u00E0o Chat Ngay");
		btnVoChatNgay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InetAddress ia;
				try {
					ia = InetAddress.getByName(txtIP.getText());

					connectDatabase(ia);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
			}
		});
		btnVoChatNgay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		btnVoChatNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoChatNgay.setBounds(116, 121, 150, 25);
		contentPane.add(btnVoChatNgay);
		
		JLabel lblNewLabel = new JLabel("K\u1EBET N\u1ED0I V\u00C0O TR\u00D2 CHUY\u1EC6N");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 362, 33);
		contentPane.add(lblNewLabel);
	}

	private static Gson gson = new Gson();
	
	protected void connectDatabase(InetAddress ia){
		try {
			Socket sk = new Socket(txtIP.getText(), 8605);
			PrintStream out = new PrintStream(sk.getOutputStream());
			
			out.println(gson.toJson(txtName.getText().trim(), String.class));
			
			System.out.println("da gui ten cho server " + txtName.getText().trim());
			
			BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));  
			String check = gson.fromJson(in.readLine(),String.class);
			System.out.println("server da xet cho nguoi dung");
			
			// out.close();
			// in.close();
			
			if(check.equalsIgnoreCase("y")) {
				MainChat mc = new MainChat(sk,txtName.getText().trim());
				mc.setVisible(true);
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, txtName.getText().trim() + " bị trùng tên. Hãy đặt tên nick khác", "KHÔNG VÀO ĐƯỢC", 0);
				sk.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
