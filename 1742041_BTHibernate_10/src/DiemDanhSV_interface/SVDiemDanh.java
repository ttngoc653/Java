package DiemDanhSV_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.PopupMenuListener;

import DiemDanhSV_process.MonHocProcess;

import javax.swing.event.PopupMenuEvent;

public class SVDiemDanh extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SVDiemDanh frame = new SVDiemDanh();
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
	public SVDiemDanh() {
		setTitle("FORM \u0110I\u1EC2M DANH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDanhSchMn = new JLabel("Danh s\u00E1ch m\u00F4n h\u1ECDc:");
		lblDanhSchMn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDanhSchMn.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblDanhSchMn.setBounds(10, 15, 144, 19);
		contentPane.add(lblDanhSchMn);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				List<String> list_mon_hoc = MonHocProcess.getAllTen();
				comboBox.removeAllItems();
				for (String string : list_mon_hoc)
					comboBox.addItem(string);
			}
		});
		comboBox.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		comboBox.setBounds(164, 11, 204, 26);
		contentPane.add(comboBox);
		
		JLabel lblNgyHc = new JLabel("Ng\u00E0y h\u1ECDc:");
		lblNgyHc.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNgyHc.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNgyHc.setBounds(10, 53, 144, 19);
		contentPane.add(lblNgyHc);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(164, 48, 204, 29);
		contentPane.add(textField);
		
		JLabel lblGiBtu = new JLabel("Gi\u1EDD b\u1EAFt \u0111\u1EA7u h\u1ECDc:");
		lblGiBtu.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGiBtu.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblGiBtu.setBounds(10, 93, 144, 19);
		contentPane.add(lblGiBtu);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(164, 88, 204, 29);
		contentPane.add(textField_1);
		
		JButton btnCheck = new JButton("\u0110i\u1EC3m danh");
		btnCheck.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnCheck.setBounds(116, 134, 151, 26);
		contentPane.add(btnCheck);
	}
}
