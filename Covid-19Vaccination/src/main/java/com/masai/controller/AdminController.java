package com.masai.controller;

import javax.validation.Valid;
//import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.exception.IdCardNotFoundException;
import com.masai.exception.IdCardNotRegisterException;
import com.masai.model.Admin;
import com.masai.model.IdCard;
//import com.masai.repo.AdminDao;
//import com.masai.service.AdminService;
import com.masai.service.AdminServiceImpl;
import com.masai.service.IdCardService;
import com.masai.service.MemberService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private AdminServiceImpl adminDao ;
	
	@Autowired
	private IdCardService ids;
	
	@Autowired
	private MemberService ms;
	
	@PostMapping("/add")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) {

		System.out.println(admin);
		
		Admin ad =  adminDao.registerAdmin(admin);
		
		return new ResponseEntity<Admin>(ad , HttpStatus.ACCEPTED) ;
	}

	@PutMapping("/update")
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
	
	
	
	
	
//	ID
	
	
//	Member
	
	@GetMapping("/IdByAdhar/{AdharNo}")
	public ResponseEntity<IdCard> FindByAdharHandler(@PathVariable Long AdharNo,@RequestParam String key) throws IdCardNotFoundException{
		
		IdCard idc=ids.getIdCardByAdharNo(AdharNo, key);
		return new ResponseEntity<IdCard>(idc,HttpStatus.FOUND);
		
	}
 
	@GetMapping("/IdByPan/{PanNo}")
	public ResponseEntity<IdCard> FindByPanHandler(@PathVariable String PanNo,@RequestParam String key) throws IdCardNotFoundException{
		
		IdCard idc=ids.getIdcardByPanNo(PanNo, key);
		return new ResponseEntity<IdCard>(idc,HttpStatus.FOUND);
		
	}
	
	

}
