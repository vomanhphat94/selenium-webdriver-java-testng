package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Element_Method_part2 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}


	public void TC_01_Verify_isDisplay() {

		driver.get("https://automationfc.github.io/basic-form/index.html");
		Boolean emailTextbox = driver.findElement(By.xpath("//input[@id='mail']")).isDisplayed();
		if (emailTextbox) {
		  System.out.println("Email textbox is displayed");
		  driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("automation@yopmail.com");
		} else {
			System.out.println("Email textbox is not displayed");
		}
		
		Boolean educationTextbox = driver.findElement(By.xpath("//textarea[@id='edu']")).isDisplayed();
		if (educationTextbox) {
			  System.out.println("Education textbox is displayed");
			  driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("automation@yopmail.com");
			} else {
				System.out.println("Education textbox is not displayed");
		}
		Boolean undereightteenCheckbox = driver.findElement(By.xpath("//input[@id='under_18']")).isDisplayed();
		if (undereightteenCheckbox) {
			System.out.println("under eighteen check box is displayed");
			driver.findElement(By.xpath("//input[@id='under_18']")).click();
		} else {
			System.out.println("under eighteen check box is not displayed");
		}
		
		Boolean nameUserFive = driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed();
		if (nameUserFive) {
			System.out.println("name User 5 is displayed");
		} else {
			System.out.println("name User 5 is not displayed");
		}
		
	}

	
	public void TC_02_Verify_isEnable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		Boolean emailTextbox = driver.findElement(By.xpath("//input[@id='mail']")).isEnabled();
		if (emailTextbox) {
		  System.out.println("Email textbox is enabled");
		  driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("automation@yopmail.com");
		} else {
			System.out.println("Email textbox is disabled");
		}
		
		Boolean educationTextbox = driver.findElement(By.xpath("//textarea[@id='edu']")).isEnabled();
		if (educationTextbox) {
			  System.out.println("Education textbox is enabled");
			  driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("automation@yopmail.com");
			} else {
				System.out.println("Education textbox is disabled");
		}
		Boolean undereightteenCheckbox = driver.findElement(By.xpath("//input[@id='under_18']")).isEnabled();
		if (undereightteenCheckbox) {
			System.out.println("under eighteen check box is enabled");

		} else {
			System.out.println("under eighteen check box is disabled");
		}
		
		Boolean job1Dropdown = driver.findElement(By.xpath("//select[@id='job1']")).isEnabled();
		if (job1Dropdown) {
			System.out.println("job 1 is enabled");
	
		} else {
			System.out.println("job 1 is disabled");
		}
		Boolean job2Dropdown = driver.findElement(By.xpath("//select[@id='job2']")).isEnabled();
		if (job2Dropdown) {
			System.out.println("job 2 is enabled");

		} else {
			System.out.println("job 2 is disabled");
		}
		
		Boolean developmentCheckbox = driver.findElement(By.xpath("//input[@id='development']")).isEnabled();
		if (developmentCheckbox) {
			System.out.println("developmentCheckbox is enabled");
		} else {
			System.out.println("developmentCheckbox is disabled");
		}
		Boolean slider1 = driver.findElement(By.xpath("//input[@id='slider-1']")).isEnabled();
		if (slider1) {
			System.out.println("slider1 is enabled");
		} else {
			System.out.println("slider1 is disabled");
		}
		
		Boolean slider2 = driver.findElement(By.xpath("//input[@id='slider-2']")).isEnabled();
		if (slider2) {
			System.out.println("slider2 is enabled");
		} else {
			System.out.println("slider2 is disabled");
		}
	}

	@Test
	public void TC_03_isSelected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//input[@id='under_18']")).click();
		driver.findElement(By.xpath("//input[@id='java']")).click();
		//Boolean checkbox18 = driver.findElement(By.xpath("//input[@id='under_18']")).isSelected();
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='java']")).isSelected());
		
		driver.findElement(By.xpath("//input[@id='under_18']")).click();
		driver.findElement(By.xpath("//input[@id='java']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='java']")).isSelected());
		
//		if (checkbox18) {
//			System.out.println("checkbox18 is selected");
//		} else {
//			System.out.println("checkbox18 is not selected");
//		}
//		Boolean checkboxJava = driver.findElement(By.xpath("//input[@id='java']")).isSelected();
//		if (checkboxJava) {
//			System.out.println("checkboxJava is selected");
//		} else {
//			System.out.println("checkboxJava is not selected");
//		}
//		
//		driver.findElement(By.xpath("//input[@id='java']")).click();
//		checkboxJava = driver.findElement(By.xpath("//input[@id='java']")).isSelected();
//		if (checkboxJava) {
//			System.out.println("checkboxJava is selected");
//		} else {
//			System.out.println("checkboxJava is not selected");
//		}
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}