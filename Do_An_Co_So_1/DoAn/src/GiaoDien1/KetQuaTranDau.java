package GiaoDien1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBKetNoi.DBConnect;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class KetQuaTranDau extends JFrame {

	private JPanel contentPane;
	 JTextField txtDoi1;
	 JTextField txtDoi2;
	JButton btnLuu;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public KetQuaTranDau(DBConnect dbconnect) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 262);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kết quả trận đấu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(217, 10, 142, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Đội 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(142, 59, 52, 20);
		contentPane.add(lblNewLabel_1);
		
		txtDoi1 = new JTextField();
		txtDoi1.setBounds(193, 59, 59, 26);
		contentPane.add(txtDoi1);
		txtDoi1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("-");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 85));
		lblNewLabel_3.setBounds(262, 59, 37, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đội 2");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(391, 59, 52, 20);
		contentPane.add(lblNewLabel_1_1);
		
		txtDoi2 = new JTextField();
		txtDoi2.setColumns(10);
		txtDoi2.setBounds(312, 59, 59, 26);
		contentPane.add(txtDoi2);
		
		btnLuu = new JButton("Lưu thay đổi");
		btnLuu.setBounds(74, 117, 417, 32);
		contentPane.add(btnLuu);
		
		setVisible(false);
	}
}
