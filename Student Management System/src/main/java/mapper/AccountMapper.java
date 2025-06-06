package mapper;

import dto.LoginRequestDTO;
import dto.LoginResponseDTO;
import entities.Account;

public class AccountMapper {
	public static Account ToEntity(LoginRequestDTO dto) {
		Account acc = new Account();
		acc.setUsername(dto.getUsername());
		acc.setPassword(dto.getPassword());
		return acc;
	}
	
	public static LoginResponseDTO toDTO(Account acc) {
		LoginResponseDTO dto = new LoginResponseDTO();
		dto.setUsername(acc.getUsername());
		dto.setEmail(acc.getEmail());
		dto.setRole(acc.getRole());
		dto.setStatus(acc.getStatus());
		return dto;
	}
}
