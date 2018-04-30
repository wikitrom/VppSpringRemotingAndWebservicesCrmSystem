package com.virtualpairprogrammers.restcontrollers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.virtualpairprogrammers.domain.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// check clazz is the Customer class
		return clazz.equals(Customer.class);
	}

	@Override
	public void validate(Object object, Errors e) {

		ValidationUtils.rejectIfEmptyOrWhitespace(e, "companyName", "required dummy value");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "notes", "required dummy value");
	}

}
