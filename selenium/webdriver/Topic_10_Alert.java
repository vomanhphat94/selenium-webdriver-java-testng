package webdriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Alert {
	WebDriver driver;
	WebDriverWait explicitWait;
	WebDriverWait explicitWait2;
	JavascriptExecutor jsExecutor;
	Alert alert;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\browserDrivers\\chromedriver.exe" );
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		System.out.println(driver.toString());

		explicitWait = new WebDriverWait(driver, 10);
		jsExecutor = (JavascriptExecutor) driver;
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
//		alert = driver.switchTo().alert();
//		alert.accept();
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		// Accept
		alert.accept();
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked an alert successfully");
		sleepInSecond(3);

		
	}

	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.dismiss();
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
		sleepInSecond(3);
	}
	
	
	public void TC_03_Prompt_Alert() {
		String alertText = "hello";
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		sleepInSecond(2);
		alert.sendKeys(alertText);
		sleepInSecond(2);
		alert.accept();
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: " + alertText);
		sleepInSecond(3);
	}
	

	public void TC_04_Authentication_Alert() {
		// Selenium by Pass
		// http://username:password@domain
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		// In case password contain special Chars
//		driver.get("http://admin:@admin@@the-internet.herokuapp.com/basic_auth");
		// Need encode HTML 
//		driver.get("http://admin:%40admin%40@the-internet.herokuapp.com/basic_auth");
		
			
		
//		driver.get("http://the-internet.herokuapp.com/basic_auth");
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	
	}

	public void TC_04_Authentication_Alert_PartII() {
		// Selenium by Pass
		// http://username:password@domain
		driver.get("http://the-internet.herokuapp.com");
		// In case we click from Home page to Auth page
		String url = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
			
		driver.get(getCredentialToUrl(url, "admin", "admin"));
		
//		driver.get("http://the-internet.herokuapp.com/basic_auth");
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	}
	

//	public void TC_04_Authentication_Alert_autoIT() throws IOException {
//		String projectPath = System.getProperty("user.dir");
////		String autoITScriptPath = projectPath + ".\\autoIT\\authen_chrome.exe";
//		
////		Runtime.getRuntime().exec(new String[] { autoITScriptPath, "admin", "admin"});
//		
//		driver.get("http://the-internet.herokuapp.com/basic_auth");
//		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
//
//	}
	
	

	public String getCredentialToUrl(String url, String username, String password) {
		// split
		String[] newUrl = url.split("//");
		url = newUrl[0] + "//" + username + ":" + password + "@" + newUrl[1];
		return url;
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