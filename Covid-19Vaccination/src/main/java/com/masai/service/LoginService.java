package com.masai.service;

import com.masai.model.AdminDTO;
import com.masai.model.CustomerDTO;

public interface LoginService {

public String adminLoggin(AdminDTO adminDto) ;
	
	public String adminLoggedOut(String key) ;
	
	public String CustomerLoggin(CustomerDTO customerDto) ;
	
	public String customerLoggedOut(String key) ;
}
