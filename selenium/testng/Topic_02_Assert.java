package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Topic_02_Assert {
	
	@Test
	  public void TC_01() {
		  System.out.println("Run Testcase 01");
		  boolean condition = true;
		  // True
		  // Class name > method name
		  condition = 3 < 5;
		  System.out.println(condition);
		  Assert.assertTrue(condition);
		  
		// Static
		  assertTrue(condition);
		  
		  // False
		  condition = 3 > 5;
		 System.out.println(condition);
		  Assert.assertFalse(condition);
		  Assert.assertFalse(false);
		  // Equal
		  Assert.assertEquals("Automation", "Automation");
		  
	  }
	
}
