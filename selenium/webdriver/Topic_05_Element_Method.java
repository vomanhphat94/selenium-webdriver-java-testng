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

public class Topic_05_Element_Method {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://automationfc.github.io/multiple-fields/");

	}

	@Test
	public void TC_01_Webelement_Command() {
		WebElement element = driver.findElement(By.xpath(""));
		
		// Có 3 nhóm chính 
		// 1. Action - click, sendkey
		// 2. Lấy dữ liệu - getXXX, getCssValue,.... thường lưu vào variable
		// 3. Kiểm tra - isXX, isEnabled, isSelected,.....true/false/equals
		
		
		// Xóa dữ liệu đã nhập trong 1 textbox/ textarea/ dropdown (Editable)
		element.clear(); //**
		
		// Nhập dữ liệu đã nhập trong 1 textbox/ textarea/ dropdown (Editable)
		element.sendKeys(""); //**
		
		// Click vào button/ checkbox/ radio button/ link/ dropdown/ image...
		element.click(); //**
		
		// Lấy value của attribute
		element.getAttribute("placeholder"); //**

		// lấy ra style của 1 element (font/ size/ color/ background/ --> Dùng để test GUI)
		element.getCssValue("background");
		element.getCssValue("font-size");
		// #3399cc
		// #FFFF
		// 13px
		
		// GUI - get kích thước của 1 element
		element.getLocation();
		element.getSize();
		element.getRect();
		
		// Chụp hình lỗi đưa vào report -> Framework
		//element.getScreenshotAs(target);
		
		// Đầu ra của hàm này là tên của thẻ -> dùng cho đầu vào của 1 element khác ( tagname trong xpath)
		String emailtextboxTagname = element.getTagName();
		// After that
		driver.findElement(By.xpath(("//" + emailtextboxTagname+ "[@id='email'")));
		
		// Lấy ra text của 1 element bất kì ( label/ header/ span/ div/ ....) - text này k nằm trong attribute
		element.getText(); //**
		
		
		// Kiểm tra xem 1 element có hiển thị lên không
		element.isDisplayed(); //**
		// Kiểm tra mong muốn element đang hiển thị
		Assert.assertTrue(element.isDisplayed()); //**
		Assert.assertTrue(element.isSelected()); //**
		Assert.assertTrue(element.isEnabled());
		// Kiểm tra không mong muốn element hiển thị
		Assert.assertFalse(element.isDisplayed());
		
		// ENTER vào trong 1 form ( chỉ dùng được vs form )
		element.submit();
		
		
	}


	public void TC_02_Demo() {
		// 1. Thao tác trực tiếp lên element + k cần khai báo biến 
		// Chỉ dùng 1 lần duy nhất thì k cần khai báo biến 
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("gauluoi@yopmail.com");
		 
		
		
		// 2. Khai báo biến rồi mới thao tác (action: click/ sendkey/ getText/ select/...)
		// Để dùng nhìu lần, không phải viết lại code
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='pass']"));

		
		// 
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");

		
		// Nếu như muốn thao tác với 1 element: WebElement
		// nếu như muốn thao tác với nhiều element (2 trở lên): List <WebElement>
		// driver.findElements(By.xpath("//input[@id='email']")).sendKeys("gauluoi@yopmail.com");
	
		
		
		
		
		//Giả sử không có list, phải click rất nhìu lần

//		driver.findElement(By.xpath("//label[contains(text(),'Anemia')]/preceding-sibling::input")).click();
//		driver.findElement(By.xpath("//label[contains(text(),'Anemia')]/preceding-sibling::input")).click();
//		driver.findElement(By.xpath("//label[contains(text(),'Anemia')]/preceding-sibling::input")).click();
//		driver.findElement(By.xpath("//label[contains(text(),'Anemia')]/preceding-sibling::input")).click();
//		driver.findElement(By.xpath("//label[contains(text(),'Anemia')]/preceding-sibling::input")).click();
		
//		//Giả sử có list
//		List <WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
//		System.out.println("Total checkbox in this page =" + checkboxes.size());
//		
//		for (WebElement checkbox : checkboxes) {
//			checkbox.click();
//		}
	}


	public void TC_03_LoginFormDisplayed() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}