package com.DisneyResort.Disney.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
@RestController
public class Exceptionhandlers extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Fieldexceptions.class)
  public final ResponseEntity<Object> handleAllExceptions(Fieldexceptions ex, WebRequest request,HttpStatus status) 
  {
	  
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false),ex.getLocalizedMessage(),HttpStatus.CONFLICT,HttpStatus.CONFLICT.value());
    return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
  }

 @ExceptionHandler(GuesttNotFoundException.class)
  public final ResponseEntity<Object> handleUserNotFoundException(GuesttNotFoundException ex, WebRequest request,HttpStatus status)
 {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
            request.getDescription(false),ex.getLocalizedMessage(),HttpStatus.CONFLICT,HttpStatus.CONFLICT.value());
    return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
  }

 @Override
 @ExceptionHandler(Exception.class)
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
        ex.getBindingResult().toString(),ex.getLocalizedMessage(),HttpStatus.CONFLICT,HttpStatus.CONFLICT.value());
    return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
  }
}