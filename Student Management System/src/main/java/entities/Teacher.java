package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import enums.AccountStatus;
import enums.Department;
import enums.Gender;
import enums.Role;

@Entity
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "teacher_id")
public class Teacher extends Account {
	@Column(name = "teacher_code", length = 10, unique = true)
	@Size(max = 10, message = "Mã giáo viên không được dài quá 10 kí tự")
	@NotEmpty(message = "Mã giáo viên không được để trống")
	private String code;

	@Column(name = "full_name", length = 100)
	@Size(max = 100, message = "Tên giáo viên không được dài quá 100 kí tự")
	@NotEmpty(message = "Tên giáo viên không được để trống")
	private String fullName;

	@Column(name = "dob")
	private LocalDate dob;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "phone_number", length = 20)
	@Size(max = 20, message = "Số điện thoại không được dài quá 20 kí tự")
	private String phoneNumber;

	@Column(name = "address", length = 255)
	@Size(max = 255, message = "Địa chỉ quá dài")
	private String address;

	@Column(name = "department", length = 50)
	@Enumerated(EnumType.STRING)
	private Department dept;

	@Column(name = "academic_title", length = 50)
	@Size(max = 50, message = "Học hàm quá dài")
	private String academicTitle;

	@Column(name = "specialization", length = 50)
	@Size(max = 50, message = "Chuyên ngành quá dài")
	private String specialization;

	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
	private Set<StudentClass> studentClassList;

	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
	private Set<TeachingClass> teachingClassLít;

	public Teacher() {
		super();
		super.setRole(Role.TEACHER);
	}

	public Teacher(String username, String password, String email, AccountStatus status, String code, String fullName) {
		super(username, password, email, Role.TEACHER, status);
		this.code = code;
		this.fullName = fullName;
	}

	public Teacher(String username, String password, String email, AccountStatus status, String code, String fullName,
			LocalDate dob, Gender gender, String phoneNumber, String address, Department dept, String academicTitle,
			String specialization) {
		super(username, password, email, Role.TEACHER, status);
		this.code = code;
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dept = dept;
		this.academicTitle = academicTitle;
		this.specialization = specialization;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getAcademicTitle() {
		return academicTitle;
	}

	public void setAcademicTitle(String academicTitle) {
		this.academicTitle = academicTitle;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
}
