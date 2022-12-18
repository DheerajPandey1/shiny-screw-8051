package com.masai.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.VaccineRegistrationException;
import com.masai.model.Customer;
import com.masai.model.CustomerLoginSession;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.model.VaccineRegistration;
import com.masai.repo.CustomerDao;
import com.masai.repo.CustomerLoginSessionDao;
import com.masai.repo.MemberDao;
import com.masai.repo.VaccineRegistrationDao;



@Service
public class VaccineRegistrationImpl implements VaccineRegistrationService {
	  
	@Autowired
	private CustomerDao cd;
	
	@Autowired
	private MemberDao mdao;
	
	@Autowired
	private CustomerLoginSessionDao clsd;
	
	
	
		@Autowired
		private VaccineRegistrationDao daoVacRegistration;
		
//		@Autowired
//		private AdminLoginSessionDao adao;
		
		@Autowired
		private CustomerLoginSessionDao cdao;
		
		@Override
		public List<VaccineRegistration> allVaccineRegistration(String key) throws VaccineRegistrationException {
			  
			     List<VaccineRegistration>   allRegistration=  daoVacRegistration.findAll();
			    
			       if(allRegistration.size()>=0)
			       {
			    	   throw new VaccineRegistrationException("Registration of  vaccine doesn't exist..");
			       }
			      
			       return allRegistration;
		}
		
		
		@Override
		public Member addVaccineRegistration(String mobile,String key) throws VaccineRegistrationException {
			   
			  CustomerLoginSession cls= cdao.findByUuid(key);
			  
			  if(cls==null)
			  {
				  throw new LoginException("Unauthorised access denied..");
			  }
			  
			  CustomerLoginSession clas =clsd.findByUuid(key);
				Integer i= clas.getCustomerId();
				Optional<Customer> c=cd.findById(i);
				Customer cr = c.get();
			  
				IdCard idcar=cr.getIdcard();
				Member memb=idcar.getMember();
				
				
//				VaccineRegistration vr=new VaccineRegistration();
				
			  VaccineRegistration obj=new VaccineRegistration();
			  obj.setMobileNumber(mobile);
			  obj.setDateofRegistration(LocalDate.now());
			  memb.setVaccineRegistration(obj);
			 
			      Member me=mdao.save(memb);
			   
			     return me;
		}
		
		
		
		
		
		
		@Override
		public VaccineRegistration getVaccineRegistration(String mobileNumber,String key) throws VaccineRegistrationException {
			     
//			 CustomerLoginSession cls= cdao.findByUuid(key);
//			  if(cls==null)
//			  {
//				  throw new LoginException("Unauthorised access denied..");
//			  }
			    VaccineRegistration optRegis= daoVacRegistration.findByMobileNumber(mobileNumber);
			   
			    if(optRegis!=null)
			    {
			    	  return optRegis;
			    }
			    throw new VaccineRegistrationException("Vaccine Registration not found with this Number..");
			   
		}
		@Override
		public List<VaccineRegistration> getAllMember() throws VaccineRegistrationException {
//			 AdminLoginSession cls= cdao.findByUuid(key);
//			  if(cls==null)
//			  {
//				  throw new LoginException("Unauthorised access denied..");
//			  }
//			 
			  List<VaccineRegistration> vrm= daoVacRegistration.findAll();
//			 
			  if(vrm.isEmpty())
			  {
				  throw new VaccineRegistrationException("Mamber Not found with this number..");
			  }
			 
			 return vrm;
			  
		}
		@Override
	public VaccineRegistration updateVaccineRegistration(String old,String mobile,String key) throws VaccineRegistrationException {
//			           
//	 CustomerLoginSession cls= cdao.findByUuid(key);
//		 if(cls==null)
//		{
//				  throw new LoginException("Unauthorised access denied..");
//		 }
			
			
			
		 VaccineRegistration optRegis= daoVacRegistration.findByMobileNumber(old);
			          
		 if(optRegis==null)
			  {
			            	throw new VaccineRegistrationException("Vaccine registration doesn't exist..");
			    }
			           
		 optRegis.setMobileNumber(mobile);
		 return  daoVacRegistration.save(optRegis);
			       
			
		}
		
		
		@Override
		public boolean deleteVaccineRegistration(String mobile,String key) throws VaccineRegistrationException {
			    
//			 CustomerLoginSession cls= cdao.findByUuid(key);
//			  if(cls==null)
//			  {
//				  throw new LoginException("Unauthorised access denied..");
//			  }
	VaccineRegistration optRegisDelete= daoVacRegistration.findByMobileNumber(mobile);
			       
			          if(optRegisDelete==null)
			          {
			        	  throw new VaccineRegistrationException("Vaccine registration can not delete because its not exist..");
			        	 
			          }
			         
			          daoVacRegistration.delete(optRegisDelete);
			         
			          return true;
		}
}