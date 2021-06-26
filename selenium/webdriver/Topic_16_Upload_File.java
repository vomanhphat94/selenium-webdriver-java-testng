package webdriver;

import java.io.BufferedReader;
import java.io.File;
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

public class Topic_16_Upload_File {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String projectOS = System.getProperty("os.name");
	String imageName1 = "image1.jpg";
	String imageName2 = "image2.jpg";
	String imageName3 = "image3.jpg";
	// Help to detect which OS will be used
	String imagePath_1 = projectPath + getFileSeparator() + "ImageTest" + getFileSeparator() + imageName1;
	String imagePath_2 = projectPath + getFileSeparator() + "ImageTest" + getFileSeparator() + imageName2;
	String imagePath_3 = projectPath + getFileSeparator() + "ImageTest" + getFileSeparator() + imageName3;

//	@BeforeClass
//	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
//		System.out.println(driver.toString());
//		explicitWait = new WebDriverWait(driver, 10);
//
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	}

	
	public void TC_01_Upload_Single_File_Chrome() {
		if(projectOS.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", ".//browerDrivers//chromedriver");
		}
		driver = new ChromeDriver();
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		WebElement uploadFileButton = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFileButton.sendKeys(imagePath_1);
		
		//Verify file uploaded
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + imageName1 + "']")).isDisplayed());
		//Click start Upload
		driver.findElement(By.cssSelector(".files .start")).click();
		
		//Verify File upload to website success
		//a[text()='image1.jpg']
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + imageName1 + "']")).isDisplayed());

	}


	public void TC_01_Upload_Single_File_Firefox() {
		driver = new FirefoxDriver();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		WebElement uploadFileButton = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFileButton.sendKeys(imagePath_1);
		
		//Verify file uploaded
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + imageName1 + "']")).isDisplayed());
		//Click start Upload
		driver.findElement(By.cssSelector(".files .start")).click();
		
		//Verify File upload to website success
		//a[text()='image1.jpg']
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + imageName1 + "']")).isDisplayed());

	}
	
	
	@Test
	public void TC_02_Upload_Multiple_File() {
		// Firefox bản mới mới upload dc multiple file
		if(projectOS.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", ".\\browerDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", ".//browerDrivers//geckodriver");
		}
		driver = new FirefoxDriver();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		WebElement uploadFileButton = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFileButton.sendKeys(imagePath_1 + "\n" + imagePath_2 + "\n" + imagePath_3);
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + imageName1 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + imageName2 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + imageName3 + "']")).isDisplayed());
		
		//Click start Upload
		List<WebElement> startButtons = driver.findElements(By.cssSelector(".files .start"));
		for(WebElement start : startButtons) {
			start.click();
			sleepInSecond(1);
		}
	}

	
	public String getFileSeparator() {
		return File.separator;
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