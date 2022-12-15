package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminServiceImpl adminDao ;
	
	@PostMapping("/")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) {
		
		Admin ad =  adminDao.registerAdmin(admin);
		
		return new ResponseEntity<Admin>(ad , HttpStatus.ACCEPTED) ;
	}
	
	@PutMapping("/")
	public ResponseEntity<Admin> UpdateAdmin(@Valid @RequestBody Admin admin) throws AdminException {
		
		Admin ad =  adminDao.updateAdmin(admin) ;
		
		return new ResponseEntity<Admin>(ad , HttpStatus.OK) ;
	}  
	
	@GetMapping("/{adminId}")
	public ResponseEntity<Admin>  getAdminByAdminId(@PathVariable("adminId") Integer adminId ) throws AdminException {
		
		Admin ad = adminDao.getAdminById(adminId);
		
		return new ResponseEntity<Admin>(ad , HttpStatus.OK) ;
	}
	@DeleteMapping("/{adminId}")
	public ResponseEntity<Admin> deleteAdminById(@PathVariable("adminId") Integer adminId ) throws AdminException {
		
		Admin ad =adminDao.deleteAdminById(adminId) ;
		
		return new ResponseEntity<Admin>(ad , HttpStatus.OK) ;
	}
	
	}
