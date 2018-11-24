package com.springboot.rest.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.mongodb.User;
import com.springboot.model.mongodb.repositories.UserMongoDbRepository;
import com.springboot.rest.dto.UserMongoDbContactDTO;
import com.springboot.rest.dto.UserMongoDbDTO;
import com.springboot.rest.dto.UserUpdateDTO;
import com.springboot.rest.dto.UserUpdatePatchDTO;
import com.springboot.rest.exception.EntityNotFoundException;
import com.springboot.rest.service.UserMongoDbService;

/**
 * @author Jay Gagnani
 * @since 2018-11-24
 */
@Service
public class UserMongoDbServiceImpl implements UserMongoDbService {

    @Autowired
    private UserMongoDbRepository userMongoDbRepository;

    @Override
    public UserMongoDbDTO addUser(UserMongoDbDTO userDTO) {
        /**
         * We are manually creating {@link User} object however there is mapper
         * available to convert to-from {@link UserDTO}.
         */
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhonenumber(userDTO.getPhonenumber());
        userMongoDbRepository.save(user);

        /* set generated user id to response object */
        userDTO.setId(user.getId());
        userDTO.setPhonenumberd(user.getPhonenumber());
        return userDTO;
    }

    @Override
    public UserMongoDbDTO getUser(String id) {
        User user = userMongoDbRepository.findOne(id);
        if (Objects.isNull(user)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new EntityNotFoundException(User.class, id);
        }
        return new UserMongoDbDTO().build(user);
    }

    @Override
    public UserMongoDbDTO updateUser(UserUpdateDTO userUpdateDTO, String id) {
        User user = userMongoDbRepository.findOne(id);
        if (Objects.isNull(user)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new EntityNotFoundException(User.class, id);
        }
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        user.setEmail(userUpdateDTO.getEmail());
        user.setPhonenumber(userUpdateDTO.getPhonenumber());
        userMongoDbRepository.save(user);
        return new UserMongoDbDTO().build(user);
    }

    @Override
    public void deleteUser(String id) {
        userMongoDbRepository.delete(id);
    }

	@Override
	public UserMongoDbDTO updatePatchUser(UserUpdatePatchDTO userUpdateDTO,
			String id) {
		// TODO Auto-generated method stub
		 User user = userMongoDbRepository.findOne(id);
	        if (Objects.isNull(user)) {
	            /* handle this exception using {@link RestExceptionHandler} */
	            throw new EntityNotFoundException(User.class, id);
	        }
	        user.setEmail(userUpdateDTO.getEmail());
	        user.setPhonenumber(userUpdateDTO.getPhonenumber());
	        userMongoDbRepository.save(user);
	        return new UserMongoDbDTO().build(user);
	}

	@Override
	public List<UserMongoDbContactDTO> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userMongoDbRepository.findAll();
	        if (Objects.isNull(users)) {
	            /* handle this exception using {@link RestExceptionHandler} */
	            throw new EntityNotFoundException(User.class,users);
	        }
	        return new UserMongoDbContactDTO().buildAll(users);
	}
}
