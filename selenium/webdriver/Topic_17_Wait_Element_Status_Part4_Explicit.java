package webdriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;


import sun.util.calendar.BaseCalendar.Date;

public class Topic_17_Wait_Element_Status_Part4_Explicit {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	String projectPath = System.getProperty("user.dir");
	String projectOS = System.getProperty("os.name");
	String imageName1 = "sample1mb.jpg";
	// Help to detect which OS will be used
	String imagePath_1 = projectPath + getFileSeparator() + "ImageTest" + getFileSeparator() + imageName1;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		System.out.println(driver.toString());
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver, 15);
	}


	public void TC_01_Explicit_Wait_Enough() {
		driver.get("https://juliemr.github.io/protractor-demo/");
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("6");
		driver.findElement(By.id("gobutton")).click();
		explicitWait = new WebDriverWait(driver, 2);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='11']")));
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText(), "11");
	}

	public void TC_02_Explicit_Wait_Less() {
		driver.get("https://juliemr.github.io/protractor-demo/");
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("6");
		driver.findElement(By.id("gobutton")).click();
		explicitWait = new WebDriverWait(driver, 1);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='11']")));
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText(), "11");
	}

	public void TC_03_Explicit_Wait_Greater() {
		driver.get("https://juliemr.github.io/protractor-demo/");
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("6");
		driver.findElement(By.id("gobutton")).click();
		explicitWait = new WebDriverWait(driver, 50);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='11']")));
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText(), "11");
	}
	
	
	public void TC_04_Explicit_Excercise() {
		explicitWait = new WebDriverWait(driver, 10);
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		//Wait for Date Picker visible
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ctl00_ContentPlaceholder1_Panel1']")));
		
		
//		WebElement selectedDateText = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']"));
		
		// Verify text is selected date
//		Assert.assertEquals(selectedDateText.getText(), "No Selected Dates to display.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']")).getText(), "No Selected Dates to display.");
		
		// Wait for Current Date clickable
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@title='Friday, July 16, 2021']")));
		
		driver.findElement(By.xpath("//td[@title='Friday, July 16, 2021']")).click();
		
		// Wait for Ajax loading and spinner invisible
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']")));
		// Wait for selected date display after spinner invisible
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='Friday, July 16, 2021' and @class='rcSelected']")));

		// Verify the date selected
		Assert.assertTrue(driver.findElement(By.xpath("//td[@title='Friday, July 16, 2021' and @class='rcSelected']")).isDisplayed());
		// Verify text is selected date
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']")).getText(), "Friday, July 16, 2021");
//		Assert.assertEquals(selectedDateText.getText(), "Friday, July 16, 2021");
		
	}
	
	@Test
	public void TC_05_Explicit_Excercise_II() {
		explicitWait = new WebDriverWait(driver, 15);

		driver.get("https://filebin.net/");
		WebElement uploadFileButton = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFileButton.sendKeys(imagePath_1);
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='progress']")));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + imageName1 + "']")));

		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + imageName1 + "']")).isDisplayed());

		
	}
	
	public String getFileSeparator() {
		return File.separator;
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