package views;

import javax.swing.JFrame;

import util.GradientUtil;
import util.RememberMeUtil;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Insets;
import java.awt.TrayIcon.MessageType;

import javax.swing.JTextField;

import controllers.AccountController;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.util.Properties;
import javax.swing.JPasswordField;

public class index extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private AccountController controller = new AccountController(this);
	private JCheckBox checkRememberMe;

	public index() {
		init();
	}

	public void init() {
		this.setTitle("Smart Solutions");
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(null);

		JPanel panel = new JPanel() /*GradientUtil.createGradientPanel(new Color(58, 123, 213), new Color(0, 210, 255))*/;
		panel.setBounds(0, 0, 1186, 763);
		panel.setLayout(null);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(370, 142, 446, 479);
		panel.add(panel_1);
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

		checkRememberMe = new JCheckBox("Remember Me");
		checkRememberMe.setBackground(Color.WHITE);
		checkRememberMe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkRememberMe.setBounds(74, 319, 128, 36);
		checkRememberMe.addActionListener(controller);
		panel_1.add(checkRememberMe);

		JButton btnLogin = new JButton()/*GradientUtil.createGradientButton("Login", new Color(255, 140, 0), new Color(255, 75, 75))*/;
		btnLogin.setText("Login");
		btnLogin.addActionListener(controller);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(268, 320, 111, 34);
		panel_1.add(btnLogin);

		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.addActionListener(controller);
		btnForgotPassword.setBackground(Color.WHITE);
		btnForgotPassword.setForeground(Color.BLACK);
		btnForgotPassword.setOpaque(true);
		btnForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnForgotPassword.setBounds(143, 419, 159, 34);
		btnForgotPassword.setBorder(null);
		panel_1.add(btnForgotPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(74, 257, 305, 39);
		panel_1.add(passwordField);

		Properties rememberData = RememberMeUtil.loadRememberMe();
		String savedUsername = rememberData.getProperty("username");
		String savedPassword = rememberData.getProperty("password");
		if (savedUsername != null && !savedUsername.isEmpty()) {
			txtUsername.setText(savedUsername);
			passwordField.setText(savedPassword);
			checkRememberMe.setSelected(true);
		}

		this.setVisible(true);
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(JTextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JCheckBox getCheckRememberMe() {
		return checkRememberMe;
	}

	public void setCheckRememberMe(JCheckBox checkRememberMe) {
		this.checkRememberMe = checkRememberMe;
	}

	public void showMessage(String message, MessageType error) {
		int messageType;

		switch (error) {
		case ERROR:
			messageType = JOptionPane.ERROR_MESSAGE;
			break;
		case INFO:
			messageType = JOptionPane.INFORMATION_MESSAGE;
			break;
		case WARNING:
			messageType = JOptionPane.WARNING_MESSAGE;
			break;
		default:
			messageType = JOptionPane.PLAIN_MESSAGE;
			break;
		}
		JOptionPane.showMessageDialog(this, message, error.name(), messageType);
	}

	// ===== This method is used to blank the properties
	public void setBlank(String propertyName) {
		if (propertyName.equals("username")) {
			this.getTxtUsername().setText("");
		} else if (propertyName.equals("password")) {
			this.getPasswordField().setText("");
		} else if (propertyName.equals("all")) {
			this.getTxtUsername().setText("");
			this.getPasswordField().setText("");
		}

	}
}
