package GiaoDien1;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBKetNoi.DBConnect;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class PanelBangXepHang extends JPanel {
	private JTable table;
	public static DefaultTableModel model = new DefaultTableModel(0,0);
	DBConnect dbconnect;
	String HEADR[] = new String[] {"STT","Đội bóng","Số trận","Thắng","Hòa","Thua","Bàn thắng","Bàn thua","Hiệu số","Điểm"};
	String maGiai;
	JComboBox cbbTenDoi;
	private JTextField txtMaDoi;
	private JTextField txtDiem;
	private JTextField txtThang;
	private JTextField txtHoa;
	private JTextField txtViTri;
	private JTextField txtThua;

	/**
	 * Create the panel.
	 */
	public PanelBangXepHang(DBConnect dbconnect,GiaiDau giaiDau) {
		setBackground(new Color(51, 255, 102));
		this.dbconnect = dbconnect;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bảng xếp hạng");
		lblNewLabel.setBounds(325, 10, 122, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 746, 315);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.setColumnIdentifiers(HEADR);
		table.setModel(model);
		giaiDau.btnQuanLy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				maGiai = giaiDau.maGiaiDau;
				model.setNumRows(0);
				try {
					ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM["+maGiai+"_Bảng xếp hạng] ORDER BY Điểm DESC,[Hiệu số] DESC");
					int i=1;
					while(rs.next()) {
						String s = Integer.toString(i);
						model.addRow(new String[] {s,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
						i++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 updatecombobox(dbconnect);
			}
			
		});
		
		JLabel lblNewLabel_1 = new JLabel("Mã đội:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(173, 410, 50, 20);
		add(lblNewLabel_1);
		
		txtMaDoi = new JTextField();
		txtMaDoi.setBounds(235, 405, 96, 25);
		add(txtMaDoi);
		txtMaDoi.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên đội:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(367, 411, 66, 19);
		add(lblNewLabel_2);
		
		txtDiem = new JTextField();
		txtDiem.setColumns(10);
		txtDiem.setBounds(100, 454, 96, 25);
		add(txtDiem);
		
		txtThang = new JTextField();
		txtThang.setColumns(10);
		txtThang.setBounds(286, 454, 96, 25);
		add(txtThang);
		
		txtHoa = new JTextField();
		txtHoa.setColumns(10);
		txtHoa.setBounds(471, 454, 96, 25);
		add(txtHoa);
		
		JLabel lblNewLabel_1_1 = new JLabel("Điểm:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(44, 459, 66, 20);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Thắng:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(224, 460, 50, 19);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Hòa:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(429, 462, 66, 17);
		add(lblNewLabel_2_1_1);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setIcon(new ImageIcon("Img/search.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s = null;
					ResultSet rs = dbconnect.getStmt().executeQuery("SELECT [Mã đội bóng] FROM ["+maGiai+"_Danh sách đội bóng] WHERE [Tên đội bóng] = N'"+cbbTenDoi.getSelectedItem()+"'");
					while(rs.next()) {
						s = rs.getString(1);
					}
						for(int i=0;i<model.getRowCount();i++) {
							if(model.getValueAt(i, 1).toString().equals(s)) {
								txtViTri.setText(model.getValueAt(i, 0).toString());
								txtMaDoi.setText(model.getValueAt(i, 1).toString());
								txtDiem.setText(model.getValueAt(i, 9).toString());
								txtThang.setText(model.getValueAt(i, 3).toString());
								txtHoa.setText(model.getValueAt(i, 4).toString());
								txtThua.setText(model.getValueAt(i, 5).toString());
							}
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(631, 399, 102, 37);
		add(btnNewButton);
		
		cbbTenDoi = new JComboBox();
		cbbTenDoi.setBounds(444, 404, 154, 25);
		add(cbbTenDoi);
		
		JLabel lblNewLabel_1_2 = new JLabel("Vị trí:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(44, 410, 53, 20);
		add(lblNewLabel_1_2);
		
		txtViTri = new JTextField();
		txtViTri.setColumns(10);
		txtViTri.setBounds(100, 405, 44, 25);
		add(txtViTri);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Thắng:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(595, 460, 66, 19);
		add(lblNewLabel_2_1_2);
		
		txtThua = new JTextField();
		txtThua.setColumns(10);
		txtThua.setBounds(660, 454, 96, 25);
		add(txtThua);
	}
public void updatecombobox(DBConnect dbconnect) {
		
		try {
			cbbTenDoi.removeAllItems();
			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM["+maGiai+"_Danh sách đội bóng]");
			while(rs.next()) {
				cbbTenDoi.addItem(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}