package com.itdepartment.studentmanagermentsystem.nguyenlehoang;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import enums.AccountStatus;
import enums.Major;
import enums.Subject;
import enums.TimeSlot;
import model.Admin;
import model.Building;
import model.Grade;
import model.Room;
import model.Schedule;
import model.Student;
import model.StudentClass;
import model.Teacher;
import model.TeachingClass;
import net.datafaker.Faker;
import util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		init();
	}
	
	public static void init() {

		Faker faker = new Faker(new Locale("vi"));
		Random rd = new Random();

		Set<Admin> adminList = new HashSet<Admin>();
		Set<Teacher> teacherList = new HashSet<Teacher>();
		Set<Student> studentList = new HashSet<Student>();
		Set<StudentClass> studentClassList = new HashSet<StudentClass>();
		Set<TeachingClass> teachingClassList = new HashSet<TeachingClass>();
		Set<Grade> gradeList = new HashSet<Grade>();
		Set<Building> buildingList = new HashSet<Building>();
		Set<Room> roomList = new HashSet<Room>();
		Set<Schedule> scheduleList = new HashSet<Schedule>();
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		List<Student> students = new ArrayList<Student>();
		List<StudentClass> studentClasses = new ArrayList<StudentClass>();
		List<TeachingClass> teachingClasses = new ArrayList<TeachingClass>();
		List<Building> buildings = new ArrayList<Building>();
		List<Room> rooms = new ArrayList<Room>();
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			ValidatorFactory validatorFactory = HibernateUtil.getValidatorFactory();

			Transaction trans = session.beginTransaction();
			Validator validator = validatorFactory.getValidator();
			
//			Thêm dữ liệu vào danh sách admin
			for (int i = 0; i < 3; i++) {
				Admin adm = new Admin(faker.name().username(), faker.internet().password(), AccountStatus.ACTIVE, String.format("ADM%04d", i+1), faker.name().fullName(), faker.internet().emailAddress(), LocalDate.now());
				adminList.add(adm);
			}
			
//			Thêm dữ liệu vào bảng Admin
			for (Admin admin : adminList) {
				Set<ConstraintViolation<Admin>> violations = validator.validate(admin);
				if (violations.isEmpty()) {
					session.save(admin);
					System.out.println("Đã thêm tài khoản");
				} else {
					for (ConstraintViolation<Admin> violation : violations) {
						System.out.println(violation.getMessage());
					}
				}
			}
			
//			Thêm dữ liệu vào danh sách teacher
			for (int i = 0; i < 15; i++) {
				Teacher tea = new Teacher(faker.name().username(), faker.internet().password(), AccountStatus.ACTIVE, String.format("TEA%04d", i+1), faker.name().fullName(), faker.internet().emailAddress());
				teacherList.add(tea);
			}
			
//			Thêm dữ liệu vào bảng Teacher
			for (Teacher teacher : teacherList) {
				Set<ConstraintViolation<Teacher>> violations = validator.validate(teacher);
				if (violations.isEmpty()) {
					session.save(teacher);
					teachers.add(teacher);
					System.out.println("Đã thêm tài khoản");
				} else {
					for (ConstraintViolation<Teacher> violation : violations) {
						System.out.println(violation.getMessage());
					}
				}
			}
			
//			Thêm dữ liệu vào danh sách StudentClass
			studentClassList.add(new StudentClass("DS001", "Khoa học dữ liệu 1", teachers.get(rd.nextInt(teachers.size())), Major.DATA_SCIENCE, 2021));
			studentClassList.add(new StudentClass("FI001", "Tài chính 1", teachers.get(rd.nextInt(teachers.size())), Major.FINANCE, 2022));
			studentClassList.add(new StudentClass("LI001", "Ngôn ngữ học 1", teachers.get(rd.nextInt(teachers.size())), Major.LINGUISTICS, 2023));
			studentClassList.add(new StudentClass("MA001", "Marketing 1", teachers.get(rd.nextInt(teachers.size())), Major.MARKETING, 2022));
			studentClassList.add(new StudentClass("NS001", "An ninh mạng 1", teachers.get(rd.nextInt(teachers.size())), Major.NETWORK_SECURITY, 2021));
			studentClassList.add(new StudentClass("SE001", "Kỹ thuật phần mềm 1", teachers.get(rd.nextInt(teachers.size())), Major.SOFTWARE_ENGINEERING, 2024));
			studentClassList.add(new StudentClass("DS002", "Khoa học dữ liệu 2", teachers.get(rd.nextInt(teachers.size())), Major.DATA_SCIENCE, 2023));
			
//			Thêm dữ liệu vào bảng StudentClass
			for (StudentClass studentClass : studentClassList) {
				Set<ConstraintViolation<StudentClass>> violations = validator.validate(studentClass);
				if (violations.isEmpty()) {
					session.save(studentClass);
					studentClasses.add(studentClass);
					System.out.println("Đã thêm lớp học");
				} else {
					for (ConstraintViolation<StudentClass> violation : violations) {
						System.out.println(violation.getMessage());
					}
				}
			}
			
//			Thêm dữ liệu vào danh sách TeachingClass
			teachingClassList.add(new TeachingClass("BDA20211", "Phân tích dữ liệu lớn 1", teachers.get(rd.nextInt(teachers.size())), Subject.BIG_DATA_ANALYTICS, 2021));
			teachingClassList.add(new TeachingClass("ALG20212", "Thuật toán 2", teachers.get(rd.nextInt(teachers.size())), Subject.ALGORITHMS, 2021));
			teachingClassList.add(new TeachingClass("DAT20221", "Khai phá dữ liệu 3", teachers.get(rd.nextInt(teachers.size())), Subject.DATA_MINING, 2022));
			teachingClassList.add(new TeachingClass("SOC20222", "Xã hội ngôn ngữ học 4", teachers.get(rd.nextInt(teachers.size())), Subject.SOCIOLINGUISTICS, 2022));
			teachingClassList.add(new TeachingClass("ML20231", "Học máy 5", teachers.get(rd.nextInt(teachers.size())), Subject.MACHINE_LEARNING, 2023));
			teachingClassList.add(new TeachingClass("CRY20232", "Mật mã học 6", teachers.get(rd.nextInt(teachers.size())), Subject.CRYPTOGRAPHY, 2023));
			teachingClassList.add(new TeachingClass("DMK20241", "Marketing kỹ thuật số 7", teachers.get(rd.nextInt(teachers.size())), Subject.DIGITAL_MARKETING, 2024));
			teachingClassList.add(new TeachingClass("CYB20242", "An ninh mạng 8", teachers.get(rd.nextInt(teachers.size())), Subject.CYBER_SECURITY, 2024));
			teachingClassList.add(new TeachingClass("LIN20211", "Nhập môn ngôn ngữ học 9", teachers.get(rd.nextInt(teachers.size())), Subject.INTRO_TO_LINGUISTICS, 2021));
			teachingClassList.add(new TeachingClass("MKS20212", "Chiến lược marketing 10", teachers.get(rd.nextInt(teachers.size())), Subject.MARKETING_STRATEGY, 2021));
			teachingClassList.add(new TeachingClass("STT20221", "Kiểm thử phần mềm 11", teachers.get(rd.nextInt(teachers.size())), Subject.SOFTWARE_TESTING, 2022));
			teachingClassList.add(new TeachingClass("INV20222", "Phân tích đầu tư 12", teachers.get(rd.nextInt(teachers.size())), Subject.INVESTMENT_ANALYSIS, 2022));
			teachingClassList.add(new TeachingClass("NSC20231", "An ninh mạng 13", teachers.get(rd.nextInt(teachers.size())), Subject.NETWORK_SECURITY, 2023));
			teachingClassList.add(new TeachingClass("OPS20232", "Hệ điều hành 14", teachers.get(rd.nextInt(teachers.size())), Subject.OPERATING_SYSTEMS, 2023));
			teachingClassList.add(new TeachingClass("ECO20241", "Kinh tế lượng 15", teachers.get(rd.nextInt(teachers.size())), Subject.ECONOMETRICS, 2024));

//			Thêm dữ liệu vào bảng TeachingClass
			for (TeachingClass teachingClass : teachingClassList) {
				Set<ConstraintViolation<TeachingClass>> violations = validator.validate(teachingClass);
				if (violations.isEmpty()) {
					session.save(teachingClass);
					teachingClasses.add(teachingClass);
					System.out.println("Đã thêm lớp học");
				} else {
					for (ConstraintViolation<TeachingClass> violation : violations) {
						System.out.println(violation.getMessage());
					}
				}
			}
			
//			Thêm dữ liệu vào danh sách Student
			for (int i = 0; i < 70; i++) {
				Student std = new Student(faker.name().username(), faker.internet().password(), AccountStatus.ACTIVE, String.format("TEA%04d", i+1), faker.name().fullName(), faker.internet().emailAddress(), studentClasses.get(rd.nextInt(studentClasses.size())));
				studentList.add(std);
			}
			
//			Thêm dữ liệu vào bảng Student
			for (Student student : studentList) {
				Set<ConstraintViolation<Student>> violations = validator.validate(student);
				if (violations.isEmpty()) {
					session.save(student);
					students.add(student);
					System.out.println("Đã thêm tài khoản");
				} else {
					for (ConstraintViolation<Student> violation : violations) {
						System.out.println(violation.getMessage());
					}
				}
			}
			
//			Thêm dữ liệu vào danh sách Grade
			for (Student std : students) {
				Grade grade = new Grade(std, teachingClasses.get(rd.nextInt(teachingClasses.size())));
				gradeList.add(grade);
			}
			
//			Thêm dữ liệu vào bảng Grade
			for (Grade grade : gradeList) {
				Set<ConstraintViolation<Grade>> violations = validator.validate(grade);
				if (violations.isEmpty()) {
					session.save(grade);
					System.out.println("Đã thêm điểm");
				} else {
					for (ConstraintViolation<Grade> violation : violations) {
						System.out.println(violation.getMessage());
					}
				}
			}
			
//			Thêm dữ liệu vào danh sách Building
			buildingList.add(new Building("A01"));
			buildingList.add(new Building("B02"));
			buildingList.add(new Building("C03"));
			
//			Thêm dữ liệu vào bảng Building
			for (Building building : buildingList) {
				Set<ConstraintViolation<Building>> violations = validator.validate(building);
				if (violations.isEmpty()) {
					session.save(building);
					buildings.add(building);
					System.out.println("Đã thêm tòa nhà");
				} else {
					for (ConstraintViolation<Building> violation : violations) {
						System.out.println(violation.getMessage());
					}
				}
			}
			
//			Thêm dữ liệu vào danh sách Room
			for (Building building : buildings) {
				for (int i = 0; i < 5; i++) {
					roomList.add(new Room(String.format("RM%04d%c", i+1, building.getName().charAt(0)), building));
				}
			}
			
//			Thêm dữ liệu vào bảng Room
			for (Room room : roomList) {
				Set<ConstraintViolation<Room>> violations = validator.validate(room);
				if (violations.isEmpty()) {
					session.save(room);
					rooms.add(room);
					System.out.println("Đã thêm phòng");
				} else {
					for (ConstraintViolation<Room> violation : violations) {
						System.out.println(violation.getMessage());
					}
				}
			}
			
//			Thêm dữ liệu vào danh sách Schedule
			TimeSlot[] times = TimeSlot.values();
			for (int i = 0; i < 20; i++) {
				Schedule schedule = new Schedule(faker.date().birthday().toLocalDateTime().toLocalDate(), times[rd.nextInt(times.length)].getTimeRange(), rooms.get(rd.nextInt(rooms.size())), teachingClasses.get(rd.nextInt(teachingClasses.size())));
				scheduleList.add(schedule);
			}
			
//			Thêm dữ liệu vào bảng Schedule
			for (Schedule schedule : scheduleList) {
				Set<ConstraintViolation<Schedule>> violations = validator.validate(schedule);
				if (violations.isEmpty()) {
					session.save(schedule);
					System.out.println("Đã thêm phòng");
				} else {
					for (ConstraintViolation<Schedule> violation : violations) {
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
}
