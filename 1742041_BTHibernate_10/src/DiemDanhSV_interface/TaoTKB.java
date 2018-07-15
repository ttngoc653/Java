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

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import DiemDanhSV_class.ViewTKB;

import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private static JTable data;
	@SuppressWarnings("null")
	private static boolean getData() {
		DefaultTableModel model= (DefaultTableModel)data.getModel();	
		model.setRowCount(0);
		ArrayList<ViewTKB> list=null;
		model.setRowCount(list.size());
		for (int i = 0; i < list.size(); i++) {
			model.setValueAt(list.get(i).getTenMonHoc(), i, 0);
			model.setValueAt(list.get(i).getNgayBatDau(), i, 1);
			model.setValueAt(list.get(i).getNgayKetThuc(), i, 2);
			model.setValueAt(list.get(i).getThuTrongTuan(), i, 3);
			model.setValueAt(list.get(i).getGioBatDau(), i, 4);
			model.setValueAt(list.get(i).getGioKetThuc(), i, 5);
			model.setValueAt(list.get(i).getTenPhongHoc(), i, 6);
		}
		data.setModel(model);
		
		return false;
	}
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
		setResizable(false);
		setTitle("T\u1EA0O TH\u1EDCI KH\u00D3A BI\u1EC2U");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDanhSchMn = new JLabel("Danh s\u00E1ch m\u00F4n h\u1ECDc:");
		lblDanhSchMn.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblDanhSchMn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDanhSchMn.setBounds(10, 14, 138, 19);
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
		cbbMonHoc.setBounds(158, 10, 212, 26);
		contentPane.add(cbbMonHoc);
		
		JLabel lblNgyBtu = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u:");
		lblNgyBtu.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNgyBtu.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNgyBtu.setBounds(10, 52, 138, 19);
		contentPane.add(lblNgyBtu);
		
		txtNgayBD = new JTextField();
		txtNgayBD.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtNgayBD.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayBD.setBounds(158, 47, 212, 29);
		contentPane.add(txtNgayBD);
		txtNgayBD.setColumns(10);
		
		txtNgayKT = new JTextField();
		txtNgayKT.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtNgayKT.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayKT.setColumns(10);
		txtNgayKT.setBounds(158, 87, 212, 29);
		contentPane.add(txtNgayKT);
		
		txtGioBD = new JTextField();
		txtGioBD.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtGioBD.setHorizontalAlignment(SwingConstants.CENTER);
		txtGioBD.setColumns(10);
		txtGioBD.setBounds(537, 47, 212, 29);
		contentPane.add(txtGioBD);
		
		txtGioKT = new JTextField();
		txtGioKT.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtGioKT.setHorizontalAlignment(SwingConstants.CENTER);
		txtGioKT.setColumns(10);
		txtGioKT.setBounds(537, 87, 212, 29);
		contentPane.add(txtGioKT);
		
		txtPhongHoc = new JTextField();
		txtPhongHoc.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtPhongHoc.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhongHoc.setColumns(10);
		txtPhongHoc.setBounds(537, 10, 212, 29);
		contentPane.add(txtPhongHoc);
		
		JLabel lblNgyKtThc = new JLabel("Ng\u00E0y k\u1EBFt th\u00FAc:");
		lblNgyKtThc.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNgyKtThc.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNgyKtThc.setBounds(10, 94, 138, 19);
		contentPane.add(lblNgyKtThc);
		
		JLabel lblThTrongTun = new JLabel("Th\u1EE9 trong tu\u1EA7n:");
		lblThTrongTun.setHorizontalAlignment(SwingConstants.TRAILING);
		lblThTrongTun.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblThTrongTun.setBounds(10, 134, 138, 19);
		contentPane.add(lblThTrongTun);
		
		JLabel lblGiBtu = new JLabel("Gi\u1EDD b\u1EAFt \u0111\u1EA7u:");
		lblGiBtu.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGiBtu.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblGiBtu.setBounds(389, 54, 138, 19);
		contentPane.add(lblGiBtu);
		
		JLabel lblGiKtThc = new JLabel("Gi\u1EDD K\u1EBFt th\u00FAc:");
		lblGiKtThc.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGiKtThc.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblGiKtThc.setBounds(389, 94, 138, 19);
		contentPane.add(lblGiKtThc);
		
		JLabel lblTnPhngHc = new JLabel("T\u00EAn ph\u00F2ng h\u1ECDc:");
		lblTnPhngHc.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTnPhngHc.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblTnPhngHc.setBounds(389, 15, 138, 19);
		contentPane.add(lblTnPhngHc);
		
		JComboBox<String> cbbThu = new JComboBox<String>();
		cbbThu.setModel(new DefaultComboBoxModel(new String[] {"Th\u1EE9 Hai", "Th\u1EE9 Ba", "Th\u1EE9 T\u01B0", "Th\u1EE9 N\u0103m", "Th\u1EE9 S\u00E1u", "Th\u1EE9 B\u1EA3y", "Ch\u1EE7 Nh\u1EADt"}));
		cbbThu.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cbbThu.setBounds(158, 127, 212, 26);
		contentPane.add(cbbThu);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnXoa.setBounds(660, 127, 89, 26);
		contentPane.add(btnXoa);
		
		JButton btnAdd = new JButton("Th\u00EAm");
		btnAdd.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnAdd.setBounds(462, 127, 89, 26);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("S\u1EEDa");
		btnUpdate.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnUpdate.setBounds(561, 127, 89, 26);
		contentPane.add(btnUpdate);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 164, 759, 317);
		contentPane.add(scrollPane);
		
		data = new JTable();
		data.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		data.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		
		data.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(data);
	}
}
