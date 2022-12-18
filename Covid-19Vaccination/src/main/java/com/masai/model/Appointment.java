package com.masai.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Appointment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	
//	@Size(min = 9  , max = 10 , message = "Please Enter valid mobile no ")
//	@NotNull(message = "Mobile number is mandatory")
//	@Pattern(regexp =  "^[7-9][0-9]9$")
	@NotEmpty(message = "Mobile number is mandatory")
	@Column(unique = true)
	private String mobileNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dateofBooking;
	
	@Enumerated(EnumType.STRING)
	private Slot slot;
	
	private Boolean bookingStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Member member;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccinationCenter vaccinationCenter;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getDateofBooking() {
		return dateofBooking;
	}

	public void setDateofBooking(LocalDate dateofBooking) {
		this.dateofBooking = dateofBooking;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Boolean getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public VaccinationCenter getVaccinationCenter() {
		return vaccinationCenter;
	}

	public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

	public Appointment(Long bookingId,
		 @NotNull(message = "Mobile number is mandatory")  @NotEmpty(message = "Mobile number is mandatory") String mobileNumber,
			LocalDate dateofBooking, Slot slot, Boolean bookingStatus, Member member,
			VaccinationCenter vaccinationCenter) {
		super();
		this.bookingId = bookingId;
		this.mobileNumber = mobileNumber;
		this.dateofBooking = dateofBooking;
		this.slot = slot;
		this.bookingStatus = bookingStatus;
		this.member = member;
		this.vaccinationCenter = vaccinationCenter;
	}

	@Override
	public String toString() {
		return "Appointment [bookingId=" + bookingId + ", mobileNumber=" + mobileNumber + ", dateofBooking="
				+ dateofBooking + ", slot=" + slot + ", bookingStatus=" + bookingStatus + ", member=" + member
				+ ", vaccinationCenter=" + vaccinationCenter + "]";
	}
	
	public Appointment() {
		
	}
}
