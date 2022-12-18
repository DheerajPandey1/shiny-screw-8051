package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId ;
	
	@NotNull(message = "Customer Name is mandatory ")
	private String customerName ;
	
	

	private String mobileNumber;
	
	@NotNull(message = "Password is Mandatory")
	@Size(min = 8 ,max = 20)
	private String password ;
	
	@Email
	@NotNull(message = "Email is mandatory")
	private String email ;
	
	@OneToOne(cascade=CascadeType.ALL )
	@JsonIgnore
	private IdCard idcard;
	
	

	public IdCard getIdcard() {
		return idcard;
	}

	public void setIdcard(IdCard idcard) {
		this.idcard = idcard;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer(Integer customerId, @NotNull(message = "Customer Name is mandatory ") String customerName,
			String mobileNumber, @NotNull(message = "Password is Mandatory") @Size(min = 8, max = 20) String password,
			@Email @NotNull(message = "Email is mandatory") String email) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobileNumber="
				+ mobileNumber + ", password=" + password + ", email=" + email + "]";
	}
	
	public Customer() {
		
	}
}
