package com.itdepartment.studentmanagermentsystem.nguyenlehoang;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import enums.AccountStatus;
import model.Admin;
import model.Teacher;
import util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Set<Teacher> teacherList = (Set<Teacher>) init().get("teacherList");
		Set<Admin> adminList = (Set<Admin>) init().get("adminList");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			ValidatorFactory validatorFactory = HibernateUtil.getValidatorFactory();

			Transaction trans = session.beginTransaction();
			for (Teacher teacher : teacherList) {
				Validator validator = validatorFactory.getValidator();
				Set<ConstraintViolation<Teacher>> violations = validator.validate(teacher);
				if (violations.isEmpty()) {
					session.save(teacher);
					System.out.println("Đã thêm tài khoản");
				} else {
					for (ConstraintViolation<Teacher> violation : violations) {
						System.out.println(violation.getMessage());
					}
				}
			}
			for (Admin admin : adminList) {
				Validator validator = validatorFactory.getValidator();
				Set<ConstraintViolation<Admin>> violations = validator.validate(admin);
				if (violations.isEmpty()) {
					session.save(admin);
					System.out.println(admin);
					System.out.println("Đã thêm tài khoản");
				} else {
					for (ConstraintViolation<Admin> violation : violations) {
						System.out.println(violation.getMessage());
					}
				}
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}

	public static Map<String, Set<?>> init() {
		Map<String, Set<?>> map = new HashMap<>();

		// Khởi tạo 5 Teacher
		Teacher tea1 = new Teacher();
		tea1.setUsername("minkoamo");
		tea1.setPassword("Nguyenlehoang1@");
		tea1.setStatus(AccountStatus.ACTIVE);
		tea1.setCode("TCH001");
		tea1.setFullName("Nguyen Le Hoang");
		tea1.setEmail("nguyenlehoang@gentherm.com");

		Teacher tea2 = new Teacher();
		tea2.setUsername("trinhtrongnghia");
		tea2.setPassword("TrinhNghia@2024");
		tea2.setStatus(AccountStatus.ACTIVE);
		tea2.setCode("TCH002");
		tea2.setFullName("Trịnh Trọng Nghĩa");
		tea2.setEmail("trinh.nghia@uet.vnu.edu.vn");

		Teacher tea3 = new Teacher();
		tea3.setUsername("phamthimai");
		tea3.setPassword("MaiPham@123");
		tea3.setStatus(AccountStatus.ACTIVE);
		tea3.setCode("TCH003");
		tea3.setFullName("Phạm Thị Mai");
		tea3.setEmail("mai.pham@hust.edu.vn");

		Teacher tea4 = new Teacher();
		tea4.setUsername("nguyenquanghuy");
		tea4.setPassword("HuyQuang@789");
		tea4.setStatus(AccountStatus.ACTIVE);
		tea4.setCode("TCH004");
		tea4.setFullName("Nguyễn Quang Huy");
		tea4.setEmail("quang.huy@fpt.edu.vn");

		Teacher tea5 = new Teacher();
		tea5.setUsername("dinhthuthao");
		tea5.setPassword("ThaoDinh@456");
		tea5.setStatus(AccountStatus.ACTIVE);
		tea5.setCode("TCH005");
		tea5.setFullName("Đinh Thị Thảo");
		tea5.setEmail("thao.dinh@hcmus.edu.vn");

		Set<Teacher> teacherList = new HashSet<>(List.of(tea1, tea2, tea3, tea4, tea5));
		map.put("teacherList", teacherList);

		// Khởi tạo 3 Admin
		Admin adm1 = new Admin();
		adm1.setUsername("phamthanhson");
		adm1.setPassword("ThanhSon@987");
		adm1.setStatus(AccountStatus.ACTIVE);
		adm1.setCode("ADM001");
		adm1.setFullName("Pham Thanh Son");
		adm1.setEmail("son.pham@example.com");
		adm1.setCreateDate(LocalDate.now());

		Admin adm2 = new Admin();
		adm2.setUsername("hoangkimngan");
		adm2.setPassword("KimNgan@2024");
		adm2.setStatus(AccountStatus.ACTIVE);
		adm2.setCode("ADM002");
		adm2.setFullName("Hoang Kim Ngan");
		adm2.setEmail("ngan.hoang@example.com");
		adm2.setCreateDate(LocalDate.now());

		Admin adm3 = new Admin();
		adm3.setUsername("vuquochung");
		adm3.setPassword("QuocHung@888");
		adm3.setStatus(AccountStatus.ACTIVE);
		adm3.setCode("ADM003");
		adm3.setFullName("Vu Quoc Hung");
		adm3.setEmail("hung.vu@example.com");
		adm3.setCreateDate(LocalDate.now());
		
		Set<Admin> adminList = new HashSet<>(List.of(adm1, adm2, adm3));
		map.put("adminList", adminList);
		
		return map;
	}
}
