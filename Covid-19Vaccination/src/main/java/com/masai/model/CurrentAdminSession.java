package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrentAdminSession {


	@Id
	@Column(unique = true)
	private Integer adminId;
	
	private String uuid;
	
	private LocalDateTime dateTime;
}
