package com.masai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId ;
	
	@NotNull(message = "Customer Name ")
	private String adminName ;
	
//	@Size(min = 9  , max = 10 , message = "Please Enter valid mobile no ")
//	@NotNull(message = "Mobile number is mandatory")
//	@Pattern(regexp =  "^[7-9][0-9]9$")
//	@NotEmpty(message = "Mobile number is mandatory")
	@Column(unique = true)
	private String mobileNumber;
	
	@NotNull(message = "Password is Mandatory")
	@Size(min = 8 ,max = 20)
	private String password ;
	
	@Email
	@NotNull(message = "Email is mandatory")
	private String email ;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
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

	public Admin(Integer adminId, @NotNull(message = "Customer Name ") String adminName, String mobileNumber,
			@NotNull(message = "Password is Mandatory") @Size(min = 8, max = 20) String password,
			@Email @NotNull(message = "Email is mandatory") String email) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", mobileNumber=" + mobileNumber
				+ ", password=" + password + ", email=" + email + "]";
	}
	
	
	public Admin() {
		
	}
}
