package com.masai.service;

import com.masai.model.VaccineRegistration;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.VaccineRegistrationException;
//import com.masai.exception.VaccineRegistrationException;
import com.masai.model.Member;


	
	public interface VaccineRegistrationService {
		
		public List<VaccineRegistration> allVaccineRegistration(String key) throws VaccineRegistrationException;
		
		
		public VaccineRegistration addVaccineRegistration(String registration, String key) throws VaccineRegistrationException;
		public VaccineRegistration getVaccineRegistration(String mobileNumber,String key) throws VaccineRegistrationException;
		public List<VaccineRegistration> getAllMember() throws VaccineRegistrationException ;
		public VaccineRegistration updateVaccineRegistration(String old,String mobile,String key) throws VaccineRegistrationException;
		 public boolean deleteVaccineRegistration(String mobile,String key) throws VaccineRegistrationException;
		
		
		
		
	
	
}
