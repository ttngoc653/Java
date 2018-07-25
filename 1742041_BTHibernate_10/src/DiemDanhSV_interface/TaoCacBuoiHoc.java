package DiemDanhSV_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DiemDanhSV_class.Thoikhoabieu;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.text.Format;
import javax.swing.JButton;

public class TaoCacBuoiHoc extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaoCacBuoiHoc frame = new TaoCacBuoiHoc(null);
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
	public TaoCacBuoiHoc(Thoikhoabieu tkb) {
		setTitle("Tạo các buổi học");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 165, 264, 335);
		contentPane.add(table);
		
		JLabel label = new JLabel("Ngày bắt đầu:");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label.setBounds(-12, 36, 138, 19);
		contentPane.add(label);
		
		JFormattedTextField formattedTextField = new JFormattedTextField((Format) null);
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		formattedTextField.setBounds(136, 31, 138, 29);
		contentPane.add(formattedTextField);
		
		JLabel label_1 = new JLabel("Giờ bắt đầu:");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label_1.setBounds(-12, 73, 138, 19);
		contentPane.add(label_1);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField((Format) null);
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		formattedTextField_1.setBounds(136, 66, 138, 29);
		contentPane.add(formattedTextField_1);
		
		JButton button = new JButton("Thêm");
		button.setFont(new Font("Sitka Text", Font.BOLD, 14));
		button.setBounds(49, 106, 89, 26);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Xóa");
		button_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		button_1.setBounds(148, 106, 89, 26);
		contentPane.add(button_1);
	}
}
