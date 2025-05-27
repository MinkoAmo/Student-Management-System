package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import enums.Major;

@Entity
@Table(name = "student_class")
@PrimaryKeyJoinColumn(name = "student_class_id")
public class StudentClass extends Class {
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "teacher_id")
	@NotNull(message = "Giáo viên không được để trống")
	Teacher teacher;
	
	@Column(name = "major")
	@NotNull(message = "Tên ngành không được để trống")
	@Enumerated(EnumType.STRING)
	Major major;
	
	@Column(name = "course_year")
	@NotNull(message = "Niên khóa không được để trống")
	int courseYear;
	
	public StudentClass() {
		super();
	}
	
	public StudentClass(String code, String name, Teacher teacher, Major major, int courseYear) {
		super(code, name);
		this.teacher = teacher;
		this.major = major;
		this.courseYear = courseYear;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public int getCourseYear() {
		return courseYear;
	}

	public void setCourseYear(int courseYear) {
		this.courseYear = courseYear;
	}
	
	
}
