package com.masai.service;

import java.util.List;

import com.masai.exception.MemberNotFoundException;
import com.masai.exception.MemberNotRegisterException;
import com.masai.model.Member;

public class MemberServiceImpl implements MemberService{

	@Override
	public List<Member> GetallTheMembers(String key) throws MemberNotRegisterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMemberById(Integer idcardid, String key) throws MemberNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMemberByAdharNo(Long adharNo, String key) throws MemberNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMemberByPanNo(String panNo, String key) throws MemberNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member addMemberbyMobileNo(Member member, String mobileNo, String key) throws MemberNotFoundException {
		// TODO Auto-generated method stub
		return null;
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
