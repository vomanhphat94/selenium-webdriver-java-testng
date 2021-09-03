package testng;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listenerConfig.TestNGListener.class)
public class Topic_09_Dependency {
	WebDriver driver;
	By emailTextBox = By.xpath("//*[@id='email']");
	By passwordTextBox = By.xpath("//*[@id='pass']");
	By loginButton = By.xpath("//*[@id='send2']");
	
	
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Before Class");
		  System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		  driver = new FirefoxDriver();


	  }
	  
	  	// Test trên mà fail thì test dưới cũng fail
	  	// Test nên phụ thuộc nhau
		@Test
		  public void TC_01_Add_New_Customer() {
			  System.out.println("Run Testcase 01");
			  Assert.assertTrue(true);
			  
		  }
		
		@Test(dependsOnMethods ="TC_01_Add_New_Customer")
		public void TC_02_View_Customer() {
			System.out.println("Run Testcase 02");
			
		}
		
		@Test(dependsOnMethods ="TC_02_View_Customer")
		public void TC_03_Edit_Customer() {
			System.out.println("Run Testcase 02");
			
		}
		@Test(dependsOnMethods ="TC_03_Edit_Customer")
		public void TC_04_Move_Customer() {
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
