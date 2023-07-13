package GiaoDien1;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



import DBKetNoi.DBConnect;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class GiaiDau extends JPanel {
	
	private JTextField txtMaGiai;
	private JTextField txtTenGiai;
	private JTextField txtNgayBatDau;
	private JTextField txtNgayKetThuc;
	private JTable table_GiaiDau;
	JButton btnDanhSchi;
	JButton btnQuanLy;
	JButton btnXoa;
	DefaultTableModel model = new DefaultTableModel(0,0);
	String HEADR[] = new String[] {"Mã giải đấu","Tên giải đấu","Ngày bắt đầu","Ngày kết thúc"};
	DBConnect dbconnect;
	int row=-1;
	String maGiaiDau;
	/**
	 * Create the panel.
	 */
	public GiaiDau(DBConnect dbconnect ) {
		setBackground(new Color(51, 255, 102));
		this.dbconnect = dbconnect;
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Giải đấu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(347, 10, 89, 30);
		add(lblNewLabel_1);
		
		JLabel lblMaGiai = new JLabel("Mã giải đấu:");
		lblMaGiai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaGiai.setBounds(149, 46, 80, 19);
		add(lblMaGiai);
		
		txtMaGiai = new JTextField();
		txtMaGiai.setBounds(274, 39, 265, 26);
		add(txtMaGiai);
		txtMaGiai.setColumns(10);
		
		JLabel lblTenGiai = new JLabel("Tên giải:");
		lblTenGiai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenGiai.setBounds(149, 82, 80, 19);
		add(lblTenGiai);
		
		txtTenGiai = new JTextField();
		txtTenGiai.setBounds(274, 75, 265, 26);
		add(txtTenGiai);
		txtTenGiai.setColumns(10);
		
		JLabel lblNgayBatDau = new JLabel("Ngày bắt đầu:");
		lblNgayBatDau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgayBatDau.setBounds(149, 118, 80, 19);
		add(lblNgayBatDau);
		
		txtNgayBatDau = new JTextField();
		txtNgayBatDau.setColumns(10);
		txtNgayBatDau.setBounds(274, 111, 265, 26);
		
		add(txtNgayBatDau);
		
		JLabel lblNgayKetThuc = new JLabel("Ngày kết thúc:");
		lblNgayKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgayKetThuc.setBounds(149, 154, 96, 19);
		add(lblNgayKetThuc);
		
		txtNgayKetThuc = new JTextField();
		txtNgayKetThuc.setColumns(10);
		txtNgayKetThuc.setBounds(274, 147, 265, 26);
		add(txtNgayKetThuc);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Img/Insert.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//maGiaiDau = txtMaGiai.getText();
				try {
					dbconnect.getStmt().execute("INSERT INTO [Danh sách giải] VALUES(N'"+txtMaGiai.getText()+"',N'"+txtTenGiai.getText()+"',N'"+txtNgayBatDau.getText()+"',N'"+txtNgayKetThuc.getText()+"')");		
					dbconnect.getStmt().execute("CREATE TABLE ["+txtMaGiai.getText()+"_Danh sách đội bóng]([Mã đội bóng] nvarchar(50),[Tên đội bóng] nvarchar(50),[Đội trưởng] nvarchar(50),[Huấn luyện viên] nvarchar(50),PRIMARY KEY ([Mã đội bóng]))");
					dbconnect.getStmt().execute("CREATE TABLE ["+txtMaGiai.getText()+"_Bảng xếp hạng]([Đội bóng] nvarchar(50),[Số trận] int,[Thắng] int,[Hòa] int,[Thua] int,[Bàn thắng] int,[Bàn thua] int,[Hiệu số] int,[Điểm] int)");				
					dbconnect.getStmt().execute("CREATE TABLE ["+txtMaGiai.getText()+"_Lịch thi đấu]([Mã trận] nvarchar(50),[Ngày] nvarchar(50),[Giờ] nvarchar(50),[Sân] nvarchar(50),[Đội 1] nvarchar(50),[Bàn thắng đội 1] int,[Bàn thắng đội 2] int,[Đội 2] nvarchar(50),PRIMARY KEY ([Mã trận]))");				
					dbconnect.getStmt().execute("CREATE TABLE ["+txtMaGiai.getText()+"_Sân thi đấu] ([Tên sân] nvarchar(50), [Địa điểm] nvarchar(50), [Sức chứa] nvarchar(50))");
					model.addRow(new String[] {txtMaGiai.getText(),txtTenGiai.getText(),txtNgayBatDau.getText(),txtNgayKetThuc.getText()});
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào không thích hợp");
				}
				txtMaGiai.setText("");
				txtTenGiai.setText("");
				txtNgayBatDau.setText("");
				txtNgayKetThuc.setText("");
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBounds(27, 183, 110, 30);
		add(btnThem);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("Img/save.png"));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "Chưa chọn hàng cần thay đổi!");
				}
				else {
					//model.setValueAt(txtMaGiai.getText(), row, 0);
					try {
						model.setValueAt(txtTenGiai.getText(), row, 1);
						model.setValueAt(txtNgayBatDau.getText(), row, 2);
						model.setValueAt(txtNgayKetThuc.getText(), row, 3);
						String ma = txtMaGiai.getText();
						dbconnect.getStmt().execute("UPDATE [Danh sách giải] SET [Tên giải đấu]=N'"+txtTenGiai.getText()+"',[Ngày kết thúc]=N'"+txtNgayBatDau.getText()+"',[Ngày bắt đầu]=N'"+txtNgayKetThuc.getText()+"' WHERE [Mã giải đấu]='"+ma+"'");
						txtMaGiai.setText("");
						txtTenGiai.setText("");
						txtNgayBatDau.setText("");
						txtNgayKetThuc.setText("");
						row = -1;
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Dữ liệu nhập vào không thích hợp");
					}
					
				}
			}
		});
		
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBounds(149, 183, 110, 30);
		add(btnLuu);
		
		JButton btnNhapLai = new JButton("Nhập lại");
		btnNhapLai.setIcon(new ImageIcon("Img/reset.png"));
		btnNhapLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaGiai.setText("");
				txtTenGiai.setText("");
				txtNgayBatDau.setText("");
				txtNgayKetThuc.setText("");
			}
		});
		btnNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNhapLai.setBounds(274, 183, 110, 30);
		add(btnNhapLai);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("Img/remove.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row==-1) {
					JOptionPane.showMessageDialog(null,"Chưa chọn giải cần xóa");
				}
				else {
					int xoa = JOptionPane.showConfirmDialog(null,"Bạn thật sự muốn xóa",null, JOptionPane.YES_NO_OPTION);
					if(xoa==JOptionPane.YES_OPTION) {
						model.removeRow(row);
						try {
							dbconnect.getStmt().execute("DELETE FROM [Danh sách giải] WHERE [Mã giải đấu]='"+txtMaGiai.getText()+"'");
							dbconnect.getStmt().execute("DROP TABLE ["+maGiaiDau+"_Danh sách đội bóng]");
							dbconnect.getStmt().execute("DROP TABLE ["+maGiaiDau+"_Bảng xếp hạng]");
							dbconnect.getStmt().execute("DROP TABLE ["+maGiaiDau+"_Lịch thi đấu]");
							dbconnect.getStmt().execute("DROP TABLE ["+maGiaiDau+"_Sân thi đấu]");
							maGiaiDau=null;
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						row = -1;
						txtMaGiai.setText("");
						txtTenGiai.setText("");
						txtNgayBatDau.setText("");
						txtNgayKetThuc.setText("");
						
					}
				}
					
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(395, 183, 110, 30);
		add(btnXoa);
		
		JButton btnXoaTatCa = new JButton("Xóa tất cả");
		btnXoaTatCa.setIcon(new ImageIcon("Img/remove.png"));
		btnXoaTatCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Bạn không thể xóa tất cả các giải đấu cùng một lúc");
			}
		});
		btnXoaTatCa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoaTatCa.setBounds(520, 183, 110, 30);
		add(btnXoaTatCa);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Img/thoat.jpg"));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.setBounds(642, 183, 110, 30);
		add(btnThoat);
		
		btnDanhSchi = new JButton("Danh sách đội bóng");
		btnDanhSchi.setBackground(UIManager.getColor("Button.background"));
		btnDanhSchi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDanhSchi.setBounds(591, 74, 144, 35);
		//btnDanhSchi.setBorder();
		add(btnDanhSchi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 245, 716, 245);
		add(scrollPane);
		table_GiaiDau = new JTable();
		table_GiaiDau.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table_GiaiDau);
		model.setColumnIdentifiers(HEADR);
		table_GiaiDau.setModel(model);
		
		btnQuanLy = new JButton("Quản lý");
		btnQuanLy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row<0) {
					JOptionPane.showMessageDialog(null,"Chọn giải đấu cần quản lý!");
				}
				else{
					maGiaiDau = model.getValueAt(row, 0).toString();
				}
			}
		});
		btnQuanLy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQuanLy.setBounds(626, 131, 85, 30);
		add(btnQuanLy);
		//dbconnect = new DBConnect();
		try {
			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM [Danh sách giải]");
			while(rs.next()) {
				model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table_GiaiDau.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				row = table_GiaiDau.getSelectedRow();
				String maGD =model.getValueAt(row, 0).toString();
				String tenGD = model.getValueAt(row, 1).toString();
				String ngayBD = model.getValueAt(row, 2).toString();
				String ngayKT = model.getValueAt(row, 3).toString();
				maGiaiDau = maGD;
				txtMaGiai.setText(maGD);
				txtTenGiai.setText(tenGD);
				txtNgayBatDau.setText(ngayBD);
				txtNgayKetThuc.setText(ngayKT);
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
		
		
		

	}
}
