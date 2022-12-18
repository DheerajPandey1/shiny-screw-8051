package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.Member;


public interface CustomerService {

public Customer registerCustomer(Customer customer) throws CustomerException  ;
	
	public Customer updateCustomer(Customer customer)throws CustomerException ;
	
	public Customer getCustomerById(Integer customerId)throws CustomerException ;
	
	public Customer deleteCustomerById(Integer customerId)throws CustomerException ;
	
	public Member getmemberstatus(String key);
	
}
