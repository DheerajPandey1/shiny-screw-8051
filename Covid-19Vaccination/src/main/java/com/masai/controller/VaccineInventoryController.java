package com.masai.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Inventory;
import com.masai.model.Vaccine;
import com.masai.service.VaccineInventryService;

import java.util.List;

@RestController
public class VaccineInventoryController {

	@Autowired
    private VaccineInventryService vis;
	
	@GetMapping("/getVaccineInvantoryByVaccine/{key}")
	public ResponseEntity<Inventory> getVaccineInvantoryByVaccine(@RequestBody Vaccine v,@PathVariable("key")  String key) {
		
		Inventory res=vis.getVaccineInvantoryByVaccine(v, key);
		
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getVaccineInvantoryByDate/{date}/{month}/{year}/{key}")
	public ResponseEntity<List<Inventory>> getVaccineInvantoryByDate(@PathVariable("date") Integer d,@PathVariable("month") Integer m,@PathVariable("year") Integer y,@PathVariable("key") String key) {
		
		
		
		LocalDate ld=LocalDate.of(y,m, d);
		
		List<Inventory> res=vis.getVaccineInvantoryByDate(ld, key);
		
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
		
	}
	
	
}
