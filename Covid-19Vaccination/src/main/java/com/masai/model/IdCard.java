package com.masai.model;

import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class IdCard {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	

	@NotNull(message = "Id name can not be Null.Please Add Proper Name")
	@NotBlank(message = "Id name can not be Blank.Name is Mandotory")
	private String name;
	
	@NotNull(message = "Id Gender can not be Null.Please Add Proper Gender")
//	@Pattern(regexp = "^[A-Z][a-z]*")
	private String gender;
	
	@NotNull(message = "Id Address can not be Null.Please Add Proper Address")
	private String address;
	
	@NotNull(message = "Id city can not be Null.Please Add Proper city")
	private String city;
	
	@NotNull(message = "Id state can not be Null.Please Add Proper state")
	private String state;
	
	@NotNull(message = "Id pincode can not be Null.Please Add Proper pincode")
	@Size(min = 6, max = 6)
	private String pinCode;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dob;
	
	@Embedded
	private PanCard panCard;
	
	@Embedded
	private AdharCard adharCard;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Member member;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public PanCard getPanCard() {
		return panCard;
	}


	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
	}


	public AdharCard getAdharCard() {
		return adharCard;
	}


	public void setAdharCard(AdharCard adharCard) {
		this.adharCard = adharCard;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public IdCard(Integer id,
			@NotNull(message = "Id name can not be Null.Please Add Proper Name") @NotBlank(message = "Id name can not be Blank.Name is Mandotory") String name,
			@NotNull(message = "Id Gender can not be Null.Please Add Proper Gender")  String gender,
			@NotNull(message = "Id Address can not be Null.Please Add Proper Address") String address,
			@NotNull(message = "Id city can not be Null.Please Add Proper city") String city,
			@NotNull(message = "Id state can not be Null.Please Add Proper state") String state,
			@NotNull(message = "Id pincode can not be Null.Please Add Proper pincode") @Size(min = 6, max = 6) String pinCode,
			LocalDate dob, PanCard panCard, AdharCard adharCard, Member member) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.dob = dob;
		this.panCard = panCard;
		this.adharCard = adharCard;
		this.member = member;
	}


	@Override
	public String toString() {
		return "IdCard [id=" + id + ", name=" + name + ", gender=" + gender + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", pinCode=" + pinCode + ", dob=" + dob + ", panCard=" + panCard + ", adharCard="
				+ adharCard + ", member=" + member + "]";
	}
	
	public IdCard() {
		
	}

	
}
