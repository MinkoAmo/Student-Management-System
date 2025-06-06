package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.AdminHomepage;

public class AdminController implements ActionListener {
	private Object v;

	public AdminController(Object v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		AdminHomepage view = (AdminHomepage) v;
		switch (command) {
		case "Account": {
			view.changePages("account");
			break;
		}
		default:
			break;
		}
		
		
	}
}
