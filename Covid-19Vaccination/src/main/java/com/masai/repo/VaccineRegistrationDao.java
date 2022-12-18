package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.VaccineRegistration;

public interface VaccineRegistrationDao extends JpaRepository<VaccineRegistration, Integer> {
		
		VaccineRegistration findByMobileNumber(String mobileNumber);
		
	

}
