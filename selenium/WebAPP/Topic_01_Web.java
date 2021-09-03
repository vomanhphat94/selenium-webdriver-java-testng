package WebAPP;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Topic_01_Web { 
	WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("Run before Class of Web");
		  System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get("https://automationfc.com");
		  Assert.assertTrue(false);
	}
	
	@Test(groups = {"web", "regresstion"})
	  public void TC_01_New_language() {
		  System.out.println("Run Testcase 01 New_language");
	  }
	@Test(groups = {"web", "regresstion"})
	public void TC_02_View_language() {
		System.out.println("Run Testcase 02 View_language");
	}
	
	@Test(groups = {"web", "regresstion"})
	public void TC_03_Delete_language() {
		System.out.println("Run Testcase 03 Delete_language");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("Run after Class of Web");
		driver.quit();
	}
}
