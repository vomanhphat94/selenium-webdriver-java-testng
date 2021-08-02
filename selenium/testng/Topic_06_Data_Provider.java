package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Topic_06_Data_Provider {
	WebDriver driver;
	By emailTextBox = By.xpath("//*[@id='email']");
	By passwordTextBox = By.xpath("//*[@id='pass']");
	By loginButton = By.xpath("//*[@id='send2']");
	
	
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Before Class");
		  // Mở Browser lên
		  // Init driver lên
		  // Nếu như trong before class mà fail thì các testcase bên dưới/after class không giờ chạy
		  // Giả sử run 20 class Test -> mở ra 20 browser, mà before k run dc -> After k run dc -> Phải tự đi tắt manual 20 browser
		  System.setProperty("webdriver.gecko.driver", ".\\browerDrivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
		 // Assert.assertTrue(false);
	  }

		@Test(dataProvider = "user_pass")
		  public void TC_01_Register(String username, String password) {
			driver.findElement(By.id("firstname")).sendKeys("Automation");
			driver.findElement(By.id("lastname")).sendKeys("FFFF");
			driver.findElement(By.id("email_address")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("confirmation")).sendKeys(password);
			driver.findElement(By.xpath("//button[@title='Register']")).click();
			driver.findElement(By.xpath("//header[@id='header']//span[text()='Account")).click();
			 driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			
		} 
	@Test(dataProvider = "user_pass")
	  public void TC_02_Login(String username, String password) {
		 driver.findElement(emailTextBox).sendKeys(username);
		 driver.findElement(passwordTextBox).sendKeys(password);
		 driver.findElement(loginButton).click();
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(username));
		 driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		 driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		 
	  } 
	
	
	
	@DataProvider(name = "user_pass")
	public Object[][] UserAndPasswordData() {
		return new Object[][] {
			{"bearvo_11_01@gmail.com","111111"},
			{"bearvo_11_02@gmail.com","111111"},
			{"bearvo_11_03@gmail.com","111111"}};
	}


	

	  @AfterClass(alwaysRun = true)
	  public void afterClass() {
		  System.out.println("After Class");
		  // Close Browser 
		  // Close driver 
		  driver.quit();
	  }

}
