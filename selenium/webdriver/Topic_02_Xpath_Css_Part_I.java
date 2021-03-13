package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_Css_Part_I {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	}

	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("Phat");
		driver.findElement(By.id("LastName")).sendKeys("Vo");
		driver.findElement(By.id("Email")).sendKeys("phatvoautofc@yopmail.com");
		driver.findElement(By.id("Password")).sendKeys("abcd1234");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("abcd1234");
		
	}

	@Test
	public void TC_02_Classname() {
		// Class have special case. It start with "." and will not take the full string in the Class because have space
		// Option 1 - Find a half element
		driver.findElement(By.className("search-box-text")).sendKeys("abcd1234");
		driver.findElement(By.className("search-box-text")).clear();
		// Option 2 - Add "." as space and change to find CSS
		driver.findElement(By.cssSelector(".search-box-text.ui-autocomplete-input")).sendKeys("abcd1234");
		// This will fail -> driver.findElement(By.className("search-box-text ui-autocomplete-input")).sendKeys("abcd1234");
		
		
	}

	@Test
	public void TC_03_Name() {
		driver.findElement(By.name("Company")).sendKeys("automationfc");
		
	}
	@Test
	public void TC_04_Tagname() {
		// find element which tagname is select
		// plural findElements ( add s ) 
		System.out.println("This is size of element with tagname select: " + driver.findElements(By.tagName("select")).size());
	}
	@Test
	public void TC_05_LinkText() {
		// Check the link with assert 
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.className("ico-register")).isDisplayed());
		
	}
	@Test
	public void TC_06_Partial_Link_Text() {
		// A part of display on UI
		Assert.assertTrue(driver.findElement(By.partialLinkText("Digital")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.partialLinkText("downloads")).isDisplayed());
	}
	@Test
	public void TC_07_Css() {
		//# = ID
		driver.findElement(By.cssSelector("#Password")).clear();;
		driver.findElement(By.cssSelector("#Password")).sendKeys("Abcd1234");
		driver.findElement(By.cssSelector("input[name='ConfirmPassword']")).clear();;
		driver.findElement(By.cssSelector("input[name='ConfirmPassword']")).sendKeys("Abcd1234");
		
	}
	@Test
	public void TC_08_Xpath() {
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).clear();;
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Abcd1234");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}