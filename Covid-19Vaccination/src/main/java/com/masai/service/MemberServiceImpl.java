package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.exception.AppointmentException;
import com.masai.exception.MemberNotFoundException;
import com.masai.exception.MemberNotRegisterException;
import com.masai.model.AdharCard;
import com.masai.model.AdminLoginSession;
import com.masai.model.Appointment;
import com.masai.model.CustomerLoginSession;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.model.PanCard;
import com.masai.repo.AdminLoginSessionDao;
import com.masai.repo.CustomerLoginSessionDao;
import com.masai.repo.IdRepo;
import com.masai.repo.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	IdRepo idDao;
	
	@Autowired
	CustomerLoginSessionDao customerLogin;
	
	@Autowired
	private MemberDao mdao;

	@Autowired
	AdminLoginSessionDao  adminLogin;
	
//	@Override
//	public List<Member> GetallTheMembers(String key) throws MemberNotRegisterException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Member getMemberById(Integer idcardid, String key) throws MemberNotFoundException {
		// TODO Auto-generated method stub
		
		
//		Optional<IdCard> idcard=idDao.findById(idcardId);
		
		return null;
	}

	@Override
	public Member getMemberByAdharNo(Long adharNo, String key) throws MemberNotFoundException {
		// TODO Auto-generated method stub
		
		AdminLoginSession adminLoginSession = adminLogin.findByUuid(key);
		if(adminLoginSession==null) {
			
			throw new MemberNotFoundException("Unauthorised access");
		}
		AdharCard adhr=new AdharCard();
		adhr.setAdhaarNo(adharNo);
		IdCard idcard = idDao.findByAdharCard(adhr);
		if(idcard !=null) {
			Optional<IdCard>id=idDao.findById(idcard.getId());
			Member member = mdao.findByIdCard(id.get());
			
			if (member != null)
				return member;
			else
				throw new MemberNotFoundException("Member not available with this adhar no: " + adharNo);
		} else
			throw new MemberNotFoundException("Member not available with this adhar no: " +adharNo);
		
       
	
	}

	@Override
	public Member getMemberByPanNo(String panNo, String key) throws MemberNotFoundException {
		// TODO Auto-generated method stub
		AdminLoginSession adlo=adminLogin.findByUuid(key);
		
		if(adlo == null) {
			throw new MemberNotFoundException("Unauthorised access");
		}
		
		PanCard pn=new PanCard();
		pn.setPanNumber(panNo);
		
		IdCard ic=idDao.findByPanCard(pn);
		
		if(ic !=null) {
			Optional<IdCard>id=idDao.findById(ic.getId());
			Member mem=mdao.findByIdCard(id.get());
			
			if(mem !=null) 
				return mem;
			else
				throw new MemberNotFoundException("Member not available with this pan no: " + panNo);
		}
		
		return null;
	}

	@Override
	public Member addMember(Member member) throws MemberNotFoundException {
		// TODO Auto-generated method stub
//		 CustomerLoginSession custLoginSession = customerLogin.findByUuid(key);
		
		
		
		
		return mdao.save(member);
	}

	@Override
	public Member updateMember(Member member, String key) throws MemberNotFoundException {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public boolean deleteMemberRecord(Member member, String key) throws MemberNotFoundException {
		// TODO Auto-generated method stub
		
		return false;
	}

	
	
}
