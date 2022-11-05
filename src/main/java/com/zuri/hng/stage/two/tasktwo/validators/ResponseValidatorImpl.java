package com.zuri.hng.stage.two.tasktwo.validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ResponseValidatorImpl implements ConstraintValidator<ResponseValidator, String>{
	 private List<String> acceptedValues = new ArrayList<String>();

	    @Override
	    public void initialize(ResponseValidator annotation) {
	        for (Enum<?> enumValue : annotation.enumClass().getEnumConstants()) {
	            acceptedValues.add(enumValue.toString());
	        }
	    }

	    @Override
	    public boolean isValid(String value, ConstraintValidatorContext context) {
	        if (value == null) {
	            return false;
	        }
	        return acceptedValues.contains(value.toString());
	    }

}
