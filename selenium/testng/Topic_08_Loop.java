package testng;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Topic_08_Loop {
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

		@Test(invocationCount = 3)
		  public void TC_01_Register() {
			driver.get("http://live.demoguru99.com/index.php/customer/account/create/");
			driver.findElement(By.id("firstname")).sendKeys("Automation");
			driver.findElement(By.id("lastname")).sendKeys("FFFF");
			String emailAddress = generateEmailAddress();
			System.out.println("Email Address : " + emailAddress);
		
			String password = String.valueOf(generatePassword());
			System.out.println("Password : " + password);
		
			driver.findElement(By.id("email_address")).sendKeys(emailAddress);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("confirmation")).sendKeys(password);
			driver.findElement(By.xpath("//button[@title='Register']")).click();
			driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
			 driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			
		} 

	public String generateEmailAddress() {
		Random rand = new Random();
		return "Autofc" + rand.nextInt(999999) + "@yopmail.com";
	}
	public int generatePassword() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}



	  @AfterClass(alwaysRun = true)
	  public void afterClass() {
		  System.out.println("After Class");
		  // Close Browser 
		  // Close driver 
		  driver.quit();
	  }

}
