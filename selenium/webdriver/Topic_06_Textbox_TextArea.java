package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Textbox_TextArea {

	WebDriver driver;
	String userID = "mngr303746";
	String userPassword = "avAsAgE";
	String generateAccess = "automationfc@gmail.com";
	String pageTitle = "Guru99 Bank Manager HomePage";
	String customerName = "automation";
	String customerDateofBirth ="1994-10-10";
	String customerAddress ="111 NTH HCM";
	String customerAddress_2 ="111 NTH HCM 111";
	String customerCity = "HCM";
	String customerCity_2 = "HCM SG";
	String customerState = "NTH";
	String customerState_2 = "NTH BT";
	String customerPIN = "123456";
	String customerPIN_2 = "654321";
	String customerMobile = "111333777999";
	String customerMobile_2 = "999777333111";
//	String customerEmail = "automationfresher@yopmail.com";
	String customerPassword ="abcd1234";
	String customerGender ="male";
	
	// Khi mà driver và browser chưa được khởi tạo + app cũng chưa mở lên -> tìm element ở đâu ?
	//WebElement emailTextbox = driver.findElement(By.name("emailid"));
	By emailTextbox = By.name("emailid");
	By useridTextbox = By.name("uid");
	By nameTextbox = By.name("name");
	By dobTextbox = By.name("dob");
	By addrTextbox = By.name("addr");
	By cityTextbox = By.name("city");
	By stateTextbox = By.name("state");
	By pinnoTextbox = By.name("pinno");
	By telephoneTextbox = By.name("telephoneno");
	By passwordTextbox = By.name("password");
	
	
	Random randomGenerator = new Random();  
	int randomInt = randomGenerator.nextInt(100000);  
	String customerEmail = "username" + randomInt +"@gmail.com";

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}

	@Test
	public void TC_01_Execute_Textbox_Textarea() {
		driver.get("http://demo.guru99.com/v4");
		driver.findElement(useridTextbox).sendKeys(userID);
		driver.findElement(passwordTextbox).sendKeys(userPassword);
		driver.findElement(By.name("btnLogin")).click();
		Assert.assertEquals(driver.getTitle(), pageTitle);
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		driver.findElement(nameTextbox).sendKeys(customerName);
		driver.findElement(dobTextbox).sendKeys(customerDateofBirth);
		driver.findElement(addrTextbox).sendKeys(customerAddress);
		driver.findElement(cityTextbox).sendKeys(customerCity);
		driver.findElement(stateTextbox).sendKeys(customerState);
		driver.findElement(pinnoTextbox).sendKeys(customerPIN);
		driver.findElement(telephoneTextbox).sendKeys(customerMobile);
		driver.findElement(emailTextbox).sendKeys(customerEmail);
		driver.findElement(passwordTextbox).sendKeys(customerPassword);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
		System.out.println(customerID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), customerName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), customerAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), customerCity);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), customerState);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), customerPIN);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), customerMobile);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), customerEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), customerDateofBirth);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), customerGender);

		
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		driver.findElement(By.name("cusid")).sendKeys(customerID);
		driver.findElement(By.name("AccSubmit")).click();
		
		Assert.assertFalse(isElementEnabled(nameTextbox));
		Assert.assertEquals(driver.findElement(nameTextbox).getAttribute("value"), customerName);
		
		Assert.assertFalse(isElementEnabled(By.xpath("//input[@name='gender']")));
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='gender']")).getAttribute("value"), customerGender);
		
		Assert.assertFalse(isElementEnabled(dobTextbox));
		Assert.assertEquals(driver.findElement(dobTextbox).getAttribute("value"), customerDateofBirth);
		
		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@name='addr']")).getText(), customerAddress);
		

		driver.findElement(cityTextbox).clear();
		driver.findElement(cityTextbox).sendKeys(customerCity_2);
		driver.findElement(stateTextbox).clear();
		driver.findElement(stateTextbox).sendKeys(customerState_2);
		driver.findElement(pinnoTextbox).clear();
		driver.findElement(pinnoTextbox).sendKeys(customerPIN_2);
		driver.findElement(telephoneTextbox).clear();
		driver.findElement(telephoneTextbox).sendKeys(customerMobile_2);
		driver.findElement(By.name("sub")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), customerName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), customerAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), customerCity_2);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), customerState_2);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), customerPIN_2);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), customerMobile_2);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), customerEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), customerDateofBirth);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), customerGender);

	}


	public void TC_02_Login() {
	}
	
	public void TC_03_New_Customer() {
	}
	
	public void TC_04_Edit_Customer() {
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	public boolean isElementEnabled(By by) {
		WebElement element = driver.findElement(by);
		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}


}