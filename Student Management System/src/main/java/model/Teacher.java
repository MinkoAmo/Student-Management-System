package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import annotations.UniqueField;
import enums.AccountStatus;
import enums.Department;
import enums.Gender;
import enums.Role;

@Entity
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "teacher_id")
public class Teacher extends Account {
	@Column(name = "teacher_code", length = 10, unique = true)
	@UniqueField(entityClass = Teacher.class, fieldName = "code", message = "Teacher code đã tồn tại")
	@Size(max = 10, message = "Teacher code không được dài quá 10 kí tự")
	@NotEmpty(message = "Teacher code không được để trống")
	private String code;

	@Column(name = "full_name", length = 100)
	@Size(max = 100, message = "Tên teacher không được dài quá 100 kí tự")
	@NotEmpty(message = "Tên teacher không được để trống")
	private String fullName;

	@Column(name = "dob")
	private LocalDate dob;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "email", length = 254, unique = true)
	@UniqueField(entityClass = Teacher.class, fieldName = "email", message = "Email đã tồn tại")
	@Size(max = 254, message = "Email không được dài quá 254 kí tự")
	@Email(message = "Email không đúng định dạng")
	@NotEmpty(message = "Email không được để trống")
	private String email;

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

	public Teacher() {
		super();
		super.setRole(Role.TEACHER);
	}

	public Teacher(String username, String password, AccountStatus status, String code, String fullName, String email) {
		super(username, password, Role.TEACHER, status);
		this.code = code;
		this.fullName = fullName;
		this.email = email;
	}

	public Teacher(String username, String password, AccountStatus status, String code,
			String fullName, LocalDate dob, Gender gender, String email, String phoneNumber, String address,
			Department dept, String academicTitle, String specialization) {
		super(username, password, Role.TEACHER, status);
		this.code = code;
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
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

	@Override
	public String toString() {
		return "Teacher [code=" + code + ", fullName=" + fullName + ", dob=" + dob + ", gender=" + gender
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", dept=" + dept
				+ ", academicTitle=" + academicTitle + ", specialization=" + specialization + ", toString()="
				+ super.toString() + "]";
	}
}
