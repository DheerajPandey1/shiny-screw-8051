package com.masai.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VaccineRegistration {

	@Id
	private String mobileno;
	
	private String dateOfRegistration;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Member>memberList;
}
