package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Wait_Element_Status_Part5_Mixing {
	WebDriver driver;
	WebDriverWait explicitWait;




	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 10);
	}


	public void TC_01_Element_Found() {
		driver.get("https://demo.nopcommerce.com/register"); 
		
		//Explicit
		System.out.println("Start time (ex):" + getDateTimeNow());
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='FirstName']")));
		System.out.println("Start time (ex):" + getDateTimeNow());
		
		//Implicit
		System.out.println("Start time (ex):" + getDateTimeNow());
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("hello");
		System.out.println("Start time (ex):" + getDateTimeNow());
		
		
	}
	

	public void TC_02_Element_NotFound_Implicit() {
		driver.get("https://demo.nopcommerce.com/register"); 
		//Implicit
		System.out.println("Start time (ex):" + getDateTimeNow());
		driver.findElement(By.xpath("//input[@id='FirstName123123']")).sendKeys("hello");
		System.out.println("Start time (ex):" + getDateTimeNow());
	}
	

	public void TC_03_Element_NotFound_Implicit_Explicit() {
		driver.get("https://demo.nopcommerce.com/register"); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 5);
		//Explicit
		System.out.println("Start time (ex):" + getDateTimeNow());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='FirstName123123']")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Start time (ex):" + getDateTimeNow());
		
	}
	

	public void TC_04_Element_NotFound_Explicit_By() {
		driver.get("https://demo.nopcommerce.com/register"); 
		explicitWait = new WebDriverWait(driver, 5);
		//Explicit, remove implicit
		System.out.println("Start time (ex):" + getDateTimeNow());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='FirstName123123']")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Start time (ex):" + getDateTimeNow());
		
		
	}

	public void TC_04_Element_NotFound_Explicit_WebElement() {
		driver.get("https://demo.nopcommerce.com/register"); 
		explicitWait = new WebDriverWait(driver, 5);
		//Explicit, remove implicit
		System.out.println("Start time (ex):" + getDateTimeNow());
		try {
			explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='FirstName123123']"))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Start time (ex):" + getDateTimeNow());
		

		
	}
	

	
	public String getDateTimeNow() {
		java.util.Date TimeNow = new java.util.Date();
		return TimeNow.toString();
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}

}