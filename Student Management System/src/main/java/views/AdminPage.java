package views;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tbl_data;
	private JTextField txtCode;
	private JTextField txtFullname;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private JTextField txtRole;
	private JTextField txtPosition;
	private JTextField txtCreateDate;
	private JTextField txtStatus;
	private JTextField txtLastLoginTime;

	public AdminPage() {
		setLayout(null);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setSize(954, 688);
		tbl_data = new JTable();
		tbl_data.setBounds(10, 285, 934, 325);
		this.add(tbl_data);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(92, 128, 48, 25);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(lblEmail);

		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(101, 235, 39, 25);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(lblRole);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(600, 128, 54, 25);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(lblStatus);

		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(95, 16, 45, 25);
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(lblCode);

		JLabel lblFullName = new JLabel("Fullname");
		lblFullName.setBounds(60, 75, 80, 25);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(lblFullName);

		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(10, 182, 130, 25);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(lblPhoneNumber);

		JLabel lblCreateDate = new JLabel("Create date");
		lblCreateDate.setBounds(552, 75, 102, 25);
		lblCreateDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(lblCreateDate);

		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(584, 16, 70, 25);
		this.add(lblPosition);
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblLastLoginTime = new JLabel("Last login time");
		lblLastLoginTime.setBounds(524, 182, 130, 25);
		this.add(lblLastLoginTime);
		lblLastLoginTime.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtCode = new JTextField();
		txtCode.setBounds(157, 10, 280, 36);
		this.add(txtCode);
		txtCode.setColumns(10);

		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		txtFullname.setBounds(157, 69, 280, 36);
		this.add(txtFullname);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(157, 122, 280, 36);
		this.add(txtEmail);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(157, 176, 280, 36);
		this.add(txtPhoneNumber);

		txtRole = new JTextField();
		txtRole.setColumns(10);
		txtRole.setBounds(157, 229, 280, 36);
		this.add(txtRole);

		txtPosition = new JTextField();
		txtPosition.setColumns(10);
		txtPosition.setBounds(664, 10, 280, 36);
		this.add(txtPosition);

		txtCreateDate = new JTextField();
		txtCreateDate.setColumns(10);
		txtCreateDate.setBounds(664, 69, 280, 36);
		this.add(txtCreateDate);

		txtStatus = new JTextField();
		txtStatus.setColumns(10);
		txtStatus.setBounds(664, 122, 280, 36);
		this.add(txtStatus);

		txtLastLoginTime = new JTextField();
		txtLastLoginTime.setColumns(10);
		txtLastLoginTime.setBounds(664, 176, 280, 36);
		this.add(txtLastLoginTime);
	}

}
