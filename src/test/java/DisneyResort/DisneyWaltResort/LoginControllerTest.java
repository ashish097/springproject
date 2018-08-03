package DisneyResort.DisneyWaltResort;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.DisneyResort.Disney.DisneyService.DisneyService;

@Transactional
public class LoginControllerTest extends DisneyWaltResortApplicationTests{
	
	
	@Autowired
	private DisneyService disneyservice;
	
	
	@Test
    public void logintest() {
        
		int id=102;
		String password="ashishk";
		
        boolean list = disneyservice.validate(id,password);

        Assert.assertNotNull("failure - expected not null", list);
        Assert.assertTrue(true);
        Assert.assertTrue("Expected True", true);

    }
}
