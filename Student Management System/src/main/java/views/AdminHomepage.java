package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.AccountController;
import controllers.AdminController;
import dto.LoginResponseDTO;
import util.SessionUtil;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminHomepage extends JFrame {

	private static final long serialVersionUID = 1L;
	private index loginForm;
	private AdminController adminController = new AdminController(this);
	private AccountController accountController = new AccountController(this);
	private JPanel contentPane;
	private LoginResponseDTO acc;
	private JPanel JPanel_content;
	private CardLayout cardLayout;
	private JTable tbl_data;
	private JTextField txtCode;
	private JTextField txtFullname;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	public AdminHomepage(index view) {
		acc = SessionUtil.getCurrentUser();
		this.loginForm = view;
		init();
	}

	public void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setTitle("Homepage");
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel JPanel_header = new JPanel();
		JPanel_header.setBackground(new Color(40, 100, 180));
		JPanel_header.setBounds(0, 0, 1186, 75);
		contentPane.add(JPanel_header);
		JPanel_header.setLayout(null);

		JLabel JLabel_app_name = new JLabel("SMART SOLUTIONS");
		JLabel_app_name.setForeground(Color.WHITE);
		JLabel_app_name.setFont(new Font("Tahoma", Font.BOLD, 30));
		JLabel_app_name.setBounds(441, 24, 304, 27);
		JPanel_header.add(JLabel_app_name);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(40, 100, 180));
		panel_1.setBounds(956, 7, 220, 60);
		JPanel_header.add(panel_1);
		JLabel lblAccountImage = new JLabel(new ImageIcon(AdminHomepage.class.getResource("/imgs/Avatar.png")));
		panel_1.add(lblAccountImage);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 100, 180));
		panel_1.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel lblUsername = new JLabel(acc.getUsername());
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel lblAccountRole = new JLabel(acc.getRole().toString());
		lblAccountRole.setForeground(Color.WHITE);
		lblAccountRole.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.add(lblAccountRole);
		lblAccountRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAccountRole.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem mntmInformation = new JMenuItem("Information");
		popupMenu.add(mntmInformation);

		JMenuItem mntmLogOut = new JMenuItem("Log out");
		popupMenu.add(mntmLogOut);
		JLabel lblDownArrow = new JLabel(new ImageIcon(AdminHomepage.class.getResource("/imgs/DownArrow.png")));
		panel_1.add(lblDownArrow);
		lblDownArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popupMenu.show(lblDownArrow, 0, lblDownArrow.getHeight());
			}
		});
		mntmLogOut.addActionListener(accountController);

		addPopup(lblDownArrow, popupMenu);

		ImageIcon icon = new ImageIcon(getClass().getResource("/imgs/Account.png"));

		JPanel JPanel_sidebar = new JPanel();
		JPanel_sidebar.setBackground(new Color(230, 235, 240));
		JPanel_sidebar.setAlignmentX(LEFT_ALIGNMENT);
		JPanel_sidebar.setBounds(0, 75, 231, 688);
		contentPane.add(JPanel_sidebar);
		JPanel_sidebar.setLayout(null);

		JButton btnAccount = new JButton("Account");
		btnAccount.setForeground(Color.BLACK);
		btnAccount.setBounds(0, 41, 232, 39);
		btnAccount.setIcon(new ImageIcon(getClass().getResource("/imgs/Account.png")));
		JPanel_sidebar.add(btnAccount);
		btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAccount.addActionListener(adminController);

		JButton btnSubject = new JButton("Subject");
		btnSubject.setBounds(0, 121, 232, 39);
		btnSubject.setIcon(new ImageIcon(getClass().getResource("/imgs/Subject.png")));
		JPanel_sidebar.add(btnSubject);
		btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnClass = new JButton("Class");
		btnClass.setBounds(0, 201, 232, 39);
		btnClass.setIcon(new ImageIcon(getClass().getResource("/imgs/Class.png")));
		btnClass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JPanel_sidebar.add(btnClass);

		JButton btnLesson = new JButton("Lesson");
		btnLesson.setBounds(0, 281, 232, 39);
		btnLesson.setIcon(new ImageIcon(getClass().getResource("/imgs/Lesson.png")));
		JPanel_sidebar.add(btnLesson);
		btnLesson.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnRoom = new JButton("Room");
		btnRoom.setBounds(0, 361, 232, 39);
		btnRoom.setIcon(new ImageIcon(getClass().getResource("/imgs/Room.png")));
		JPanel_sidebar.add(btnRoom);
		btnRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnBuilding = new JButton("Building");
		btnBuilding.setBounds(0, 441, 232, 39);
		btnBuilding.setIcon(new ImageIcon(getClass().getResource("/imgs/Building.png")));
		JPanel_sidebar.add(btnBuilding);
		btnBuilding.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnReport = new JButton("Report");
		btnReport.setBounds(0, 521, 232, 39);
		btnReport.setIcon(new ImageIcon(getClass().getResource("/imgs/Report.png")));
		JPanel_sidebar.add(btnReport);
		btnReport.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnSystemAdministration = new JButton("System Administration");
		btnSystemAdministration.setBounds(0, 601, 232, 39);
		JPanel_sidebar.add(btnSystemAdministration);
		btnSystemAdministration.setIcon(new ImageIcon(getClass().getResource("/imgs/Administration.png")));
		btnSystemAdministration.setFont(new Font("Tahoma", Font.PLAIN, 16));

		cardLayout = new CardLayout(0, 0);
		JPanel_content = new JPanel();
		JPanel_content.setBounds(232, 75, 954, 688);
		contentPane.add(JPanel_content);
		JPanel_content.setLayout(cardLayout);

		JPanel JPanel_account = new AccountPage();
		JPanel_content.add(JPanel_account, "account");

		JPanel JPanel_welcome = new JPanel();
		JPanel_welcome.setBounds(232, 75, 554, 488);

		JPanel_content.add(JPanel_welcome, "welcome");

		JPanel JPanel_admin = new AdminPage();
		JPanel_content.add(JPanel_admin, "admin");


		JPanel JPanel_template = new JPanel();
		JPanel_template.setLayout(null);
		JPanel_content.add(JPanel_template, "template");
		JPanel_welcome.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to my app");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel.setBounds(275, 259, 403, 170);
		JPanel_welcome.add(lblNewLabel);

		cardLayout.show(JPanel_content, "admin");
		this.setVisible(true);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public index getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(index loginForm) {
		this.loginForm = loginForm;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public void changePages(String name) {
		this.getCardLayout().show(JPanel_content, name);
	}
}
