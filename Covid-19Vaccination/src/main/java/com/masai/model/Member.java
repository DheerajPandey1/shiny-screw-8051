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
import javax.validation.constraints.AssertFalse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Member {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer memberId;
	
	private Boolean dose1status;

	private Boolean dose2status;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dose1date;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dose2date;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private IdCard idCard;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private VaccineRegistration vaccineRegistration;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;
	
	private String vaccineName;
	
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "member")
	private  Appointment appointment;





	public Integer getMemberId() {
		return memberId;
	}





	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}





	public Boolean getDose1status() {
		return dose1status;
	}





	public void setDose1status(Boolean dose1status) {
		this.dose1status = dose1status;
	}





	public Boolean getDose2status() {
		return dose2status;
	}





	public void setDose2status(Boolean dose2status) {
		this.dose2status = dose2status;
	}





	public LocalDate getDose1date() {
		return dose1date;
	}





	public void setDose1date(LocalDate dose1date) {
		this.dose1date = dose1date;
	}





	public LocalDate getDose2date() {
		return dose2date;
	}





	public void setDose2date(LocalDate dose2date) {
		this.dose2date = dose2date;
	}





	public IdCard getIdCard() {
		return idCard;
	}





	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}





	public VaccineRegistration getVaccineRegistration() {
		return vaccineRegistration;
	}





	public void setVaccineRegistration(VaccineRegistration vaccineRegistration) {
		this.vaccineRegistration = vaccineRegistration;
	}





	public Vaccine getVaccine() {
		return vaccine;
	}





	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}





	public String getVaccineName() {
		return vaccineName;
	}





	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}





	public Appointment getAppointment() {
		return appointment;
	}





	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}





	public Member() {
		
	}
	
}
