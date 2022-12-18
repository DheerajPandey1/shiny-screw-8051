package com.masai.service;

import java.util.List;

import com.masai.exception.VaccineRegistrationException;
import com.masai.model.Member;
import com.masai.model.VaccineRegistration;


	
	public interface VaccineRegistrationService {
		
		public List<VaccineRegistration> allVaccineRegistration(String key) throws VaccineRegistrationException;
		
		
		public Member addVaccineRegistration(String mobile, String key) throws VaccineRegistrationException;
		public VaccineRegistration getVaccineRegistration(String mobileNumber,String key) throws VaccineRegistrationException;
		public List<VaccineRegistration> getAllMember() throws VaccineRegistrationException ;
		public VaccineRegistration updateVaccineRegistration(String old,String mobile,String key) throws VaccineRegistrationException;
		 public boolean deleteVaccineRegistration(String mobile,String key) throws VaccineRegistrationException;
		
		
		
		
	
	
}
