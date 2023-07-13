package GiaoDien;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DBKetNoi.DBConnect;

import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;

public class GiaiDau extends JPanel implements ActionListener {
	//DBConnect dbconnect;
	JLabel titleGiaiDau;
	DefaultTableModel modelGiaiDau = new DefaultTableModel(0,0);
	String HEADR[] = new String[] {"Mã giải","Tên giải","Ngày bắt đầu","Ngày kết thúc"};
	private JTextField txtIDGiai;
	private JTextField txtTenGiai;
	private JTextField txtNgayBatDau;
	private JTextField txtNgayKetThuc;
	private JTable table;
	JButton btnThem,btnXoa,btnCapNhat,btnQuanLy;
	int row=-1;
	public static String maGiai;
	String tenGiai;
	/**
	 * Create the panel.
	 */
	public GiaiDau(DBConnect dbconnect) {
		setBackground(Color.getHSBColor(222, 222, 229));
		setSize(767,520);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.getHSBColor(222, 222, 229));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.getHSBColor(222, 222, 229));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(52, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 675, GroupLayout.PREFERRED_SIZE))
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		modelGiaiDau.setColumnIdentifiers(HEADR);
		table.setModel(modelGiaiDau);
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
		
		btnQuanLy = new JButton("Quản lý");
		btnQuanLy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnQuanLy);
		panel.setLayout(new GridLayout(0, 2, 0, 20));
		
		JLabel lblNewLabel = new JLabel("Mã giải đấu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		txtIDGiai = new JTextField();
		panel.add(txtIDGiai);
		txtIDGiai.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên giải:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_1);
		
		txtTenGiai = new JTextField();
		panel.add(txtTenGiai);
		txtTenGiai.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày bắt đầu:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_2);
		
		txtNgayBatDau = new JTextField();
		panel.add(txtNgayBatDau);
		txtNgayBatDau.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày kết thúc:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_3);
		
		txtNgayKetThuc = new JTextField();
		panel.add(txtNgayKetThuc);
		txtNgayKetThuc.setColumns(10);
		setLayout(groupLayout);
		modelGiaiDau.setColumnIdentifiers(HEADR);
		
		try {
			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM GiaiDau");
			while(rs.next()) {
				modelGiaiDau.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				txtIDGiai.setText(modelGiaiDau.getValueAt(row, 0).toString());
				txtTenGiai.setText(modelGiaiDau.getValueAt(row, 1).toString());
				txtNgayBatDau.setText(modelGiaiDau.getValueAt(row, 2).toString());
				txtNgayKetThuc.setText(modelGiaiDau.getValueAt(row, 3).toString());
			}
		});
		btnThem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dbconnect.getStmt().execute("INSERT INTO GiaiDau VALUES('"+txtIDGiai.getText()+"',N'"+txtTenGiai.getText()+"',N'"+txtNgayBatDau.getText()+"',N'"+txtNgayKetThuc.getText()+"')");
					modelGiaiDau.addRow(new String[] {txtIDGiai.getText(),txtTenGiai.getText(),txtNgayBatDau.getText(),txtNgayKetThuc.getText()});
					txtIDGiai.setText("");
					txtTenGiai.setText("");
					txtNgayBatDau.setText("");
					txtNgayKetThuc.setText("");
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
					dbconnect.getStmt().execute("DELETE FROM GiaiDau WHERE ID='"+modelGiaiDau.getValueAt(row, 0).toString()+"'");
					dbconnect.getStmt().execute("DELETE FROM DoiBong WHERE GiaiDau='"+modelGiaiDau.getValueAt(row, 1).toString()+"'");
					dbconnect.getStmt().execute("DELETE FROM TranDau WHERE ID='"+modelGiaiDau.getValueAt(row, 2).toString()+"'");
					dbconnect.getStmt().execute("DELETE FROM BangDau WHERE ID='"+modelGiaiDau.getValueAt(row, 3).toString()+"'");
					modelGiaiDau.removeRow(row);
					txtIDGiai.setText("");
					txtTenGiai.setText("");
					txtNgayBatDau.setText("");
					txtNgayKetThuc.setText("");
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
					dbconnect.getStmt().execute("UPDATE Giaidau SET ten=N'"+txtTenGiai.getText()+"',ngayBatDau=N'"+txtNgayBatDau.getText()+"',ngayKetThuc=N'"+txtNgayKetThuc.getText()+"' WHERE ID='"+modelGiaiDau.getValueAt(row, 0).toString()+"'");
					modelGiaiDau.setValueAt(txtTenGiai.getText(), row, 1);
					modelGiaiDau.setValueAt(txtNgayBatDau.getText(), row, 2);
					modelGiaiDau.setValueAt(txtNgayKetThuc.getText(), row, 3);
					txtIDGiai.setText("");     
					txtTenGiai.setText("");
					txtNgayBatDau.setText("");
					txtNgayKetThuc.setText("");
					row=-1;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuanLy.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(row!=-1) {
				maGiai = modelGiaiDau.getValueAt(row, 0).toString();
				tenGiai = modelGiaiDau.getValueAt(row, 1).toString();
				}
				else {
					JOptionPane.showMessageDialog(null,"Chọn giải đấu cần quản lý");
				}
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
