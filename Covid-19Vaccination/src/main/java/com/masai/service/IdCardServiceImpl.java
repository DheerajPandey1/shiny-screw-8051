package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.IdCardNotFoundException;
import com.masai.exception.IdCardNotRegisterException;
import com.masai.model.AdharCard;
import com.masai.model.AdminLoginSession;
import com.masai.model.Customer;
import com.masai.model.CustomerLoginSession;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.model.PanCard;
import com.masai.repo.AdminLoginSessionDao;
import com.masai.repo.CustomerDao;
import com.masai.repo.CustomerLoginSessionDao;
import com.masai.repo.IdRepo;
import com.masai.repo.MemberDao;

@Service
public class IdCardServiceImpl implements IdCardService {

	

	@Autowired
	private CustomerDao cdao;
	
	@Autowired
	private IdRepo irepo;
	
	@Autowired
	private AdminLoginSessionDao alsd;
	
	@Autowired
	private CustomerLoginSessionDao clsd;
//	
//	@Autowired
//	private MemberDao mdao;
	
	@Override
	public  IdCard getIdcardByPanNo(String panNumber, String key) throws IdCardNotFoundException {
		// TODO Auto-generated method stub
		CustomerLoginSession als=clsd.findByUuid(key);
		
		if(als==null) {
			throw new IdCardNotFoundException("Unauthorised access");
		}
		
		PanCard p=new PanCard();
		p.setPanNumber(panNumber);
		IdCard ic =irepo.findByPanCard(p);
		
		if (ic == null)
			throw new IdCardNotFoundException("IdCard not found with the panNo "+panNumber);
		else
			return   ic;
	}

	@Override
	public IdCard getIdCardByAdharNo(Long adharnumber, String key) throws IdCardNotFoundException {
		// TODO Auto-generated method stub
        CustomerLoginSession als=clsd.findByUuid(key);
		
		if(als==null) {
			throw new IdCardNotFoundException("Unauthorised access");
		}
		
		AdharCard ac=new AdharCard();
		ac.setAdhaarNo(adharnumber);
		IdCard ic =irepo.findByAdharCard(ac);
		
		if (ic == null)
			throw new IdCardNotFoundException("IdCard not found with the panNo "+adharnumber);
		else
			return   ic;
	}

	

	@Override
	public Customer addIdCard(IdCard idCard,String key) throws IdCardNotRegisterException {
		
		CustomerLoginSession cls=clsd.findByUuid(key);
		Integer i= cls.getCustomerId();
		Optional<Customer> c=cdao.findById(i);
		Customer cr = c.get();
		
		cr.setIdcard(idCard);
		
		Member m=new Member();
		
		m.setDose1date(null);
		m.setDose2date(null);
		m.setDose1status(false);
		m.setDose2status(false);
		
		idCard.setMember(m);
		
		return cdao.save(cr);
			
     
		
	}
	

}
