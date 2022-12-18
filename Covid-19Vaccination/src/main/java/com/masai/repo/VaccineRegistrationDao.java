package com.masai.repo;
public interface VaccineRegistrationDao extends JpaRepository<VaccineRegistration, Integer> {
		
		VaccineRegistration findByMobileNumber(String mobileNumber);
		
	

}
