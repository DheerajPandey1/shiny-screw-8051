package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.CustomerLoginSession;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.repo.CustomerDao;
import com.masai.repo.CustomerLoginSessionDao;
import com.masai.repo.MemberDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	
	
	
	@Autowired
	private CustomerDao cdao;
	
	@Autowired
	private MemberDao mdao;
	
	@Autowired
	private CustomerLoginSessionDao clsd;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		Customer c=cdao.findByMobileNumber(customer.getMobileNumber());
		
		if(c!= null) {
			throw new CustomerException("customer is alredy there");
		}
		Customer c1= cdao.save(customer);
		Member m=new Member();
		m.setMemberId(c1.getCustomerId());
		mdao.save(m);
		return c1;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
Optional<Customer> customer2 = cdao.findById(customer.getCustomerId()) ;
		
		if(customer2== null) {
			throw new  CustomerException("Admin is Not Found") ;
		}
		return cdao.save(customer) ;
	
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer>opt=cdao.findById(customerId);
		
		if(opt.isEmpty()) {
			throw new CustomerException("Customer not found");
		}
		
		return opt.get();
	}

	@Override
	public Customer deleteCustomerById(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer>opt=cdao.findById(customerId);
		
		if(opt.isEmpty()) {
			throw new CustomerException("Customer not found");
			
		}
		
	         cdao.delete(opt.get());
	         
	         return opt.get();
	        
	          
	}
	
	
	public Member getmemberstatus(String key) throws CustomerException {
		CustomerLoginSession cls=clsd.findByUuid(key);
		Integer i= cls.getCustomerId();
		Optional<Customer> c=cdao.findById(i);
		Customer cr = c.get();
		IdCard ic=cr.getIdcard();
		if(ic==null) {
			throw new CustomerException("Please fill your id card first...");
		}
		return ic.getMember();
		
		
	}

}
