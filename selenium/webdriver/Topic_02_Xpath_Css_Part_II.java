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

public class Topic_02_Xpath_Css_Part_II {
	WebDriver driver;
	String expectedRequiredMessage = "This is a required field.";
	String expectedEmailFormatMessage = "Please enter a valid email address. For example johndoe@domain.com.";
	String expectedPassSpaceMessage = "Please enter 6 or more characters without leading or trailing spaces.";
	String expectedInvalidLoginMessage = "Invalid login or password.";
	String registerSuccessMsg = "Thank you for registering with Main Website Store.";
	String firstName = "Phat";
	String lastName = "Vo";
	String password = "Abcd1234";
			
	
	Random randomGenerator = new Random();  
	int randomInt = randomGenerator.nextInt(100000);  
	String userEmail = "username" + randomInt +"@gmail.com";

	
	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver",".\\browserDrivers\\chromedriver.exe" );
//		driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	public void TC_01_Empty_Email_And_Password() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(), expectedRequiredMessage);
		// Option 1 - better because it will show which text is wrong 
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(), expectedRequiredMessage);
		// Option 2 - This assert only show failed or not
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-required-entry-email' and text()='This is a required field.']")).isDisplayed());
	}
	
	
	public void TC_02_Invalid_Email_Address() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(), expectedEmailFormatMessage);	
	}
	 

	public void TC_03_Invalid_Password() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(), expectedPassSpaceMessage);
		
	}
	

	public void TC_04_Incorrect_Password() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123123");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span[contains(text(),'Invalid login or password.')]")).getText(), expectedInvalidLoginMessage);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), expectedInvalidLoginMessage);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']")).getText(), expectedInvalidLoginMessage);
		System.out.println(driver.findElement(By.xpath("//li[@class='error-msg']//span[contains(text(),'Invalid login or password.')]")).getText());
	}

//	public void TC_05_Create_A_New_Account() {
//		driver.get("http://live.demoguru99.com/");
//		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
//		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
//		// Input information for registration
//		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
//		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
//		//driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("username"+ randomInt +"@gmail.com");
//		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(userEmail);
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
//		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(password);
//		driver.findElement(By.xpath("//button[@title='Register']")).click();
//
//		// Register success
//	    Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), registerSuccessMsg);
//		// Verify information after register
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'Phat Vo')]/text()[1]")).getText(), firstName + " " + lastName);
//	//	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='box-content']//p[contains(.,'Phat Vo')]")).getText().contains("Phat"), firstName + " " +  lastName);
//	//	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='box']//p[contains(.,'Bear')]")).getText(), firstName);
//	//	Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']")).getText(), lastName);
//	    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'Phat Vo')]//text()[2]")).getText(), userEmail);
//	//    driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']]")).click();
//	    //driver.findElement(By.xpath("////a[@title='My Account']")).click();
//	}
	
	//div[@class='footer']//a[contains(@text(),'My Account')]
	public void TC_06_Login_With_Valid_Account() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	}
	


	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}

}