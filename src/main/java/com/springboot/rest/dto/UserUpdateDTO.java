package com.springboot.rest.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jay Gagnani
 * @since 2018-11-24
 */
public class UserUpdateDTO {
	@NotEmpty(message = "first_name can not be empty")
	@JsonProperty("first_name")
	private String firstName;
	
	@NotEmpty(message = "last_name can not be empty")
	@JsonProperty("last_name")
	private String lastName;
	
	@Field("email")
	@NotEmpty(message = "email can not be empty.")
	@Size(max = 100, message = "email can not be more than 100 characters.")
	private String email;

	@Field("phonenumber")
	@NotEmpty(message = "phonenumber can not be empty.")
	@Size(max = 12, message = "phonenumber can not be more than 12 characters.")
	private String phonenumber;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
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
