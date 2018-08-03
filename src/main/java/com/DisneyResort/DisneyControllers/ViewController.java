package com.DisneyResort.DisneyControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.DisneyResort.Disney.GuestProfile;

import com.DisneyResort.Disney.DisneyService.IDsineyService;
import com.DisneyResort.Disney.exception.GuesttNotFoundException;




@RestController
public class ViewController {

	
	@Autowired
	private IDsineyService disneyService;
	
	
	//userDetails
	@GetMapping("/user/{id}")
	public ResponseEntity<GuestProfile> getArticleById(@PathVariable("id") Integer id) {
		
		boolean present = disneyService.ispresent(id);
		if(present)
		{
			GuestProfile guest = disneyService.getuserById(id);
			return new ResponseEntity<GuestProfile>(guest, HttpStatus.OK);
		}
		else
		{
			throw new GuesttNotFoundException("No Records found with this id-" + id);
		}
	}	
	
} 
