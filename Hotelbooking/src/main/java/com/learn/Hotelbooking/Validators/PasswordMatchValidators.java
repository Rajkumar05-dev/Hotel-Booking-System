package com.learn.Hotelbooking.Validators;

import com.learn.Hotelbooking.Dto.UserDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidators implements ConstraintValidator<PasswordMatch, UserDto> {

	@Override
	public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return userDto.getPassword().equals(userDto.getConfirmPassword());
	}

}
