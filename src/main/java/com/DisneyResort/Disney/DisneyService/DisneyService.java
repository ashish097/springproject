package com.DisneyResort.Disney.DisneyService;

import java.util.Collection;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DisneyResort.Disney.DiningReservation;
import com.DisneyResort.Disney.GuestProfile;
import com.DisneyResort.Disney.ResortReservation;
import com.DisneyResort.Disney.DisneyDao.IDisneyDAO;

@Service
public class DisneyService implements IDsineyService {
	
	@Autowired
	private IDisneyDAO disneyeDAO;
	
	
	
	//----------------REGISTRAION SERVICE----------------------//
	@Override
	public GuestProfile addMember(GuestProfile user) {
		 /*if (disneyeDAO.userExists(user)) {
	    	   return false;
	       } else {*/
	    	  return   disneyeDAO.adduser(user);
	    	   
	}
	

	@Override
	public ResortReservation addresort(ResortReservation resort,int id) {

		return  disneyeDAO.addresort(resort,id);
		
		
	}
    
	@Override
	public DiningReservation addDining(DiningReservation user, int customerId) {
	
		return disneyeDAO.adddining(user,customerId);	
	}
    
	
	//----------------LOGIN_VALID SERVICE----------------------//
	@Override
	public boolean validate(int id, String pass) {

        return disneyeDAO.validate(id,pass);
		
	}

	@Override
	public boolean ispresent(Integer id) {
		return disneyeDAO.ispresent(id);
	}

	@Override
	public GuestProfile getuserById(Integer id) {
		GuestProfile guest = disneyeDAO.getuserbyID(id);
		return guest;
	}

	//----------------UPDATION SERVICE----------------------//
	@Override
	public GuestProfile updateuser(GuestProfile user,int id) {
		return disneyeDAO.updateuser(user,id);
	}


	@Override
	public ResortReservation updateresort(ResortReservation user,int id) {
		return disneyeDAO.updateresort(user,id);
	}


	@Override
	public DiningReservation updatedining(DiningReservation user,int id) {
		return disneyeDAO.upadtedining(user,id);
		
	}

	@Override
	public Collection<GuestProfile> findall() {
		return disneyeDAO.findall();	
	}

	//----------------FinD SERVICE----------------------//

	@Override
	public GuestProfile findById(int id) {
		return disneyeDAO.findbyId(id);
	}
	
}
