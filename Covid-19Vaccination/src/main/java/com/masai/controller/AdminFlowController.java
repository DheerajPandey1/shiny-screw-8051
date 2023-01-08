package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

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

import com.masai.exception.LoginException;
import com.masai.exception.VaccineNotFoundException;
import com.masai.model.Admin;
import com.masai.model.AdminDTO;
import com.masai.model.Inventory;
import com.masai.model.Vaccine;
import com.masai.service.AdminServiceImpl;
import com.masai.service.IdCardService;
import com.masai.service.LoginServiceImpl;
import com.masai.service.MemberService;
import com.masai.service.VaccineInventryService;
import com.masai.service.VaccineService;

@RestController
@RequestMapping("/AdminFlow")
public class AdminFlowController {

	@Autowired
	private AdminServiceImpl adminDao ;
	
	@Autowired
	private IdCardService ids;
	
	@Autowired
	private MemberService ms;
	
	@Autowired
	private VaccineService vs;
	
	@Autowired 
	LoginServiceImpl loginService ;
	
	@PostMapping("/add")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) {

		System.out.println(admin);
		
		Admin ad =  adminDao.registerAdmin(admin);
		
		return new ResponseEntity<Admin>(ad , HttpStatus.ACCEPTED) ;
	}

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
	
	@PostMapping("/addVaccine/{uuid}")
	public ResponseEntity<Vaccine> addVaccine(@RequestBody Vaccine v,  @PathVariable("uuid") String uuid) throws LoginException, VaccineNotFoundException{
			
		return new ResponseEntity<>(vs.addVaccine(v, uuid),HttpStatus.ACCEPTED)	;	
	}
	
	@DeleteMapping("/deleteVaccine/{id}/{uuid}")
	public ResponseEntity<String> deleteVaccine(@PathVariable("id") Integer v,  @PathVariable("uuid") String uuid) throws LoginException, VaccineNotFoundException{
		
		boolean res=vs.deleteVaccine(v, uuid);
		
		if(res) {
			return new ResponseEntity<>("Deletion of Vaccine is Sucess....",HttpStatus.ACCEPTED)	;	
		}
		
		return new ResponseEntity<>("Unable to remove vaccine",HttpStatus.ACCEPTED)	;
	}
	
	@GetMapping("/getVaccineById/{vid}/{uuid}")
	public ResponseEntity<Vaccine> getVaccineById(@PathVariable("vid") Integer vid,  @PathVariable("uuid") String uuid) throws LoginException, VaccineNotFoundException{
		
		Vaccine res=vs.getVaccineById(vid, uuid);
		
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED)	;
	}
	
	
	@GetMapping("/getVaccineByName/{name}/{uuid}")
    public ResponseEntity<Vaccine> getVaccineByName(@PathVariable("name") String vname,  @PathVariable("uuid") String uuid) throws LoginException, VaccineNotFoundException{
		
		Vaccine res=vs.getVaccineByName(vname, uuid);
		
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED)	;
	}
	
	@PutMapping("/updateVaccine/{uuid}")
    public ResponseEntity<Vaccine> updateVaccine(@RequestBody Vaccine v,  @PathVariable("uuid") String uuid) throws LoginException, VaccineNotFoundException{
		
		Vaccine res=vs.updateVaccine(v, uuid);
		
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED)	;
	}
}
