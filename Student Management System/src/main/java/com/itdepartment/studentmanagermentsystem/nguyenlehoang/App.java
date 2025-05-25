package com.itdepartment.studentmanagermentsystem.nguyenlehoang;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import enums.AccountStatus;
import enums.Role;
import model.Account;
import model.Teacher;
import util.HibernateUtil;

public class App {
    public static void main(String[] args) {
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	try {
    		ValidatorFactory validatorFactory = HibernateUtil.getValidatorFactory();
    		
    		Transaction trans = session.beginTransaction();
    		Teacher tea1 = new Teacher();
    		tea1.setUsername("minkoamo");
    		tea1.setPassword("Nguyenlehoang1@");
    		tea1.setStatus(AccountStatus.ACTIVE);
    		tea1.setCode("Teacher001");
    		tea1.setFullName("Nguyen Le Hoang");
    		tea1.setEmail("Nguyenlehoang1@gentherm.com");
            
    		Validator validator = validatorFactory.getValidator();
    		Set<ConstraintViolation<Teacher>> violations = validator.validate(tea1);
			if (violations.isEmpty()) {
				System.out.println("Teacher ID before save: " + tea1.getId());
				session.save(tea1);
				System.out.println("Teacher ID after save: " + tea1.getId());
				System.out.println(tea1.toString());
				trans.commit();
				System.out.println("Đã thêm tài khoản");
			} else {
				for (ConstraintViolation<Teacher> violation : violations) {
					System.out.println(violation.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
    }
}
