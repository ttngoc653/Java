package DiemDanhSV_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DiemDanhSV_process.MonHocProcess;
import DiemDanhSV_process.TKBProcess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.management.ThreadMXBean;

public class TaoTKB extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4923724871293078076L;
	private JPanel contentPane;
	private JTextField txtPhongHoc;
	private JComboBox<String> cbbThu;
	private JButton btnXoa;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JFormattedTextField txtNgayBD;
	private JFormattedTextField txtNgayKT;
	private JFormattedTextField txtGioBD;
	private JFormattedTextField txtGioKT;
	private static JTable data;
	@SuppressWarnings("null")
	private static boolean getData() {
		DefaultTableModel model= (DefaultTableModel)data.getModel();	
		model.setRowCount(0);
		ArrayList<ViewTKB> list=null;
		model.setRowCount(list.size());
		for (int i = 0; i < list.size(); i++) {
			model.setValueAt(list.get(i).getTenMonHoc(), i, 0);
			model.setValueAt(new SimpleDateFormat("dd/MM/yyyy").format(list.get(i).getNgayBatDau()), i, 1);
			model.setValueAt(new SimpleDateFormat("dd/MM/yyyy").format(list.get(i).getNgayKetThuc()), i, 2);
			model.setValueAt(list.get(i).getThuTrongTuan(), i, 3);
			model.setValueAt(new SimpleDateFormat("HH:mm").format(list.get(i).getGioBatDau()), i, 4);
			model.setValueAt(new SimpleDateFormat("HH:mm").format(list.get(i).getGioKetThuc()), i, 5);
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				getData();
			}
		});
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
			@SuppressWarnings("deprecation")
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				if(cbbMonHoc.getSelectedItem().toString().equals("chọn để thêm môn học")) {
					TaoMonHoc frm =new TaoMonHoc();
					frm.show();
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				List<String> list_mon_hoc = MonHocProcess.getAllTen();
				cbbMonHoc.removeAllItems();
				for (String string : list_mon_hoc)
					cbbMonHoc.addItem(string);
				cbbMonHoc.addItem("chọn để thêm môn học");
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
		
		cbbThu = new JComboBox<String>();
		cbbThu.setModel(new DefaultComboBoxModel(new String[] {"Th\u1EE9 Hai", "Th\u1EE9 Ba", "Th\u1EE9 T\u01B0", "Th\u1EE9 N\u0103m", "Th\u1EE9 S\u00E1u", "Th\u1EE9 B\u1EA3y", "Ch\u1EE7 Nh\u1EADt"}));
		cbbThu.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cbbThu.setBounds(158, 127, 212, 26);
		contentPane.add(cbbThu);
		
		btnXoa = new JButton("X\u00F3a");
		btnXoa.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnXoa.setBounds(660, 127, 89, 26);
		contentPane.add(btnXoa);
		
		btnAdd = new JButton("Th\u00EAm");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					switch (TKBProcess.create(new ViewTKB(cbbMonHoc.getSelectedItem().toString(), txtNgayBD.getText(), txtNgayKT.getText(), cbbThu.getSelectedItem().toString(), txtGioBD.getText(), txtGioKT.getText(), txtPhongHoc.getText()))) {
					case 0:
					case 1:
					case 2:
					default:
						break;
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnAdd.setBounds(462, 127, 89, 26);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("S\u1EEDa");
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
			},
			new String[] {
				"T\u00EAn M\u00F4n h\u1ECDc", "Ng\u00E0y B\u1EAFt \u0111\u1EA7u h\u1ECDc", "Ng\u00E0y K\u1EBFt th\u00FAc m\u00F4n", "Th\u1EE9 trong tu\u1EA7n", "Gi\u1EDD B\u1EAFt \u0111\u1EA7u h\u1ECDc", "Gi\u1EDD K\u1EBFt th\u00FAc bu\u1ED5i h\u1ECDc", "T\u00EAn Ph\u00F2ng h\u1ECDc"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(data);
		
		txtNgayBD = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		txtNgayBD.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayBD.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtNgayBD.setBounds(158, 47, 212, 29);
		contentPane.add(txtNgayBD);
		
		txtNgayKT = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		txtNgayKT.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayKT.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtNgayKT.setBounds(158, 89, 212, 29);
		contentPane.add(txtNgayKT);
		
		txtGioBD = new JFormattedTextField(new SimpleDateFormat("HH:mm"));
		txtGioBD.setHorizontalAlignment(SwingConstants.CENTER);
		txtGioBD.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtGioBD.setBounds(537, 49, 212, 29);
		contentPane.add(txtGioBD);
		
		txtGioKT = new JFormattedTextField(new SimpleDateFormat("HH:mm"));
		txtGioKT.setHorizontalAlignment(SwingConstants.CENTER);
		txtGioKT.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtGioKT.setBounds(537, 89, 212, 29);
		contentPane.add(txtGioKT);
	}
}
