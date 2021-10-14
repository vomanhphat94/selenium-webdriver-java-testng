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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Topic_17_Wait_Element_Status_Part2 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		System.out.println(driver.toString());
		driver.manage().window().maximize();
	}

	
	public void TC_01_FindElement() {
		driver.get("http://facebook.com");
		// Tìm được 1 element
		// Nếu như tìm thấy ngay thì k cần chờ hết timeout
		// Nếu chưa tìm thấy thì tiếp tục chờ - trong thời gian chờ mỗi 0.5s sẽ tìm lại 1 lần
		// Nếu tìm thấy vẫn đang còn trong thời gian chờ thì k cần chờ hết timeout
		// Chuyển qua step kế
		System.out.println("Start -" + getDateTimeNow());
		driver.findElement(By.id("email"));
		System.out.println("End -" + getDateTimeNow());
		// Tìm thấy nhiều hơn 1 element
		// nó sẽ thao tác với element đầu tiên ( K quan tâm element này ẩn hay hiện)
		System.out.println("Start -" + getDateTimeNow());
		driver.findElement(By.xpath("//input[@id='email' or @id='pass']")).sendKeys("hello@gmail.com");;
		System.out.println("End -" + getDateTimeNow());
		// Tìm không thấy element nào
		// Chờ hết timeout rồi mà vẫn không tìm thấy element
		// Đánh testcase này fail ngay lập tức tại đúng step này
		// Throw ra 1 exception
		System.out.println("Start -" + getDateTimeNow());
		driver.findElement(By.id("emailaaaaa"));
		System.out.println("End -" + getDateTimeNow());

	}


	public void TC_02_FindElements() {
		// Tìm được 1 element
		// Nếu như tìm thấy ngay thì k cần chờ hết timeout
		// Nếu chưa tìm thấy thì tiếp tục chờ - trong thời gian chờ mỗi 0.5s sẽ tìm lại 1 lần
		// Nếu tìm thấy vẫn đang còn trong thời gian chờ thì k cần chờ hết timeout
		// Chuyển qua step kế
		// Lưu nó vào trong List ( Chỉ có duy nhất 1 element
		driver.get("http://facebook.com");
		System.out.println("Start -" + getDateTimeNow());
		List<WebElement> elements = driver.findElements(By.id("email"));
		System.out.println(elements.size());
		System.out.println("End -" + getDateTimeNow());
		// Tìm thấy nhiều hơn 1 element
		// Lưu vào trong list và chứa các element thỏa mãn điều kiện
		System.out.println("Start -" + getDateTimeNow());
		elements = driver.findElements(By.xpath("//input"));
		System.out.println(elements.size());
		System.out.println("End -" + getDateTimeNow());
		// Tìm không thấy element nào
		// Chờ hết timeout rồi mà vẫn không tìm thấy element
		// Nhưng không đánh tcs này failed vì nó trả ra list rỗng
		// Chuyển qua step kế 
		System.out.println("Start -" + getDateTimeNow());
		elements = driver.findElements(By.id("emailasdasd"));
		System.out.println(elements.size());
		System.out.println("End -" + getDateTimeNow());
	}

	public void TC_03_FindElements() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(checkboxes.size());
		for (WebElement singlecheckbox : checkboxes) {
			singlecheckbox.click();
		}
	}
	

	public void TC_04_ImplicitWait_Not_Set() {
		driver.get("https://juliemr.github.io/protractor-demo/");
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("6");
		driver.findElement(By.id("gobutton")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText(), "11");
	}
	

	public void TC_05_ImplicitWait_Invalid_Locator() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://juliemr.github.io/protractor-demo/");
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("6");
		driver.findElement(By.id("gobutton")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText(), "11");
	}
	

	public void TC_06_ImplicitWait_valid_Locator() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://juliemr.github.io/protractor-demo/");
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("6");
		driver.findElement(By.id("gobutton")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='ng-binding' and text()='11']")).getText(), "11");
	}
	@Test
	public void TC_07_ImplicitWait_valid_Locator_with_limit_time() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://juliemr.github.io/protractor-demo/");
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("6");
		driver.findElement(By.id("gobutton")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='ng-binding' and text()='11']")).getText(), "11");
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