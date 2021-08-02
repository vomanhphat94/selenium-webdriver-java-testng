package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Topic_17_Wait_Element_Status_Part6_FluentWait {
	WebDriver driver;
	WebDriverWait explicitWait;
	FluentWait<WebElement> fluentElement;
	long timeout = 15;
	long interval = 1;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		explicitWait = new WebDriverWait(driver, 10);
	}

	@Test
	public void TC_01_FLuent() {
		driver.get("https://automationfc.github.io/fluent-wait/"); 
		fluentElement = new FluentWait<WebElement>(driver.findElement(By.id("javascript_countdown_time")));
		
		fluentElement.withTimeout(12, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentElement.until(new Function<WebElement, Boolean>() {
			public Boolean apply(WebElement element) {
				// Kiểm tra điều kiện countdown = 00
				boolean flag = element.getText().endsWith("02");
				System.out.println("Time = " + element.getText());
				// return giá trị cho function apply
				return flag;
			}
		});
	}
	
//	public void TC_02_FLuentWait() {
//		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2"); 
//		waitForElementAndClick(By.xpath("//div[@id='start']/button"));
//		Assert.assertTrue(waitForElementAndDisplayed(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")));
//		
//	}
//	
//
//	public WebElement waitedElement(By locator) {
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(timeout, TimeUnit.SECONDS)
//				.pollingEvery(interval, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
//		
//		WebElement element = wait.until(new Function<Webdriver, WebElement>(){
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(locator);
//			}
//		});
//		return element;
//	}
	
//	public void waitForElementAndClick(By locator) {
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(timeout, TimeUnit.SECONDS)
//				.pollingEvery(interval, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
//		WebElement element = wait.until(new Function<Webdriver, WebElement>(){
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(locator);
//			}
//		});
//		element.click();
//	}
//	
//	public boolean waitForElementAndDisplayed(By locator) {
//		element = waitedElement(locator);
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(timeout, TimeUnit.SECONDS)
//				.pollingEvery(interval, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
//		
//		boolean isDisplayed = wait.until(new Function<WebElement, Boolean>() {
//			public Boolean apply(WebElement element) {
//				boolean flag = element.isDisplayed();
//				return flag;
//			}
//		});
//		return isDisplayed;
//	}
	
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