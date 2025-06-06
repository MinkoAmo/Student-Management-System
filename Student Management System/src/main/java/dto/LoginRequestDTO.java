package dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginRequestDTO {
	
	@Size(max = 50, message = "Username không được dài quá 50 kí tự")
	@NotEmpty(message = "Username không được để trống")
	private String username;
	
	@Size(max = 50, message = "Password không được dài quá 50 kí tự")
	@NotEmpty(message = "Password không được để trống")
	private String password;

	public LoginRequestDTO() {
	}

	public LoginRequestDTO(String username, String password) {
		this.username = username;
		this.password = password;
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

}
