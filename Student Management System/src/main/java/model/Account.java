package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import annotations.UniqueField;
import enums.AccountStatus;
import enums.Role;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "account_id")
	private String id;

	@Column(name = "username", length = 50, unique = true)
	@UniqueField(entityClass = Account.class, fieldName = "username", message = "Username đã tồn tại")
	@Size(max = 50, message = "Username không được dài quá 50 kí tự")
	@NotEmpty(message = "Username không được để trống")
	private String username;

	@Column(name = "password", length = 50)
	@Size(max = 50, message = "Password không được dài quá 50 kí tự")
	@NotEmpty(message = "Password không được để trống")
	private String password;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Vui lòng chọn quyền cho tài khoản")
	private Role role;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Vui lòng chọn trạng thái tài khoản")
	private AccountStatus status;

	public Account() {

	}

	public Account(String username, String password, Role role, AccountStatus status) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.status = status;
	}
	
	public Account(String id, String username, String password, Role role, AccountStatus status) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.status = status;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", status=" + status + "]";
	}

}
