package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Multiple_Parallel {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	
	
	@Parameters({"browser", "url"})
	  @BeforeClass
	  public void beforeClass(@Optional("firefox") String browserName, String urlValue) {
			if(browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				
			} else if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDrivers\\chromedriver.exe");
				driver = new ChromeDriver();
				
			} else if (browserName.equals("edge")) {
				System.setProperty("webdriver.edge.driver", projectLocation + "\\browserDrivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			} else {
				throw new RuntimeException("The browser name is not correct!");
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  System.out.println("Before Class");
			driver.get(urlValue);
			sleepInSecond(2);
			driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='fb-page fb_iframe_widget']//iframe[contains(@title, 'Face')]")));
			sleepInSecond(2);
			String likefbNumber = driver.findElement(By.xpath("//a[text()='Automation FC']/parent::div/following-sibling::div")).getText();
			sleepInSecond(2);
			System.out.println(likefbNumber);
			driver.switchTo().defaultContent();
			sleepInSecond(2);

	  }
	@Test
	  public void TC_01_iFrame() {
			//driver.get("https://automationfc.com/2020/02/18/training-online-automation-testing/");
			sleepInSecond(2);
			driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='fb-page fb_iframe_widget']//iframe[contains(@title, 'Face')]")));
			sleepInSecond(2);
			String likefbNumber = driver.findElement(By.xpath("//a[text()='Automation FC']/parent::div/following-sibling::div")).getText();
			sleepInSecond(2);
			System.out.println(likefbNumber);
			driver.switchTo().defaultContent();
			sleepInSecond(2);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'docs.google.com')]")));
			sleepInSecond(2);
			Assert.assertTrue(driver.findElement(By.xpath("//div[text()='KHÓA HỌC SELENIUM AUTOMATION TESTING']")).isDisplayed());
			
		}
	
		public void sleepInSecond(long second) {
			try {
				Thread.sleep(second * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	  @AfterClass(alwaysRun = true)
	  public void afterClass() {
		  System.out.println("After Class");
		  // Close Browser 
		  // Close driver 
		  driver.quit();
	  }

}
