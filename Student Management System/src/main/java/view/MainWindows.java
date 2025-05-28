package view;

import javax.swing.JFrame;

import util.GradientUtil;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainWindows extends JFrame {
	private JTextField txtUsername;
	private JTextField txtPassword;

	public MainWindows() {
		init();
	}

	public void init() {
		this.setTitle("Smart Solutions");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(null);

		JPanel panel = GradientUtil.createGradientPanel(new Color(58, 123, 213), new Color(0, 210, 255));;
		panel.setBounds(0, 0, 800, 600);
		panel.setLayout(null);
		getContentPane().add(panel);	

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(170, 42, 446, 479);
		panel.add(panel_1);
//		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("SMART SOLUTIONS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(74, 41, 298, 62);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(74, 136, 105, 30);
		panel_1.add(lblNewLabel_1);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setBounds(74, 170, 305, 41);
		txtUsername.setMargin(new Insets(0, 5, 0, 5));
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(74, 221, 105, 30);
		panel_1.add(lblNewLabel_1_1);

		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBounds(74, 255, 305, 41);
		txtPassword.setMargin(new Insets(0, 5, 0, 5));
		panel_1.add(txtPassword);

		JCheckBox checkRememberMe = new JCheckBox("Remember Me");
		checkRememberMe.setBackground(Color.WHITE);
		checkRememberMe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkRememberMe.setBounds(74, 319, 128, 36);
		panel_1.add(checkRememberMe);

		JButton btnLogin = GradientUtil.createGradientButton("Login", new Color(255, 140, 0), new Color(255, 75, 75));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bạn đã nhấn nút");
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(268, 320, 111, 34);
		panel_1.add(btnLogin);

		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bạn đã nhấn nút");
			}
		});
		btnForgotPassword.setBackground(Color.WHITE);
		btnForgotPassword.setForeground(Color.BLACK);
		btnForgotPassword.setOpaque(true);
		btnForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnForgotPassword.setBounds(143, 419, 159, 34);
		btnForgotPassword.setBorder(null);
		panel_1.add(btnForgotPassword);

		this.setVisible(true);
	}
}
