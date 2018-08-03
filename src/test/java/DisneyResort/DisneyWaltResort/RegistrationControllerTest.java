package DisneyResort.DisneyWaltResort;
import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.DisneyResort.Disney.DiningReservation;
import com.DisneyResort.Disney.GuestProfile;
import com.DisneyResort.Disney.ResortReservation;

import com.DisneyResort.Disney.DisneyService.DisneyService;

@Transactional
public class RegistrationControllerTest extends DisneyWaltResortApplicationTests
{
		  @Autowired
		  private DisneyService disneyService;
	
	  
	    @Test
	    public void usertest() throws Exception 
	   {

		    GuestProfile entity = new GuestProfile("radhikaa@gmail.com", "ashishk","sinhaa",
					"BangloreMarathali","8093401286","ashish097",new Date(),new Date());
            
		    
	        Object guest2= disneyService.addMember(entity);


	        Collection<GuestProfile> list = disneyService.findall();

	        Assert.assertEquals("failure - expected size",12,list.size());
	        Assert.assertEquals(guest2,guest2);
	        Assert.assertNotNull(guest2);
	        Assert.assertNotNull("failure - expected not null", guest2);

	    }
	    
	    @Test
	    public void resorttest() throws Exception 
		   {

			    ResortReservation entity = new ResortReservation(102, "double",new Date(),
			    		new Date(),8,"arrived",new Date(),new Date());
	            
			    
			    ResortReservation guest= disneyService.addresort(entity,entity.getGuest_id_fk());


		        //Collection<ResortReservation> list = disneyService.findall();

		        //Assert.assertEquals("failure - expected size",12,list.size());
		        Assert.assertEquals(guest,guest);
		        Assert.assertNotNull("failure - expected not null", guest);

		    }
	    
	    @Test
	    public void dinnigtest() throws Exception 
		   {

			    DiningReservation entity = new DiningReservation(102,"double",new Date(),
			    		8,"arrived",new Date(),new Date());
	            
			    
			    DiningReservation guest= disneyService.addDining(entity,entity.getGuestid_fk());


		        //Collection<ResortReservation> list = disneyService.findall();

		        //Assert.assertEquals("failure - expected size",12,list.size());
		        Assert.assertEquals(guest,guest);
		        Assert.assertNotNull("failure - expected not null", guest);

		    }
	    
	    
}

