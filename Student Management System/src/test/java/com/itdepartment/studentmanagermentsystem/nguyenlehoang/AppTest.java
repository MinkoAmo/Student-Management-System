package com.itdepartment.studentmanagermentsystem.nguyenlehoang;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dto.LoginRequestDTO;
import entities.Account;
import mapper.AccountMapper;
import service.AccountService;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
    public void testAccountService() {
    	LoginRequestDTO dto = new LoginRequestDTO("abdul.koss", "gbd9xwu8");
    	AccountService service = new AccountService();	
    	assertNotNull(service.login(dto), "Login failed - expected account, got null");
    }
}
