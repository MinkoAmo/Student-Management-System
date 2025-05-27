CREATE DATABASE student_management CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE Student_Management;

CREATE TABLE ACCOUNT(
	account_id VARCHAR(36),
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	role ENUM('ADMIN', 'TEACHER', 'STUDENT') NOT NULL,
	status ENUM('ACTIVE', 'INACTIVE') NOT NULL,
	PRIMARY KEY(account_id)
);

CREATE TABLE BUILDING(
	building_id VARCHAR(36),
	building_name VARCHAR(50),
	location VARCHAR(255),
	PRIMARY KEY(building_id)
);

CREATE TABLE ROOM(
	room_id VARCHAR(36),
	room_code VARCHAR(10),
	type VARCHAR(50),
	building_id VARCHAR(36),
	PRIMARY KEY(room_id),
	FOREIGN KEY(building_id) REFERENCES BUILDING(building_id) 
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ADMIN (
	admin_id VARCHAR(36),
	admin_code VARCHAR(10) NOT NULL UNIQUE,
	full_name VARCHAR(100) NOT NULL,
	email VARCHAR(254) NOT NULL UNIQUE,
	phone_number VARCHAR(20),
	admin_position VARCHAR(50),
	create_date DATE NOT NULL,
	last_login_time DATETIME,
	PRIMARY KEY(admin_id),
	FOREIGN KEY(admin_id) REFERENCES ACCOUNT(account_id) 
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE TEACHER(
	teacher_id VARCHAR(36),
	teacher_code VARCHAR(10) NOT NULL UNIQUE,
	full_name VARCHAR(100) NOT NULL,
	dob DATE,
	gender ENUM('MALE', 'FEMALE', 'OTHER'),
	email VARCHAR(254) NOT NULL UNIQUE,
	phone_number VARCHAR(20),
	address VARCHAR(255),
	department VARCHAR(50),
	academic_title VARCHAR(50),
	specialization VARCHAR(50),
	PRIMARY KEY(teacher_id),
	FOREIGN KEY(teacher_id) REFERENCES ACCOUNT(account_id) 
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE CLASS (
	class_id VARCHAR(36),
	class_code VARCHAR(10) NOT NULL UNIQUE,
	class_name VARCHAR(50) NOT NULL,
	PRIMARY KEY(class_id)
);

CREATE TABLE STUDENT_CLASS(
	student_class_id VARCHAR(36),
	teacher_id VARCHAR(36) NOT NULL,
	major VARCHAR(50) NOT NULL,
	course_year INT NOT NULL,
	PRIMARY KEY(student_class_id),
	FOREIGN KEY(student_class_id) REFERENCES CLASS(class_id) 
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(teacher_id) REFERENCES TEACHER(teacher_id) 
		ON DELETE CASCADE ON UPDATE CASCADE 
);
student_management
CREATE TABLE TEACHING_CLASS(
	teaching_class_id VARCHAR(36),
	teacher_id VARCHAR(36) NOT NULL,
	subject VARCHAR(50) NOT NULL,
	academic_year INT NOT NULL,
	PRIMARY KEY(teaching_class_id),
	FOREIGN KEY(teaching_class_id) REFERENCES CLASS(class_id) 
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(teacher_id) REFERENCES TEACHER(teacher_id)
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE SCHEDULE(
	schedule_id VARCHAR(36),
	date DATE,
	day_of_week ENUM('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY'),
	time_slot VARCHAR(20),
	room_id VARCHAR(36),
	teaching_class_id VARCHAR(36),
	PRIMARY KEY(schedule_id),
	FOREIGN KEY(room_id) REFERENCES ROOM(room_id) 
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(teaching_class_id) REFERENCES TEACHING_CLASS(teaching_class_id) 
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE STUDENT(
	student_id VARCHAR(36),
	student_code VARCHAR(10) NOT NULL UNIQUE,
	full_name VARCHAR(100) NOT NULL,
	dob DATE,
	gender ENUM('MALE', 'FEMALE', 'OTHER'),
	email VARCHAR(254) NOT NULL UNIQUE,
	phone_number VARCHAR(20),
	address VARCHAR(255),
	student_class_id VARCHAR(36 NOT NULL),
	PRIMARY KEY(student_id),
	FOREIGN KEY(student_id) REFERENCES ACCOUNT(account_id) 
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(student_class_id) REFERENCES STUDENT_CLASS(student_class_id) 
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE GRADE(
	grade_id VARCHAR(36),
	student_id VARCHAR(36) NOT NULL,
	teaching_class_id VARCHAR(36) NOT NULL,
	mid_term_score DECIMAL(4,2),
	final_term_score DECIMAL(4,2),
	exam_score DECIMAL(4,2),
	PRIMARY KEY(grade_id),
	FOREIGN KEY(student_id) REFERENCES STUDENT(student_id) 
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(teaching_class_id) REFERENCES TEACHING_CLASS(teaching_class_id) 
		ON DELETE CASCADE ON UPDATE CASCADE
);