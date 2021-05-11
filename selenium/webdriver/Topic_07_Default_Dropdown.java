package webdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Default_Dropdown {

	WebDriver driver;
	Select select;
	Select select_2;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	Actions action;
	
	String firstName, lastname, email, company, password;
	
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		firstName = "Bear";
		lastname = "Vo";
		// Email phải khai báo ở dưới vì mỗi lần chạy TCs nó sẽ chạy new cái mới, chứ khai bao trên này nó sẽ giữ nguyên 
		//email = "bear" + getRandomNumber() + "@yopmail.com";
		company = "TC";
		password = "abcd1234";
		
		explicitWait = new WebDriverWait(driver, 20);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);

	}

//	@Test(invocationCount = 1)
	public void TC_01_Create_Account_Selectbox() {
		// Open Register Page
		driver.get("https://demo.nopcommerce.com");
		driver.findElement(By.cssSelector(".ico-register")).click();
		
		// Fill required fields
		checkToCheckBoxOrRadio(By.cssSelector("#gender-male"));
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastname);

		// Check this dropdown support Multiple or not
		//Assert.assertFalse(select_2.isMultiple());
		
		// Khởi tạo biến Select để thao tác với dropdown
		select_2 = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		// Text 
		System.out.println(select_2.getAllSelectedOptions());
		select_2.selectByVisibleText("30");
		System.out.println(select_2.getFirstSelectedOption().getText());
		Assert.assertEquals(select_2.getFirstSelectedOption().getText(), "30");
		Assert.assertEquals(select_2.getOptions().size(), 32);
		
		// Kiểm tra item trong dropdown đó
		select_2.getOptions();
		List<WebElement> allDate = select_2.getOptions();
		//System.out.println(allDate);
		// Kiểm tra số lượng có bằng với mong muốn hay không
		//Assert.assertEquals(allDate.size(), 32); // 31 ngày + default value )
		for (WebElement item : allDate) {
			System.out.println(item.getText());
		}

		// Có nhìu cách dùng 
		// Index ( Index này start từ 1 , not 0 )
		//select_2.selectByIndex(31);
		//sleepInSecond(5);
		// Value
		//select_2.selectByValue("15");
		//sleepInSecond(5);
		select_2 = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		
		select_2.selectByVisibleText("October");
		System.out.println(select_2.getFirstSelectedOption().getText());
		Assert.assertEquals(select_2.getFirstSelectedOption().getText(), "October");
		select_2 = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		select_2.selectByVisibleText("1994");
		System.out.println(select_2.getFirstSelectedOption().getText()); 
		Assert.assertEquals(select_2.getFirstSelectedOption().getText(), "1994");
		email = "bear" + getRandomNumber() + "@yopmail.com";
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Company")).sendKeys(company);
		checkToCheckBoxOrRadio(By.id("Newsletter"));
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
		//sleepInSecond(5);
		
		driver.findElement(By.xpath("//button[@name='register-button']")).click();
		driver.findElement(By.xpath("//button[@name='register-button']")).click();
		// Check message register successfully
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector(".result")).getText(), "Your registration completed");
		sleepInSecond(2);
		driver.findElement(By.cssSelector(".ico-logout")).click();
	}

//	@Test
	public void TC_02_Multiple_Selectbox() {
		// Open Register Page
		driver.get("https://automationfc.github.io/basic-form/");
		select = new Select(driver.findElement(By.xpath("//select[@id='job2']")));
		
		ArrayList<String> allItemText = new ArrayList<String>();
		allItemText.add("Automation");
		allItemText.add("Mobile");
		allItemText.add("Functional UI");

		for (String item : allItemText) {
			select.selectByVisibleText(item);
		}
		sleepInSecond(3);
//		select.selectByVisibleText("Automation");
//		select.selectByVisibleText("Mobile");
//		select.selectByVisibleText("Functional UI");
		
		Assert.assertTrue(select.isMultiple());
	
		// kiểm tra đã chọn đúng 3 items chưa
		List<WebElement> allSelectedItems = select.getAllSelectedOptions(); 
		ArrayList<String> allSelectedText = new ArrayList<String>();
		for (WebElement item : allSelectedItems) {
			allSelectedText.add(item.getText());
			
		}
		Assert.assertEquals(allSelectedText.size(), 3);
		Assert.assertEquals(allSelectedText, allItemText);
	}

	public void checkToCheckBoxOrRadio (By by) {
		WebElement element = driver.findElement(by);
		if (!element.isSelected()) {
			element.click();
		}
	}
	public void uncheckToCheckBoxo (By by) {
		WebElement element = driver.findElement(by);
		if (element.isSelected()) {
			element.click();
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
	
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
}