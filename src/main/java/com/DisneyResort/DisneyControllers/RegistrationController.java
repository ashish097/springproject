package com.DisneyResort.DisneyControllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.UriComponentsBuilder;
import com.DisneyResort.Disney.DiningReservation;
import com.DisneyResort.Disney.GuestProfile;
import com.DisneyResort.Disney.ResortReservation;
import com.DisneyResort.Disney.DisneyService.IDsineyService;
import com.DisneyResort.Disney.exception.Fieldexceptions;
import com.DisneyResort.Disney.exception.GuesttNotFoundException;


@RestController
public class RegistrationController {

	
	@Autowired
	private IDsineyService disneyService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
	
	//registration
	@PostMapping("/user")
	@ResponseBody
	public ResponseEntity<GuestProfile> addmember( @Valid @RequestBody GuestProfile user, 
			BindingResult result,UriComponentsBuilder builder,Exception ex, WebRequest request,HttpStatus status
			)
	{
		if(LOGGER.isErrorEnabled())
		{
			LOGGER.error("Errors Enabled"+user);
		}
		if(result.hasFieldErrors() || result.hasErrors())
		{
	    	throw new Fieldexceptions("Guest with this email"+ user.getEmail());
	    	
        }
		GuestProfile userss =disneyService.addMember(user);
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.add("Statusmsg", "Created");
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getGuest_id()).toUri());
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        return new ResponseEntity<GuestProfile>(userss,headers,HttpStatus.CREATED);
     
	}
	
	
	
	
	
	//resortregistration
	@PostMapping("/user/resort/")
	public ResponseEntity<Object> addmemberresort(@Valid  @RequestBody ResortReservation user, @RequestParam("CustomerId") int CustomerId, @RequestParam("password") String password,
			 UriComponentsBuilder builder,BindingResult result) throws Exception 
	{		
		if(LOGGER.isErrorEnabled())
		{
			LOGGER.error("Errors Enabled"+user);
		}
		
		boolean flguser = disneyService.validate(CustomerId,password);
		
		if(flguser)
		{
			if(result.hasFieldErrors() || result.hasErrors())
	        {
	        	throw new Exception();
	        }
			
			ResortReservation resorts= disneyService.addresort(user,CustomerId);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Status", "Created");
	        headers.setLocation(builder.path("/user/resort/{id}").buildAndExpand(user.getGuest_id_fk()).toUri());
	        
	        
	        return new ResponseEntity<Object>(resorts,headers, HttpStatus.CREATED);
		}		
		else
        {
			throw new GuesttNotFoundException("Guest with this Id not found"+ CustomerId);     	
        }
	}
	
	
	
	//diningregistration
	@PostMapping("/user/dining/")
	public ResponseEntity<Object> addmemberresort(@Valid @RequestBody DiningReservation user, @RequestParam("CustomerId") int CustomerId, @RequestParam("password") String password,
			 UriComponentsBuilder builder,BindingResult result) throws Exception 
	{
		
		boolean flguser = disneyService.validate(CustomerId,password);
		if(LOGGER.isErrorEnabled())
		{
			LOGGER.error("Errors Enabled"+user);
		}
		if(flguser)
		{
			if(result.hasFieldErrors())
	        {
				throw new Exception();
	        }
			
			DiningReservation dinnings=disneyService.addDining(user,CustomerId);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Responded", "Created");
	        headers.setLocation(builder.path("/user/dining/{id}").buildAndExpand(user.getGuestid_fk()).toUri());
	        
	        
	        return new ResponseEntity<Object>(dinnings,headers, HttpStatus.CREATED);
		}  
		else
        {
			throw new GuesttNotFoundException("Guest with this Id not found"+ CustomerId);  
        }
        
	}
	
	
} 