package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Template_II {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\browserDrivers\\chromedriver.exe" );
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	public void TC_01_ValidateCurrentUrl() {
		driver.get("http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_02_TestElement() {
		driver.get("http://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.name("emailid")).sendKeys("automationfc@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		String userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		System.out.println(userID);
		String passwordUser =  driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		System.out.println(passwordUser);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}