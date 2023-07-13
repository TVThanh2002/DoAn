package GiaoDien;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import DBKetNoi.DBConnect;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DoiBong extends JPanel {
	JButton btnThem,btnCapNhat,btnCauThu,btnXoa;
	JTextField txtDoiTruong,txtMaDoi,txtTenDoi,txtHLV;
	JLabel lblTitle;
	DefaultTableModel modelDoiBong = new DefaultTableModel(0,0);
	String HEARD[] = new String[] {"Mã đội","Tên đội","Huấn luyện viên","Đội trưởng"};
	private JTable table;
	int row =-1;
	static String maDoi;
	String tenDoi;
	/**
	 * Create the panel.
	 */
	public DoiBong(DBConnect dbconnect) {
		
		setBackground(Color.getHSBColor(222, 222, 229));
		setSize(767,520);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.getHSBColor(222, 222, 229));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.getHSBColor(222, 222, 229));
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblTitle = new JLabel("Giải đấu:");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(219)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(176, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 727, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addGap(24)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		modelDoiBong.setColumnIdentifiers(HEARD);
		table.setModel(modelDoiBong);
		panel_1.setLayout(new GridLayout(0, 1, 0, 15));
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnThem);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnCapNhat);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnXoa);
		
		btnCauThu = new JButton("Danh sách cầu thủ");
		btnCauThu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnCauThu);
		panel.setLayout(new GridLayout(0, 2, 0, 20));
		
		JLabel lblNewLabel = new JLabel("ID Đội:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		txtMaDoi = new JTextField();
		panel.add(txtMaDoi);
		txtMaDoi.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đội:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_1);
		
		txtTenDoi = new JTextField();
		panel.add(txtTenDoi);
		txtTenDoi.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Đội trưởng:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_2);
		
		txtDoiTruong = new JTextField();
		panel.add(txtDoiTruong);
		txtDoiTruong.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Huấn luyện viên:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_3);
		
		txtHLV = new JTextField();
		panel.add(txtHLV);
		txtHLV.setColumns(10);
		setLayout(groupLayout);
		
//		try {
//			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT ID,ten,DoiTruong,HLV FROM DoiBong WHERE GiaiDau='"+giaiDau.maGiai+"'");
//			while(rs.next()) {
//				modelDoiBong.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Event(dbconnect);
	}
	public void Event(DBConnect dbconnect) {
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				row = table.getSelectedRow();
				txtMaDoi.setText(modelDoiBong.getValueAt(row, 0).toString());
				txtTenDoi.setText(modelDoiBong.getValueAt(row, 1).toString());
				txtDoiTruong.setText(modelDoiBong.getValueAt(row, 2).toString());
				txtHLV.setText(modelDoiBong.getValueAt(row, 3).toString());
				maDoi = modelDoiBong.getValueAt(row, 0).toString();
				tenDoi = modelDoiBong.getValueAt(row, 1).toString();
			}
		});
		
		btnThem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dbconnect.getStmt().execute("INSERT INTO DoiBong VALUES('"+txtMaDoi.getText()+"',N'"+txtTenDoi.getText()+"',N'"+txtHLV.getText()+"',N'"+txtDoiTruong.getText()+"','"+GiaiDau.maGiai+"')");
					modelDoiBong.addRow(new String[] {txtMaDoi.getText(),txtTenDoi.getText(),txtHLV.getText(),txtDoiTruong.getText()});
					txtMaDoi.setText("");
					txtTenDoi.setText("");
					txtHLV.setText("");
					txtDoiTruong.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCapNhat.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dbconnect.getStmt().execute("UPDATE DoiBong SET ten=N'"+txtTenDoi.getText()+"',HLV=N'"+txtHLV.getText()+"',DoiTruong=N'"+txtDoiTruong.getText()+"' WHERE ID='"+modelDoiBong.getValueAt(row, 0)+"'");
					modelDoiBong.setValueAt(txtTenDoi.getText(), row, 1);
					modelDoiBong.setValueAt(txtHLV.getText(), row, 2);
					modelDoiBong.setValueAt(txtDoiTruong.getText(), row, 3);
					row=-1;
					txtMaDoi.setText("");
					txtTenDoi.setText("");
					txtHLV.setText("");
					txtDoiTruong.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnXoa.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dbconnect.getStmt().execute("DELETE FROM DoiBong WHERE ID='"+modelDoiBong.getValueAt(row, 0).toString()+"'");
					modelDoiBong.removeRow(row);
					row=-1;
					txtMaDoi.setText("");
					txtTenDoi.setText("");
					txtHLV.setText("");
					txtDoiTruong.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
