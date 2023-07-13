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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import DBKetNoi.DBConnect;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class San extends JPanel {
	JLabel lblTitle;
	DefaultTableModel modelSan = new DefaultTableModel(0,0);
	String HEADR[] = new String[] {"Sân Bóng","Địa Chỉ","Số Lượng Khán Giả"};
	private JTextField txtSan;
	private JTextField txtDiaChi;
	private JTextField txtSoLuong;
	private JTable table;
	JButton btnThem,btnXoa,btnCapNhat;
	int row=-1;

	/**
	 * Create the panel.
	 * @param dbconnect 
	 */
	public San(DBConnect dbconnect) {
		setBackground(Color.getHSBColor(222, 222, 229));
		setSize(767,520);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.getHSBColor(222, 222, 229));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.getHSBColor(222, 222, 229));
		
		JPanel panel_2 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblTitle = new JLabel("Giải đấu:");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(116)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(154, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(74)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 598, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(255)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(128, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(51))
		);
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		modelSan.setColumnIdentifiers(HEADR);
		table.setModel(modelSan);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("img\\san.jpg"));
		panel_2.add(lblNewLabel_3);
		panel_1.setLayout(new GridLayout(1, 0, 10, 0));
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnThem);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnCapNhat);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnXoa);
		
		panel.setLayout(new GridLayout(0, 2, 0, 20));
		
		JLabel lblNewLabel = new JLabel("Sân Bóng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		txtSan = new JTextField();
		panel.add(txtSan);
		txtSan.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Địa điểm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_1);
		
		txtDiaChi = new JTextField();
		panel.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Số Lượng:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_2);
		
		txtSoLuong = new JTextField();
		panel.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		setLayout(groupLayout);
		modelSan.setColumnIdentifiers(HEADR);
		
		Event(dbconnect);
		
	}
	public void Event(DBConnect dbconnect) {
		//this.dbconnect = dbconnect;
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
				txtSan.setText(modelSan.getValueAt(row, 0).toString());
				txtDiaChi.setText(modelSan.getValueAt(row, 1).toString());
				txtSoLuong.setText(modelSan.getValueAt(row, 2).toString());
				
			}
		});
		btnThem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dbconnect.getStmt().execute("INSERT INTO San VALUES('"+txtSan.getText()+"',N'"+txtDiaChi.getText()+"',N'"+txtSoLuong.getText()+"','"+GiaiDau.maGiai+"')");
					modelSan.addRow(new String[] {txtSan.getText(),txtDiaChi.getText(),txtSoLuong.getText()});
					txtSan.setText("");
					txtSoLuong.setText("");
					txtDiaChi.setText("");
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
					dbconnect.getStmt().execute("DELETE FROM San WHERE ten='"+modelSan.getValueAt(row, 0).toString()+"' AND GiaiDau='"+GiaiDau.maGiai+"'");
					modelSan.removeRow(row);
					txtSan.setText("");
					txtDiaChi.setText("");
					txtSoLuong.setText("");
					txtDiaChi.setText("");
					row=-1;
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
					dbconnect.getStmt().execute("UPDATE San SET diaChi=N'"+txtDiaChi.getText()+"',SucChua=N'"+txtSoLuong.getText()+"' WHERE ten='"+modelSan.getValueAt(row, 0).toString()+"'AND GiaiDau='"+GiaiDau.maGiai+"'");
					modelSan.setValueAt(txtDiaChi.getText(), row, 1);
					modelSan.setValueAt(txtSoLuong.getText(), row, 2);  
					txtSan.setText("");
					txtSoLuong.setText("");
					txtDiaChi.setText("");
					row=-1;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

}
