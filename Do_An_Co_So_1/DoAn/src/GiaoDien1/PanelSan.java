package GiaoDien1;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBKetNoi.DBConnect;

import java.awt.Color;
import javax.swing.ImageIcon;

public class PanelSan extends JPanel {
	private JTextField txtTenSan;
	private JTextField txtDiaDiem;
	private JTextField txtSucChua;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel(0,0);
	String HEADR[] = new String[] {"Tên sân","Địa điểm","Sức chứa"};
	int row = -1;
	String maGiai;
	/**
	 * Create the panel.
	 */
	public PanelSan(GiaiDau giaiDau,DBConnect dbconnect) {
		setBackground(new Color(51, 255, 102));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh sách sân thi đấu");
		lblNewLabel.setBounds(294, 5, 178, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên sân:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(99, 74, 96, 33);
		add(lblNewLabel_1);
		
		txtTenSan = new JTextField();
		txtTenSan.setBounds(230, 74, 230, 33);
		add(txtTenSan);
		txtTenSan.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Địa điểm:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(99, 117, 96, 33);
		add(lblNewLabel_1_1);
		
		txtDiaDiem = new JTextField();
		txtDiaDiem.setColumns(10);
		txtDiaDiem.setBounds(230, 117, 230, 33);
		add(txtDiaDiem);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Sức chứa:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(99, 160, 96, 33);
		add(lblNewLabel_1_1_1);
		
		txtSucChua = new JTextField();
		txtSucChua.setColumns(10);
		txtSucChua.setBounds(230, 160, 230, 33);
		add(txtSucChua);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Img/Insert.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addRow(new String[] {txtTenSan.getText(),txtDiaDiem.getText(),txtSucChua.getText()});
				try {
					dbconnect.getStmt().execute("INSERT INTO ["+maGiai+"_Sân thi đấu] VALUES(N'"+txtTenSan.getText()+"',N'"+txtDiaDiem.getText()+"',N'"+txtSucChua.getText()+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtTenSan.setText("");
				txtDiaDiem.setText("");
				txtSucChua.setText("");
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBounds(10, 226, 110, 30);
		add(btnThem);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("Img/save.png"));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "Chưa chọn hàng cần thay đổi!");
				}
				else {
					String tenSan = model.getValueAt(row, 0).toString();
					model.setValueAt(txtTenSan.getText(), row, 0);
					model.setValueAt(txtDiaDiem.getText(), row, 1);
					model.setValueAt(txtSucChua.getText(), row, 2);
					row = -1;
					//String ma = txtMaGiai.getText();
					try {
						dbconnect.getStmt().execute("UPDATE ["+maGiai+"_Sân thi đấu] SET [Tên sân]=N'"+txtTenSan.getText()+"',[Địa điểm]=N'"+txtDiaDiem.getText()+"',[Sức chứa]=N'"+txtSucChua.getText()+"' WHERE [Tên sân]='"+tenSan+"'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					txtTenSan.setText("");
					txtDiaDiem.setText("");
					txtSucChua.setText("");
				}
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBounds(133, 226, 110, 30);
		add(btnLuu);
		
		JButton btnNhapLai = new JButton("Nhập lại");
		btnNhapLai.setIcon(new ImageIcon("Img/reset.png"));
		btnNhapLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtTenSan.setText("");
				txtDiaDiem.setText("");
				txtSucChua.setText("");
			}
			
		});
		btnNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNhapLai.setBounds(259, 226, 110, 30);
		add(btnNhapLai);
		
		JButton btnXoa = new JButton("Xóa");
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
							dbconnect.getStmt().executeUpdate("DELETE FROM["+maGiai+"_Sân thi đấu] WHERE [Tên sân] = N'"+txtTenSan.getText()+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						model.removeRow(row);
						txtTenSan.setText("");
						txtDiaDiem.setText("");
						txtSucChua.setText("");
					}
					row=-1;
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(386, 226, 110, 30);
		add(btnXoa);
		
		JButton btnXoaTatCa = new JButton("Xóa tất cả");
		btnXoaTatCa.setIcon(new ImageIcon("Img/remove.png"));
		btnXoaTatCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa tất cả các sân thi đấu", null, JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					model.setNumRows(0);
					try {
						dbconnect.getStmt().executeUpdate("DELETE FROM ["+maGiai+"_Sân thi đấu]");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnXoaTatCa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoaTatCa.setBounds(515, 226, 110, 30);
		add(btnXoaTatCa);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Img/thoat.jpg"));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.setBounds(639, 226, 110, 30);
		add(btnThoat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 291, 739, 218);
		add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		model.setColumnIdentifiers(HEADR);
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				row = table.getSelectedRow();
				txtTenSan.setText(model.getValueAt(row, 0).toString());
				txtDiaDiem.setText(model.getValueAt(row, 1).toString());
				txtSucChua.setText(model.getValueAt(row, 2).toString());
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
				maGiai = giaiDau.maGiaiDau;
				model.setNumRows(0);
				try {
					ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM["+maGiai+"_Sân thi đấu]");
					while(rs.next()) {
						model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3)});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}
}
