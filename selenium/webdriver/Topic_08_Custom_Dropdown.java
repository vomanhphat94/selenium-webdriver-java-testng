package webdriver;

import static org.testng.Assert.assertThrows;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	
	String[] months_1 = {"January", "May", "October", "December" };
	String[] months_2 = {"January", "May", "October" };
	String[] months_3 = {"January", "May", "October", "December" };
	String[] months_4 = {""};

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\browserDrivers\\chromedriver.exe" );
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void TC_01_Jquery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "12");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(), "12" );
		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "1");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(), "1" );
		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "19");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(), "19" );
		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "6");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(), "6" );
	}


	public void TC_02_NopCommerce() {
		selectItemInCustomDropdown("//select[@name='DateOfBirthDay']", "//select[@name='DateOfBirthDay']//option", "12");
		selectItemInCustomDropdown("//select[@name='DateOfBirthMonth']", "//select[@name='DateOfBirthMonth']//option", "October");
		selectItemInCustomDropdown("//select[@name='DateOfBirthYear']", "//select[@name='DateOfBirthYear']//option", "1994");

	}
	
	
	
	public void TC_03_Angular() {
		driver.get("https://ej2.syncfusion.com/angular/demos/?_ga=2.262049992.437420821.1575083417-524628264.1575083417#/material/drop-down-list/data-binding");

		selectItemInCustomDropdown("//ejs-dropdownlist[@id='games']", "//ul[@id='games_options']/li", "Golf");
		sleepInSecond(2);
		// This Assert will fail because have element matching node but it not show on UI with highlight. Text not in DOM
//		Assert.assertTrue(driver.findElement(By.xpath("//select[@name='games']/option[@selected and text()='Golf']")).isDisplayed());
		Assert.assertEquals(getAngularDropdownSelectedText(), "Golf");
		
		selectItemInCustomDropdown("//ejs-dropdownlist[@id='games']", "//ul[@id='games_options']/li", "Badminton");
		sleepInSecond(2);
		Assert.assertEquals(getAngularDropdownSelectedText(), "Badminton");
	}
	
	
	public void TC_04_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

		selectItemInCustomDropdown("//div[@role='listbox']", "//div[@role='option']/span", "Christian");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Christian");
		selectItemInCustomDropdown("//div[@role='listbox']", "//div[@role='option']/span", "Stevie Feliciano");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Stevie Feliciano");
		selectItemInCustomDropdown("//div[@role='listbox']", "//div[@role='option']/span", "Matt");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Matt");

	}
	
	
	public void TC_05_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		selectItemInCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "Second Option");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "Second Option");
		
		selectItemInCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "First Option");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "First Option");
		
		selectItemInCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "Third Option");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "Third Option");
		
	}
	
	
	public void TC_06_Editable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		selectItemInEditableDropdown("//input[@class='search']", "//div[@role='option']//span", "Albania");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Albania");
		
		selectItemInEditableDropdown("//input[@class='search']", "//div[@role='option']//span", "Benin");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Benin");
		
		selectItemEditableDropdown("//input[@class='search']", "Austria");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Austria");
		
		selectItemEditableDropdown("//input[@class='search']", "Albania");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Albania");

	}
	
	@Test
	public void TC_07_Multiple_Select() {
		driver.get("https://multiple-select.wenzhixin.net.cn/templates/template.html?v=189&url=basic.html");
		selectMultipleInCustomDropdown("(//button[@class='ms-choice'])[1]", "(//div[@class='ms-drop bottom'])[1]//li//span", months_1);
		sleepInSecond(2);
		Assert.assertTrue(verifyItemsSelected(months_1));
		
		driver.navigate().refresh();
		
		selectMultipleInCustomDropdown("(//button[@class='ms-choice'])[1]", "(//div[@class='ms-drop bottom'])[1]//li//span", months_2);
		sleepInSecond(2);
		Assert.assertTrue(verifyItemsSelected(months_2));

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* Hành vi của 1 dropdown:
	 * - Click vào dropdown
	 * - Chờ các item dc hiển thị ra
	 * - Tìm cái item cần chọn -> Lấy ra text của item mình muốn -> So sánh vs cái mình expect -> Bằng nhau
	 *   + Item mình cần nó nằm trong tầm nhìn thấy của User -> Click luôn
	 *   + Item không nằm trong tầm nhìn thấy (viewport) -> Scroll xuống -> Click
	 * - Bấm vào
	 * - Kiểm tra xem đã chọn đúng chưa
	 * */
	public void selectItemInCustomDropdown (String parentXpath, String allItemXpath, String expectedText) {
		// Click vào dropdown
		driver.findElement(By.xpath(parentXpath)).click();
		sleepInSecond(2);
		
		// Chờ cho các item được hiển thị trước khi chọn
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
		
		//  lấy tất cả item con đưa vào 1 list để duyệt qua 
		List <WebElement> allItem = driver.findElements(By.xpath(allItemXpath));
		// Có thể ghi List <WebElement> allItem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

		// Dùng vòng lặp duyệt qua từng item
		for (WebElement item : allItem) {
			// Duyệt qa từng cái và getText ra
			// Nếu như text get ra bằng vs text mong muốn thì dừng lại và click vào item đó luôn
			// Thoát khỏi vòng lặp
			if(item.getText().equals(expectedText)) {
				System.out.println("This is my selected item: " + item.getText());
				item.click();
				break;
			}
			
		}
	}
	
	public void selectItemInEditableDropdown (String parentXpath, String allItemXpath, String expectedText) {
		// Click vào dropdown
		
		driver.findElement(By.xpath(parentXpath)).clear();
		driver.findElement(By.xpath(parentXpath)).sendKeys(expectedText);
		sleepInSecond(2);
		
		// lấy tất cả item con đưa vào 1 list để duyệt qua 
		List <WebElement> allItem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
		
		// Dùng vòng lặp duyệt qua từng item
		for (WebElement item : allItem) {
			// Duyệt qa từng cái và getText ra
			// Nếu như text get ra bằng vs text mong muốn thì dừng lại và click vào item đó luôn
			// Thoát khỏi vòng lặp
			if(item.getText().equals(expectedText)) {
				System.out.println("This is my selected item: " + item.getText());
				item.click();
				break;
			}
			
		}
	}
	public void selectItemEditableDropdown (String parentXpath, String expectedText) {
		// Click vào dropdown
		
		driver.findElement(By.xpath(parentXpath)).clear();
		driver.findElement(By.xpath(parentXpath)).sendKeys(expectedText);
		sleepInSecond(2);
		driver.findElement(By.xpath(parentXpath)).sendKeys(Keys.TAB);
		
	}
	
	

	public void selectMultipleInCustomDropdown (String parentXpath, String allItemXpath, String[] months) {
		driver.findElement(By.xpath(parentXpath)).click();
		sleepInSecond(2);
	
		List <WebElement> allItem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
//		String[] months = {"January", "May", "October", "December" };
		for (String month : months) {
			for (WebElement item : allItem) {
				if(item.getText().equals(month)) {
					System.out.println("This is my selected item: " + item.getText());
					item.click();
					break;
				}
			}
				
		}
	}

	public boolean verifyItemsSelected(String[] months) {
		List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='selected']"));
		int numberItemSelected = itemSelected.size();
		System.out.println(numberItemSelected);
		
		String allItemSelectedText = driver.findElement(By.xpath("(//button[@class='ms-choice']/span)[1]")).getText();
		System.out.println("Text selected:" + allItemSelectedText);
		
		if (numberItemSelected <=3 && numberItemSelected > 0) {
			for (String item : months) {
				if (allItemSelectedText.contains(item)) {
					System.out.println("Item selected below or equal 3");
					break;
				}
			}
			return true;
		} else if (numberItemSelected >= 12){
			return driver.findElement(By.xpath("//button[@class='ms-choice']/span[text()='All selected']")).isDisplayed();
		} else if (numberItemSelected > 3 && numberItemSelected < 12){
			return driver.findElement(By.xpath("//button[@class='ms-choice']/span[text()='" + numberItemSelected + " of 12 selected']")).isDisplayed();
		} else {
			new RuntimeException("NO item selected");
			return false;
			// return new RuntimeException("No selected month") != null;
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
	
	public String getAngularDropdownSelectedText() {
//		return (String) jsExecutor.executeScript("return $(\"select[name='games']>option[selected]\").text");
		return (String) jsExecutor.executeScript("return document.querySelector(\"select[name='games']>option[selected]\").text");
	}

	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}

}