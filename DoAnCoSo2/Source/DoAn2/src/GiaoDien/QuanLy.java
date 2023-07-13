package GiaoDien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import DBKetNoi.DBConnect;
import ObjectDoiBong.XepHang;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class QuanLy extends JPanel implements ActionListener{
	//DBConnect dbconnect;
	GiaiDau pnGiaiDau;
	DoiBong pnDoiBong;
	TrongTai pnTrongTai;
	San pnSan;
	BangDau pnBangDau;
	TranDau pnTranDau;
	ChiTietBangDau pnChiTietBangDau;
	TranDau_Bang pnLichBang;
	JPanel panel_2;
	JButton btnGiaiDau;
	JButton btnDoiBong;
	JButton btnBangDau;
	JButton btnTranDau; 
	JButton btnSan;
	JButton btnTrongTai;
	CardLayout card;
	DanhSachCauThu pnDanhSachCT;
	/**
	 * Create the panel.
	 */
	public QuanLy(DBConnect dbconnect) {
		setBackground(Color.getHSBColor(222, 222, 222));
		setSize(980, 680);
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel titleGiaiDau = new JLabel();
		titleGiaiDau.setIcon(new ImageIcon("img\\backgroundGiaiDau.jpg"));
		titleGiaiDau.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(titleGiaiDau);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.getHSBColor(255, 250, 150));
		add(panel_1, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.getHSBColor(255, 250, 150));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(36)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		panel_3.setLayout(new GridLayout(0, 1, 0, 20));
		
		btnGiaiDau = new JButton("Giải đấu");
		btnGiaiDau.setBackground(new Color(100, 240, 250));
		panel_3.add(btnGiaiDau);
		
		btnDoiBong = new JButton("Đội bóng");
		btnDoiBong.setBackground(new Color(100, 240, 250));
		panel_3.add(btnDoiBong);
		
		btnSan = new JButton("Sân ");
		btnSan.setBackground(new Color(100, 240, 250));
		panel_3.add(btnSan);
		
		btnBangDau = new JButton("Bảng đấu");
		btnBangDau.setBackground(new Color(100, 240, 250));
		panel_3.add(btnBangDau);
		
		btnTranDau = new JButton("Trận đấu");
		btnTranDau.setBackground(new Color(100, 240, 250));
		panel_3.add(btnTranDau);
		
		btnTrongTai = new JButton("Trọng tài");
		btnTrongTai.setBackground(new Color(100, 240, 250));
		panel_3.add(btnTrongTai);
		panel_1.setLayout(gl_panel_1);
		
		card = new CardLayout();
		panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(card);
		
		pnGiaiDau = new GiaiDau(dbconnect);
		panel_2.add("name_GiaiDau",pnGiaiDau);
		
		pnDoiBong = new DoiBong(dbconnect);
		panel_2.add("name_DoiBong",pnDoiBong);
		
		pnSan = new San(dbconnect);
		panel_2.add("name_San",pnSan);
		
		pnTrongTai = new TrongTai(dbconnect);
		panel_2.add("name_TrongTai",pnTrongTai);
		
		pnBangDau = new BangDau(dbconnect);
		panel_2.add("name_BangDau",pnBangDau);
		
		pnChiTietBangDau = new ChiTietBangDau(dbconnect);
		panel_2.add("name_ChiTietBangDau",pnChiTietBangDau);
		
		pnTranDau = new TranDau(dbconnect);
		panel_2.add("name_TranDau",pnTranDau);
		
		pnLichBang = new TranDau_Bang(dbconnect);
		panel_2.add("name_LichBang",pnLichBang);
		
		pnDanhSachCT = new DanhSachCauThu(dbconnect);
		panel_2.add("name_DanhSachCT",pnDanhSachCT);
		
		batSukien(dbconnect);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void batSukien(DBConnect dbconnect) {
		btnGiaiDau.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(panel_2, "name_GiaiDau");
			}
		});
		
		btnDoiBong.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pnGiaiDau.maGiai==null) {
					JOptionPane.showMessageDialog(null, "Chọn giải đấu mà bạn cần quản lý trước khi thực hiện các chức năng");
				}
				else {
					card.show(panel_2, "name_DoiBong");
					pnDoiBong.lblTitle.setText("Giải đấu: "+pnGiaiDau.tenGiai);
				}
				EventDoiBong(dbconnect);
			}
		});
		
		pnDoiBong.btnCauThu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pnDoiBong.maDoi==null) {
					JOptionPane.showMessageDialog(null, "Chọn đội bóng để xem cầu thủ");
				}
				else {
					card.show(panel_2, "name_DanhSachCT");
					pnDanhSachCT.lblTitle.setText("Đội Bóng: "+pnDoiBong.tenDoi);
					EventCauThu(dbconnect);
				}
			}
		});
		btnBangDau.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pnGiaiDau.maGiai==null) {
					JOptionPane.showMessageDialog(null, "Chọn giải đấu mà bạn cần quản lý trước khi thực hiện các chức năng");
				}
				else {
					card.show(panel_2, "name_BangDau");		
					pnBangDau.lblTitle.setText("Giải đấu: "+pnGiaiDau.tenGiai);
					EventBangDau(dbconnect);
				}
			}
		});
		btnSan.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pnGiaiDau.maGiai==null) {
					JOptionPane.showMessageDialog(null, "Chọn giải đấu mà bạn cần quản lý trước khi thực hiện các chức năng");
				}
				else {
					EventSan(dbconnect);
					card.show(panel_2, "name_San");
					pnSan.lblTitle.setText("Giải đấu: "+pnGiaiDau.tenGiai);
				}
			}
		});
		
		btnTrongTai.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pnGiaiDau.maGiai==null) {
					JOptionPane.showMessageDialog(null, "Chọn giải đấu mà bạn cần quản lý trước khi thực hiện các chức năng");
				}
				else {
					EventTrongTai(dbconnect);
					card.show(panel_2, "name_TrongTai");
					pnTrongTai.lblTitle.setText("Giải đấu: "+pnGiaiDau.tenGiai);
				}
			}
		});
		pnBangDau.btnXemChiTiet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pnBangDau.maBang==null) {
					JOptionPane.showMessageDialog(null, "Chọn bảng đấu");
				}
				else {
					card.show(panel_2, "name_ChiTietBangDau");
					pnChiTietBangDau.lblTitle.setText("Bảng đấu: "+pnBangDau.tenBang);
					EventChiTietBangDau(dbconnect);
					XepHang.XepHang(dbconnect);
				}
			}
		});
		pnChiTietBangDau.btnLichThiDau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(panel_2, "name_LichBang");
				pnLichBang.lblTitle.setText("Bảng đấu: "+pnBangDau.tenBang);
				EventLichBang(dbconnect);
			}
		});
		
		btnTranDau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pnGiaiDau.maGiai==null) {
					JOptionPane.showMessageDialog(null, "Chọn giải đấu mà bạn cần quản lý trước khi thực hiện các chức năng");
				}
				else {
					card.show(panel_2, "name_TranDau");
					pnTranDau.lblTitle.setText("Giải đấu: "+pnGiaiDau.tenGiai);
					EventTranDau(dbconnect);
				}
			}
		});
		
		pnLichBang.btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pnBangDau.maBang==null) {
					JOptionPane.showMessageDialog(null, "Chọn bảng đấu");
				}
				else {
					card.show(panel_2, "name_ChiTietBangDau");
					pnChiTietBangDau.lblTitle.setText("Bảng đấu: "+pnBangDau.tenBang);
					EventChiTietBangDau(dbconnect);
					XepHang.XepHang(dbconnect);
				}
			}
		});
	}
	public void EventDoiBong(DBConnect dbconnect) {
		try {
			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT ID,ten,HLV,DoiTruong FROM DoiBong WHERE GiaiDau='"+pnGiaiDau.maGiai+"'");
			pnDoiBong.modelDoiBong.setNumRows(0);
			while(rs.next()) {
				pnDoiBong.modelDoiBong.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
			}
			pnDoiBong.txtMaDoi.setText("");
			pnDoiBong.txtTenDoi.setText("");
			pnDoiBong.txtDoiTruong.setText("");
			pnDoiBong.txtHLV.setText("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void EventBangDau(DBConnect dbconnect) {
		try {
			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT ID,ten FROM BangDau WHERE GiaiDau='"+pnGiaiDau.maGiai+"'");
			pnBangDau.modelBangDau.setNumRows(0);
			while(rs.next()) {
				pnBangDau.modelBangDau.addRow(new String[] {rs.getString(1),rs.getString(2)});
			}
			pnBangDau.txtMaBang.setText("");
			pnBangDau.txtTenBang.setText("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void EventChiTietBangDau(DBConnect dbconnect) {
		try {
			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT ten FROM DoiBong WHERE GiaiDau='"+pnGiaiDau.maGiai+"'");
			while(rs.next()) {
				pnChiTietBangDau.cbbDoiBong.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void EventTranDau(DBConnect dbconnect) {
		try {
			ResultSet rs = dbconnect.getStmt().executeQuery(
					"SELECT TranDau.ID,TranDau.thoigian,TranDau.san,A.ten,TranDau.banthang1,B.ten,TranDau.banthang2,TranDau.tinhtrang,TranDau.BangDau FROM TranDau, DoiBong A, DoiBong B WHERE TranDau.GiaiDau ='"
							+ pnGiaiDau.maGiai + "' AND A.GiaiDau ='" + pnGiaiDau.maGiai + "' AND B.GiaiDau ='"
							+ pnGiaiDau.maGiai + "' AND A.ID = TranDau.doi1 AND B.ID = TranDau.doi2");
			//ResultSet rs = dbconnect.getStmt().executeQuery("SELECT ID,thoigian,san,doi1,banthang1,doi2,banthang2,tinhtrang,BangDau FROM TranDau WHERE GiaiDau='"+pnGiaiDau.maGiai+"'");
			pnTranDau.modelTranDau.setNumRows(0);
			while(rs.next()) {
				pnTranDau.modelTranDau.addRow(new String [] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
			}
			pnTranDau.cbbDoi1.removeAllItems();
			pnTranDau.cbbDoi2.removeAllItems();
			pnTranDau.cbbBangDau.removeAllItems();
			rs = dbconnect.getStmt().executeQuery("SELECT ten FROM DoiBong WHERE GiaiDau='"+pnGiaiDau.maGiai+"'");
			while(rs.next()) {
				pnTranDau.cbbDoi1.addItem(rs.getString(1));
				pnTranDau.cbbDoi2.addItem(rs.getString(1));
			}
			rs = dbconnect.getStmt().executeQuery("SELECT ten FROM BangDau WHERE GiaiDau='"+pnGiaiDau.maGiai+"'");
			while(rs.next()) {
				pnTranDau.cbbBangDau.addItem(rs.getString(1));
			}
			pnTranDau.cbbSan.removeAllItems();
			rs = dbconnect.getStmt().executeQuery("SELECT ten FROM San WHERE GiaiDau='"+pnGiaiDau.maGiai+"'");
			while(rs.next()) {
				pnTranDau.cbbSan.addItem(rs.getString(1));
			}
			pnTranDau.txtThoiGian.setText("");
			pnTranDau.txtBanThang1.setText("");
			pnTranDau.txtBanThang2.setText("");
			pnTranDau.txtMaTran.setText("");
			pnTranDau.txtThoiGian.setText("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void EventLichBang(DBConnect dbconnect) {
		try {
			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT TranDau.ID,TranDau.thoigian,TranDau.san,A.ten,TranDau.banthang1,B.ten,TranDau.banthang2,TranDau.tinhtrang,TranDau.BangDau FROM TranDau, DoiBong A, DoiBong B WHERE TranDau.GiaiDau ='"
					+ pnGiaiDau.maGiai + "'AND TranDau.BangDau='"+pnBangDau.tenBang+"' AND A.GiaiDau ='" + pnGiaiDau.maGiai + "' AND B.GiaiDau ='"
					+ pnGiaiDau.maGiai + "' AND A.ID = TranDau.doi1 AND B.ID = TranDau.doi2");
			//ResultSet rs = dbconnect.getStmt().executeQuery("SELECT ID,thoigian,san,doi1,banthang1,doi2,banthang2,tinhtrang FROM TranDau WHERE GiaiDau='"+pnGiaiDau.maGiai+"' AND BangDau='"+pnBangDau.tenBang+"'");
			pnLichBang.modelTranDau.setNumRows(0);
			while(rs.next()) {
				pnLichBang.modelTranDau.addRow(new String [] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
			}
			pnLichBang.cbbDoi1.removeAllItems();
			pnLichBang.cbbDoi2.removeAllItems();
			rs = dbconnect.getStmt().executeQuery("SELECT ten FROM XepHang WHERE bangDau='"+BangDau.maBang+"'");
			while(rs.next()) {
				pnLichBang.cbbDoi1.addItem(rs.getString(1));
				pnLichBang.cbbDoi2.addItem(rs.getString(1));
			}
			pnLichBang.cbbSan.removeAllItems();
			rs = dbconnect.getStmt().executeQuery("SELECT ten FROM San WHERE GiaiDau='"+GiaiDau.maGiai+"'");
			while(rs.next()) {
				pnLichBang.cbbSan.addItem(rs.getString(1));
			}
			pnLichBang.txtThoiGian.setText("");
			pnLichBang.txtBanThang1.setText("");
			pnLichBang.txtBanThang2.setText("");
			pnLichBang.txtMaTran.setText("");
			pnLichBang.txtThoiGian.setText("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void EventCauThu(DBConnect dbconnect) {
		try {
			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT ID,ten,ngaySinh,soAo,viTri FROM CauThu WHERE DoiBong='"+pnDoiBong.maDoi+"'");
			pnDanhSachCT.modelCauThu.setNumRows(0);
			while(rs.next()) {
				pnDanhSachCT.modelCauThu.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
			}
			pnDanhSachCT.txtIDCT.setText("");
			pnDanhSachCT.txtTenCT.setText("");
			pnDanhSachCT.txtNgaySinh.setText("");
			pnDanhSachCT.txtSoAo.setText("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void EventSan(DBConnect dbconnect) {
		try {
			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM San");
			while(rs.next()) {
				pnSan.modelSan.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void EventTrongTai(DBConnect dbconnect) {
		try {
			ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM TrongTai");
			while(rs.next()) {
				pnTrongTai.modelTrongTai.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
			}
			
			rs = dbconnect.getStmt().executeQuery("SELECT ID FROM TranDau");
			pnTrongTai.cbbTranDau.removeAllItems();
			while(rs.next()) {
				pnTrongTai.cbbTranDau.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
