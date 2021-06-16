package webdriver;

import java.io.BufferedReader;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Windows_Tab {
	WebDriver driver;
	WebDriverWait explicitWait;
	WebDriverWait explicitWait2;
	JavascriptExecutor jsExecutor;
	Alert alert;
	Actions action;
	Select select; 

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

	
	public void TC_01_Only_Two_Windows_or_Tabs() {
		driver.get("https://kyna.vn/");
		
		// Before click
		String kynaID = driver.getWindowHandle();
		System.out.println("ID of page A: " + kynaID);
		// Click to facebook link at footer
		driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='facebook']")).click();
		
		// After click
		Set<String> allIDs = driver.getWindowHandles();
		
		// Switch to facebook page ( tab)
//		for (String id : allIDs) {
//			System.out.println("All IDs: " + id);
//			if(!id.equals(parentID)) {
//				driver.switchTo().window(id);
//			
//			}
//		}
		switchToWindowByID(kynaID);
		
		String facebookID = driver.getWindowHandle();
		
		// Verify URL is displayed Facebook page
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/kyna.vn");
		
		
		
		// Switch back to Kyna (Parent)
//		for (String id : allIDs) {
//			System.out.println("All IDs: " + id);
//			if(id.equals(parentID)) {
//				driver.switchTo().window(id);
//			
//			}
//		}
		switchToWindowByID(facebookID);
		// Verify any element is displayed on Kyna page
		Assert.assertEquals(driver.getCurrentUrl(), "https://kyna.vn/");
	}

	@Test
	public void TC_02_Greater_than_two_window_or_tab() {
		driver.get("https://kyna.vn/");
		String kynaID = driver.getWindowHandle();
		// Click to Facebook
		driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='facebook']")).click();
		// Switch to Facebook
		switchToWindowByTitle("Đăng nhập Facebook");
		// Verify Facebook
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/kyna.vn");
		// Switch to Kyna
		switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
		// Verify Kyna
		Assert.assertEquals(driver.getCurrentUrl(), "https://kyna.vn/");
		// CLick Youtube
		driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='youtube']")).click();
		// Switch to Youtube
		switchToWindowByTitle("Kyna.vn - YouTube");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/user/kynavn");
		// Switch to Kyna
		switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
		Assert.assertEquals(driver.getCurrentUrl(), "https://kyna.vn/");
		// Click to Primus
		driver.findElement(By.xpath("//div[@class='info']//a[text()='PRIMUS']")).click();
		// Switch to Primus
		switchToWindowByTitle("PRIMUS Homepage");
		// Verify Primus
		Assert.assertTrue(driver.getCurrentUrl().contains("primus.vn"));
		// Switch to Kyna
		//switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
		// Close all tabs
		closeAllWindowWithoutWindowSelected(kynaID);

	}
	
	public void closeAllWindowWithoutWindowSelected(String windowID) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			if(!id.equals(windowID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
	}

	public void switchToWindowByTitle(String windowExpectedTitle) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			driver.switchTo().window(id);
			String windowActualTitle = driver.getTitle();
			if (windowActualTitle.equals(windowExpectedTitle)) {
				break;
			}
		}
	}
	
	public void switchToWindowByID(String windowID) {
		// Lấy hết tất cả các ID của window/tab đang có
		Set<String> allIDs = driver.getWindowHandles();
		// Dùng vòng lặp duyệt qua từng ID
		for (String id : allIDs) {
			// Mỗi lần duyệt qua 1 ID thì kiểm tra điều kiện
			// Nếu không = với giá trị được nhập, thì switch vào cái ID đó
			if(!id.equals(windowID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
				// Đạt điều kiện rồi, k cần chạy tiếp nếu list quá dài
				break;
			}
		}
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