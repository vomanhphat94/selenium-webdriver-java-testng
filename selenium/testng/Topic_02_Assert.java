package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Topic_02_Assert {
	
	
	// Kiểu nguyên thủy sẽ có giá trị mặc định nếu chưa khởi tạo ( Global )
	int studentNumber;
	
	Object studentAdress = null;
	
	@Test
	  public void TC_01() {
		
		// thường sử dụng cho isDisplayed/ isEnabled/ isSelected/ isMultiple
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
		  String studentName ="Lê Văn A";
		  
		 
		 Assert.assertTrue(studentName.contains("A"));
		 
		 Assert.assertFalse(studentName.contains("E"));
		 Assert.assertEquals(studentName, "Lê Văn A");
		 Assert.assertNotEquals(studentName, "A");
		 
		 Assert.assertNull(studentAdress);
		 
		 studentAdress = "A";
		 Assert.assertNotNull(studentAdress);
		 
		  
	  }
	
}
