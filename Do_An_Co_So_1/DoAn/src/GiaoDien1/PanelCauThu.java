package GiaoDien1;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;

import javax.swing.ButtonGroup;
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

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PanelCauThu extends JPanel {
	private JTextField txtMaCauThu;
	private JTextField txtTenCauThu;
	private JTextField txtNgaySinh;
	private JTextField txtSoAo;
	private JTable table;
	JButton btnThoat;
	String maCauThu;
	String maDoi;
	String maGiai;
	private String vitri=null;
	int row=-1;
	DefaultTableModel model = new DefaultTableModel(0,0);
	String HEADR[] = new String[] {"Mã cầu thủ","Tên cầu thủ","Ngày sinh","số áo","vị trí"};
	/**
	 * Create the panel.
	 */
	public PanelCauThu(DBConnect dbconnect,PanelDoiBong pnDoiBong,GiaiDau giaiDau,XepHang xepHang) {
		setBackground(new Color(51, 255, 102));
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Danh sách cầu thủ");
		lblNewLabel.setBounds(308, 5, 150, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNewLabel);
		
		JLabel lblMaCauThu = new JLabel("Mã cầu thủ:");
		lblMaCauThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaCauThu.setBounds(121, 58, 81, 27);
		add(lblMaCauThu);
		
		txtMaCauThu = new JTextField();
		txtMaCauThu.setBounds(249, 58, 209, 26);
		add(txtMaCauThu);
		txtMaCauThu.setColumns(10);
		
		JLabel lblTenCauThu = new JLabel("Tên cầu thủ:");
		lblTenCauThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenCauThu.setBounds(121, 95, 81, 27);
		add(lblTenCauThu);
		
		txtTenCauThu = new JTextField();
		txtTenCauThu.setColumns(10);
		txtTenCauThu.setBounds(249, 95, 209, 26);
		add(txtTenCauThu);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgaySinh.setBounds(121, 132, 81, 27);
		add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(249, 132, 209, 26);
		add(txtNgaySinh);
		
		JLabel lblSoAo = new JLabel("Số áo:");
		lblSoAo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoAo.setBounds(121, 169, 81, 27);
		add(lblSoAo);
		
		txtSoAo = new JTextField();
		txtSoAo.setColumns(10);
		txtSoAo.setBounds(249, 169, 209, 26);
		add(txtSoAo);
		
		JLabel lblViTri = new JLabel("Vị trí:");
		lblViTri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblViTri.setBounds(121, 206, 81, 27);
		add(lblViTri);
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnThuMon = new JRadioButton("Thủ môn");
		rdbtnThuMon.setBounds(218, 211, 103, 21);
		bg.add(rdbtnThuMon);
		add(rdbtnThuMon);
		rdbtnThuMon.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				vitri = rdbtnThuMon.getText();
				//System.out.print(vitri);
			}		
		});
		
		JRadioButton rdbtnHauVe = new JRadioButton("Hậu vệ");
		rdbtnHauVe.setBounds(323, 211, 103, 21);
		bg.add(rdbtnHauVe);
		add(rdbtnHauVe);
		rdbtnHauVe.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				vitri = rdbtnHauVe.getText();
			}			
		});
	
		JRadioButton rdbtnTienVe = new JRadioButton("Tiền vệ");
		rdbtnTienVe.setBounds(428, 211, 103, 21);
		bg.add(rdbtnTienVe);
		add(rdbtnTienVe);
		rdbtnTienVe.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				vitri = rdbtnTienVe.getText();
			}
		});
		
		
		JRadioButton rdbtnTienDao = new JRadioButton("Tiền đạo");
		rdbtnTienDao.setBounds(533, 211, 103, 21);
		bg.add(rdbtnTienDao);
		add(rdbtnTienDao);
		rdbtnTienDao.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				vitri = rdbtnTienDao.getText();
			}
		});
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Img/Insert.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vitri==null) JOptionPane.showMessageDialog(null, "Chọn vị trí cầu thủ.");
				else {
					try {
						dbconnect.getStmt().execute("INSERT INTO["+maGiai+"_"+maDoi+"_Danh sách cầu thủ] VALUES(N'"+txtMaCauThu.getText()+"',N'"+txtTenCauThu.getText()+"',N'"+txtNgaySinh.getText()+"',N'"+txtSoAo.getText()+"',N'"+vitri+"')");
						model.addRow(new String[] {txtMaCauThu.getText(),txtTenCauThu.getText(),txtNgaySinh.getText(),txtSoAo.getText(),vitri});
						txtMaCauThu.setText("");
						txtTenCauThu.setText("");
						txtNgaySinh.setText("");
						txtSoAo.setText("");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào không thích hợp");
					}
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBounds(10, 255, 110, 30);
		add(btnThem);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("Img/save.png"));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "Chọn hàng cần thay đổi");
				}
				else{
					try {
						dbconnect.getStmt().execute("UPDATE ["+maGiai+"_"+maDoi+"_Danh sách cầu thủ] SET [Mã cầu thủ]=N'"+txtMaCauThu.getText()+"',[Tên cầu thủ]=N'"+txtTenCauThu.getText()+"',[Ngày sinh]=N'"+txtNgaySinh.getText()+"',[Số áo]=N'"+txtSoAo.getText()+"',[Vị trí]=N'"+vitri+"' WHERE [Mã cầu thủ]='"+maCauThu+"'");
						model.setValueAt(txtMaCauThu.getText(), row, 0);
						model.setValueAt(txtTenCauThu.getText(), row, 1);
						model.setValueAt(txtNgaySinh.getText(), row, 2);
						model.setValueAt(txtSoAo.getText(), row, 3);
						model.setValueAt(vitri, row, 4);
						txtMaCauThu.setText("");
						txtTenCauThu.setText("");
						txtNgaySinh.setText("");
						txtSoAo.setText("");
						row=-1;
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Dữ liệu nhập vào không thích hợp");
					}
					
				}
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBounds(134, 255, 110, 30);
		add(btnLuu);
		
		JButton btnNhapLai = new JButton("Nhập lại");
		btnNhapLai.setIcon(new ImageIcon("Img/reset.png"));
		btnNhapLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaCauThu.setText("");
				txtTenCauThu.setText("");
				txtNgaySinh.setText("");
				txtSoAo.setText("");
			}
		});
		btnNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNhapLai.setBounds(260, 255, 110, 30);
		add(btnNhapLai);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("Img/remove.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "chọn hàng để xóa");
				}
				else {
					int xoa = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa cầu thủ đã chọn", null, JOptionPane.YES_NO_OPTION);
					if(xoa==JOptionPane.YES_OPTION) {
						try {
							dbconnect.getStmt().execute("DELETE FROM["+maGiai+"_"+maDoi+"_Danh sách cầu thủ] WHERE [Mã cầu thủ]='"+txtMaCauThu.getText()+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						model.removeRow(row);
						txtMaCauThu.setText("");
						txtTenCauThu.setText("");
						txtNgaySinh.setText("");
						txtSoAo.setText("");
					}
				}
				row=-1;
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(390, 255, 110, 30);
		add(btnXoa);
		
		JButton btnXoaTatCa = new JButton("Xóa tất cả");
		btnXoaTatCa.setIcon(new ImageIcon("Img/remove.png"));
		btnXoaTatCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int xoatatca = JOptionPane.showConfirmDialog(null, "Bạn thực muốn xóa tất cả cầu thủ",null,JOptionPane.YES_NO_OPTION);
				if(xoatatca==JOptionPane.YES_OPTION) {
					try {
						dbconnect.getStmt().execute("DELETE FROM["+maGiai+"_"+maDoi+"_Danh sách cầu thủ]");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					model.setNumRows(0);
				}
			}
		});
		btnXoaTatCa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoaTatCa.setBounds(515, 255, 110, 30);
		add(btnXoaTatCa);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Img/thoat.jpg"));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.setBounds(643, 255, 110, 30);
		add(btnThoat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 307, 743, 202);
		add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		model.setColumnIdentifiers(HEADR);
		table.setModel(model);
		
		
		pnDoiBong.btnDSCauThu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				maDoi = pnDoiBong.maDoiBong;
				maGiai = pnDoiBong.maGiai;
				model.setNumRows(0);
				if(pnDoiBong.row==-1) {
					JOptionPane.showMessageDialog(null,"Chọn đội bóng cần cập nhật danh sách");
				}
				else {
					try {
						ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM["+maGiai+"_"+maDoi+"_Danh sách cầu thủ]");
						while(rs.next()) {
							model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				row = table.getSelectedRow();
				txtMaCauThu.setText(model.getValueAt(row, 0).toString());
				txtTenCauThu.setText(model.getValueAt(row, 1).toString());
				txtNgaySinh.setText(model.getValueAt(row, 2).toString());
				txtSoAo.setText(model.getValueAt(row, 3).toString());
				maCauThu = model.getValueAt(row, 0).toString();
				//txtViTri.setText(model.getValueAt(row, 4).toString());
				if(model.getValueAt(row, 4).toString().equals(rdbtnTienDao.getText())) rdbtnTienDao.setSelected(true);
				else if(model.getValueAt(row, 4).toString().equals(rdbtnHauVe.getText())) rdbtnHauVe.setSelected(true);
				else if(model.getValueAt(row, 4).toString().equals(rdbtnTienVe.getText())) rdbtnTienVe.setSelected(true);
				else if(model.getValueAt(row, 4).toString().equals(rdbtnThuMon.getText())) rdbtnThuMon.setSelected(true);
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
		giaiDau.btnXoa.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<pnDoiBong.model.getRowCount();i++) {
					try {
						dbconnect.getStmt().execute("DROP TABLE ["+giaiDau.maGiaiDau+"_"+pnDoiBong.model.getValueAt(i,0)+"_Danh sách cầu thủ]");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				model.setNumRows(0);
				pnDoiBong.model.setNumRows(0);
			}
			
		});
		pnDoiBong.btnXoaTatCa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int xoaTatCa = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa tất cả đội bóng", null, JOptionPane.YES_NO_OPTION);
				if(xoaTatCa == JOptionPane.YES_OPTION) {
					for(int i=0;i<pnDoiBong.model.getRowCount();i++) {
						try {
							dbconnect.getStmt().execute("DROP TABLE ["+maGiai+"_"+pnDoiBong.model.getValueAt(i,0)+"_Danh sách cầu thủ]");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					model.setNumRows(0);
					pnDoiBong.model.setNumRows(0);
					try {
						dbconnect.getStmt().execute("DELETE TABLE ["+pnDoiBong.maGiai+"_Danh sách đội bóng]");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					xepHang.XepHangDB(dbconnect);
				}
			}
						
		});
	}
}
