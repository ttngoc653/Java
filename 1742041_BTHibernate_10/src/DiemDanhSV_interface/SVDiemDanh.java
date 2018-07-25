package DiemDanhSV_interface;

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

import DiemDanhSV_class.Nguoidung;
import DiemDanhSV_process.DiemDanhProcess;
import DiemDanhSV_process.MonHocProcess;

import javax.swing.event.PopupMenuEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SVDiemDanh extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNgayHoc;
	private JTextField txtGioHoc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SVDiemDanh frame = new SVDiemDanh(null);
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
	public SVDiemDanh(Nguoidung nd) {
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
		
		JComboBox<String> cbbMonHoc = new JComboBox<String>();
		cbbMonHoc.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				if(nd == null) return;
				
				List<String> list_mon_hoc = MonHocProcess.getAllTen();
				cbbMonHoc.removeAllItems();
				for (String string : list_mon_hoc)
					cbbMonHoc.addItem(string);
			}
		});
		cbbMonHoc.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cbbMonHoc.setBounds(164, 11, 204, 26);
		contentPane.add(cbbMonHoc);
		
		JLabel lblNgyHc = new JLabel("Ng\u00E0y h\u1ECDc:");
		lblNgyHc.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNgyHc.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNgyHc.setBounds(10, 53, 144, 19);
		contentPane.add(lblNgyHc);
		
		txtNgayHoc = new JTextField();
		txtNgayHoc.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayHoc.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtNgayHoc.setColumns(10);
		txtNgayHoc.setBounds(164, 48, 204, 29);
		contentPane.add(txtNgayHoc);
		
		JLabel lblGiBtu = new JLabel("Gi\u1EDD b\u1EAFt \u0111\u1EA7u h\u1ECDc:");
		lblGiBtu.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGiBtu.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblGiBtu.setBounds(10, 93, 144, 19);
		contentPane.add(lblGiBtu);
		
		txtGioHoc = new JTextField();
		txtGioHoc.setHorizontalAlignment(SwingConstants.CENTER);
		txtGioHoc.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtGioHoc.setColumns(10);
		txtGioHoc.setBounds(164, 88, 204, 29);
		contentPane.add(txtGioHoc);
		
		JButton btnCheck = new JButton("\u0110i\u1EC3m danh");
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(nd == null) return;
				DiemDanhProcess.check(txtGioHoc.getText(), txtGioHoc.getText(), cbbMonHoc.getSelectedItem().toString(), nd.getTenDn());
			}
		});
		btnCheck.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnCheck.setBounds(116, 134, 151, 26);
		contentPane.add(btnCheck);
	}
}
