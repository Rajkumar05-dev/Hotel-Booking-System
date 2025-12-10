package com.learn.Hotelbooking.Dto;

import com.learn.Hotelbooking.Validators.PasswordMatch;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatch
public class UserDto {
	 
	private String id;
	
	
	@NotNull(message="Name cannot be Null")
	@NotBlank(message="Name cannot be blank")
	@Size(min=2,max=40)
	private String name;
    @NotNull(message="password cannot be Null")
    @NotBlank(message="password cannot be blank")
    @Pattern(regexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])\\S{6,}$")
	private String password;
	 private String confirmPassword;
	 
	 @NotNull(message=" email cannot be Null")
	    @NotBlank(message="email cannot be blank")
	private String email;
	
}
