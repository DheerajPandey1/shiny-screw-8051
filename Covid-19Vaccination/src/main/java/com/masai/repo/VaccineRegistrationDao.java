package com.masai.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.exception.VaccineRegistrationException;
import com.masai.model.VaccineRegistration;

public interface VaccineRegistrationDao extends JpaRepository<VaccineRegistration, Integer> {
		
		VaccineRegistration findByMobileNumber(String mobileNumber);
		
	

}
