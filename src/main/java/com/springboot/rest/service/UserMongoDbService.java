package com.springboot.rest.service;

import java.util.List;

import com.springboot.rest.dto.UserMongoDbContactDTO;
import com.springboot.rest.dto.UserMongoDbDTO;
import com.springboot.rest.dto.UserUpdateDTO;
import com.springboot.rest.dto.UserUpdatePatchDTO;

/**
 * @author Jay Gagnani
 * @since 2018-11-24
 */
public interface UserMongoDbService {
    public UserMongoDbDTO addUser(UserMongoDbDTO userDTO);
    public UserMongoDbDTO getUser(String id);
    public UserMongoDbDTO updateUser(UserUpdateDTO userUpdateDTO, String id);
    public UserMongoDbDTO updatePatchUser(UserUpdatePatchDTO userUpdateDTO, String id);
    public void deleteUser(String id);
    public List<UserMongoDbContactDTO> getAllUsers();
}
