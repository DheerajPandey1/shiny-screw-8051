package com.masai.model;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AdminDTO {

	
	@Size(min = 9  , max = 10 , message = "Please Enter valid mobile no ")
	@NotNull(message = "Mobile number is mandatory")
	@Pattern(regexp =  "^[7-9][0-9]9$")
	@NotEmpty(message = "Mobile number is mandatory")
	@Column(unique = true)
	private String mobileNumber;
	
	@NotNull(message = "Password is Mandatory")
	@Size(min = 8 ,max = 20)
	private String password ;

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

	public AdminDTO(
			@Size(min = 9, max = 10, message = "Please Enter valid mobile no ") @NotNull(message = "Mobile number is mandatory") @Pattern(regexp = "^[7-9][0-9]9$") @NotEmpty(message = "Mobile number is mandatory") String mobileNumber,
			@NotNull(message = "Password is Mandatory") @Size(min = 8, max = 20) String password) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminDTO [mobileNumber=" + mobileNumber + ", password=" + password + "]";
	}
	
	public AdminDTO() {
		
	}
	
}
