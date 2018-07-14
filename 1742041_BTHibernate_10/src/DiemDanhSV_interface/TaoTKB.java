package DiemDanhSV_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DiemDanhSV_process.MonHocProcess;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class TaoTKB extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4923724871293078076L;
	private JPanel contentPane;
	private JTextField txtNgayBD;
	private JTextField txtNgayKT;
	private JTextField txtGioBD;
	private JTextField txtGioKT;
	private JTextField txtPhongHoc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaoTKB frame = new TaoTKB();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TaoTKB() {
		setTitle("T\u1EA0O TH\u1EDCI KH\u00D3A BI\u1EC2U");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDanhSchMn = new JLabel("Danh s\u00E1ch m\u00F4n h\u1ECDc:");
		lblDanhSchMn.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblDanhSchMn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDanhSchMn.setBounds(10, 14, 165, 19);
		contentPane.add(lblDanhSchMn);
		
		JComboBox<String> cbbMonHoc = new JComboBox<String>();
		cbbMonHoc.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				List<String> list_mon_hoc = MonHocProcess.getAllTen();
				cbbMonHoc.removeAllItems();
				for (String string : list_mon_hoc)
					cbbMonHoc.addItem(string);
			}
		});
		cbbMonHoc.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cbbMonHoc.setBounds(185, 10, 266, 26);
		contentPane.add(cbbMonHoc);
		
		JLabel lblNgyBtu = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u:");
		lblNgyBtu.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNgyBtu.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNgyBtu.setBounds(10, 52, 165, 19);
		contentPane.add(lblNgyBtu);
		
		txtNgayBD = new JTextField();
		txtNgayBD.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtNgayBD.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayBD.setBounds(185, 47, 266, 29);
		contentPane.add(txtNgayBD);
		txtNgayBD.setColumns(10);
		
		txtNgayKT = new JTextField();
		txtNgayKT.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtNgayKT.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayKT.setColumns(10);
		txtNgayKT.setBounds(185, 87, 266, 29);
		contentPane.add(txtNgayKT);
		
		txtGioBD = new JTextField();
		txtGioBD.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtGioBD.setHorizontalAlignment(SwingConstants.CENTER);
		txtGioBD.setColumns(10);
		txtGioBD.setBounds(185, 167, 266, 29);
		contentPane.add(txtGioBD);
		
		txtGioKT = new JTextField();
		txtGioKT.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtGioKT.setHorizontalAlignment(SwingConstants.CENTER);
		txtGioKT.setColumns(10);
		txtGioKT.setBounds(185, 207, 266, 29);
		contentPane.add(txtGioKT);
		
		txtPhongHoc = new JTextField();
		txtPhongHoc.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtPhongHoc.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhongHoc.setColumns(10);
		txtPhongHoc.setBounds(185, 247, 266, 29);
		contentPane.add(txtPhongHoc);
		
		JLabel lblNgyKtThc = new JLabel("Ng\u00E0y k\u1EBFt th\u00FAc:");
		lblNgyKtThc.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNgyKtThc.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNgyKtThc.setBounds(10, 94, 165, 19);
		contentPane.add(lblNgyKtThc);
		
		JLabel lblThTrongTun = new JLabel("Th\u1EE9 trong tu\u1EA7n:");
		lblThTrongTun.setHorizontalAlignment(SwingConstants.TRAILING);
		lblThTrongTun.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblThTrongTun.setBounds(10, 134, 165, 19);
		contentPane.add(lblThTrongTun);
		
		JLabel lblGiBtu = new JLabel("Gi\u1EDD b\u1EAFt \u0111\u1EA7u:");
		lblGiBtu.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGiBtu.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblGiBtu.setBounds(10, 174, 165, 19);
		contentPane.add(lblGiBtu);
		
		JLabel lblGiKtThc = new JLabel("Gi\u1EDD K\u1EBFt th\u00FAc:");
		lblGiKtThc.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGiKtThc.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblGiKtThc.setBounds(10, 214, 165, 19);
		contentPane.add(lblGiKtThc);
		
		JLabel lblTnPhngHc = new JLabel("T\u00EAn ph\u00F2ng h\u1ECDc:");
		lblTnPhngHc.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTnPhngHc.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblTnPhngHc.setBounds(10, 252, 165, 19);
		contentPane.add(lblTnPhngHc);
		
		JComboBox<String> cbbThu = new JComboBox<String>();
		cbbThu.setModel(new DefaultComboBoxModel(new String[] {"Th\u1EE9 Hai", "Th\u1EE9 Ba", "Th\u1EE9 T\u01B0", "Th\u1EE9 N\u0103m", "Th\u1EE9 S\u00E1u", "Th\u1EE9 B\u1EA3y", "Ch\u1EE7 Nh\u1EADt"}));
		cbbThu.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cbbThu.setBounds(185, 127, 266, 26);
		contentPane.add(cbbThu);
		//contentPane.hide();
	}
}
