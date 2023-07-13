package GiaoDien1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBKetNoi.DBConnect;
import Object.XepHang;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import javax.swing.JScrollBar;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class TrangChu extends JFrame implements ActionListener{
	private JPanel contentPane;
	JLayeredPane layeredPane;
	JPanel panel,panel_1,panel_2;
	GiaiDau giaiDau;
	PanelDoiBong pnDoiBong;
	PanelLichThidau pnLichThiDau;
	PanelBangXepHang pnBangXepHang;
	PanelCauThu pnCauThu;
	PanelSan pnSan;
	static XepHang xepHang;
	static DBConnect dbconnect;
	static KetQuaTranDau kqTranDau;
	//KetQuaTranDau kqTranDau;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		dbconnect = new DBConnect();
		kqTranDau = new KetQuaTranDau(dbconnect);
		xepHang = new XepHang();
		new TrangChu();
		new DangNhap();
		
	}
	 
	public void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	/**
	 * Create the frame.
	 */
	public TrangChu() {
		super("QUẢN LÝ CÁC GIẢI ĐẤU BÓNG ĐÁ");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmTrangChu = new JMenuItem("Trang chủ");
		menuBar.add(mntmTrangChu);
		mntmTrangChu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchPanel(panel);
			}
			
		});
		
		JMenuItem mntmGiaiDau = new JMenuItem("Giải đấu");
		menuBar.add(mntmGiaiDau);
		mntmGiaiDau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchPanel(giaiDau);
			}
			
		});
		
		JMenuItem mntmDoiBong = new JMenuItem("Đội bóng");
		menuBar.add(mntmDoiBong);
		mntmDoiBong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchPanel(pnDoiBong);
			}
			
		});
		
		JMenuItem mntmLichThiDau = new JMenuItem("Lịch thi đấu");
		menuBar.add(mntmLichThiDau);
		mntmLichThiDau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchPanel(pnLichThiDau);
			}
			
		});
		JMenuItem mntmBXH = new JMenuItem("Bảng xếp hạng");
		menuBar.add(mntmBXH);
		mntmBXH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchPanel(pnBangXepHang);
			}			
		});
		
		JMenuItem mntmSanThiDau = new JMenuItem("Sân thi đấu");
		menuBar.add(mntmSanThiDau);
		JMenuItem mntmHuongDan = new JMenuItem("Hướng dẫn");
		menuBar.add(mntmHuongDan);
		mntmSanThiDau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchPanel(pnSan);
			}
			
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 10, 766, 519);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		layeredPane.add(panel, "name_687014026076200");
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setBounds(328, 53, 101, 32);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DangNhap();
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		JButton btnngK = new JButton("Đăng ký");
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DangKy();
			}
		});
		btnngK.setBounds(328, 129, 101, 32);
		panel.add(btnngK);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Do an co so 1\\java\\gvdhgfj.jpg"));
		lblNewLabel.setBounds(10, 10, 746, 499);
		panel.add(lblNewLabel);
		
		
		 giaiDau = new GiaiDau( dbconnect);
		layeredPane.add(giaiDau, "name_687015936540800");
		giaiDau.btnDanhSchi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchPanel(pnDoiBong);
			}
			
		});
		pnBangXepHang = new PanelBangXepHang(dbconnect,giaiDau);
		layeredPane.add(pnBangXepHang, "name_792957211951500");
		
		pnLichThiDau = new PanelLichThidau(giaiDau, dbconnect,kqTranDau,pnBangXepHang,xepHang);
		layeredPane.add(pnLichThiDau, "name_786226439394500");
		
		
		 pnDoiBong = new PanelDoiBong(dbconnect,giaiDau,pnLichThiDau,pnBangXepHang,xepHang);
		layeredPane.add(pnDoiBong, "name_687017950590700");
		pnDoiBong.btnDSCauThu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pnDoiBong.row != -1)
					switchPanel(pnCauThu);
			}			
		});
		
		pnCauThu = new PanelCauThu(dbconnect, pnDoiBong,giaiDau,xepHang);
		layeredPane.add(pnCauThu, "name_143372085481500");
		pnCauThu.btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchPanel(pnDoiBong);
			}
			
		});
		
		
		
		pnSan = new PanelSan(giaiDau,dbconnect);
		JPanel panel_3 = new JPanel();
		layeredPane.add(panel_3, "name_365849640880100");
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Tổng kết giải")) {
			System.out.print("da click");
		}
		
	}
}
