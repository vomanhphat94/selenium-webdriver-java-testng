package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Element_Method {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");

	}

	@Test
	public void TC_01_Webelement_Command() {
		// Thao tác trực tiếp lên Element + K cần khai báo biến 
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("gauluoi@yopmail.com");
		
		
		
		// Khai báo biến rồi mới thao tác (action: click/ sendkey/ getText/ select/...)
	}


	public void TC_02_ValidatePageTitle() {

	}


	public void TC_03_LoginFormDisplayed() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}