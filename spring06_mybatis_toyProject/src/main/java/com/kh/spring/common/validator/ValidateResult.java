package com.kh.spring.common.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class ValidateResult {

	private Map<String,Object> error; 
	
	public ValidateResult() {
		error = new HashMap<String, Object>();
	}
	
	public void addErrors(Errors erros) {
		
		for (FieldError fieldError : erros.getFieldErrors()) {
			error.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		
	}

	public Map<String, Object> getError() {
		return error;
	}
	
	
	
}
