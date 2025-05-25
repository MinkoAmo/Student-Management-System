package util;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final ValidatorFactory validatorFactory = buildValidatorFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Không thể khởi tạo SessionFactory");
			return null;
		}
	}
	
	private static ValidatorFactory buildValidatorFactory() {
		try {
			return Validation.buildDefaultValidatorFactory();
		} catch (Exception e) {
			System.out.println("Không thể khởi tạo ValidatorFactory");
			return null;
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static ValidatorFactory getValidatorFactory() {
		return validatorFactory;
	}
	
	public static void shutdown() {
		getSessionFactory().close();
		getValidatorFactory().close();
	}
}
