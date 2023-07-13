package GiaoDien;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import DBKetNoi.DBConnect;
import ObjectDoiBong.XepHang;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;

public class ChiTietBangDau extends JPanel {
	private JTable table;
	public static DefaultTableModel modelChiTiet = new DefaultTableModel();
	String HEADR[] = new String[] {"Vị trí","Tên đội","Số trận","Thắng","Thua","Hòa","Bàn thắng","Bàn thua","Hiệu số","Điểm"};
	JButton btnThem,btnXoa,btnLichThiDau;
	JComboBox cbbDoiBong;
	JLabel lblTitle;
	XepHang xepHang;
	String ten;
	/**
	 * Create the panel.
	 */
	public ChiTietBangDau(DBConnect dbconnect) {
		setBackground(Color.getHSBColor(222, 222, 229));
		setSize(767,520);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.getHSBColor(222, 222, 229));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.getHSBColor(222, 222, 229));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.getHSBColor(222, 222, 229));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(154)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(164, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 635, GroupLayout.PREFERRED_SIZE)
					.addGap(64))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 737, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(295)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(240, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(new GridLayout(1, 2, 30, 0));
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(btnXoa);
		
		btnLichThiDau = new JButton("Lịch thi đấu");
		btnLichThiDau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(btnLichThiDau);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblTitle = new JLabel("BẢNG:");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_1.add(lblTitle, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Đội bóng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		cbbDoiBong = new JComboBox();
		panel.add(cbbDoiBong);
		
		modelChiTiet.setColumnIdentifiers(HEADR);
		table = new JTable();
		table.setModel(modelChiTiet);
		scrollPane.setViewportView(table);
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
				ten = modelChiTiet.getValueAt(table.getSelectedRow(), 1).toString();
			}
		});
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ResultSet rs = dbconnect.getStmt().executeQuery("SELECT ID,ten FROM DoiBong WHERE ten=N'"+cbbDoiBong.getSelectedItem().toString()+"' AND GiaiDau='"+GiaiDau.maGiai+"'");
					rs.next();
					dbconnect.getStmt().execute("INSERT INTO XepHang(ID,ten,bangDau) VALUES('"+rs.getString(1)+"','"+rs.getString(2)+"','"+BangDau.maBang+"')");
					XepHang.XepHang(dbconnect);
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
					dbconnect.getStmt().execute("DELETE FROM XepHang WHERE ten=N'"+ten+"' AND bangDau = '"+BangDau.maBang+"'");
					XepHang.XepHang(dbconnect);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
