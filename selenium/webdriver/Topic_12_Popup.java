package webdriver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Popup {
	WebDriver driver;
	WebDriverWait explicitWait;
	WebDriverWait explicitWait2;
	JavascriptExecutor jsExecutor;
	Alert alert;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		System.out.println(driver.toString());

		action = new Actions(driver);
		explicitWait = new WebDriverWait(driver, 10);
		jsExecutor = (JavascriptExecutor) driver;
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	public void TC_01_Popup_fixed() {
		driver.get("https://tiki.vn/");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[@id='onesignal-slidedown-cancel-button']")).click();
		sleepInSecond(2);
		action.moveToElement(driver.findElement(By.xpath("//span[@class='account-label']"))).perform();
		//button[text()='Đăng nhập']
		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']/div")).isDisplayed());
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Tiếp Tục']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//button[text()='Tiếp Tục']")).getText(), "Tiếp Tục");
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='tel']")).isDisplayed());
		
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		sleepInSecond(2);
		// This assert will be failed. Because Popup not in DOM -> Selenium cannot find and check
		// FindELement can be use if element in DOM
		// Assert.assertFalse(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']/div")).isDisplayed());
	
	
	}
	
	public void TC_02_Popup_In_DOM() {
		driver.get("https://bni.vn/");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")).isDisplayed());
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//img[@class='sgpb-popup-close-button-1']")).click();
		sleepInSecond(2);
	
		Assert.assertFalse(driver.findElement(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")).isDisplayed());
	}
	

	public void TC_03_Popup_NotIn_DOM() {
		driver.get("https://tiki.vn/");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[@id='onesignal-slidedown-cancel-button']")).click();
		sleepInSecond(2);
		action.moveToElement(driver.findElement(By.xpath("//span[@class='account-label']"))).perform();
		//button[text()='Đăng nhập']
		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']/div")).isDisplayed());
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Tiếp Tục']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//button[text()='Tiếp Tục']")).getText(), "Tiếp Tục");
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='tel']")).isDisplayed());
		
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		sleepInSecond(2);
		// This assert will be failed. Because Popup not in DOM -> Selenium cannot find and check
		// FindELement can be use if element in DOM
		// Assert.assertFalse(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']/div")).isDisplayed());
		// Verify Element not in DOM
		Assert.assertEquals(driver.findElements(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']/div")).size(), 0 );
		System.out.println(driver.findElements(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']/div")).size());
	}
	
	@Test
	public void TC_04_Popup_In_DOM_And_Condition() {
		driver.get("https://blog.testproject.io/");
		System.out.println("Step 1");
		sleepInSecond(60);
		if(driver.findElement(By.xpath("//div[@class='mailch-wrap']")).isDisplayed()) {
			System.out.println("Step 2");
			driver.findElement(By.xpath("//div[@class='close-mailch']")).click();
			sleepInSecond(2);
		}
		
//		// trường hợp popup k có trong trong DOM 
//		if(driver.findElements(By.xpath("//div[@class='mailch-wrap']")).size() >= 1) {
//			System.out.println("Step 3");
//			driver.findElement(By.xpath("//div[@class='close-mailch']")).click();
//			sleepInSecond(2);
//		}
		
		
		System.out.println("Step 4");
		driver.findElement(By.xpath("//section[@id='search-2']//input[@class='search-field']")).sendKeys("Robot");
		sleepInSecond(2);
		
		System.out.println("Step 5");
		driver.findElement(By.xpath("//section[@id='search-2']//span[@class='glass']")).click();
		
	}
	
	public void TC_04_Double_Click() {

	}
	
	
	public void TC_05_Right_Click() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

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