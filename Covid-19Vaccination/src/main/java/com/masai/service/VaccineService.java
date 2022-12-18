package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.VaccineNotFoundException;
import com.masai.model.Vaccine;


public interface VaccineService {

	public Vaccine getVaccineByName(String Vname,String uuid) throws VaccineNotFoundException,LoginException  ;
	public Vaccine getVaccineById(Integer vId,String uuid) throws VaccineNotFoundException,LoginException ;
	public Vaccine addVaccine(Vaccine v,String uuid) throws VaccineNotFoundException,LoginException ;
	public Vaccine updateVaccine(Vaccine v,String uuid) throws VaccineNotFoundException,LoginException ;
	public boolean deleteVaccine(Integer id,String uuid) throws VaccineNotFoundException,LoginException ;
	
}
