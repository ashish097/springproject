package com.DisneyResort.Disney.validtion;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ValidationErrorBuilder {
	
	 public static ValidationError fromBindingErrors(Errors errors) 
	 {
	        ValidationError error = new ValidationError("Validation failed. " + errors.getErrorCount() + " error(s)");
	        for (ObjectError objectError : errors.getAllErrors()) {
	            error.addValidationError(objectError.getDefaultMessage());
	            error.addValidationError(objectError.getCode());
	        }
	        return error;
	 }
}

