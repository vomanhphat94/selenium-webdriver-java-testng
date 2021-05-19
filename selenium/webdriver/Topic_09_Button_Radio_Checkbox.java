package webdriver;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jdk.nashorn.internal.runtime.Context.ThrowErrorManager;

public class Topic_09_Button_Radio_Checkbox {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	JavascriptExecutor jsExecutor;
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\browserDrivers\\chromedriver.exe" );
		driver = new ChromeDriver();
		
		jsExecutor = (JavascriptExecutor) driver;
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	public void TC_01_Button_Disable() {
		driver.get("https://www.fahasa.com/customer/account/create");
		
		By loginButton = By.cssSelector(".fhs-btn-login");
		driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
		Assert.assertFalse(driver.findElement(loginButton).isEnabled());
		
		driver.findElement(By.cssSelector("#login_username")).sendKeys("bearvo@yopmail.com");
		driver.findElement(By.cssSelector("#login_password")).sendKeys("Abcd1234");
		sleepInSecond(2);
		
		Assert.assertTrue(driver.findElement(loginButton).isEnabled());
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
		
		removeDisableAtbByJS(loginButton);
		sleepInSecond(2);
		driver.findElement(loginButton).click();

		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số điện thoại/Email']/following-sibling::div[@class='fhs-input-alert']")).getText(),"Thông tin này không thể để trống");
	}
	
	public void TC_02_Default_Radio_Checkbox() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		//Check box
		List<WebElement> listCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement itemCheckbox : listCheckbox) {
			itemCheckbox.click();
		}
		
		for (WebElement itemCheckbox : listCheckbox) {
			Assert.assertTrue(itemCheckbox.isSelected());
		}
		
		for (WebElement itemCheckbox : listCheckbox) {
			itemCheckbox.click();
		}
		for (WebElement itemCheckbox : listCheckbox) {
			Assert.assertFalse(itemCheckbox.isSelected());
		}
		
		driver.findElement(By.xpath("//input[@value='Gout']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Gout']")).isSelected());
		
		// Radio
		driver.findElement(By.xpath("//input[@value='I have a loose diet']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Gout']")).isSelected());
		// Radio button - deselect will not work
		driver.findElement(By.xpath("//input[@value='I have a loose diet']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Gout']")).isSelected());

	}
	
	
	public void TC_03_Custom_Checkbox_Radio() {
		driver.get("https://material.angular.io/components/radio/examples");
		// CASE 1
		// k thể find input[@value=''] được vì đã bị thẻ span che mất rồi 
		//driver.findElement(By.xpath("//input[@value='Spring']")).click();
		// Nhưng có thể để verify được
		//Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Gout']")).isSelected());
		
		// CASE 2 - Thẻ span click được nhưng không verify được
		//driver.findElement(By.xpath("//input[@value='Spring']")).click();
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Gout']/preceding-sibling::span[@class='mat-radio-outer-circle']")).isSelected());
		
		// CASE 3 - combine 1 and 2 
//		driver.findElement(By.xpath("//input[@value='Spring']/preceding-sibling::span[@class='mat-radio-outer-circle']")).click();
//		sleepInSecond(2);
//		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Spring']")).isSelected());
		
		// CASE 4 -  dùng hàm click của JS - vừa click vừa verify luôn
		By springRadio = By.xpath("//input[@value='Spring']");
		clickByJs(springRadio);
		Assert.assertTrue(driver.findElement(springRadio).isSelected());
	}
	
	
	@Test
	public void TC_04_Custom_Checkbox_Radio_II() {
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		
		// Before click
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='false']")).isDisplayed());
	
		driver.findElement(By.xpath("//div[@aria-label='Cần Thơ']")).click();
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='true']")).isDisplayed());

	}
	
	public void removeDisableAtbByJS(By by) {
		WebElement element = driver.findElement(by);
		jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", element);
	}
	
	
	// Không care element hidden/visible đều click được hết 
	public void clickByJs(By by) {
		WebElement element = driver.findElement(by);
		jsExecutor.executeScript("arguments[0].click();", element);
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