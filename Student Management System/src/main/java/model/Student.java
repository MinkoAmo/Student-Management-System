package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import annotations.UniqueField;
import enums.AccountStatus;
import enums.Gender;
import enums.Role;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends Account {
	@Column(name = "student_code", length = 10, unique = true)
	@UniqueField(entityClass = Student.class, fieldName = "code", message = "Mã học sinh đã tồn tại")
	@Size(max = 10, message = "Mã học sinh không được dài quá 10 kí tự")
	@NotEmpty(message = "Mã học sinh không được để trống")
	private String code;
	
	@Column(name = "full_name", length = 100)
	@Size(max = 100, message = "Tên học sinh không được dài quá 100 kí tự")
	@NotEmpty(message = "Tên học sinh không được để trống")
	private String fullName;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "email", length = 254, unique = true)
	@UniqueField(entityClass = Student.class, fieldName = "email", message = "Email đã tồn tại")
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
	
	@JoinColumn(name = "student_class_id")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@NotNull(message = "Không được để trống lớp học")
	private StudentClass stdClass;
	
	public Student() {
		super();
		super.setRole(Role.STUDENT);
	}
	
	public Student(String username, String password, AccountStatus status, String code, String fullName, String email, StudentClass stdClass) {
		super(username, password, Role.STUDENT, status);
		this.code = code;
		this.fullName = fullName;
		this.email = email;
		this.stdClass = stdClass;
	}

	public Student(String username, String password, AccountStatus status, String code, String fullName, LocalDate dob, Gender gender, String email, String phoneNumber,
			String address, StudentClass stdClass) {
		super(username, password, Role.STUDENT, status);
		this.code = code;
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.stdClass = stdClass;
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
		this.email = email;
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

	public StudentClass getStdClass() {
		return stdClass;
	}

	public void setStdClass(StudentClass stdClass) {
		this.stdClass = stdClass;
	}

	@Override
	public String toString() {
		return "Student [code=" + code + ", fullName=" + fullName + ", dob=" + dob + ", gender=" + gender + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", stdClass=" + stdClass + "]";
	}
	
}
