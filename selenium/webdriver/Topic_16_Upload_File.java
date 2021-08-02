package webdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.support.ui.Sleeper;
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
	String imageName1 = "imagea.jpg";
	String imageName2 = "imageb.jpg";
	String imageName3 = "imagec.jpg";
	// Help to detect which OS will be used
	String imagePath_1 = projectPath + getFileSeparator() + "ImageTest" + getFileSeparator() + imageName1;
	String imagePath_2 = projectPath + getFileSeparator() + "ImageTest" + getFileSeparator() + imageName2;
	String imagePath_3 = projectPath + getFileSeparator() + "ImageTest" + getFileSeparator() + imageName3;
	
	String chromeAutoITPath = projectPath + getFileSeparator() + "ImageTest" + "\\chromeUploadOneTime.exe";
	String firefoxAutoITPath = projectPath + getFileSeparator() + "ImageTest" + "\\firefoxUploadOneTime.exe";
	String chromeAutoITPathMultiple = projectPath + getFileSeparator() + "ImageTest" + "\\chromeUploadMultiple.exe";
	String firefoxAutoITPathMultiple = projectPath + getFileSeparator() + "ImageTest" + "\\firefoxUploadMultiple.exe";

//	@BeforeClass
//	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		//driver = new FirefoxDriver();
//		//System.out.println(driver.toString());
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
		sleepInSecond(3);
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
	

	public void TC_03_Upload_Single_File_Chrome_AutoIT() throws IOException {
//		if(projectOS.contains("Windows")) {
//			System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
//		} else {
//			System.setProperty("webdriver.chrome.driver", ".//browerDrivers//chromedriver");
//		}
//		driver = new ChromeDriver();
		
		if(projectOS.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", ".\\browerDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", ".//browerDrivers//geckodriver");
		}
		driver = new FirefoxDriver();
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
//		WebElement uploadFileButton = driver.findElement(By.xpath("//input[@type='file']"));
//		uploadFileButton.sendKeys(imagePath_1);
		
		// Dùng ToolIT, Robot, Sikuli cần phải click cho mở Window Explorer lên trước
		driver.findElement(By.cssSelector(".btn-success")).click();
		// Xử lí upload bằng AUtoIT
		if(driver.toString().contains("chrome")) {
		Runtime.getRuntime().exec(new String[] {chromeAutoITPath,imagePath_1});
		} else {
			Runtime.getRuntime().exec(new String[] {firefoxAutoITPath,imagePath_1});
		}
		sleepInSecond(5);
		//Verify file uploaded
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + imageName1 + "']")).isDisplayed());
		//Click start Upload
		driver.findElement(By.cssSelector(".files .start")).click();
		sleepInSecond(5);
		//Verify File upload to website success
		//a[text()='image1.jpg']
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + imageName1 + "']")).isDisplayed());

	}
	

	public void TC_04_Upload_Multiple_File_AutoIT() throws IOException {
//		 Firefox bản mới mới upload dc multiple file
//		if(projectOS.contains("Windows")) {
//			System.setProperty("webdriver.gecko.driver", ".\\browerDrivers\\geckodriver.exe");
//		} else {
//			System.setProperty("webdriver.gecko.driver", ".//browerDrivers//geckodriver");
//		}
//		driver = new FirefoxDriver();
		if(projectOS.contains("Windows")) {
		System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
	} else {
		System.setProperty("webdriver.chrome.driver", ".//browerDrivers//chromedriver");
	}
	driver = new ChromeDriver();
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.cssSelector(".btn-success")).click();
		// Xử lí upload bằng AUtoIT
		if(driver.toString().contains("chrome")) {
		Runtime.getRuntime().exec(new String[] {chromeAutoITPathMultiple,imagePath_1, imagePath_2, imagePath_3 });
		} else {
			Runtime.getRuntime().exec(new String[] {firefoxAutoITPathMultiple,imagePath_1,imagePath_2, imagePath_3});
			sleepInSecond(4);
		}
		sleepInSecond(5);
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
	
	@Test
	public void TC_05_Upload_Single_File_Chrome_Robot() throws IOException, AWTException {
//		if(projectOS.contains("Windows")) {
//			System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
//		} else {
//			System.setProperty("webdriver.chrome.driver", ".//browerDrivers//chromedriver");
//		}
//		driver = new ChromeDriver();
		
		if(projectOS.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", ".\\browerDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", ".//browerDrivers//geckodriver");
		}
		driver = new FirefoxDriver();
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		// Xử lý chức năng Upload bằng Java Robot
		driver.findElement(By.cssSelector(".btn-success")).click();
		StringSelection select = new StringSelection(imagePath_1);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		Robot robot = new Robot();
		sleepInSecond(2);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		sleepInSecond(2);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		sleepInSecond(2);
		//Verify file uploaded
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + imageName1 + "']")).isDisplayed());
		//Click start Upload
		driver.findElement(By.cssSelector(".files .start")).click();
		sleepInSecond(5);
		//Verify File upload to website success
		//a[text()='image1.jpg']
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + imageName1 + "']")).isDisplayed());

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