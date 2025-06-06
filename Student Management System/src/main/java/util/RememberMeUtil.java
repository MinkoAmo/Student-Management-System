package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class RememberMeUtil {
	private static final String FILE_PATH = System.getProperty("user.home") + "\\.smartsolutions.properties";

	public static void saveRememberMe(String username, String password) {
		Properties props = new Properties();
		props.setProperty("username", username);
		props.setProperty("password", password);

		try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
			props.store(fos, "Remember Me Data");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Properties loadRememberMe() {
		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

	public static void clearRememberMe() {
		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
			props.load(fis);
		} catch (IOException e) {
			return;
		}

		props.remove("username");
		props.remove("password");

		try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
			props.store(fos, "Remember Me Data Cleared");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
