package webdriver;



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

public class Topic_17_Wait_Element_Status_Part1 {
	WebDriver driver;
	WebDriverWait explicitWait;



	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		System.out.println(driver.toString());
		explicitWait = new WebDriverWait(driver, 15);

		driver.manage().window().maximize();
	}


	public void TC_01_Visible() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		// Có trong DOM và có trên UI để thấy/thao tác ( Bắt buộc )
		// Chờ cho submit button dc visible trong vòng 15s
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='SubmitLogin']")));	
	}


	public void TC_02_Invisible() {
		// Có trng DOM hoặc k có trong DOM 
		// Và không hiển thị trên UI để thấy hoặc thao tác ( Bắt buộc )
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//li[text()='An email address required.']")));
		// Chờ form forgot pw
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//form[@id='form_forgotpassword']")));
	}
	
	
	public void TC_03_Presence() {
		// Không có trên UI hoặc có trên UI
		// Phải có trong DOM ( bắt buộc )
		driver.get("http://live.demoguru99.com/");
		
		// Có trong DOM nhưng k có trên UI
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='header-account']//a[@title='My Account']")));
		
		// Có trong DOM và có trên UI
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='search']")));
	}
	
	@Test
	public void TC_04_Staleness() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		WebElement errorMsg = driver.findElement(By.xpath("//li[text()='An email address required.']"));
		driver.navigate().refresh();
		explicitWait.until(ExpectedConditions.stalenessOf(errorMsg));
		
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