package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBKetNoi.DBConnect;
import ObjectDoiBong.XepHang;

import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrangChu extends JFrame {

	private JPanel contentPane;
	//DBConnect dbConnect;
	QuanLy pnQuanLy;
	static DangNhap dangNhap;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DBConnect dbconnect = new DBConnect();
		//XepHang xepHang = new XepHang(dbconnect);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu(dbconnect);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		dangNhap = new DangNhap();
		
	}

	/**
	 * Create the frame.
	 */
	public TrangChu(DBConnect dbconnect) {
		super("Quản lý giải đấu bóng đá");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setResizable(false); // không thay doi kich thuoc cua so
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		
		pnQuanLy = new QuanLy(dbconnect);
		panel.add(pnQuanLy, "name_11140812491600");
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "name_11146719535200");
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "name_11155402030300");
	}
}
