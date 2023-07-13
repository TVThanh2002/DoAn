package GiaoDien1;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBKetNoi.DBConnect;
import Object.XepHang;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PanelDoiBong extends JPanel{
	private JTextField txtMaDoi;
	private JTextField txtTenDoi;
	private JTextField txtDoiTruong;
	private JTextField txtHLV;
	private JTable tableDoiBong;
	JButton btnXoaTatCa;
	JButton btnDSCauThu;
	DBConnect dbconnect;
	JButton btnThem;
	JButton btnXoa;
	JButton btnLuu;
	PanelLichThidau pnLichThiDau;
	PanelBangXepHang pnBangXepHang;
	public static DefaultTableModel model = new DefaultTableModel(0,0);
	String HEADR[] = new String[]{"Mã đội","Tên đội","Đội trưởng","Huấn luyện viên"};
	String maDoiBong;
	public static String maGiai;
	int row = -1;
	/**
	 * Create the panel.
	 */
	public PanelDoiBong(DBConnect dbconnect,GiaiDau giaiDau,PanelLichThidau pnLichThiDau,PanelBangXepHang pnBangXepHang,XepHang xepHang) {
		setBackground(new Color(51, 255, 102));
		setLayout(null);
		
		JLabel lblDoiBong = new JLabel("Đội bóng");
		lblDoiBong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDoiBong.setBounds(346, 10, 104, 45);
		add(lblDoiBong);
		
		JLabel lblMaDoi = new JLabel("Mã đội:");
		lblMaDoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaDoi.setBounds(125, 90, 93, 21);
		add(lblMaDoi);
		
		txtMaDoi = new JTextField();
		txtMaDoi.setBounds(252, 85, 209, 26);
		add(txtMaDoi);
		txtMaDoi.setColumns(10);
		
		JLabel lblTenDoi = new JLabel("Tên đội:");
		lblTenDoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenDoi.setBounds(125, 121, 93, 21);
		add(lblTenDoi);
		
		txtTenDoi = new JTextField();
		txtTenDoi.setColumns(10);
		txtTenDoi.setBounds(252, 116, 209, 26);
		add(txtTenDoi);
		
		JLabel lblDoiTruong = new JLabel("Đội trưởng:");
		lblDoiTruong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoiTruong.setBounds(125, 152, 93, 21);
		add(lblDoiTruong);
		
		txtDoiTruong = new JTextField();
		txtDoiTruong.setColumns(10);
		txtDoiTruong.setBounds(252, 147, 209, 26);
		add(txtDoiTruong);
		
		JLabel lblHLV = new JLabel("Huấn luyện viên:");
		lblHLV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHLV.setBounds(125, 183, 113, 21);
		add(lblHLV);
		
		txtHLV = new JTextField();
		txtHLV.setColumns(10);
		txtHLV.setBounds(252, 178, 209, 26);
		add(txtHLV);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Img/Insert.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					model.addRow(new String[] {txtMaDoi.getText(),txtTenDoi.getText(),txtDoiTruong.getText(),txtHLV.getText()});
					dbconnect.getStmt().execute("INSERT INTO["+maGiai+"_Danh sách đội bóng] VALUES(N'"+txtMaDoi.getText()+"',N'"+txtTenDoi.getText()+"',N'"+txtDoiTruong.getText()+"',N'"+txtHLV.getText()+"')");
					dbconnect.getStmt().execute("CREATE TABLE ["+maGiai+"_"+txtMaDoi.getText()+"_Danh sách cầu thủ]([Mã cầu thủ] nvarchar(50),[Tên cầu thủ] nvarchar(50),[Ngày sinh] nvarchar(50),[Số áo] int,[Vị trí] nvarchar(50),PRIMARY KEY ([Mã cầu thủ]))");				
					txtMaDoi.setText("");
					txtTenDoi.setText("");
					txtDoiTruong.setText("");
					txtHLV.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào không thích hợp");
				}
				pnLichThiDau.updatecombobox(dbconnect);
				pnBangXepHang.updatecombobox(dbconnect);
				xepHang.XepHangDB(dbconnect);
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBounds(26, 226, 110, 30);
		add(btnThem);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("Img/save.png"));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "Chưa chọn hàng cần thay đổi!");
				}
				else {
					//model.setValueAt(txtMaGiai.getText(), row, 0);
					
					//String ma = txtMaGiai.getText();
					try {
						model.setValueAt(txtTenDoi.getText(), row, 1);
						model.setValueAt(txtDoiTruong.getText(), row, 2);
						model.setValueAt(txtHLV.getText(), row, 3);
						dbconnect.getStmt().execute("UPDATE ["+maGiai+"_Danh sách đội bóng] SET [Tên đội bóng]=N'"+txtTenDoi.getText()+"',[Đội trưởng]=N'"+txtDoiTruong.getText()+"',[Huấn luyện viên]=N'"+txtHLV.getText()+"' WHERE [Mã đội bóng]='"+txtMaDoi.getText()+"'");
						row = -1;
						txtMaDoi.setText("");
						txtTenDoi.setText("");
						txtDoiTruong.setText("");
						txtHLV.setText("");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào không thích hợp");
					}
					pnLichThiDau.updatecombobox(dbconnect);
					xepHang.XepHangDB(dbconnect);
				}
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBounds(151, 226, 110, 30);
		add(btnLuu);
		
		JButton btnNhapLai = new JButton("Nhập lại");
		btnNhapLai.setIcon(new ImageIcon("Img/reset.png"));
		btnNhapLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaDoi.setText("");
				txtTenDoi.setText("");
				txtDoiTruong.setText("");
				txtHLV.setText("");
				pnBangXepHang.updatecombobox(dbconnect);
			}
		});
		btnNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNhapLai.setBounds(270, 226, 110, 30);
		add(btnNhapLai);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("Img/remove.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row==-1) {
					JOptionPane.showMessageDialog(null,"Chưa chọn đội bóng cần xóa");
				}
				else {
					int xoa = JOptionPane.showConfirmDialog(null,"Bạn thật sự muốn xóa",null, JOptionPane.YES_NO_OPTION);
					if(xoa==JOptionPane.YES_OPTION) {
						try {
							dbconnect.getStmt().execute("DELETE FROM["+maGiai+"_Danh sách đội bóng] WHERE [Mã đội bóng]='"+txtMaDoi.getText()+"'");
							dbconnect.getStmt().execute("DROP TABLE ["+maGiai+"_"+maDoiBong+"_Danh sách cầu thủ]");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						model.removeRow(row);
						txtMaDoi.setText("");
						txtTenDoi.setText("");
						txtDoiTruong.setText("");
						txtHLV.setText("");
						pnLichThiDau.updatecombobox(dbconnect);
						pnBangXepHang.updatecombobox(dbconnect);
						xepHang.XepHangDB(dbconnect);
					}
					row=-1;
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(394, 226, 110, 30);
		add(btnXoa);
		
		btnXoaTatCa = new JButton("Xóa tất cả");
		btnXoaTatCa.setIcon(new ImageIcon("Img/remove.png"));
		btnXoaTatCa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoaTatCa.setBounds(517, 226, 110, 30);
		add(btnXoaTatCa);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Img/thoat.jpg"));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.setBounds(639, 226, 110, 30);
		add(btnThoat);
		
		btnDSCauThu = new JButton("Danh sách cầu thủ");
		btnDSCauThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDSCauThu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDSCauThu.setBounds(557, 116, 137, 50);
		add(btnDSCauThu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 286, 723, 223);
		add(scrollPane);
		
		tableDoiBong = new JTable();
		tableDoiBong.setAutoCreateRowSorter(true);
		tableDoiBong.setModel(new DefaultTableModel(
		));
		
		scrollPane.setViewportView(tableDoiBong);
		model.setColumnIdentifiers(HEADR);
		tableDoiBong.setModel(model);
		giaiDau.btnQuanLy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					maGiai = giaiDau.maGiaiDau;
					model.setNumRows(0);
					try {
						ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM["+maGiai+"_Danh sách đội bóng]");
						while(rs.next()) {
							model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}			
		});
		
		tableDoiBong.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				row = tableDoiBong.getSelectedRow();
				txtMaDoi.setText(model.getValueAt(row, 0).toString());
				txtTenDoi.setText(model.getValueAt(row, 1).toString());
				txtDoiTruong.setText(model.getValueAt(row, 2).toString());
				txtHLV.setText(model.getValueAt(row, 3).toString());
				maDoiBong = model.getValueAt(row,0).toString();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub		
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		pnLichThiDau.cbbMaDoi1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<model.getRowCount();i++) {
					if(model.getValueAt(i, 0).toString().equals(pnLichThiDau.cbbMaDoi1.getSelectedItem()))
						pnLichThiDau.cbbTenDoi1.setSelectedItem(model.getValueAt(i, 1).toString());
				}
			}			
		});
		
		pnLichThiDau.cbbMaDoi2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<model.getRowCount();i++) {
					if(model.getValueAt(i, 0).toString().equals(pnLichThiDau.cbbMaDoi2.getSelectedItem()))
						pnLichThiDau.cbbTenDoi2.setSelectedItem(model.getValueAt(i, 1).toString());
				}
			}	
		});
		
		pnLichThiDau.cbbTenDoi1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<model.getRowCount();i++) {
					if(model.getValueAt(i, 1).toString().equals(pnLichThiDau.cbbTenDoi1.getSelectedItem()))
						pnLichThiDau.cbbMaDoi1.setSelectedItem(model.getValueAt(i, 0).toString());
				}
			}			
		});
		
		pnLichThiDau.cbbTenDoi2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<model.getRowCount();i++) {
					if(model.getValueAt(i, 1).toString().equals(pnLichThiDau.cbbTenDoi2.getSelectedItem()))
						pnLichThiDau.cbbMaDoi2.setSelectedItem(model.getValueAt(i, 0).toString());
				}
			}			
		});
		
	}
	

	
}
