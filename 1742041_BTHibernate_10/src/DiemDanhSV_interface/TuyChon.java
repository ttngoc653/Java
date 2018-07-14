package DiemDanhSV_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DiemDanhSV_class.Nguoidung;
import DiemDanhSV_process.NguoiDungProcess;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class classEvent implements ActionListener{
		@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			//................
			String str = e.getActionCommand();
			JOptionPane.showInternalMessageDialog(null, str,"thông báo", JOptionPane.DEFAULT_OPTION);
			if (str.equals("button1"))
			{
				//.....................
				System.out.println("Process for button1");
			} else if (str.equals("button2"))
				{
					//......................
					System.out.println("Process for button2");
				}
		
	}

}

public class TuyChon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TuyChon frame = new TuyChon(null);
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
	public TuyChon(Nguoidung nd) {
		setResizable(false);
		setTitle("\u0110I\u1EC2M DANH SINH VI\u00CAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{48, 0, 0, 0, 0, 0, 0, 0, 48};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblLoiChao = new JLabel("Xin ch\u00E0o!");
		lblLoiChao.setFont(new Font("Sitka Display", Font.BOLD, 15));
		GridBagConstraints gbc_lblLoiChao = new GridBagConstraints();
		gbc_lblLoiChao.gridwidth = 9;
		gbc_lblLoiChao.insets = new Insets(0, 0, 5, 5);
		gbc_lblLoiChao.gridx = 0;
		gbc_lblLoiChao.gridy = 0;
		contentPane.add(lblLoiChao, gbc_lblLoiChao);
		
		JLabel lblNewLabel_1 = new JLabel("CH\u1ECCN CH\u1EE8C N\u0102NG:");
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 9;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnSuaTen = new JButton("S\u1EEDa T\u00EAn");
		btnSuaTen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nd.setHoTen(JOptionPane.showInputDialog(null, "Nhập tên hiển thị: ","ĐỔI TÊN",JOptionPane.DEFAULT_OPTION));
				NguoiDungProcess.update(nd);
			}
		});
		btnSuaTen.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		GridBagConstraints gbc_btnSuaTen = new GridBagConstraints();
		gbc_btnSuaTen.gridwidth = 7;
		gbc_btnSuaTen.insets = new Insets(0, 0, 5, 5);
		gbc_btnSuaTen.gridx = 1;
		gbc_btnSuaTen.gridy = 2;
		contentPane.add(btnSuaTen, gbc_btnSuaTen);
		
		JButton btnDoiMK = new JButton("\u0110\u1ED5i M\u1EADt kh\u1EA9u");
		btnDoiMK.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		GridBagConstraints gbc_btnDoiMK = new GridBagConstraints();
		gbc_btnDoiMK.gridwidth = 7;
		gbc_btnDoiMK.insets = new Insets(0, 0, 5, 5);
		gbc_btnDoiMK.gridx = 1;
		gbc_btnDoiMK.gridy = 3;
		contentPane.add(btnDoiMK, gbc_btnDoiMK);
		
		JButton btnFunc1 = new JButton("Ch\u1EE9c N\u0103ng 1");
		btnFunc1.setFont(new Font("Sitka Text", Font.BOLD, 16));
		GridBagConstraints gbc_btnFunc1 = new GridBagConstraints();
		gbc_btnFunc1.gridwidth = 7;
		gbc_btnFunc1.insets = new Insets(0, 0, 5, 5);
		gbc_btnFunc1.gridx = 1;
		gbc_btnFunc1.gridy = 4;
		contentPane.add(btnFunc1, gbc_btnFunc1);
		
		JButton btnFunc2 = new JButton("Ch\u1EE9c N\u0103ng 2");
		btnFunc2.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		GridBagConstraints gbc_btnFunc2 = new GridBagConstraints();
		gbc_btnFunc2.gridwidth = 7;
		gbc_btnFunc2.insets = new Insets(0, 0, 5, 5);
		gbc_btnFunc2.gridx = 1;
		gbc_btnFunc2.gridy = 5;
		contentPane.add(btnFunc2, gbc_btnFunc2);
		
		JButton btnFunc3 = new JButton("Ch\u1EE9c N\u0103ng 3");
		btnFunc3.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		GridBagConstraints gbc_btnFunc3 = new GridBagConstraints();
		gbc_btnFunc3.insets = new Insets(0, 0, 0, 5);
		gbc_btnFunc3.gridwidth = 7;
		gbc_btnFunc3.gridx = 1;
		gbc_btnFunc3.gridy = 6;
		contentPane.add(btnFunc3, gbc_btnFunc3);
		
		addWindowListener(new WindowAdapter() {
			@SuppressWarnings({ "deprecation" })
			@Override
			public void windowActivated(WindowEvent arg0) {
				lblLoiChao.setText("Xin chào"+(nd==null?"":(" "+nd.getHoTen()))+"!");
				// quyen quan tri
				if (nd == null) {
					btnFunc1.setText("Đăng nhập");;;
					btnFunc2.hide();
					btnFunc3.hide();
					btnDoiMK.hide();
					btnSuaTen.hide();
					lblNewLabel_1.setText("Hãy Đăng nhập để có chức năng:");;
				} else if(nd.getQuyen() == 0) {
					btnFunc1.setText("Tạo TKB");
					btnFunc2.setText("Tạo Tài khoản");
					btnFunc3.setText("Điểm danh");
				} else if (nd.getQuyen() == 1) {
					btnFunc1.setText("Điểm danh");
					btnFunc2.setText("Kết quả Điểm danh");
					btnFunc3.hide();
				}
			}
		});
	}

}
