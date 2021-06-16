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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Frame_iFrame {
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

	
	public void TC_01_iFrame() {
		driver.get("https://automationfc.com/2020/02/18/training-online-automation-testing/");
		sleepInSecond(2);
//		
//		driver.switchTo().frame(4);
//		
//		driver.switchTo().frame("");
		
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title, 'Face')]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='fb-page fb_iframe_widget']//iframe[contains(@title, 'Face')]")));
		sleepInSecond(2);
		
		String likefbNumber = driver.findElement(By.xpath("//a[text()='Automation FC']/parent::div/following-sibling::div")).getText();
		sleepInSecond(2);

		System.out.println(likefbNumber);
		
		driver.switchTo().defaultContent();
		sleepInSecond(2);

//		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='freebirdFormviewerViewFormContentWrapper']//iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'docs.google.com')]")));
		sleepInSecond(2);

		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='KHÓA HỌC SELENIUM AUTOMATION TESTING']")).isDisplayed());
		
	}

	@Test
	public void TC_02_iFrame_chatbox() {
		driver.get("https://kyna.vn/");
		sleepInSecond(2);
//		driver.switchTo().frame("cs_chat_iframe");
//		sleepInSecond(2);
//		driver.findElement(By.cssSelector("div.meshim_widget_widgets_BorderOverlay")).click();
//		sleepInSecond(2);
//		driver.findElement(By.cssSelector("input.input_name")).sendKeys("Bear");
//		driver.findElement(By.cssSelector("input.input_phone")).sendKeys("123456678");
//		select = new Select(driver.findElement(By.id("serviceSelect")));
//		//select.selectByVisibleText("HỖ TRỢ KỸ THUẬT");
//		select.selectByValue("60021807");
//		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("hello");
//		
//		driver.findElement(By.cssSelector("div.overlay")).click();
//		driver.switchTo().defaultContent();
		driver.findElement(By.id("live-search-bar")).sendKeys("Excel");
		driver.findElement(By.className("search-button")).click();
		
		List<WebElement> excelText = driver.findElements(By.cssSelector(".content>h4"));
		for (WebElement text : excelText) {
			Assert.assertTrue(text.getText().contains("Excel"));
			System.out.println(text.getText());
		}
	}
	

	public void TC_03_Popup_NotIn_DOM() {

	}
	

	public void TC_04_Popup_In_DOM_And_Condition() {
	

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