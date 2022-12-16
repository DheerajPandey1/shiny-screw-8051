package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CustomerLoginSession;

public interface CustomerLoginSessionDao extends JpaRepository<CustomerLoginSession, Integer>{

public CustomerLoginSession findByCustomerId(Integer customerId) ;
	
	public CustomerLoginSession findByUuid(String key);

	public void delete(CustomerLoginSession customerLoginSession);

	

}
