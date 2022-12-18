package com.masai.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VaccineRegistration {

	@Id
	private String mobileNumber;


	private LocalDate dateofRegistration;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Member> memberList ;

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

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public VaccineRegistration(String mobileNumber, LocalDate dateofRegistration, List<Member> memberList) {
		super();
		this.mobileNumber = mobileNumber;
		this.dateofRegistration = dateofRegistration;
		this.memberList = memberList;
	}

	public VaccineRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}

