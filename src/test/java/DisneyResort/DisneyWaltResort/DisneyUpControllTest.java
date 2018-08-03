package DisneyResort.DisneyWaltResort;

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
public class DisneyUpControllTest extends DisneyWaltResortApplicationTests {
	
	@Autowired
	private DisneyService disneyService;
	
	    @Test
	    public void userupdate() {

	        int id=102;

	        GuestProfile entity = disneyService.findById(id);
            
	        Assert.assertNotNull("failure - expected not null", entity);
            
	        int updatedText  = entity.getGuest_id();
	        String updatedText0 = entity.getEmail() + " test";
	        String updatedText1 = entity.getFirst_name() + " test";
	        String updatedText2 = entity.getLast_name() + " test";
	        String updatedText3 = entity.getAddress() + " test";
	        String updatedText4 = entity.getPhone() + " test";
	        String updatedText5 = entity.getPassword() + " test";
	        Date updatedText6 = entity.getCreated_date();
	        Date updatedText7 = entity.getUpdated_date();
	        
	        entity.setGuest_id(updatedText);
	        entity.setEmail(updatedText0);
	        entity.setFirst_name(updatedText1);
	        entity.setLast_name(updatedText2);
	        entity.setAddress(updatedText3);
	        entity.setPhone(updatedText4);
	        entity.setPassword(updatedText5);
	        entity.setCreated_date(updatedText6);
	        entity.setUpdated_date(updatedText7);
	        
	        
	        GuestProfile updatedEntity = disneyService.updateuser(entity,updatedText);

	        Assert.assertNotNull("failure - expected not null", updatedEntity);
	        
	        Assert.assertEquals("failure - expected id attribute match", id,
	                updatedEntity.getGuest_id());
	        
	        Assert.assertEquals("failure - expected text attribute match",
	                updatedText0, updatedEntity.getEmail());
	        Assert.assertNotNull(updatedEntity);
	        Assert.assertEquals(updatedEntity,updatedEntity);

	    }
	    
	    @Test
	    public void resortupdate() 
	    {

	    	ResortReservation entity = new ResortReservation();
            
	        Assert.assertNotNull("failure - expected not null", entity);
            
	     
	        entity.setGuest_id_fk(102);
	        entity.setRoom_type("tripple");
	        entity.setArrival_date(new Date());
	        entity.setDeparture_date(new Date());
	        entity.setNo_of_people(3);
	        entity.setStatus("arrived");
	        entity.setCreated_date(new Date());
	        entity.setUpdated_date(new Date());
	        
	        
	        ResortReservation updatedEntity = disneyService.updateresort(entity,entity.getGuest_id_fk());

	        Assert.assertNotNull("failure - expected not null", updatedEntity);
	        
	        Assert.assertEquals("failure - expected id attribute match",entity.getGuest_id_fk(),
	                updatedEntity.getGuest_id_fk());
	        
	        Assert.assertEquals("failure - expected text attribute match",
	                entity.getRoom_type(), updatedEntity.getRoom_type());

	    }
	    
	    @Test
	    public void diningupdate() 
	    {

	    	DiningReservation entity = new DiningReservation();
            
	        Assert.assertNotNull("failure - expected not null", entity);
            
	     
	        entity.setGuestid_fk(102);
	        entity.setDining_type("tripple");
	        entity.setArrival_date(new Date());
	        entity.setNo_of_people(3);
	        entity.setStatus("arrived");
	        entity.setCreated_date(new Date());
	        entity.setUpdated_date(new Date());
	        
	        
	        DiningReservation updatedEntity = disneyService.updatedining(entity,entity.getGuestid_fk());

	        Assert.assertNotNull("failure - expected not null", updatedEntity);
	        
	        Assert.assertEquals("failure - expected id attribute match",entity.getGuestid_fk(),
	                updatedEntity.getGuestid_fk());
	        
	        Assert.assertEquals("failure - expected text attribute match",
	                entity.getDining_type(), updatedEntity.getDining_type());

	    }


}
