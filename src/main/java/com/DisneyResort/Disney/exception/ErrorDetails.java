package com.DisneyResort.Disney.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ErrorDetails {
	
  private Date timestamp;
  private String message;
  private String details;
  private String debugMessage;
  private HttpStatus status;
  private int statuscode;
  
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> subErrors= new ArrayList<>();

		public ErrorDetails(Date timestamp, String message, String details, String debugMessage, HttpStatus status
				,int statuscode) 
		{
			super();
			this.timestamp = timestamp;
			this.message = message;
			this.details = details;
			this.debugMessage = debugMessage;
			this.status = status;
			this.statuscode=statuscode;
		}
		
		public int getStatuscode() {
			return statuscode;
		}

		public void setStatuscode(int statuscode) {
			this.statuscode = statuscode;
		}

		public ErrorDetails(String errorMessage) {
		    this.message = errorMessage;
		}
		
		public void addValidationError(String error) {
			subErrors.add(error);
		}
		
		
		public void setSubErrors(List<String> subErrors) {
			this.subErrors = subErrors;
		}

		public Date getTimestamp() {
			return timestamp;
		}
		
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
		
		public String getMessage() {
			return message;
		}
		
		public void setMessage(String message) {
			this.message = message;
		}
		
		public String getDetails() {
			return details;
		}
		
		public void setDetails(String details) {
			this.details = details;
		}
		
		public String getDebugMessage() {
			return debugMessage;
		}
		
		public void setDebugMessage(String debugMessage) {
			this.debugMessage = debugMessage;
		}
		
		public HttpStatus getStatus() {
			return status;
		}
		
		public void setStatus(HttpStatus status) {
			this.status = status;
		}
		
		public List<String> getSubErrors() {
			return subErrors;
		}

}