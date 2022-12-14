package com.masai.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int memberid;
	private boolean dose1status;
	private boolean dose2status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dosedate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dose2date;
	
	@OneToOne(cascade = CascadeType.ALL)
	private IdCard idCard;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineRegistration vaccineRegistration;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
	private  List<Appointment> listofappointments;
	
	
	
}
