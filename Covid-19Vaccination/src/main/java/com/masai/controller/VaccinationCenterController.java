package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.VaccineCenterException;
import com.masai.model.VaccinationCenter;
import com.masai.service.VaccinationCenterService;

@RestController
public class VaccinationCenterController {
	
	@Autowired
	private VaccinationCenterService vs;
	
	@PostMapping("/addVaccineCenter/{uuid}")
	public ResponseEntity<VaccinationCenter> addVaccineCenter(@RequestBody VaccinationCenter vc, @PathVariable("uuid") String uuid) throws VaccineCenterException{
		return new ResponseEntity<>(vs.addVaccineCenter(vc, uuid), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteVaccineCenter/{uuid}")
	public ResponseEntity<Boolean> deleteVaccineCenter(@RequestBody VaccinationCenter vc, @PathVariable("uuid") String uuid) throws VaccineCenterException{
		
		boolean res =vs.deleteVaccineCenter(vc, uuid) ;
		if(res) {
			return new ResponseEntity<>(res, HttpStatus.ACCEPTED)	;	
		}
		
		return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST)	;
	}
	
	@PutMapping("/deleteVaccineCenter/{uuid}")
	public ResponseEntity<VaccinationCenter> updateVaccineCenter(@RequestBody VaccinationCenter vc, @PathVariable("uuid") String uuid) throws VaccineCenterException{
		
		VaccinationCenter res =vs.updateVaccineCenter(vc, uuid);
			return new ResponseEntity<>(res, HttpStatus.ACCEPTED)	;	
	}
}