package GiaoDien;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import DBKetNoi.DBConnect;
import ObjectDoiBong.XepHang;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BangDau extends JPanel {
	JTextField txtMaBang,txtTenBang;
	JTable table;
	JButton btnThem,btnXoa,btnCapNhat,btnXemChiTiet;
	DefaultTableModel modelBangDau = new DefaultTableModel();
	String HEARD[] = new String[] {"Mã bảng","Tên bảng"};
	public static String maBang;
	public static String tenBang;
	JLabel lblTitle;
	/**
	 * Create the panel.
	 */
	int row = -1;
	public BangDau(DBConnect dbconnect) {
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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(114)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(42, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 673, GroupLayout.PREFERRED_SIZE)))
					.addGap(52))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(195, Short.MAX_VALUE)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
					.addGap(165))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addGap(54)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		modelBangDau.setColumnIdentifiers(HEARD);
		table.setModel(modelBangDau);
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
		
		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnXemChiTiet);
		panel.setLayout(new GridLayout(0, 2, 0, 20));
		
		JLabel lblNewLabel = new JLabel("Mã bảng đấu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		txtMaBang = new JTextField();
		panel.add(txtMaBang);
		txtMaBang.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên bảng đấu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_1);
		
		txtTenBang = new JTextField();
		panel.add(txtTenBang);
		txtTenBang.setColumns(10);
		setLayout(groupLayout);
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
				txtMaBang.setText(modelBangDau.getValueAt(row, 0).toString());
				txtTenBang.setText(modelBangDau.getValueAt(row, 1).toString());
				maBang = txtMaBang.getText();
				tenBang = txtTenBang.getText();
			}
		});
		btnThem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dbconnect.getStmt().execute("INSERT INTO BangDau VALUES('"+txtMaBang.getText()+"',N'"+txtTenBang.getText()+"','"+GiaiDau.maGiai+"')");
					modelBangDau.addRow(new String[] {txtMaBang.getText(),txtTenBang.getText()});
					txtMaBang.setText("");
					txtTenBang.setText("");
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
					dbconnect.getStmt().execute("UPDATE BangDau SET ten=N'"+txtTenBang.getText()+"' WHERE ID='"+modelBangDau.getValueAt(row, 0).toString()+"'");
					modelBangDau.setValueAt(txtTenBang.getText(), row, 1);
					row=-1;
					txtMaBang.setText("");
					txtTenBang.setText("");
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
					dbconnect.getStmt().execute("DELETE FROM XepHang WHERE bangDau='"+maBang+"'");
					modelBangDau.removeRow(row);
					dbconnect.getStmt().execute("DELETE FROM BangDau WHERE ID='"+maBang+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
