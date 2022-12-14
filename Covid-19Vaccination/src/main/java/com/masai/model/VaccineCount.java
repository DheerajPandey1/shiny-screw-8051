package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VaccineCount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccinecountId;
	private Integer quantity;
	private Double price;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineInventory vaccineinventory;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;

}
