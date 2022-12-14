package com.masai.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Appointment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	
	@Size(min = 9  , max = 10 , message = "Please Enter valid mobile no ")
	@NotNull(message = "Mobile number is mandatory")
	@Pattern(regexp =  "^[7-9][0-9]9$")
	@NotEmpty(message = "Mobile number is mandatory")
	@Column(unique = true)
	private String mobileNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dateofBooking;
	
	private Slot slot;
	private Boolean bookingStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Member member;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccinationCenter vaccinationCenter;
}
