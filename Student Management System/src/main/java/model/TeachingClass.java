package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import enums.Subject;

@Entity
@Table(name = "teaching_class")
@PrimaryKeyJoinColumn(name = "teaching_class_id")
public class TeachingClass extends Class {
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "teacher_id")
	@NotNull(message = "Giáo viên không được để trống")
	private Teacher teacher;

	@Column(name = "subject")
	@NotNull(message = "Tên môn học không được để trống")
	@Enumerated(EnumType.STRING)
	private Subject subject;

	@Column(name = "academic_year")
	@NotNull(message = "Năm học không được để trống")
	private int academicYear;
	
	@OneToMany(mappedBy = "teachingClass", cascade = CascadeType.ALL)
	private Set<Grade> gradeList;
	
	@OneToMany(mappedBy = "teachingClass", cascade = CascadeType.ALL)
	private Set<Schedule> scheduleList;

	public TeachingClass() {
		super();
	}

	public TeachingClass(String code, String name, Teacher teacher, Subject subject, int academicYear) {
		super(code, name);
		this.teacher = teacher;
		this.subject = subject;
		this.academicYear = academicYear;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(int academicYear) {
		this.academicYear = academicYear;
	}

}
