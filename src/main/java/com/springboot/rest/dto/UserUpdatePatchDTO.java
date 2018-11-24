package com.springboot.rest.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Field;

public class UserUpdatePatchDTO {
	
	@Field("email")
	@NotEmpty(message = "email can not be empty.")
	@Size(max = 100, message = "email can not be more than 100 characters.")
	private String email;

	@Field("phonenumber")
	@NotEmpty(message = "phonenumber can not be empty.")
	@Size(max = 12, message = "phonenumber can not be more than 12 characters.")
	private String phonenumber;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	

}
