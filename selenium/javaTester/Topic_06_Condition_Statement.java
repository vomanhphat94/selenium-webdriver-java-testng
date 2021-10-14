package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String getProjectLocation = System.getProperty("user.dir");
	String ChromeDriverLocation = getProjectLocation + "\\browserDrivers\\chromedriver.exe";
	String IEDriverLocation = getProjectLocation + "\\browserDrivers\\IEDriverServer.exe";

	public void TC_01_If() {
		boolean status = 5 > 3;
		System.out.println(status);
		
		if (status) {
			System.out.println("inside if");
		}
		
		// Gán (assign )
		int studentNumber = 10;
		// So sánh
		status = (studentNumber != 10);
		System.out.println(status);
		
		
		
		WebDriver driver = new FirefoxDriver();
		// Ex : uncheck to checkbox
		WebElement languagesCheckbox = driver.findElement(By.id(""));
		if(languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}
		
		// Ex: check to checkbox
		if(!languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}
		

	}
	@Test
	public void TC_02_If_Else() {
		// Ex có 2 điều kiện : Nếu đúng thì vào if - sai vào else
		
		// Nếu driver start vs browser như Chrome/Firefox/Edge/Safari
		// thì dùng hàm click thông thường (buitin) của Selenium WebElement
		
		// Nếu driver là IE thì dùng hàm click của JavascriptExecutor
//		System.setProperty("webdriver.ie.driver", IEDriverLocation);
//		driver = new InternetExplorerDriver();

//		System.setProperty("webdriver.chrome.driver", ChromeDriverLocation);
//		driver = new ChromeDriver();

		if(driver.toString().contains("internet explorer")) {
			System.out.println("Click by javascript");
		} else {
			System.out.println("Click by Selenium WebElement");
		}
	}


}
