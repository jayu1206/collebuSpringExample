package com.springboot.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.model.mongodb.User;

public class UserMongoDbContactDTO {
	 
    private String id;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "phonenumber can not be empty")
	    @Size(min = 10, message = "phonenumber must be at least 10 digit")
	    @JsonProperty("phonenumber")
	    private String phonenumber;
	 
	 	public String getPhonenumber() {
			return phonenumber;
		}

		public void setPhonenumberd(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		
		 public List<UserMongoDbContactDTO> buildAll(List<User> users) {  
		    	List<UserMongoDbContactDTO> contactList = new ArrayList<UserMongoDbContactDTO>();
		    	for(User user : users){
		    		UserMongoDbContactDTO dto= new UserMongoDbContactDTO();
		    		dto.setId(user.getId());
		    		dto.setPhonenumberd(user.getPhonenumber());		    		
		    		contactList.add(dto);
		    	}		    	
		        return contactList;
		    }
		
		

}
