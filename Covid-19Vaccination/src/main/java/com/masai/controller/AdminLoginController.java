package com.masai.controller;

//import javax.security.auth.login.LoginException ;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.AdminLoginDTO;
import com.masai.DTO.CustomerDTO;
import com.masai.model.AdminDTO;
import com.masai.model.CurrentAdminSession;
import com.masai.service.AdminLoginService;
import com.masai.service.AdminLoginServiceImpl;

@RestController
public class AdminLoginController {
	@Autowired 
	AdminLoginServiceImpl loginService ;
	
	@PostMapping("/adminLogin")
	public ResponseEntity<String> adminLogging(@RequestBody AdminDTO adminDto){
		String str =  loginService.adminLoggin(adminDto) ;
		
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED) ;
	}
	
	@DeleteMapping("/adminLogin/{key}")
	public ResponseEntity<String> adminLoggedOut(@PathVariable("key") String key){
		
		String str = loginService.adminLoggedOut(key) ;
		
		return new ResponseEntity<>(str , HttpStatus.OK) ;
	}
	
//	@PostMapping("/customerLogin")
//	public ResponseEntity<String> customerLogging(@RequestBody CustomerDTO cusstomerDto){
//		String str =  loginService.CustomerLogin(cusstomerDto);
//		
//		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED) ;
//	}
//	
	@DeleteMapping("/customerLogin/{key}")
	public ResponseEntity<String> customerLoggedOut(@PathVariable("key") String key){
		
		String str = loginService.customerLoggedOut(key);
		
		return new ResponseEntity<>(str , HttpStatus.OK) ;
	}
}
