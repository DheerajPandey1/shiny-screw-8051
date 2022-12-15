package com.masai.service;

import org.springframework.stereotype.Service;

//import javax.security.auth.login.LoginException;

import com.masai.DTO.AdminLoginDTO;
import com.masai.model.AdminDTO;
import com.masai.model.CurrentAdminSession;
import com.masai.model.customerDTO;

@Service
public interface AdminLoginService {


	public String adminLoggin(AdminDTO adminDto) ;
	
	public String adminLoggedOut(String key) ;
	
	public String CustomerLoggin(customerDTO customerDto) ;
	
	public String customerLoggedOut(String key) ;
}
