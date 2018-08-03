package com.DisneyResort.Disney.DisneyService;



import java.util.Collection;

import com.DisneyResort.Disney.DiningReservation;

//import java.util.List;

//import javax.validation.Valid;

import com.DisneyResort.Disney.GuestProfile;
import com.DisneyResort.Disney.ResortReservation;
//import com.DisneyResort.Disney.UserDetail;
public interface IDsineyService {
    
	//REGISTRATION USER
	GuestProfile addMember(GuestProfile user);

	ResortReservation addresort(ResortReservation user,int id);
	
	DiningReservation addDining(DiningReservation user, int customerId);
	
	//LOGIN VALIDATIONS
	boolean validate(int id, String pass);

	boolean ispresent(Integer id);

	GuestProfile getuserById(Integer id);
    	
	//UPDATING DETAILS
	GuestProfile updateuser(GuestProfile user,int id);

	ResortReservation updateresort(ResortReservation user,int id);

	DiningReservation updatedining(DiningReservation user,int id);
	
	//TEST dao

     Collection<GuestProfile> findall();
	
	 GuestProfile findById(int id);
}
