package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import netscape.javascript.JSException;

public class Topic_15_Javascript_Executor {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\browerDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	public void TC_01_Click_Hidden_Element() {
		driver.get("https://www.zingpoll.com/");
//		WebElement vietnameseLanguage = driver.findElement(By.xpath("//li[@class='dropdown hidden-xs']//a[contains(string(), 'Tiếng Việt' )]"));
//		jsExecutor.executeScript("arguments[0].click();",vietnameseLanguage);
//		sleepInSecond(5);
		clickToElementByJS("//li[@class='dropdown hidden-xs']//a[contains(string(), 'Tiếng Việt' )]");
		sleepInSecond(5);
	}


	public void TC_02() {
		navigateToUrlByJS("http://live.demoguru99.com/");
		String homepageDomain = (String) executeForBrowser("return document.domain;");
		Assert.assertEquals(homepageDomain, "live.demoguru99.com");
		
		String homepageURL = (String) executeForBrowser("return document.URL;");
		Assert.assertEquals(homepageURL, "http://live.demoguru99.com/");

		highlightElement("//a[text()='Mobile']");
		clickToElementByJS("//a[text()='Mobile']");
		
		highlightElement("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
		clickToElementByJS("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
		
		highlightElement("//li[@class='success-msg']//span");
		Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));
		
		highlightElement("//a[contains(@href,'customer-service')]");
		clickToElementByJS("//a[contains(@href,'customer-service')]");

		highlightElement("//input[@id='newsletter']");
		scrollToElement("//input[@id='newsletter']");
		sendkeyToElementByJS("//input[@id='newsletter']", getEmailRandom());
		clickToElementByJS("//button[@title='Subscribe']");

		Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
		sleepInSecond(2);
		
		navigateToUrlByJS("http://demo.guru99.com/v4/");
		String demoGuru = (String) executeForBrowser("return document.domain;");
		Assert.assertEquals(demoGuru, "demo.guru99.com");
		
	}
	

	public void TC_03_HTML5() {
		navigateToUrlByJS("https://login.ubuntu.com/");
		clickToElementByJS("//button[@class='p-button--positive js-close']");
		clickToElementByJS("//button[@data-qa-id='login_button']");
		sleepInSecond(2);
		Assert.assertEquals(getHTML5ElementValidationMessage("//input[@name='email']"), "Please fill out this field.");
		
		sendkeyToElementBySelenium("//input[@name='email']", "aa");
		clickToElementByJS("//button[@data-qa-id='login_button']");
		sleepInSecond(2);
		Assert.assertEquals(getHTML5ElementValidationMessage("//input[@name='email']"), "Please include an '@' in the email address. 'aa' is missing an '@'.");
		
		sendkeyToElementBySelenium("//input[@name='email']", "aa@");
		clickToElementByJS("//button[@data-qa-id='login_button']");
		sleepInSecond(2);
		Assert.assertEquals(getHTML5ElementValidationMessage("//input[@name='email']"), "Please enter a part following '@'. 'aa@' is incomplete.");
		
		sendkeyToElementBySelenium("//input[@name='email']", "bearvo@gmail.com");
		clickToElementByJS("//button[@data-qa-id='login_button']");
		sleepInSecond(2);
		Assert.assertEquals(getHTML5ElementValidationMessage("//input[@name='password']"), "Please fill out this field.");
		
	}
		
	public void TC_04_Remove_attribute() {
		String userID = "mngr336375";
		String userPassword = "nEjusuz";
		String generateAccess = "automationfc@gmail.com";
		String pageTitle = "Guru99 Bank Manager HomePage";
		String customerName = "automation";
		String customerDateofBirth ="1994-10-10";
		String customerAddress ="111 NTH HCM";
		String customerCity = "HCM";
		String customerState = "NTH";
		String customerPIN = "123456";
		String customerMobile = "111333777999";
//		String customerEmail = "automationfresher@yopmail.com";
		String customerPassword ="abcd1234";
		String customerGender ="male";
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(100000);  
		String customerEmail = "username" + randomInt +"@gmail.com";

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
		
		driver.get("http://demo.guru99.com/v4");
		driver.findElement(useridTextbox).sendKeys(userID);
		driver.findElement(passwordTextbox).sendKeys(userPassword);
		driver.findElement(By.name("btnLogin")).click();
		Assert.assertEquals(driver.getTitle(), pageTitle);
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		driver.findElement(nameTextbox).sendKeys(customerName);
		sleepInSecond(2);
		//remove attribute (type = date )
		removeAttributeInDOM("//input[@name='dob']", "type");
		sleepInSecond(2);
		driver.findElement(dobTextbox).sendKeys(customerDateofBirth);
		driver.findElement(addrTextbox).sendKeys(customerAddress);
		driver.findElement(cityTextbox).sendKeys(customerCity);
		driver.findElement(stateTextbox).sendKeys(customerState);
		driver.findElement(pinnoTextbox).sendKeys(customerPIN);
		driver.findElement(telephoneTextbox).sendKeys(customerMobile);
		driver.findElement(emailTextbox).sendKeys(customerEmail);
		driver.findElement(passwordTextbox).sendKeys(customerPassword);
		
		
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
	
	// Dùng cho browser
	// document.title/ document.domain/ document.URL...
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
	}

	public void scrollToElement(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}
	
	public void sendkeyToElementBySelenium(String locator, String value) {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public String getHTML5ElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
	}

	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
	public String getEmailRandom() {
		Random random = new Random();
		return "automationbv" + random.nextInt() + "@gmail.com";
	
	}
}