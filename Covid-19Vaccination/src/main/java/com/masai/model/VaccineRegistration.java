package com.masai.model;

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


	private String dateofRegistration;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Member> memberList ;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDateofRegistration() {
		return dateofRegistration;
	}

	public void setDateofRegistration(String dateofRegistration) {
		this.dateofRegistration = dateofRegistration;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public VaccineRegistration(String mobileNumber, String dateofRegistration, List<Member> memberList) {
		super();
		this.mobileNumber = mobileNumber;
		this.dateofRegistration = dateofRegistration;
		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "VaccineRegistration [mobileNumber=" + mobileNumber + ", dateofRegistration=" + dateofRegistration
				+ ", memberList=" + memberList + "]";
	}

	
	public VaccineRegistration() {
		
	}
	
}
