package views;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AccountPage extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AccountPage() {
		setLayout(null);
		init();
	}

	private void init() {
		this.setSize(954, 688);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(64, 178, 825, 332);
		this.add(panel_2);
		panel_2.setLayout(null);

		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(24, 76, 243, 180);
		panel_2.add(btnAdmin);
		btnAdmin.setIcon(new ImageIcon(getClass().getResource("/imgs/Admin.png")));
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdmin.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAdmin.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.setBounds(291, 76, 243, 180);
		panel_2.add(btnTeacher);
		btnTeacher.setIcon(new ImageIcon(getClass().getResource("/imgs/Teacher.png")));
		btnTeacher.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTeacher.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTeacher.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnStudent = new JButton("Student");
		btnStudent.setBounds(558, 76, 243, 180);
		panel_2.add(btnStudent);
		btnStudent.setIcon(new ImageIcon(getClass().getResource("/imgs/Student.png")));
		btnStudent.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnStudent.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnStudent.setHorizontalTextPosition(SwingConstants.CENTER);
	}

}
