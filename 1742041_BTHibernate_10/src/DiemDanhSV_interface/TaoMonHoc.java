package DiemDanhSV_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DiemDanhSV_class.Monhoc;
import DiemDanhSV_process.MonHocProcess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class TaoMonHoc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 771197374000891074L;
	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaoMonHoc frame = new TaoMonHoc();
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
	public TaoMonHoc() {
		setResizable(false);
		setTitle("TH\u00CAM M\u00D4N H\u1ECCC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 m\u00F4n h\u1ECDc:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel.setBounds(46, 25, 112, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn m\u00F4n h\u1ECDc:");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel_1.setBounds(121, 56, 124, 19);
		contentPane.add(lblNewLabel_1);
		
		txtCode = new JTextField();
		txtCode.setHorizontalAlignment(SwingConstants.CENTER);
		txtCode.setFont(new Font("Sitka Text", Font.BOLD, 15));
		txtCode.setBounds(156, 19, 146, 26);
		contentPane.add(txtCode);
		txtCode.setColumns(10);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("Sitka Text", Font.BOLD, 15));
		txtName.setColumns(10);
		txtName.setBounds(46, 80, 256, 26);
		contentPane.add(txtName);
		
		JButton btnAdd = new JButton("Th\u00EAm v\u00E0 qua T\u1EA1o TKB");
		btnAdd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					themMonHocAndReturnTaoTKB();
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				themMonHocAndReturnTaoTKB();
			}
		});
		btnAdd.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnAdd.setBounds(72, 117, 206, 26);
		contentPane.add(btnAdd);
		
		JLabel lblDanhSchMn = new JLabel("Danh sách môn học hiện tại:");
		lblDanhSchMn.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchMn.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblDanhSchMn.setBounds(10, 166, 347, 14);
		contentPane.add(lblDanhSchMn);
		
		JComboBox<String> cbbDSMonHoc = new JComboBox<String>();
		cbbDSMonHoc.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				List<Monhoc> list_mon_hoc = MonHocProcess.getDanhSachMonHoc();
				cbbDSMonHoc.removeAllItems();
				for (Monhoc item : list_mon_hoc)
					cbbDSMonHoc.addItem(item.getMaMonHoc()+" - "+item.getTenMonHoc());
			}
		});
		cbbDSMonHoc.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cbbDSMonHoc.setBounds(10, 191, 347, 26);
		contentPane.add(cbbDSMonHoc);
		
	}

	protected void themMonHocAndReturnTaoTKB() {
		if (txtCode.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Mã môn học không thể bỏ trống!", "Thông báo", 1);
			return;
		}
		else if (txtName.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Chưa nhập tên môn học! Hãy nhập tên môn học.", "Thông báo", 1);
			return;
		}
		
		switch (MonHocProcess.addMonHoc(new Monhoc(txtCode.getText(), txtName.getText()))) {
		case 3:
			JOptionPane.showMessageDialog(null, "Đã tạo môn học thành công!", "Thông báo", 1);
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Bị trùng mã môn học.\nHãy nhập mã môn học khác.", "Thông báo", 1);
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Bị trùng tên môn học.\nHãy kiểm tra lại tên môn học.", "Thông báo", 1);
			break;
		case 0:
			JOptionPane.showMessageDialog(null, "Tạo môn học thất bại.", "Thông báo", 1);
			break;
		}
	}
}
