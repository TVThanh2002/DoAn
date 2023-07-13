package GiaoDien1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtUse;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DangNhap() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(174, 21, 105, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(47, 87, 74, 25);
		contentPane.add(lblNewLabel_1);
		
		txtUse = new JTextField();
		txtUse.setBounds(149, 87, 130, 26);
		contentPane.add(txtUse);
		txtUse.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(47, 141, 74, 25);
		contentPane.add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setBounds(149, 140, 130, 26);
		contentPane.add(password);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((txtUse.getText().equals("tvthanh2002")))
					setVisible(false);
				else
					JOptionPane.showMessageDialog(null, "Bạn cần nhập đúng thông tin đăng nhập");
			}
		});
		btnDangNhap.setBounds(82, 190, 105, 25);
		contentPane.add(btnDangNhap);
		
		JButton btnDangKy = new JButton("Đăng ký");
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnDangKy.setBounds(233, 190, 105, 25);
		contentPane.add(btnDangKy);
		
		setVisible(true);
	}
}
