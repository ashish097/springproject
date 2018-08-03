package com.DisneyResort.Disney.DisneyDao;
//import java.util.List;


import java.util.Collection;
 

import com.DisneyResort.Disney.DiningReservation;
import com.DisneyResort.Disney.GuestProfile;
import com.DisneyResort.Disney.ResortReservation;
//import com.DisneyResort.Disney.UserDetail;


public interface IDisneyDAO 
{
	//REGISTRATION USER DAO
	GuestProfile adduser(GuestProfile user);
    
	ResortReservation addresort(ResortReservation resort,int id);

	DiningReservation adddining(DiningReservation user, int customerId);
	
	//LOGIN_VALID USER DAO
	boolean userExists(GuestProfile user);

	boolean validate(int id, String pass);

	boolean ispresent(Integer id);
    
	//VIEW DAO
	GuestProfile getuserbyID(Integer id);
	
    //UPDATION USER
	GuestProfile updateuser(GuestProfile user,int id);

	ResortReservation updateresort(ResortReservation user, int id);

	DiningReservation upadtedining(DiningReservation user, int id);
    
	//Security dao

	Collection<GuestProfile> findall();

	GuestProfile findbyId(int id);
}
 