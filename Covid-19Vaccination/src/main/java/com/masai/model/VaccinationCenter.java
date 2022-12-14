package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer centerId;
	
	@NotNull(message = "Center name can not be null")
	private String centername;

	@NotNull(message = "City can not be null")
	
	private String city;

	@NotNull(message = "Address can not be null")
	
	private String address;

	@NotNull(message = "State can not be null")

	private String state;

	@NotNull(message = "Pincode can not be null")
	@Size(min = 6, max = 8)
	private String pincode;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineInventory vaccineinventory;
}
