package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;
	private String vaccineName;
	private String description;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private VaccineCount vaccineCount;
}
