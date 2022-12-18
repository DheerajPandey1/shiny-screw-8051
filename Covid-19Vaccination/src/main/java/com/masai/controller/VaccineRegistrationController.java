package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.VaccineRegistrationException;
import com.masai.model.Member;
import com.masai.model.VaccineRegistration;
import com.masai.service.VaccineRegistrationService;

//import com.masai.service.VaccineRegistrationImpl;

	//import com.masai.service.VaccineRegistrationService;

	@RestController
	//@RequestMapping("/service")
	public class VaccineRegistrationController{
       
		
		@Autowired
		private VaccineRegistrationService ser;
		
		
		@GetMapping("/Allregistrations")
		     public ResponseEntity<List<VaccineRegistration>> getallRegistration(String key) throws VaccineRegistrationException{
		    	 
		    	        List<VaccineRegistration> myreg= ser.allVaccineRegistration(key);
		    	        
		    	        return new ResponseEntity<List<VaccineRegistration>>(myreg, HttpStatus.OK);
		    	        
		     }

		@GetMapping("/member/{mobileNumber}/{key}")
		 public ResponseEntity<VaccineRegistration> getMemberByNumber(@PathVariable("mobileNumber") String mobileNumber,@PathVariable("key") String key) throws VaccineRegistrationException{
//			    Member me=ser.getAllMember();
			
			    return new ResponseEntity<>(ser.getVaccineRegistration(mobileNumber, key),HttpStatus.OK);
////			return new ResponseEntity<List<Member>>(HttpStatus.OK);
//			return new ResponseEntity<List<Member>>(reg.getAllMember(mobileNumber, key),HttpStatus.OK);
		 }
		
		  @PostMapping("/registration/{mobile}/{key}")
		   public ResponseEntity<Member> addRegistration( @PathVariable("mobile") String m,@RequestParam("key") String key) throws VaccineRegistrationException{
			   
			      return new ResponseEntity<>(ser.addVaccineRegistration(m,key), HttpStatus.OK);
		   }
		  
//		  @GetMapping("/registrations/{mobileNumber}")
//		  public ResponseEntity<VaccineRegistration> getVaccineRegistration( @PathVariable("mobileNumber") String mobileNumber,@RequestParam String key) throws VaccineRegistrationException{
//			  
//			    return new ResponseEntity<VaccineRegistration>(ser.getVaccineRegistration(mobileNumber,key),HttpStatus.OK);
//		  }
//		  
//		  @PutMapping("/registration")
//		  public ResponseEntity<VaccineRegistration> UpdateRegistration( @RequestBody VaccineRegistration registration,@RequestParam String key) throws VaccineRegistrationException{
//			  
//			      return new ResponseEntity<VaccineRegistration>(ser.updateVaccineRegistration(registration,key),HttpStatus.OK);
//		  }
//		  
//		  @DeleteMapping("/registration")
//		  public boolean DeleteRegistraion( @RequestBody VaccineRegistration registration,@RequestParam String key) throws VaccineRegistrationException{
//			        
//			      boolean del =     ser.deleteVaccineRegistration(registration,key);		               
//			             return del;
//		  }
//		
//		



	}
	
	

