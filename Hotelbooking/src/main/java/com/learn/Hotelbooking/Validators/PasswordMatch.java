package com.learn.Hotelbooking.Validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordMatchValidators.class) 

public @interface PasswordMatch {

	String message() default "Password and confirm password a is not same";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
