package GiaoDien;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import DBKetNoi.DBConnect;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class TranDau extends JPanel {
	JTextField txtMaTran,txtThoiGian,txtBanThang1,txtBanThang2;
	public static DefaultTableModel modelTranDau = new DefaultTableModel();
	String HEARD[] = new String[] {"Mã trận","Thời gian","Sân","Đội 1","Bàn thắng đội 1","Đội 2","Bàn thắng đội 2","Tình trạng","Bảng đấu"};
	JButton btnThem,btnXoa,btnCapNhat;
	JComboBox cbbDoi1,cbbDoi2,cbbBangDau,cbbSan;
	JCheckBox checkTinhTrang;
	JLabel lblTitle;
	private JTable table;
	int row = -1;
	/**
	 * Create the panel.
	 */
	public TranDau(DBConnect dbconnect) {
		setBackground(Color.getHSBColor(222, 222, 229));
		setSize(767,520);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.getHSBColor(222, 222, 229));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.getHSBColor(222, 222, 229));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.getHSBColor(222, 222, 229));
		
		lblTitle = new JLabel("Giải đấu:");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		checkTinhTrang = new JCheckBox("Đã thi đấu");
		checkTinhTrang.setBackground(Color.getHSBColor(222, 222, 229));
		checkTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 671, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(48)
									.addComponent(checkTinhTrang, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
							.addContainerGap(33, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(207)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(203, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(49))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(checkTinhTrang, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addGap(29))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
							.addGap(31)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		
		table = new JTable();
		modelTranDau.setColumnIdentifiers(HEARD);
		table.setModel(modelTranDau);
		scrollPane.setViewportView(table);
		panel_2.setLayout(new GridLayout(0, 2, 0, 20));
		
		JLabel lblNewLabel_7 = new JLabel("Bảng đấu:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_7);
		
		cbbBangDau = new JComboBox();
		panel_2.add(cbbBangDau);
		
//		JCheckBox check=new JCheckBox();
//		DefaultCellEditor tinhTrang = new DefaultCellEditor(check);
//		table.getColumnModel().getColumn(7).setCellEditor(tinhTrang);
		
		JLabel lblNewLabel_5 = new JLabel("Bàn thắng 1:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_5);
		
		txtBanThang1 = new JTextField();
		panel_2.add(txtBanThang1);
		txtBanThang1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Bàn thắng 2:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_6);
		
		txtBanThang2 = new JTextField();
		panel_2.add(txtBanThang2);
		txtBanThang2.setColumns(10);
		panel_1.setLayout(new GridLayout(0, 1, 0, 15));
		
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
		
		JLabel lblNewLabel = new JLabel("Mã trận:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		txtMaTran = new JTextField();
		panel.add(txtMaTran);
		txtMaTran.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Đội 1:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_1);
		
		cbbDoi1 = new JComboBox();
		panel.add(cbbDoi1);
		
		JLabel lblNewLabel_2 = new JLabel("Đội 2:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_2);
		
		cbbDoi2 = new JComboBox();
		panel.add(cbbDoi2);
		
		JLabel lblNewLabel_3 = new JLabel("Thời gian:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_3);
		
		txtThoiGian = new JTextField();
		panel.add(txtThoiGian);
		txtThoiGian.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Sân:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_4);
		
		cbbSan = new JComboBox();
		panel.add(cbbSan);
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
				txtMaTran.setText(modelTranDau.getValueAt(row, 0).toString());
				cbbDoi1.setSelectedItem(modelTranDau.getValueAt(row, 3).toString());
				cbbDoi2.setSelectedItem(modelTranDau.getValueAt(row, 5).toString());
				cbbBangDau.setSelectedItem(modelTranDau.getValueAt(row, 8).toString());
				cbbSan.setSelectedItem(modelTranDau.getValueAt(row, 2).toString());
				txtThoiGian.setText(modelTranDau.getValueAt(row, 1).toString());
				if(modelTranDau.getValueAt(row, 7).toString().equals("Đã thi đấu")) {
					checkTinhTrang.setSelected(true);
					txtBanThang1.setText(modelTranDau.getValueAt(row, 4).toString());
					txtBanThang2.setText(modelTranDau.getValueAt(row, 6).toString());
				}
				else {
					checkTinhTrang.setSelected(false);
					txtBanThang1.setText("");
					txtBanThang2.setText("");
				}
			}			
		});
		
		btnThem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method 
				try {
					ResultSet rs = dbconnect.getStmt().executeQuery("SELECT A.ID,B.ID FROM DoiBong A, DoiBong B WHERE A.GiaiDau='"+GiaiDau.maGiai+"' AND B.GiaiDau='"+GiaiDau.maGiai+"' AND A.ten='"+cbbDoi1.getSelectedItem()+"' AND B.ten='"+cbbDoi2.getSelectedItem()+"'");
					String doi1 = null,doi2 = null;
					while (rs.next()) {
						doi1 = rs.getString(1);
						doi2 = rs.getString(2);
					}
					String tinhtrang;
					if(checkTinhTrang.isSelected()) {
						tinhtrang = "Đã thi đấu";
						modelTranDau.addRow(new String [] {txtMaTran.getText(),txtThoiGian.getText(),cbbSan.getSelectedItem().toString(),cbbDoi1.getSelectedItem().toString(),txtBanThang1.getText(),cbbDoi2.getSelectedItem().toString(),txtBanThang2.getText(),tinhtrang,cbbBangDau.getSelectedItem().toString()});	
						dbconnect.getStmt().execute("INSERT INTO TranDau VALUES('"+txtMaTran.getText()+"',N'"+doi1+"','"+txtBanThang1.getText()+"',N'"+doi2+"','"+txtBanThang2.getText()+"',N'"+tinhtrang+"',N'"+txtThoiGian.getText()+"','"+cbbSan.getSelectedItem().toString()+"',N'"+cbbBangDau.getSelectedItem().toString()+"',N'"+GiaiDau.maGiai+"')");
					}
					else {
						tinhtrang = "";
						modelTranDau.addRow(new String [] {txtMaTran.getText(),txtThoiGian.getText(),cbbSan.getSelectedItem().toString(),cbbDoi1.getSelectedItem().toString(),"",cbbDoi2.getSelectedItem().toString(),"",tinhtrang,cbbBangDau.getSelectedItem().toString()});	
						dbconnect.getStmt().execute("INSERT INTO TranDau VALUES('"+txtMaTran.getText()+"',N'"+doi1+"',"+null+",N'"+doi2+"',"+null+",N'"+tinhtrang+"',N'"+txtThoiGian.getText()+"','"+cbbSan.getSelectedItem().toString()+"',N'"+cbbBangDau.getSelectedItem().toString()+"',N'"+GiaiDau.maGiai+"')");
					}
					txtMaTran.setText("");
					txtThoiGian.setText("");
					txtBanThang1.setText("");
					txtBanThang2.setText("");
					checkTinhTrang.setSelected(false);
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
					dbconnect.getStmt().execute("DELETE FROM TranDau WHERE ID='"+modelTranDau.getValueAt(row, 0).toString()+"'");
					modelTranDau.removeRow(row);
					txtMaTran.setText("");
					txtThoiGian.setText("");
					txtBanThang1.setText("");
					txtBanThang2.setText("");
					checkTinhTrang.setSelected(false);
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
					ResultSet rs = dbconnect.getStmt().executeQuery("SELECT A.ID,B.ID FROM DoiBong A, DoiBong B WHERE A.GiaiDau='"+GiaiDau.maGiai+"' AND B.GiaiDau='"+GiaiDau.maGiai+"' AND A.ten='"+cbbDoi1.getSelectedItem()+"' AND B.ten='"+cbbDoi2.getSelectedItem()+"'");
					String doi1 = null,doi2 = null;
					while (rs.next()) {
						doi1 = rs.getString(1);
						doi2 = rs.getString(2);
					}
					if(checkTinhTrang.isSelected()) {
						dbconnect.getStmt().execute("UPDATE TranDau SET doi1=N'"+doi1+"',banthang1='"+txtBanThang1.getText()+
							"',doi2='"+doi2+"',banthang2='"+txtBanThang2.getText()+"',tinhtrang=N'Đã thi đấu',thoigian='"+txtThoiGian.getText()+"',san=N'"+cbbSan.getSelectedItem().toString()+"',BangDau=N'"+cbbBangDau.getSelectedItem().toString()+"' WHERE ID='"+modelTranDau.getValueAt(row, 0).toString()+"'");
						modelTranDau.setValueAt(txtBanThang1.getText(), row, 4);
						modelTranDau.setValueAt(txtBanThang2.getText(), row, 6);
						modelTranDau.setValueAt("Đã thi đấu", row, 7);
					}
					else {
						dbconnect.getStmt().execute("UPDATE TranDau SET doi1=N'"+doi1+"',banthang1="+null+
								",doi2='"+doi2+"',banthang2="+null+",tinhtrang=N'',thoigian='"+txtThoiGian.getText()+"',san=N'"+cbbSan.getSelectedItem().toString()+"',BangDau=N'"+cbbBangDau.getSelectedItem().toString()+"' WHERE ID='"+modelTranDau.getValueAt(row, 0).toString()+"'");
						modelTranDau.setValueAt("", row, 4);
						modelTranDau.setValueAt("", row, 6);
						modelTranDau.setValueAt("", row, 7);
					}
					modelTranDau.setValueAt(txtThoiGian.getText(), row, 1);
					modelTranDau.setValueAt(cbbSan.getSelectedItem().toString(), row, 2);
					modelTranDau.setValueAt(cbbDoi1.getSelectedItem().toString(), row, 3);
					modelTranDau.setValueAt(cbbDoi2.getSelectedItem().toString(), row, 5);
					modelTranDau.setValueAt(cbbBangDau.getSelectedItem().toString(), row, 8);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
