package webdriver;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class Topic_11_User_Interaction_II {
	WebDriver driver;
	WebDriverWait explicitWait;
	WebDriverWait explicitWait2;
	JavascriptExecutor jsExecutor;
	Alert alert;
	Actions action;
	String projectPath = System.getProperty("user.dir");
	String javascriptPath = projectPath + "\\dragAndDrop\\drag_and_drop_helper";
	String jqueryPath = projectPath + "\\dragAndDrop\\jquery_load_helper";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\browerDriver\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		System.out.println(driver.toString());

		action = new Actions(driver);
		explicitWait = new WebDriverWait(driver, 10);
		jsExecutor = (JavascriptExecutor) driver;
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	public void TC_01_Drag_and_Drop_HTML4() {
		
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		WebElement dragitem = driver.findElement(By.id("draggable"));
		WebElement droptarget = driver.findElement(By.id("droptarget"));
		action.dragAndDrop(dragitem, droptarget).perform();
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='droptarget' and text()='You did great!']")).isDisplayed());
		Assert.assertEquals(getHexaValue(driver.findElement(By.id("droptarget")).getCssValue("background-color")), "#03a9f4");
		Assert.assertEquals(driver.findElement(By.id("droptarget")).getCssValue("background-color"), getRGBValue("#03a9f4"));
		

	}

	public void TC_02_Drag_and_Drop_HTML5_Css() throws IOException {
		driver.get("https://automationfc.github.io/drag-drop-html5/");
		WebElement columnA = driver.findElement(By.id("column-a"));
		WebElement columnB = driver.findElement(By.id("column-b"));
		String sourceCss = "#column-a";
		String targetCss = "#column-b";
		
		String java_script = getFileContent(javascriptPath);
		
		// A to B
				java_script = java_script + "$(\"" + sourceCss + "\").simulateDragDrop({ dropTarget: \"" + targetCss + "\"});";
				jsExecutor.executeScript(java_script);
				sleepInSecond(2);
				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-a']/header[text()='B']")).isDisplayed());

				// B to A
				jsExecutor.executeScript(java_script);
				sleepInSecond(2);
				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-b']/header[text()='B']")).isDisplayed());
				
	}
	@Test
	public void TC_03_Drag_and_Drop_HTML5_Xpath() throws AWTException {
		driver.get("https://automationfc.github.io/drag-drop-html5/");
		
		drag_the_and_drop_html5_by_xpath("//div[@id='column-a']", "//div[@id='column-b']");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-a']/header[text()='B']")).isDisplayed());
		drag_the_and_drop_html5_by_xpath("//div[@id='column-a']", "//div[@id='column-b']");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-b']/header[text()='B']")).isDisplayed());

	}
	
	public void drag_the_and_drop_html5_by_xpath(String sourceLocator, String targetLocator) throws AWTException {

		WebElement source = driver.findElement(By.xpath(sourceLocator));
		WebElement target = driver.findElement(By.xpath(targetLocator));

		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		// Get size of elements
		Dimension sourceSize = source.getSize();
		Dimension targetSize = target.getSize();

		// Get center distance
		int xCentreSource = sourceSize.width / 2;
		int yCentreSource = sourceSize.height / 2;
		int xCentreTarget = targetSize.width / 2;
		int yCentreTarget = targetSize.height / 2;

		Point sourceLocation = source.getLocation();
		Point targetLocation = target.getLocation();
		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		// Make Mouse coordinate center of element
		sourceLocation.x += 20 + xCentreSource;
		sourceLocation.y += 110 + yCentreSource;
		targetLocation.x += 20 + xCentreTarget;
		targetLocation.y += 110 + yCentreTarget;

		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		// Move mouse to drag from location
		robot.mouseMove(sourceLocation.x, sourceLocation.y);

		// Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

		// Move to final position
		robot.mouseMove(targetLocation.x, targetLocation.y);

		// Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public static String getRGBValue(String hexaValue) {
		return Color.fromString(hexaValue).asRgba();
	}
	
	public static String getHexaValue(String rgbValue) {
		return Color.fromString(rgbValue).asHex();
	}
	
	public String getFileContent(String file) throws IOException {
		Charset cs = Charset.forName("UTF-8");
		FileInputStream stream = new FileInputStream(file);
		try {
			Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[8192];
			int read;
			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
				builder.append(buffer, 0, read);
			}
			return builder.toString();
		} finally {
			stream.close();
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

	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}

}