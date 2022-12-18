package com.masai.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VaccineRegistration {

	@Id
	private String mobileNumber;


	private LocalDate dateofRegistration;
	
//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL)
//	private Member memberList ;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getDateofRegistration() {
		return dateofRegistration;
	}

	public void setDateofRegistration(LocalDate dateofRegistration) {
		this.dateofRegistration = dateofRegistration;
	}

//	public Member getMemberList() {
//		return memberList;
//	}
//
//	public void setMemberList(Member memberList) {
//		this.memberList = memberList;
//	}

	public VaccineRegistration(String mobileNumber, LocalDate dateofRegistration, Member memberList) {
		super();
		this.mobileNumber = mobileNumber;
		this.dateofRegistration = dateofRegistration;
//		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "VaccineRegistration [mobileNumber=" + mobileNumber + ", dateofRegistration=" + dateofRegistration
				+ ",]";
	}

	public VaccineRegistration() {
		
	}
	
}

