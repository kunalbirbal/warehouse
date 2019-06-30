package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;

@Component
public class OrderMethodValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		OrderMethod orderMethod  = (OrderMethod) target;
		
	}

}
