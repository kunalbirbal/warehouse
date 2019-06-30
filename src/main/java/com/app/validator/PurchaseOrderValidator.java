package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.PurchaseOrder;

@Component
public class PurchaseOrderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PurchaseOrder purchaseOrder = (PurchaseOrder)target;
		
		// for order code
		if(!StringUtils.hasText(purchaseOrder.getOrderCode())) {
			errors.rejectValue("orderCode", null, "Please Enter Order Code");
		}else if(!Pattern.matches("[A-Z]{4,6}", purchaseOrder.getOrderCode())) {
			errors.rejectValue("orderCode", null, "Char should be 4-6 Uppercase Only");
		}
		
		
		// for Reference No.
		if(!StringUtils.hasText(purchaseOrder.getRefNum())) {
			errors.rejectValue("refNum", null, "Please Enter Order Code");
		}else if(!Pattern.matches("[A-Z]{8,12}", purchaseOrder.getRefNum())) {
			errors.rejectValue("refNum", null, "Char should be 8-12 Uppercase Only");
		}
		
		// quality Check
		if(StringUtils.isEmpty(purchaseOrder.getQualityCheck())) {
			errors.rejectValue("qualityCheck", null, "Please Select Any One Option");
		}
		
		// order Desc
		if(!StringUtils.hasText(purchaseOrder.getOrderDesc())) {
			errors.rejectValue("orderDesc", null, "Please Enter Description");
		}else if(purchaseOrder.getOrderDesc().length() <= 10 || purchaseOrder.getOrderDesc().length() >= 100) {
			errors.rejectValue("orderDesc", null, "Description must be 10-100 chars only");
		}
		
	}

}
