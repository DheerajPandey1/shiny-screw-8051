package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VaccinationCenter{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer centerId;
	@NotNull(message = "Center name can not be null")
	@NotBlank(message = "Center name is Mandatory")
	private String centername;

	@NotNull(message = "City can not be null")
	@NotBlank(message = "City name is Mandatory")
	private String city;

	@NotNull(message = "Address can not be null")
	@NotBlank(message = "Address is Mandatory")
	private String address;

	@NotNull(message = "State can not be null")
	@NotBlank(message = "State name is Mandatory")
	private String state;

	@NotNull(message = "Pincode can not be null")
	@NotBlank(message = "Pincode is Mandatory")
	@Size(min = 6, max = 8)
	private String pincode;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Admin admin;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Inventory inventory;

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

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public VaccinationCenter(Integer centerId,
			@NotNull(message = "Center name can not be null") @NotBlank(message = "Center name is Mandatory") String centername,
			@NotNull(message = "City can not be null") @NotBlank(message = "City name is Mandatory") String city,
			@NotNull(message = "Address can not be null") @NotBlank(message = "Address is Mandatory") String address,
			@NotNull(message = "State can not be null") @NotBlank(message = "State name is Mandatory") String state,
			@NotNull(message = "Pincode can not be null") @NotBlank(message = "Pincode is Mandatory") @Size(min = 6, max = 8) String pincode,
			Inventory inventory) {
		super();
		this.centerId = centerId;
		this.centername = centername;
		this.city = city;
		this.address = address;
		this.state = state;
		this.pincode = pincode;
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "VaccinationCenter [centerId=" + centerId + ", centername=" + centername + ", city=" + city
				+ ", address=" + address + ", state=" + state + ", pincode=" + pincode + ", inventory=" + inventory
				+ "]";
	}
	
	public VaccinationCenter() {
		
	}
}
