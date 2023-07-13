package GiaoDien1;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import DBKetNoi.DBConnect;
import Object.XepHang;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PanelLichThidau extends JPanel {
	private JTextField txtMaTran;
	private JTextField txtNgay;
	private JTextField txtGio;
	private JTextField txtSan;
	private JTable table;
	PanelDoiBong pnDoiBong;
	PanelBangXepHang pnBangXepHang;
	JButton btnCapNhapKQ;
	DBConnect dbconnect;
	String maGiai;
	JComboBox cbbMaDoi1;
	JComboBox cbbMaDoi2;
	JComboBox cbbTenDoi1;
	JComboBox cbbTenDoi2;
	JButton btnThem,btnLuu,btnXoa;
	int row =-1;
	String maTran;
	public static DefaultTableModel model = new DefaultTableModel(0,0);
	String HEADR[] = new String[] {"Mã trận","Ngày" ,"Giờ","Sân","Đội 1","Bàn thắng đội 1","Bàn thắng đội 2","Đội 2"};
	/**
	 * Create the panel.
	 */
	public PanelLichThidau(GiaiDau giaiDau, DBConnect dbconnect,KetQuaTranDau kqTranDau,PanelBangXepHang pnBangXepHang, XepHang xepHang) {
		setBackground(new Color(51, 255, 102));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lịch thi đấu");
		lblNewLabel.setBounds(336, 5, 94, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã trận:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(109, 33, 74, 26);
		add(lblNewLabel_1);
		
		txtMaTran = new JTextField();
		txtMaTran.setBounds(221, 35, 242, 26);
		add(txtMaTran);
		txtMaTran.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(109, 69, 74, 26);
		add(lblNewLabel_1_1);
		
		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(221, 70, 242, 26);
		add(txtNgay);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giờ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(109, 105, 74, 26);
		add(lblNewLabel_1_1_1);
		
		txtGio = new JTextField();
		txtGio.setColumns(10);
		txtGio.setBounds(221, 105, 242, 26);
		add(txtGio);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Sân");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(109, 141, 74, 26);
		add(lblNewLabel_1_1_1_1);
		
		txtSan = new JTextField();
		txtSan.setColumns(10);
		txtSan.setBounds(221, 140, 242, 26);
		add(txtSan);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Đội 1:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(109, 177, 74, 26);
		add(lblNewLabel_1_1_1_1_1);
		
		cbbMaDoi1 = new JComboBox();
		cbbMaDoi1.setBounds(221, 175, 74, 28);
		add(cbbMaDoi1);
		
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Đội 2:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(109, 213, 74, 26);
		add(lblNewLabel_1_1_1_1_1_1);
		
		cbbMaDoi2 = new JComboBox();
		cbbMaDoi2.setBounds(221, 213, 74, 26);
		add(cbbMaDoi2);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Img/Insert.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.addRow(new String[]{txtMaTran.getText(),txtNgay.getText(),txtGio.getText(),txtSan.getText(),cbbMaDoi1.getSelectedItem().toString(),"","",cbbMaDoi2.getSelectedItem().toString()});
					dbconnect.getStmt().execute("INSERT INTO["+maGiai+"_Lịch thi đấu] VALUES(N'"+txtMaTran.getText()+"',N'"+txtNgay.getText()+"',N'"+txtGio.getText()+"',N'"+txtSan.getText()+"',N'"+cbbMaDoi1.getSelectedItem().toString()+"',"+null+","+null+",N'"+cbbMaDoi2.getSelectedItem().toString()+"')");
					txtMaTran.setText("");
					txtNgay.setText("");
					txtGio.setText("");
					txtSan.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Dữ Liệu nhập vào không thích hợp");
				}
				//xepHang.XepHangDB(dbconnect);
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBounds(23, 257, 110, 30);
		add(btnThem);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("Img/save.png"));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//model.setValueAt(txtMaTran.getText(), row, 0);
					model.setValueAt(txtNgay.getText(), row, 1);
					model.setValueAt(txtGio.getText(), row, 2);
					model.setValueAt(txtSan.getText(), row, 3);
					model.setValueAt(cbbMaDoi1.getSelectedItem().toString(), row, 4);
					model.setValueAt(cbbMaDoi2.getSelectedItem().toString(), row, 7);
					dbconnect.getStmt().execute("UPDATE ["+maGiai+"_Lịch thi đấu] SET [Ngày]=N'"+txtNgay.getText()+"',[Giờ]=N'"+txtGio.getText()+"',[Đội 1]=N'"+cbbMaDoi1.getSelectedItem().toString()+"',[Đội 2]=N'"+cbbMaDoi2.getSelectedItem().toString()+"' WHERE [Mã trận]='"+maTran+"'");
					txtMaTran.setText("");
					txtNgay.setText("");
					txtGio.setText("");
					txtSan.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào không thích hợp");
				}
				xepHang.XepHangDB(dbconnect);
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBounds(144, 257, 110, 30);
		add(btnLuu);
		
		JButton btnNhapLai = new JButton("Nhập lại");
		btnNhapLai.setIcon(new ImageIcon("Img/reset.png"));
		btnNhapLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaTran.setText("");
				txtNgay.setText("");
				txtGio.setText("");
				txtSan.setText("");
			}
		});
		btnNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNhapLai.setBounds(266, 257, 110, 30);
		add(btnNhapLai);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("Img/remove.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "Chọn trận đấu bạn muốn xóa thông tin");
				}
				int xoa = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa thông tin trận đấu", null, JOptionPane.YES_NO_OPTION);
				if(xoa == JOptionPane.YES_NO_OPTION) {
					try {
						dbconnect.getStmt().execute("DELETE FROM["+maGiai+"_Lịch thi đấu] WHERE [Mã trận]='"+txtMaTran.getText()+"'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					model.removeRow(row);
					txtMaTran.setText("");
					txtNgay.setText("");
					txtGio.setText("");
					txtSan.setText("");
					xepHang.XepHangDB(dbconnect);
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(389, 257, 110, 30);
		add(btnXoa);
		
		JButton btnXoaTatCa = new JButton("Xóa tất cả");
		btnXoaTatCa.setIcon(new ImageIcon("Img/remove.png"));
		btnXoaTatCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa tất cả các trận đấu", null, JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					model.setNumRows(0);
					try {
						dbconnect.getStmt().executeUpdate("DELETE FROM ["+maGiai+"_Lịch thi đấu]");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					xepHang.XepHangDB(dbconnect);
				}
			}
		});
		btnXoaTatCa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoaTatCa.setBounds(515, 257, 110, 30);
		add(btnXoaTatCa);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Img/thoat.jpg"));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.setBounds(640, 257, 110, 30);
		add(btnThoat);
		
		btnCapNhapKQ = new JButton("Cập nhật kết quả");
		btnCapNhapKQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "Chọn trận đấu cần cập nhật kết quả");
				}
				else {
				kqTranDau.setVisible(true);
				}
			}
		});
		
		
		btnCapNhapKQ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCapNhapKQ.setBounds(550, 113, 137, 50);
		add(btnCapNhapKQ);

		kqTranDau.btnLuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if((kqTranDau.txtDoi1.getText().equals(""))||(kqTranDau.txtDoi2.getText().equals(""))||(kqTranDau.txtDoi2.getText().equals(null))||(kqTranDau.txtDoi2.getText().equals(null))) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập tỉ số của trận đấu");
				}
				else {
					try {
						model.setValueAt(kqTranDau.txtDoi1.getText(), row, 5);
						model.setValueAt(kqTranDau.txtDoi2.getText(), row, 6);
						dbconnect.getStmt().execute("UPDATE ["+maGiai+"_Lịch thi đấu] SET [Bàn thắng đội 1]=N'"+kqTranDau.txtDoi1.getText()+"',[Bàn thắng đội 2]=N'"+kqTranDau.txtDoi2.getText()+"'WHERE [Mã trận]='"+maTran+"'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Dữ liệu nhập vào không thích hợp");
					}
					kqTranDau.txtDoi1.setText(null);
					kqTranDau.txtDoi2.setText(null);
					kqTranDau.setVisible(false);
					xepHang.XepHangDB(dbconnect);
				}
			}			
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 297, 727, 212);
		add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);

		
		scrollPane.setViewportView(table);
		model.setColumnIdentifiers(HEADR);
		table.setModel(model);
		
		cbbTenDoi1 = new JComboBox();
		cbbTenDoi1.setBounds(317, 175, 146, 28);
		add(cbbTenDoi1);
		
		cbbTenDoi2 = new JComboBox();
		cbbTenDoi2.setBounds(317, 211, 146, 28);
		add(cbbTenDoi2);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				row = table.getSelectedRow();
				txtMaTran.setText(model.getValueAt(row, 0).toString());
				txtNgay.setText(model.getValueAt(row, 1).toString());
				txtGio.setText(model.getValueAt(row, 2).toString());
				txtSan.setText(model.getValueAt(row, 3).toString());
				cbbMaDoi1.setSelectedItem(model.getValueAt(row, 4));
				cbbMaDoi2.setSelectedItem(model.getValueAt(row, 7));
				maTran = model.getValueAt(row, 0).toString();
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
		giaiDau.btnQuanLy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(giaiDau.row!=-1) {
					maGiai = giaiDau.maGiaiDau;
					model.setNumRows(0);
					try {
						ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM["+maGiai+"_Lịch thi đấu]");
						while(rs.next()) {
							model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
						}
						updatecombobox(dbconnect);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		
		
		
	}
	public void updatecombobox(DBConnect dbconnect) {
		
		try {
			cbbTenDoi1.removeAllItems();
			cbbMaDoi1.removeAllItems();
			cbbTenDoi2.removeAllItems();
			cbbMaDoi2.removeAllItems();
			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM["+maGiai+"_Danh sách đội bóng]");
			while(rs.next()) {
				cbbTenDoi1.addItem(rs.getString(2));
				cbbMaDoi1.addItem(rs.getString(1));
				cbbTenDoi2.addItem(rs.getString(2));
				cbbMaDoi2.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
