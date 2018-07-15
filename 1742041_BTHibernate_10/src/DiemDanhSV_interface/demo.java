package DiemDanhSV_interface;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class demo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo frame = new demo();
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
	public demo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//getData();
			}
		});
		setTitle("QU\u1EA2N L\u00DD SINH VI\u00CAN");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMssv = new JLabel("MSSV:");
		lblMssv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMssv.setBounds(10, 11, 67, 14);
		contentPane.add(lblMssv);
		
		JLabel lblLp = new JLabel("L\u1EDBp:");
		lblLp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLp.setBounds(10, 36, 67, 14);
		contentPane.add(lblLp);
		
		JLabel lblGpaHinTi = new JLabel("GPA hi\u1EC7n t\u1EA1i:");
		lblGpaHinTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblGpaHinTi.setBounds(10, 61, 77, 14);
		contentPane.add(lblGpaHinTi);
		
		JTextField txtCode = new JTextField();
		txtCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Character c=e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
			}
		});
		txtCode.setBounds(87, 8, 86, 20);
		contentPane.add(txtCode);
		txtCode.setColumns(10);
		
		JTextField txtClass = new JTextField();
		txtClass.setBounds(87, 33, 86, 20);
		contentPane.add(txtClass);
		txtClass.setColumns(10);
		
		JTextField txtGpa = new JTextField();
		txtGpa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Character c=e.getKeyChar();
				if(c=='.') {
					if(txtGpa.getText().indexOf('.')>=0)
						e.consume();
				}
				else if (c>='0' && c<='9') ;
				else  e.consume();
			}
		});
		txtGpa.setBounds(87, 58, 96, 20);
		contentPane.add(txtGpa);
		txtGpa.setColumns(10);
		
		JLabel lblHTn = new JLabel("H\u1ECD t\u00EAn:");
		lblHTn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHTn.setBounds(197, 11, 53, 14);
		contentPane.add(lblHTn);
		
		JLabel lblNmSinh = new JLabel("N\u0103m sinh:");
		lblNmSinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmSinh.setBounds(429, 11, 57, 14);
		contentPane.add(lblNmSinh);
		
		JLabel lblNiHin = new JLabel("N\u01A1i \u1EDF hi\u1EC7n nay:");
		lblNiHin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNiHin.setBounds(197, 36, 97, 14);
		contentPane.add(lblNiHin);
		
		JTextField txtName = new JTextField();
		txtName.setBounds(260, 8, 150, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JComboBox<Integer> txtYob = new JComboBox<Integer>();
		txtYob.setBounds(496, 8, 88, 20);
		contentPane.add(txtYob);
		for (int i = 2018; i > 1900; i--)
			txtYob.addItem(i);
		
		JTextField txtAddress = new JTextField();
		txtAddress.setBounds(304, 33, 280, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JButton btnAdd = new JButton("TH\u00CAM");
		
		btnAdd.setBounds(259, 57, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnReplace = new JButton("S\u1EECA");
		
		btnReplace.setBounds(358, 57, 89, 23);
		contentPane.add(btnReplace);
		
		JButton btnDelete = new JButton("X\u00D3A");
		
		btnDelete.setBounds(457, 57, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblTmKim = new JLabel("T\u00ECm ki\u1EBFm:");
		lblTmKim.setBounds(10, 105, 57, 14);
		contentPane.add(lblTmKim);
		
		JTextField txtSearch = new JTextField();
		
		txtSearch.setBounds(77, 102, 160, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 133, 594, 288);
		contentPane.add(scrollPane);
		
		JTable data = new JTable();
		data.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCode.setText(data.getValueAt(data.getSelectedRow(), 0).toString());
				txtName.setText(data.getValueAt(data.getSelectedRow(), 1).toString());
				txtYob.setSelectedItem(Integer.parseInt(data.getValueAt(data.getSelectedRow(), 2).toString()));
				txtClass.setText(data.getValueAt(data.getSelectedRow(), 3).toString());
				txtGpa.setText(data.getValueAt(data.getSelectedRow(), 4).toString());
				txtAddress.setText(data.getValueAt(data.getSelectedRow(), 5).toString());
			}
		});
		data.setModel(new DefaultTableModel(
			new Object[][] {
				{"1460653", "Tr\u1EA7n Th\u1EBF Ng\u1ECDc", "1996", "14CK4", "7.37", "185/26 D\u01A1\u01A1ng B\u00E1 Th\u00E1n Qu\u1EADn 8"},
			},
			new String[] {
				"MSSV", "H\u1ECD t\u00EAn", "N\u0103m sinh", "L\u1EDBp", "GPA hi\u1EC7n t\u1EA1i", "N\u01A1i \u1EDF hi\u1EC7n nay"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(data);
	}
}

