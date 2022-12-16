package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.model.VaccineRegistration;

public interface MemberDao extends JpaRepository<Member, Integer>{

public Member findByIdCard(IdCard idcard);

	


	public Member findByvaccineRegistration(VaccineRegistration vr);

}
