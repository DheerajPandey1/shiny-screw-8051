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

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCentername() {
		return centername;
	}

	public void setCentername(String centername) {
		this.centername = centername;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public VaccineInventory getVaccineinventory() {
		return vaccineinventory;
	}

	public void setVaccineinventory(VaccineInventory vaccineinventory) {
		this.vaccineinventory = vaccineinventory;
	}

	public VaccinationCenter(Integer centerId, @NotNull(message = "Center name can not be null") String centername,
			@NotNull(message = "City can not be null") String city,
			@NotNull(message = "Address can not be null") String address,
			@NotNull(message = "State can not be null") String state,
			@NotNull(message = "Pincode can not be null") @Size(min = 6, max = 8) String pincode,
			VaccineInventory vaccineinventory) {
<<<<<<< HEAD
		super();
=======
>>>>>>> 1f53cfbfb11b156cb4c7c84f6dc51476e1b5adfa
		this.centerId = centerId;
		this.centername = centername;
		this.city = city;
		this.address = address;
		this.state = state;
		this.pincode = pincode;
		this.vaccineinventory = vaccineinventory;
	}

<<<<<<< HEAD
=======
	public VaccinationCenter() {
		// TODO Auto-generated constructor stub
	}

>>>>>>> 1f53cfbfb11b156cb4c7c84f6dc51476e1b5adfa
	@Override
	public String toString() {
		return "VaccinationCenter [centerId=" + centerId + ", centername=" + centername + ", city=" + city
				+ ", address=" + address + ", state=" + state + ", pincode=" + pincode + ", vaccineinventory="
				+ vaccineinventory + "]";
	}
	
<<<<<<< HEAD
	public VaccinationCenter() {
		
	}
=======
	
>>>>>>> 1f53cfbfb11b156cb4c7c84f6dc51476e1b5adfa
}
