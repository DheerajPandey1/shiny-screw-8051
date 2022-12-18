package com.masai.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.VaccineRegistrationException;
import com.masai.model.CustomerLoginSession;
import com.masai.model.VaccineRegistration;
import com.masai.repo.CustomerLoginSessionDao;
import com.masai.repo.VaccineRegistrationDao;



@Service
public class VaccineRegistrationImpl implements VaccineRegistrationService {
	  
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
		public VaccineRegistration addVaccineRegistration(String mobile,String key) throws VaccineRegistrationException {
			   
			  CustomerLoginSession cls= cdao.findByUuid(key);
			  if(cls==null)
			  {
				  throw new LoginException("Unauthorised access denied..");
			  }
			  
			  VaccineRegistration obj=new VaccineRegistration();
			  obj.setMobileNumber(mobile);
			  obj.setDateofRegistration(LocalDate.now());
			 
			    VaccineRegistration registraionDone=daoVacRegistration.save(obj);
			   
			     return registraionDone;
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