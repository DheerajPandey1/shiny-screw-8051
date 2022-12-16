package com.masai.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.LoginException;
import com.masai.model.Admin;
import com.masai.model.AdminDTO;
import com.masai.model.AdminLoginSession;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.model.CustomerLoginSession;
import com.masai.repo.AdminDao;
import com.masai.repo.AdminLoginSessionDao;
import com.masai.repo.CustomerDao;
import com.masai.repo.CustomerLoginSessionDao;

import net.bytebuddy.utility.RandomString;

public class LoginServiceImpl implements LoginService{

	@Autowired
	AdminDao adminDao ;
	
	@Autowired
	CustomerDao customerDao ;
	
	@Autowired
	AdminLoginSessionDao adminLoginSessionDao ;
	
	@Autowired
	CustomerLoginSessionDao customerLoginSessionDao ;
	
	
	@Override
	public String adminLoggin(AdminDTO adminDto) {
		Admin admin = adminDao.findByMobileNumber(adminDto.getMobileNumber()) ;
		
		if(admin==null) {
			throw new LoginException("Admin is not available with this Number: "+adminDto.getMobileNumber());
		}
		
		AdminLoginSession adminLoginSession = adminLoginSessionDao.findByAdminId(admin.getAdminId());
		
		if(adminLoginSession !=null) {
			throw new LoginException("Admin Already Loggged in");
		}
		
		if(! admin.getPassword().equalsIgnoreCase(adminDto.getPassword())) {
			throw new LoginException("please Enter Correct password");
		}
		
		AdminLoginSession adminLoginSession2 = new  AdminLoginSession() ;
		
		adminLoginSession2.setAdminId(admin.getAdminId());
		
		String key = RandomString.make(7);
		
		adminLoginSession2.setUuid(key);
		adminLoginSession2.setDateTime(LocalDateTime.now());
		
	    adminLoginSessionDao.save(adminLoginSession2).toString() ;
		
		return adminLoginSession2.toString();
	}

	@Override
	public String adminLoggedOut(String key) {
		
		AdminLoginSession adminLoginSession = adminLoginSessionDao.findByUuid(key) ;
		
		if(adminLoginSession ==null) {
			throw new LoginException("Admin is Not Logged In ");
		}
		adminLoginSessionDao.delete(adminLoginSession);
		
		return "Admin Logged Out Successfully";
	}

	@Override
	public String CustomerLoggin(CustomerDTO customerDto) {
Customer customer = customerDao.findByMobileNumber(customerDto.getMobileNumber()) ;
		
		if(customer==null) {
			throw new LoginException("Customer is not available with this Number: "+customerDto.getMobileNumber());
		}
		
		CustomerLoginSession customerLoginSession = customerLoginSessionDao.findByCustomerId(customer.getCustomerId());
		
		if(customerLoginSession !=null) {
			throw new LoginException("Customer Already Loggged in");
		}
		
		if(! customer.getPassword().equalsIgnoreCase(customerDto.getPassword())) {
			throw new LoginException("please Enter Correct password");
		}
		
		CustomerLoginSession customerLoginSession2 = new  CustomerLoginSession() ;
		
		customerLoginSession2.setCustomerId(customer.getCustomerId());
		
		String key = RandomString.make(7);
		
		customerLoginSession2.setUuid(key);
		customerLoginSession2.setDateTime(LocalDateTime.now()) ;;
		
	    customerLoginSessionDao.save(customerLoginSession2) ;
		
		return customerLoginSession2.toString();
	}

	@Override
	public String customerLoggedOut(String key) {
    
		CustomerLoginSession customerLoginSession = customerLoginSessionDao.findByUuid(key) ;
		
		if(customerLoginSession ==null) {
			throw new LoginException("Customer is Not Logged In ");
		}
		customerLoginSessionDao.delete(customerLoginSession);
		
		return "Customer Logged Out Successfully";
	}

}
