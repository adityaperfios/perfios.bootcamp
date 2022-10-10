package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCase {

	//UserDao obj = new UserDao();
	User user = new User();
	
	
	@Test
	public void saveuserTest() throws Exception{
		user.setName("Balaji");
		user.setPassword("12345");
		user.setUserName("Balaji1234");
		user.setEmail("balaji597@gmail.com");
		user.setPhn_no(Long.parseLong("7842309230"));
		user.setAddress("Bangalore");
		user.setGender("Male");
		user.setAmount(Double.parseDouble("20000"));
		assertEquals(1, UserDao.saveUser(user));
	}
	
	@Test
	public void loginTest() throws Exception{
		assertEquals(true, UserDao.login("aditya_8571", "1234"));
	}
	

}
