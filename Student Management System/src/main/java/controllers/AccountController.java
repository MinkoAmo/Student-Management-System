package controllers;

import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.validation.ConstraintViolation;

import dto.LoginRequestDTO;
import dto.LoginResponseDTO;
import service.AccountService;
import util.HibernateUtil;
import util.RememberMeUtil;
import util.SessionUtil;
import views.AdminHomepage;
import views.index;

public class AccountController implements ActionListener {

	private Object v;
	private AccountService service;
	private LoginRequestDTO dto;

	public AccountController(Object view) {
		service = new AccountService();
		this.v = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "Login": {
			index view = (index) v;
			String username = view.getTxtUsername().getText();
			String password = view.getPasswordField().getText();
			dto = new LoginRequestDTO(username, password);

			Set<ConstraintViolation<LoginRequestDTO>> violations = HibernateUtil.getValidatorFactory().getValidator().validate(dto);
			if (!violations.isEmpty()) {
				for (ConstraintViolation<LoginRequestDTO> violation : violations) {
					view.showMessage(violation.getMessage(), MessageType.ERROR);
					view.setBlank(violation.getPropertyPath().toString());
					break;
				}
			} else {
				LoginResponseDTO acc = service.login(dto);
				if (acc == null) {
					view.showMessage("Tên tài khoản hoặc mật khẩu không đúng", MessageType.ERROR);
					view.setBlank("all");
				} else {
					// Save session of user
					SessionUtil.setCurrentUser(acc);
					if (view.getCheckRememberMe().isSelected()) {
						RememberMeUtil.saveRememberMe(username, password);
					} else {
						RememberMeUtil.clearRememberMe();
					}
					
					// Hide the login windows
					view.setVisible(false);
					switch (acc.getRole().toString()) {
					case "ADMIN": {
						new AdminHomepage(view).show();
						break;
					}
					case "TEACHER": {

						break;
					}
					case "STUDENT": {

						break;
					}
					}
				}
			}
			break;
		}
		case "Forgot Password?": {
			index view = (index) v;
			view.showMessage("Bạn đã nhấn quên mật khẩu", MessageType.INFO);
			break;
		}
		case "Log out": {
			AdminHomepage view = (AdminHomepage) v;
			view.dispose();
			index loginForm = view.getLoginForm();
			loginForm.setVisible(true);
			loginForm.setBlank("password");
			SessionUtil.setCurrentUser(null);

			break;
		}
		}
	}
}
