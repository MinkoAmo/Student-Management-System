package dto;

import enums.AccountStatus;
import enums.Role;

public class LoginResponseDTO {
	private String username;
	private String email;
	private Role role;
	private AccountStatus status;

	public LoginResponseDTO() {
	}

	public LoginResponseDTO(String username, String email, Role role, AccountStatus status) {
		this.username = username;
		this.email = email;
		this.role = role;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
