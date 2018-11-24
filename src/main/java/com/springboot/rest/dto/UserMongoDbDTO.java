package com.springboot.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.model.mongodb.User;

/**
 * @author Jay Gagnani
 * @since 2018-11-24
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class UserMongoDbDTO {

    /* used to send database id */
    private String id;

    @NotEmpty(message = "first_name can not be empty")
    @JsonProperty("first_name")
    private String firstName;

    @NotEmpty(message = "last_name can not be empty")
    @JsonProperty("last_name")
    private String lastName;

    @Email
    @JsonProperty("email")
    private String email;

    @NotEmpty(message = "phonenumber can not be empty")
    @Size(min = 10, message = "phonenumber must be at least 10 digit")
    @JsonProperty("phonenumber")
    private String phonenumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public void setPhonenumberd(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
    /**
     * We are manually creating {@link UserMongoDbDTO} object however there is
     * mapper available to convert to-from {@link User}.
     *
     * @param user
     * @return
     */
    public UserMongoDbDTO build(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phonenumber=user.getPhonenumber();
        return this;
    }
    
    public List<String> buildAll(List<User> users) {  
    	List<String> contactList = new ArrayList<String>();
    	for(User user : users){
    		contactList.add(user.getPhonenumber());
    	}
   	
        return contactList;
    }
}