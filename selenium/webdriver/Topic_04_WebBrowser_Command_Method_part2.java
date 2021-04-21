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

public class Topic_04_WebBrowser_Command_Method_part2 {

	WebDriver driver;
    String LoginURL = "http://live.demoguru99.com/index.php/customer/account/login/";
	String CreateURL = "http://live.demoguru99.com/index.php/customer/account/create/";
	String LoginTitle = "Customer Login";
	String CreateTitle = "Create New Customer Account";
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void TC_01_Verify_URL() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), LoginURL );
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), CreateURL );
		
		
	}
	@Test
	public void TC_02_Verify_Title() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		Assert.assertEquals(driver.getTitle(), LoginTitle);
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		Assert.assertEquals(driver.getTitle(), CreateTitle);

	}

	@Test
	public void TC_03_Navigate_Function() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), CreateURL );
		driver.navigate().back();
		Assert.assertEquals(driver.getCurrentUrl(), LoginURL );
		driver.navigate().forward();
		Assert.assertEquals(driver.getTitle(), CreateTitle);

	}
	
	@Test
	public void TC_04_Get_Page_Source() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}