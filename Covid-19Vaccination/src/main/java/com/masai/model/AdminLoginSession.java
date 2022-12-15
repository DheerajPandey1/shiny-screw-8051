package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class AdminLoginSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminLoginId ;
	
	@NotNull(message = "Please Enter admin Id")
	private Integer adminId ;
	
	@Column(unique = true)
	private String uuid ;
	
	private LocalDateTime dateTime ;

	public Integer getAdminLoginId() {
		return adminLoginId;
	}

	public void setAdminLoginId(Integer adminLoginId) {
		this.adminLoginId = adminLoginId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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

	public AdminLoginSession(Integer adminLoginId, @NotNull(message = "Please Enter admin Id") Integer adminId,
			String uuid, LocalDateTime dateTime) {
		super();
		this.adminLoginId = adminLoginId;
		this.adminId = adminId;
		this.uuid = uuid;
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "AdminLoginSession [adminLoginId=" + adminLoginId + ", adminId=" + adminId + ", uuid=" + uuid
				+ ", dateTime=" + dateTime + "]";
	}
	public AdminLoginSession() {
		
	}
	
}
