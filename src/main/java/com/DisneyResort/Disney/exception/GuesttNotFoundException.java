package com.DisneyResort.Disney.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GuesttNotFoundException extends RuntimeException 
{

    public GuesttNotFoundException(String exception) {
    super(exception);
  }


}
