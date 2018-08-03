package com.DisneyResort.Disney.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Fieldexceptions extends RuntimeException {
	
	 public Fieldexceptions(String exception) {
		    super(exception);
		  }
	 
}
