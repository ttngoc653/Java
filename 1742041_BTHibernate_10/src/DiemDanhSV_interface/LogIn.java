package DiemDanhSV_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DiemDanhSV_class.Nguoidung;
import DiemDanhSV_process.NguoiDungProcess;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class LogIn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblngNhpVo = new JLabel("\u0110\u0102NG NH\u1EACP V\u00C0O H\u1EC6 TH\u1ED0NG");
		lblngNhpVo.setHorizontalAlignment(SwingConstants.CENTER);
		lblngNhpVo.setFont(new Font("Sitka Heading", Font.BOLD, 16));
		lblngNhpVo.setBounds(10, 11, 284, 21);
		contentPane.add(lblngNhpVo);
		
		txtUser = new JTextField();
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setFont(new Font("Sitka Text", Font.BOLD, 16));
		txtUser.setBounds(30, 68, 243, 27);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 43, 263, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 106, 263, 21);
		contentPane.add(lblNewLabel_1);
		
		txtPass = new JPasswordField();
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		txtPass.setEchoChar('_');
		txtPass.setFont(new Font("Sitka Text", Font.BOLD, 16));
		txtPass.setBounds(30, 131, 243, 27);
		contentPane.add(txtPass);
		
		JButton btnLogin = new JButton("\u0110\u0102NG NH\u1EACP");
		btnLogin.setFont(new Font("Sitka Banner", Font.BOLD, 15));
		btnLogin.setBounds(89, 218, 125, 33);
		contentPane.add(btnLogin);
		
		JLabel lblNote = new JLabel("\u0110ang ch\u1EDD \u0111\u0103ng nh\u1EADp...");
		lblNote.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setBounds(30, 180, 243, 27);
		contentPane.add(lblNote);
		

		btnLogin.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//NguoiDungProcess.create(new Nguoidung("1742041",1));
				
				Nguoidung nd = NguoiDungProcess.login(new Nguoidung(txtUser.getText(),txtPass.getText()));
				lblNote.setText("Kết nối database xong.");
				if(nd == null) {
					lblNote.setForeground(Color.RED);
					lblNote.setText("Sai tài khoản.");
				}else {
					lblNote.setForeground(Color.GREEN);
					lblNote.setText("Đăng nhập thành công.");
					TuyChon tc = new TuyChon(nd);
					tc.setVisible(true);
					dispose();
				}
			}
		});
	}
}