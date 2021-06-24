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

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_11_User_Interaction {
	WebDriver driver;
	WebDriverWait explicitWait;
	WebDriverWait explicitWait2;
	JavascriptExecutor jsExecutor;
	Alert alert;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\browserDrivers\\chromedriver.exe" );
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		System.out.println(driver.toString());

		action = new Actions(driver);
		explicitWait = new WebDriverWait(driver, 10);
		jsExecutor = (JavascriptExecutor) driver;
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Hover_Mouse() {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		action.moveToElement(driver.findElement(By.xpath("//a[text()='ThemeRoller']"))).perform();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText(), "ThemeRoller: jQuery UI's theme builder application");
		// Chú ý khi run TCs liên quan chuột/bàn phím thì nó sẽ ảnh hưởng TCs , vd như TCs đang hover vào, mình đưa chuột vô là nó mất 
	}
	
	public void TC_02_Hover_Mouse_II() {
		driver.get("https://hn.telio.vn/");
		action.moveToElement(driver.findElement(By.xpath("//main[@id='maincontent']//span[text()='Đồ uống']"))).perform();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//main[@id='maincontent']//a[text()='Cà phê']")).getText(), "Cà phê");
		
		driver.findElement(By.xpath("//main[@id='maincontent']//a[text()='Cà phê']")).click();
	}
	
	
	public void TC_03_Click_And_Hold() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		List<WebElement> numberCanSelect = driver.findElements(By.xpath("//*[@id='selectable']/li"));
		Assert.assertEquals(numberCanSelect.size(), 12);


		action.clickAndHold(numberCanSelect.get(0)).moveToElement(numberCanSelect.get(3)).release().perform();
		sleepInSecond(3);
		List<WebElement> numberSelected = driver.findElements(By.xpath("//*[@id='selectable']/li[contains(@class,'ui-selected')]"));
		for (WebElement number : numberSelected) {
			System.out.println(number.getText());
		}
		Assert.assertEquals(numberSelected.size(), 4);
		
	}
	
	public void TC_03_Click_And_Hold_Random() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		List<WebElement> numberCanSelect = driver.findElements(By.xpath("//*[@id='selectable']/li"));
		Assert.assertEquals(numberCanSelect.size(), 12);

		action.keyDown(Keys.CONTROL).perform();
		action.click(numberCanSelect.get(1)).click(numberCanSelect.get(3)).click(numberCanSelect.get(8)).click(numberCanSelect.get(9)).perform();
		action.keyUp(Keys.CONTROL).perform();

		sleepInSecond(3);
		List<WebElement> numberSelected = driver.findElements(By.xpath("//*[@id='selectable']/li[contains(@class,'ui-selected')]"));
		for (WebElement number : numberSelected) {
			System.out.println(number.getText());
		}
		Assert.assertEquals(numberSelected.size(), 4);
		
	}
	
	public void TC_04_Double_Click() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(), "Hello Automation Guys!");

	}
	
	
	public void TC_05_Right_Click() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		
		//Verify Quit button display after Right QUit
		Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]")).isDisplayed());
		
		// Hover to QUit
		action.moveToElement(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]"))).perform();
		
		// Verify Quit button
		Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') and contains(@class, 'context-menu-hover') and contains(@class,'context-menu-visible')]")).isDisplayed());
	
		// Click to Quit
		action.click(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]"))).perform();
		sleepInSecond(3);
		
		// Verify noti
		Assert.assertEquals(driver.switchTo().alert().getText(), "clicked: quit");
		
		driver.switchTo().alert().accept();
		
		Assert.assertFalse(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]")).isDisplayed());
		
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