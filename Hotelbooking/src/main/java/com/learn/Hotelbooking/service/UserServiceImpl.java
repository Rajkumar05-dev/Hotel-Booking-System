package com.learn.Hotelbooking.service;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.Hotelbooking.Dto.UserDto;
import com.learn.Hotelbooking.Entities.AppRole;
import com.learn.Hotelbooking.Entities.Role;
import com.learn.Hotelbooking.Entities.User;
import com.learn.Hotelbooking.repository.RoleRepository;
import com.learn.Hotelbooking.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    
	


	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepository userRepository;
 	@Autowired
	private PasswordEncoder passwordEncoder;
    @Autowired
 	private RoleRepository roleRepository;

    
 
	
	@Override
	public UserDto createUser(UserDto userDto) {

	System.out.println(userDto);
		User user = modelMapper.map(userDto, User.class);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleRepository.findByRoleName(AppRole.ROLE_USER)
	    .orElseThrow(()->new RuntimeException("Role Not Found"));
		user.setRole(role);
		User savedUser=userRepository.save(user);
		UserDto savedDto=modelMapper.map(savedUser,UserDto .class);
		return savedDto ;
	}

		
	
}