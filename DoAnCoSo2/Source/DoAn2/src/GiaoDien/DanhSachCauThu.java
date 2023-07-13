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
import javax.swing.JComboBox;
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
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DBKetNoi.DBConnect;

import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.SystemColor;

public class DanhSachCauThu extends JPanel implements ActionListener {
	//DBConnect dbconnect;
	JLabel lblTitle;
	DefaultTableModel modelCauThu = new DefaultTableModel(0,0);
	String HEADR[] = new String[] {"Mã Cầu Thủ","Tên Cầu Thủ","Ngày Sinh","Số Áo","Vị Trí"};
	JTextField txtIDCT,txtTenCT,txtNgaySinh,txtSoAo;
	private JTable table;
	JButton btnThem,btnXoa,btnCapNhat;
	JRadioButton rdbtnThuMon,rdbtnHauVe,rdbtnTienVe,rdbtnTienDao;
	ButtonGroup bgViTri;
	int row=-1;
	String viTri;
	/**
	 * Create the panel.
	 */
	public DanhSachCauThu(DBConnect dbconnect) {
		setBackground(Color.getHSBColor(222, 222, 229));
		setSize(767,520);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.getHSBColor(222, 222, 229));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.getHSBColor(222, 222, 229));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.getHSBColor(222, 222, 229));
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblTitle = new JLabel("Đội Bóng:");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_3 = new JPanel();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(282)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(209, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(24))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		panel_3.setLayout(new GridLayout(1, 0, 15, 0));
		panel_3.setBackground(Color.getHSBColor(222, 222, 229));
		
		rdbtnThuMon = new JRadioButton("Thủ môn");
		rdbtnThuMon.setBackground(Color.getHSBColor(222, 222, 229));
		rdbtnThuMon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(rdbtnThuMon);
		
		rdbtnHauVe = new JRadioButton("Hậu vệ");
		rdbtnHauVe.setBackground(Color.getHSBColor(222, 222, 229));
		rdbtnHauVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(rdbtnHauVe);
		
		rdbtnTienVe = new JRadioButton("Tiền vệ");
		rdbtnTienVe.setBackground(Color.getHSBColor(222, 222, 229));
		rdbtnTienVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(rdbtnTienVe);
		
		rdbtnTienDao = new JRadioButton("Tiền đạo");
		rdbtnTienDao.setBackground(Color.getHSBColor(222, 222, 229));
		rdbtnTienDao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(rdbtnTienDao);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		modelCauThu.setColumnIdentifiers(HEADR);
		table.setModel(modelCauThu);
		
		panel_2.setLayout(new GridLayout(0, 2, 0, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Ngày Sinh:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2);
		
		txtNgaySinh = new JTextField();
		panel_2.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Số Áo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_3);
		
		txtSoAo = new JTextField();
		panel_2.add(txtSoAo);
		txtSoAo.setColumns(10);
		
		
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
		
		JLabel lblNewLabel = new JLabel("Mã Cầu Thủ:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		txtIDCT = new JTextField();
		panel.add(txtIDCT);
		txtIDCT.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Cầu Thủ:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_1);
		
		txtTenCT = new JTextField();
		panel.add(txtTenCT);
		txtTenCT.setColumns(20);
		
				
		setLayout(groupLayout);
		modelCauThu.setColumnIdentifiers(HEADR);
		
		bgViTri = new ButtonGroup();
		bgViTri.add(rdbtnThuMon);
		bgViTri.add(rdbtnHauVe);
		bgViTri.add(rdbtnTienVe);
		bgViTri.add(rdbtnTienDao);
		
		
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
				txtIDCT.setText(modelCauThu.getValueAt(row, 0).toString());
				txtTenCT.setText(modelCauThu.getValueAt(row, 1).toString());
				txtNgaySinh.setText(modelCauThu.getValueAt(row, 2).toString());
				txtSoAo.setText(modelCauThu.getValueAt(row, 3).toString());
				if(modelCauThu.getValueAt(row, 4).toString().equals(rdbtnTienDao.getText())) rdbtnTienDao.setSelected(true);
				else if(modelCauThu.getValueAt(row, 4).toString().equals(rdbtnHauVe.getText())) rdbtnHauVe.setSelected(true);
				else if(modelCauThu.getValueAt(row, 4).toString().equals(rdbtnTienVe.getText())) rdbtnTienVe.setSelected(true);
				else if(modelCauThu.getValueAt(row, 4).toString().equals(rdbtnThuMon.getText())) rdbtnThuMon.setSelected(true);
			}
		});
		btnThem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(rdbtnThuMon.isSelected()) viTri = rdbtnThuMon.getText();
					else if(rdbtnHauVe.isSelected()) viTri = rdbtnHauVe.getText();
					else if(rdbtnTienVe.isSelected()) viTri = rdbtnTienVe.getText();
					else if(rdbtnTienDao.isSelected()) viTri = rdbtnTienDao.getText();
					dbconnect.getStmt().execute("INSERT INTO CauThu VALUES('"+txtIDCT.getText()+"',N'"+txtTenCT.getText()+"','"+txtNgaySinh.getText()+"','"+txtSoAo.getText()+"',N'"+viTri+"','"+DoiBong.maDoi+"')");
					modelCauThu.addRow(new String[] {txtIDCT.getText(),txtTenCT.getText(),txtNgaySinh.getText(),txtSoAo.getText(),viTri});
					txtIDCT.setText("");
					txtTenCT.setText("");
					txtNgaySinh.setText("");
					txtSoAo.setText("");
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
					dbconnect.getStmt().execute("DELETE FROM CauThu WHERE ID='"+modelCauThu.getValueAt(row, 0).toString()+"'");
					modelCauThu.removeRow(row);
					txtIDCT.setText("");
					txtTenCT.setText("");
					txtNgaySinh.setText("");
					txtSoAo.setText("");
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
					if(rdbtnThuMon.isSelected()) viTri = rdbtnThuMon.getText();
					else if(rdbtnHauVe.isSelected()) viTri = rdbtnHauVe.getText();
					else if(rdbtnTienVe.isSelected()) viTri = rdbtnTienVe.getText();
					else if(rdbtnTienDao.isSelected()) viTri = rdbtnTienDao.getText();
					dbconnect.getStmt().execute("UPDATE CauThu SET ten=N'"+txtTenCT.getText()+"',ngaySinh=N'"+txtNgaySinh.getText()+"',soAo=N'"+txtSoAo.getText()+"',viTri=N'"+viTri+"' WHERE ID='"+modelCauThu.getValueAt(row, 0).toString()+"'");
					modelCauThu.setValueAt(txtTenCT.getText(), row, 1);
					modelCauThu.setValueAt(txtNgaySinh.getText(), row, 2);
					modelCauThu.setValueAt(txtSoAo.getText(), row, 3);
					modelCauThu.setValueAt(viTri, row, 4);
					txtIDCT.setText("");     
					txtTenCT.setText("");
					txtNgaySinh.setText("");
					txtSoAo.setText("");
					row=-1;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
