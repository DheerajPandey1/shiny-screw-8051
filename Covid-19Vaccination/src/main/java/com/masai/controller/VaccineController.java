package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.exception.VaccineNotFoundException;
import com.masai.model.Vaccine;
import com.masai.service.VaccineService;

@RestController

public class VaccineController {

	@Autowired
	private VaccineService vs;
	
	@PostMapping("/register/{uuid}")
	public ResponseEntity<Vaccine> register(@RequestBody Vaccine v,  @PathVariable("uuid") String uuid) throws LoginException, VaccineNotFoundException{
			
		return new ResponseEntity<>(vs.addVaccine(v, uuid),HttpStatus.ACCEPTED)	;	
	}
	
	@DeleteMapping("/deleteVaccine/{uuid}")
	public ResponseEntity<String> deleteVaccine(@RequestBody Vaccine v,  @PathVariable("uuid") String uuid) throws LoginException, VaccineNotFoundException{
		
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
