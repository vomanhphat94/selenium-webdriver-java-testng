package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Run_On_Browser {

	WebDriver driver;
	String getProjectLocation = System.getProperty("user.dir");
	String ChromeDriverLocation = getProjectLocation + "/browserDrivers/chromedriver.exe";
	String ChromeDriverLocationMac = getProjectLocation + "/browserDrivers/chromedriver";
	
	//@Test
	public void TC_01_Run_On_Firefox() {
		// Firefox 47 + selenium 2.x.x + not use geckodriver
		driver = new FirefoxDriver();
//		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
		driver.quit();
		// Firefox 48 + Selenium 3.x.x + must use geckodriver
		// System.setProperty("webdriver.geckodriver.driver","path_of_Geckodriver.exe" );
		// FirefoxDriver driver = new FirefoxDriver();
		
	}

	@Test
	public void TC_02_Run_On_Chrome() {
		// Option 1 - absolute path
		// System.setProperty("webdriver.chrome.driver","C:\\backup\\Learning\\02 - Selenium API\\browserDrivers\\chromedriver.exe" );
		// Option 2 - dynamic path
		// . = Project location
		//System.setProperty("webdriver.chrome.driver",".\\browserDrivers\\chromedriver.exe" );
		//Option 3
		System.setProperty("webdriver.chrome.driver", ChromeDriverLocationMac );

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.quit();
	}


}