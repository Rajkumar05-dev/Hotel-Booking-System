package com.learn.Hotelbooking.security;

import com.learn.Hotelbooking.Dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginResponse {

	
	private String token;
	private UserDto userDto;
}
