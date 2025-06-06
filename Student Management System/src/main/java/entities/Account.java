package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

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
	private String username;

	@Column(name = "password", length = 50)
	private String password;

	@Column(name = "email", length = 254, unique = true)
	@Size(max = 254, message = "Email không được dài quá 254 kí tự")
	@Email(message = "Email không đúng định dạng")
	@NotEmpty(message = "Email không được để trống")
	private String email;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Vui lòng chọn quyền cho tài khoản")
	private Role role;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Vui lòng chọn trạng thái tài khoản")
	private AccountStatus status;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	Set<ActivityLog> logs;

	public Account() {

	}

	public Account(String username, String password, String email, Role role, AccountStatus status) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.status = status;
	}

	public Account(String id, String username, String password, String email, Role role, AccountStatus status) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
