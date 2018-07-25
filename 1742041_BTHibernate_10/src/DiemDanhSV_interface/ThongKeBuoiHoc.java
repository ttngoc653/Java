package DiemDanhSV_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;

import DiemDanhSV_class.Diemdanh;
import DiemDanhSV_class.Nguoidung;
import DiemDanhSV_process.DiemDanhProcess;

import javax.swing.event.PopupMenuEvent;

public class ThongKeBuoiHoc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBuoiHoc;
	private JLabel lblBuoiVang;
	private JLabel lblBuoiChuaCoDuLieu;
	private static JTable table;
	private static JComboBox<String> cbbMonHoc;
	
	private static boolean getData(Nguoidung nd) {
		DefaultTableModel model= (DefaultTableModel)table.getModel();	
		model.setRowCount(0);
		ArrayList<Diemdanh> list=(ArrayList<Diemdanh>) DiemDanhProcess.loadDSNgayDiemDanh(cbbMonHoc.getSelectedItem().toString(), new SimpleDateFormat("yyyy-MM-dd").format(new Date(0)), nd.getTenDn());
		model.setRowCount(list.size());
		for (int i = 0; i < list.size(); i++) {
			model.setValueAt(new SimpleDateFormat("dd/MM/yyyy").format(list.get(i).getId().getNgayHoc()), i, 0);
			model.setValueAt(new SimpleDateFormat("HH:mm").format(list.get(i).getId().getGioHoc()), i, 1);
			model.setValueAt(list.get(i).getDaDiHoc(), i, 2);
		}
		table.setModel(model);
		
		return false;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeBuoiHoc frame = new ThongKeBuoiHoc(null);
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
	public ThongKeBuoiHoc(Nguoidung nd) {
		setTitle("Th\u1ED1ng K\u00EA C\u00E1c Bu\u1ED5i \u0110ang H\u1ECDc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDanhSchMn = new JLabel("Danh s\u00E1ch m\u00F4n \u0111ang h\u1ECDc:");
		lblDanhSchMn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDanhSchMn.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblDanhSchMn.setBounds(10, 15, 186, 19);
		contentPane.add(lblDanhSchMn);
		
		cbbMonHoc = new JComboBox<String>();
		cbbMonHoc.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				getData(nd);
				int i_co_hoc = 0, i_vang = 0;
				
				for (int i = 0; i < table.getRowCount(); i++) {
					if (table.getModel().getValueAt(i, 2).toString() == "true")
						i_co_hoc++;
					else if(table.getModel().getValueAt(i, 2).toString() == "false")
						i_vang++;
				}
				
				lblBuoiHoc.setText(i_co_hoc + " buổi");
				lblBuoiVang.setText(i_vang + " buổi");
				lblBuoiChuaCoDuLieu.setText(String.valueOf(15 - i_co_hoc - i_vang) + " buổi");
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				if(nd == null) return;

				List<String> list_mon_hoc = DiemDanhProcess.getMonDangHoc(nd.getTenDn());
				cbbMonHoc.removeAllItems();
				for (String string : list_mon_hoc)
					cbbMonHoc.addItem(string);
			}
		});
		cbbMonHoc.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cbbMonHoc.setBounds(206, 11, 212, 26);
		contentPane.add(cbbMonHoc);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Ng\u00E0y h\u1ECDc", "Gi\u1EDD h\u1ECDc", "C\u00F3 \u0111i h\u1ECDc"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Boolean.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.setBounds(10, 86, 282, 354);
		contentPane.add(table);
		
		JLabel lblChiTitCc = new JLabel("Chi ti\u1EBFt c\u00E1c bu\u1ED5i h\u1ECDc");
		lblChiTitCc.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTitCc.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblChiTitCc.setBounds(10, 56, 282, 19);
		contentPane.add(lblChiTitCc);
		
		JLabel lblSBuiC = new JLabel("S\u1ED1 bu\u1ED5i c\u00F3 \u0111i h\u1ECDc:");
		lblSBuiC.setHorizontalAlignment(SwingConstants.CENTER);
		lblSBuiC.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblSBuiC.setBounds(302, 86, 186, 19);
		contentPane.add(lblSBuiC);
		
		JLabel lblSBuiVng = new JLabel("S\u1ED1 bu\u1ED5i v\u1EAFng:");
		lblSBuiVng.setHorizontalAlignment(SwingConstants.CENTER);
		lblSBuiVng.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblSBuiVng.setBounds(302, 136, 186, 19);
		contentPane.add(lblSBuiVng);
		
		JLabel lblSBuiCha = new JLabel("S\u1ED1 bu\u1ED5i ch\u01B0a c\u00F3 d\u1EEF li\u1EC7u:");
		lblSBuiCha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSBuiCha.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblSBuiCha.setBounds(302, 182, 186, 19);
		contentPane.add(lblSBuiCha);
		
		lblBuoiHoc = new JLabel("bu\u1ED5i");
		lblBuoiHoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuoiHoc.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblBuoiHoc.setBounds(302, 102, 186, 19);
		contentPane.add(lblBuoiHoc);
		
		lblBuoiVang = new JLabel("bu\u1ED5i");
		lblBuoiVang.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuoiVang.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblBuoiVang.setBounds(302, 152, 186, 19);
		contentPane.add(lblBuoiVang);
		
		lblBuoiChuaCoDuLieu = new JLabel("bu\u1ED5i");
		lblBuoiChuaCoDuLieu.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuoiChuaCoDuLieu.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblBuoiChuaCoDuLieu.setBounds(302, 199, 186, 19);
		contentPane.add(lblBuoiChuaCoDuLieu);
		
		
	}
}
