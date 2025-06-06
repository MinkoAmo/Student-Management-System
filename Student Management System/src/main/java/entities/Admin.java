package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import enums.AccountStatus;
import enums.AdminPosition;
import enums.Role;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "admin_id")
public class Admin extends Account {
	@Column(name = "admin_code", length = 10, unique = true)
	@Size(max = 10, message = "Mã admin không được dài quá 10 kí tự")
	@NotEmpty(message = "Mã admin không được để trống")
	private String code;

	@Column(name = "full_name", length = 100)
	@Size(max = 100, message = "Tên admin không được dài quá 100 kí tự")
	@NotEmpty(message = "Tên admin không được để trống")
	private String fullName;

	@Column(name = "phone_number", length = 20)
	@Size(max = 20, message = "Số điện thoại không được dài quá 20 kí tự")
	private String phoneNumber;

	@Column(name = "admin_position")
	@Enumerated(EnumType.STRING)
	private AdminPosition adPos;

	@Column(name = "create_date")
	private LocalDate createDate;

	@Column(name = "last_login_time")
	private LocalDate lastLoginTime;

	public Admin() {
		super();
		super.setRole(Role.ADMIN);
	}

	public Admin(String username, String password, String email, AccountStatus status, String code, String fullName,
			LocalDate createDate) {
		super(username, password, email, Role.ADMIN, status);
		this.code = code;
		this.fullName = fullName;
		this.createDate = createDate;
	}

	public Admin(String username, String password, String email, AccountStatus status, String code, String fullName,
			String phoneNumber, AdminPosition adPos, LocalDate createDate, LocalDate lastLoginTime) {
		super(username, password, email, Role.ADMIN, status);
		this.code = code;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.adPos = adPos;
		this.createDate = createDate;
		this.lastLoginTime = lastLoginTime;
	}

	public String getId() {
		return super.getId();
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public AdminPosition getAdPos() {
		return adPos;
	}

	public void setAdPos(AdminPosition adPos) {
		this.adPos = adPos;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(LocalDate lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
