package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.MemberNotFoundException;
import com.masai.exception.MemberNotRegisterException;
import com.masai.model.Member;

@Service
public interface MemberService {


    
	public Member getMemberById(Integer idcardid,String key) throws MemberNotFoundException;

	public Member getMemberByAdharNo(Long adharNo,String key) throws MemberNotFoundException;

	public Member getMemberByPanNo(String panNo,String key) throws MemberNotFoundException;
	
	public Member addMember(Member member) throws MemberNotFoundException;

	public Member updateMember(Member member,String key) throws MemberNotFoundException;

	public boolean deleteMemberRecord(Member member,String key) throws MemberNotFoundException;
}
