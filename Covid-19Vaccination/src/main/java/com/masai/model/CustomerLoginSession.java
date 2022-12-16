package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CustomerLoginSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerLoginId ;
	
	@NotNull(message = "Please Enter Customer Id")
	private Integer customerId ;
	
	@Column(unique = true)
	private String uuid ;
	
	private LocalDateTime dateTime ;

	public Integer getCustomerLoginId() {
		return customerLoginId;
	}

	public void setCustomerLoginId(Integer customerLoginId) {
		this.customerLoginId = customerLoginId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public CustomerLoginSession(Integer customerLoginId,
			@NotNull(message = "Please Enter Customer Id") Integer customerId, String uuid, LocalDateTime dateTime) {
		super();
		this.customerLoginId = customerLoginId;
		this.customerId = customerId;
		this.uuid = uuid;
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "CustomerLoginSession [customerLoginId=" + customerLoginId + ", customerId=" + customerId + ", uuid="
				+ uuid + ", dateTime=" + dateTime + "]";
	}
	
	public CustomerLoginSession() {
		
	}
	
}
