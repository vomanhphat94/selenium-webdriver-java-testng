package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Always_Run {
	WebDriver driver;
	
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Before Class");
		  // Mở Browser lên
		  // Init driver lên
		  // Nếu như trong before class mà fail thì các testcase bên dưới/after class không giờ chạy
		  // Giả sử run 20 class Test -> mở ra 20 browser, mà before k run dc -> After k run dc -> Phải tự đi tắt manual 20 browser
		  System.setProperty("webdriver.gecko.driver", ".\\browerDrivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get("https://automationfc.com");
		  Assert.assertTrue(false);
	  }

	@Test
	  public void TC_01() {
		  System.out.println("Run Testcase 01");
		  
	  }
	
	@Test
	public void TC_02() {
		System.out.println("Run Testcase 02");
		
	}
	

	  @AfterClass(alwaysRun = true)
	  public void afterClass() {
		  System.out.println("After Class");
		  // Close Browser 
		  // Close driver 
		  driver.quit();
	  }

}
