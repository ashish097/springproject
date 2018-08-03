package com.DisneyResort.DisneyControllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.DisneyResort.Disney.DiningReservation;
import com.DisneyResort.Disney.GuestProfile;
import com.DisneyResort.Disney.ResortReservation;
import com.DisneyResort.Disney.DisneyService.IDsineyService;


@RestController
public class DisneyUpControll {

	private static final Logger LOGGER = LoggerFactory.getLogger(DisneyUpControll.class);
	
	@Autowired
	private IDsineyService disneyService;
	 
	//updatinguserdetails
	@PutMapping("/user/{id}")
	public ResponseEntity<Object> Userdetail( @RequestBody GuestProfile user, @PathVariable int id,UriComponentsBuilder builder)
	{
		if(LOGGER.isErrorEnabled())
		{
			LOGGER.error("Errors Enabled"+user);
		}
		disneyService.updateuser(user,id);
		
		HttpHeaders headers = new HttpHeaders();
		
        headers.add("Responded", "Success");
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getGuest_id()).toUri());
        headers.setContentType(MediaType.APPLICATION_JSON);
       
        return new ResponseEntity<Object>(user,headers,HttpStatus.ACCEPTED);
	}
	
	//updateingresort
	@PutMapping("/resort/{id}")
	public ResponseEntity<Object> resortdetail( @RequestBody ResortReservation user,@PathVariable int id,UriComponentsBuilder builder)
	{
		if(LOGGER.isErrorEnabled())
		{
			LOGGER.error("Errors Enabled"+user);
		}
		disneyService.updateresort(user,id);
		
		HttpHeaders headers = new HttpHeaders();
		
        headers.add("Responded", "Success");
        headers.setLocation(builder.path("/user/resort/{id}").buildAndExpand(user.getGuest_id_fk()).toUri());
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        return new ResponseEntity<Object>(user,headers,HttpStatus.ACCEPTED);
	}
	
	//updatingdinign
	@PutMapping("/dining/{id}")
	public ResponseEntity<Object> diningdetail( @RequestBody DiningReservation user, @PathVariable int id,UriComponentsBuilder builder)
	{
		if(LOGGER.isErrorEnabled())
		{
			LOGGER.error("Errors Enabled"+user);
		}
		disneyService.updatedining(user,id);
		
		HttpHeaders headers = new HttpHeaders();
		
        headers.add("Responded", "Success");
        headers.setLocation(builder.path("/user/resort/{id}").buildAndExpand(user.getGuestid_fk()).toUri());
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        return new ResponseEntity<Object>(headers,HttpStatus.ACCEPTED);
	}
	
} 
