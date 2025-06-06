package service;

import dao.AccountDAO;
import dto.LoginRequestDTO;
import dto.LoginResponseDTO;
import entities.Account;
import mapper.AccountMapper;

public class AccountService {
	private AccountDAO accountDao;
	
	public AccountService() {
		this.accountDao = new AccountDAO();
	}
	
	public LoginResponseDTO login(LoginRequestDTO dto) {
		Account acc = accountDao.selectByCode(dto.getUsername());
		
		if (acc == null || !acc.getPassword().equals(dto.getPassword())) return null;
		return AccountMapper.toDTO(acc);
	}
}
