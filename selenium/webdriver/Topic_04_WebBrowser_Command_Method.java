package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_WebBrowser_Command_Method {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();

	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		// Any method/command interact with Browser must use driver
		// driver. 
		
		// Open application web/page
		driver.get("http://live.demoguru99.com/");
		
		// Đóng trình duyệt - only current tab
		//driver.close();
		
		// Đóng trình duyệt - all
		//driver.quit();
		
		// Mở ra trang Mobile
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.demoguru99.com/index.php/mobile.html" );
		System.out.println(driver.getCurrentUrl());
		
		
		// Get title of current page
		System.out.println(driver.getTitle());
		
		// Get source code of current page
		System.out.println(driver.getPageSource());
		
		// Get current ID of tab/window ( active )
		driver.getWindowHandle();
		driver.getWindowHandles();
		
		// implicitlyWait: Chờ cho element được xuất hiện để tương tác trong vòng / / /  s
		// Phạm vi apply findElement/findElements
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);

		// Chờ page được load xong trong vòng . . .  s ( thường không dùng )
		// Hàm Get có cơ chế chờ riêng
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		
		// Chờ 1 đoạn script của Javascript Executor thực thi xong trong vòng . . . s
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		// Phóng to browser = kích thước screen
		driver.manage().window().maximize();

		// = F11 
		driver.manage().window().fullscreen();;
		
		// Kích thước của trình duyệt
		// Dùng cho test responsive desktop, nhưng Selenium thường không mạnh cho việc này
		// Thông thường là 1024x768 1366x768 1920x1080 1440x1080
		// setSize
		// getSize
		
		
		
		// Vị trí của trình duyệt so với độ phân giải của màn hình hiện tại - thường k dùng, demo for fun
		// Dựa trên x y của màn hình hiện tại
		// setPosition
		// getPosition
		
		// Navigte
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		// Open an URL : tracking history tốt hơn
		driver.navigate().to("http://live.demoguru99.com/");
		
		// interact with Alert
		driver.switchTo().alert();
		
		// interact with frame/iframe
		driver.switchTo().frame(0);
		
		// interact with window/tab
		driver.switchTo().window("");
		
		// Any method/command interact with Element
		// driver.findElement]
		//driver.findElement(By.xpath("")).
	}


	public void TC_02_ValidatePageTitle() {

	}


	public void TC_03_LoginFormDisplayed() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}