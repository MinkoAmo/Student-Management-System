package util;

import dto.LoginResponseDTO;

public class SessionUtil {
	private static LoginResponseDTO currentUser;

	public static void setCurrentUser(LoginResponseDTO user) {
		currentUser = user;
	}

	public static LoginResponseDTO getCurrentUser() {
		return currentUser;
	}

	public static void clear() {
		currentUser = null;
	}
}
