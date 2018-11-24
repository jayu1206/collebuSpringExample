package com.springboot.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.dto.UserMongoDbContactDTO;
import com.springboot.rest.dto.UserMongoDbDTO;
import com.springboot.rest.dto.UserUpdateDTO;
import com.springboot.rest.dto.UserUpdatePatchDTO;
import com.springboot.rest.response.SuccessResponse;
import com.springboot.rest.service.UserMongoDbService;
import com.springboot.sqs.MessageService;

/**
 * @author Jay Gagnani
 * @since 2018-11-24
 */
@RestController
@RequestMapping("/api/user/mongodb")
public class UserMongoDbController {

    @Autowired
    private UserMongoDbService userMongoDbService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserMongoDbController.class);

    @PostMapping
    public ResponseEntity<UserMongoDbDTO> addUser(@Valid @RequestBody UserMongoDbDTO userDTO) {
    	LOGGER.info("Addin user process for "+userDTO.getFirstName());
        return ResponseEntity.ok(userMongoDbService.addUser(userDTO));
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public ResponseEntity<List<UserMongoDbContactDTO>> getAllUser() {
    	LOGGER.info("get all user's contacts only ");
        return ResponseEntity.ok(userMongoDbService.getAllUsers());
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserMongoDbDTO> getUser(@RequestParam String id) {
    	LOGGER.info("get user details only base on id : "+id);
        return ResponseEntity.ok(userMongoDbService.getUser(id));
    }
    
    

    @PutMapping
    public ResponseEntity<UserMongoDbDTO> updateUser(@Valid @RequestBody UserUpdateDTO userUpdateDTO, @RequestParam String id) {
    	LOGGER.info("update user with put method for : "+userUpdateDTO.getFirstName());
    	try{
    		MessageService messageService = new MessageService();
        	messageService.sendMessage("hiiii");
    	}catch(Exception e){
    		System.out.println("SQS failed....");
    	}
    	
        return ResponseEntity.ok(userMongoDbService.updateUser(userUpdateDTO, id));
    }
    
    @PatchMapping
    public ResponseEntity<UserMongoDbDTO> updatePatchUser(@Valid @RequestBody UserUpdatePatchDTO userUpdateDTO, @RequestParam String id) {
    	LOGGER.info("update user with patch method for phone number : "+userUpdateDTO.getPhonenumber());
    	return ResponseEntity.ok(userMongoDbService.updatePatchUser(userUpdateDTO, id));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestParam String id) {
    	LOGGER.info("delete user id : "+id);
        userMongoDbService.deleteUser(id);
        return ResponseEntity.ok(new SuccessResponse("deleted"));
    }
}
