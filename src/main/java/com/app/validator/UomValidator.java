package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;

@Component
public class UomValidator implements Validator {
	
	@Autowired
	private IUomService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Uom uom = (Uom) target;
		
		// Uom Type
		if(StringUtils.isEmpty(uom.getUomType())) {
			errors.rejectValue("uomType", null, "Please Select Any One Option");
		}
		
		// Uom Model
		if(!StringUtils.hasText(uom.getUomModel())) {
			errors.rejectValue("uomModel", null, "Please Enter Uom Model");
		}else if(service.isUomModelExist(uom.getUomModel())) {
			errors.rejectValue("uomModel", null, "Uom Already Exists");
		}
		
		// Uom Desc
		if(!StringUtils.hasText(uom.getUomDsc())) {
			errors.rejectValue("uomDsc", null, "Please Enter Description");
		}else if(uom.getUomDsc().length() <= 10 || uom.getUomDsc().length() >= 100) {
			errors.rejectValue("uomDsc", null, "Description must be 10-100 chars only");
		}
		
	}

}
