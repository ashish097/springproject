package com.DisneyResort.DisneyControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.DisneyResort.Disney.GuestProfile;
import com.DisneyResort.Disney.DisneyService.IDsineyService;
import com.DisneyResort.Disney.exception.GuesttNotFoundException;




@RestController
public class LoginController {

	
	@Autowired
	private IDsineyService disneyService;
	
	
	    //userDetails
		@PostMapping("/login")
		public ResponseEntity<GuestProfile> getArticleById(@RequestBody GuestProfile guest) 
		{
			
			boolean flguser = disneyService.validate(guest.getGuest_id(),guest.getPassword());
			
			if(flguser)
			{
				int id = guest.getGuest_id();
				GuestProfile guests = disneyService.getuserById(id);
				return new ResponseEntity<GuestProfile>(guests, HttpStatus.OK);
			}
			else
			{
				throw new GuesttNotFoundException("No Records found with this id-" + guest.getGuest_id());
			}
		}		
} 
