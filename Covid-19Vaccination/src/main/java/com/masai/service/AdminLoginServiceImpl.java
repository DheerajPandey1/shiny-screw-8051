package com.masai.service;

//import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.DTO.AdminLoginDTO;
import com.masai.model.Admin;
import com.masai.model.AdminDTO;
import com.masai.model.CurrentAdminSession;
import com.masai.model.customerDTO;
import com.masai.repo.AdminDao;
import com.masai.repo.AdminLoginSessionDao;

import net.bytebuddy.utility.RandomString;


public class AdminLoginServiceImpl implements AdminLoginService {

	
	@Override
	public String adminLoggin(AdminDTO adminDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String adminLoggedOut(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String CustomerLoggin(customerDTO customerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerLoggedOut(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
