package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;

@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		// Convert to model class object
		Item itm = (Item) target;
		
		// For Item Code
		if(!StringUtils.hasText(itm.getItemCode())) {
			errors.rejectValue("itemCode", null, "Please Enter Code");
		}else if(!Pattern.matches("[A-Z]{4,6}", itm.getItemCode())) {
			errors.rejectValue("itemCode", null, "Code must me 4-6 Upper Case Only");
		}
		
		// for Item Length		
		String d= String.valueOf(itm.getItemLength());
		if(d == null || itm.getItemLength() <= 0) {
			errors.rejectValue("itemLength", null, "Please Enter Valid Length");
		}
		// for Item Width
		if(itm.getItemWidht() <= 0) {
			errors.rejectValue("itemWidht", null, "Please Enter Valid Length");
		}
		// for Item Height
		if(itm.getItemHeight() <= 0) {
			errors.rejectValue("itemHeight", null, "Please Enter Valid Length");
		}
		// for Item Base Cost
		if(itm.getBaseCost() <= 0) {
			errors.rejectValue("baseCost", null, "Please Enter Valid Base Cost");
		}
		// for Item Currency
		if(StringUtils.isEmpty(itm.getBaseCurr())) {
			errors.rejectValue("baseCurr", null, "Please Select any one option");
		}
		// for Item Description
		if(!StringUtils.hasText(itm.getItemDsc())) {
			errors.rejectValue("itemDsc", null, "Please Enter Description");
		}else if(itm.getItemDsc().length() <= 10 || itm.getItemDsc().length() >= 100) {
			errors.rejectValue("itemDsc", null, "Description must be 10-100 chars only");
		}
		
		// for Uom
		if(itm.getUom() == null || itm.getUom().getUomId() == null || itm.getUom().getUomId() <= 0) {
			errors.rejectValue("uom", null, "Please Select Atleast One Uom");
		}
		
		// for Order Method
		if(itm.getOrderMethod() == null || itm.getOrderMethod().getOid() == null || itm.getOrderMethod().getOid() <= 0 ) {
			errors.rejectValue("orderMethod", null, "Please Select Atleast One Order Method");
		}
		
	}

}
