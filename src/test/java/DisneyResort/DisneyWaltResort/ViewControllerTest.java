package DisneyResort.DisneyWaltResort;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.DisneyResort.Disney.GuestProfile;
import com.DisneyResort.Disney.DisneyService.DisneyService;

@Transactional
public class ViewControllerTest extends DisneyWaltResortApplicationTests{
	
	@Autowired
	private DisneyService disneyservice;
	
	
	@Test
    public void testFindAll() {
        
		Integer id=102;
        GuestProfile list = disneyservice.getuserById(id);

        Assert.assertNotNull("failure - expected not null", list);
        Assert.assertEquals(list,list);

    }

}
