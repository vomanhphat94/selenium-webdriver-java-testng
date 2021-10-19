package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String getProjectLocation = System.getProperty("user.dir");
	String ChromeDriverLocation = getProjectLocation + "\\browserDrivers\\chromedriver.exe";
	String FirefoxDriverLocation = getProjectLocation + "\\browserDrivers\\geckodriver.exe";
	String IEDriverLocation = getProjectLocation + "\\browserDrivers\\IEDriverServer.exe";
	String EdgeDriverLocation = getProjectLocation + "\\browserDrivers\\msedgedriver.exe";

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

	public void TC_02_If_Else() {
		// Ex có 2 điều kiện : Nếu đúng thì vào if - sai vào else
		
		// Nếu driver start vs browser như Chrome/Firefox/Edge/Safari
		// thì dùng hàm click thông thường (buitin) của Selenium WebElement
		
		// Nếu driver là IE thì dùng hàm click của JavascriptExecutor
//		System.setProperty("webdriver.ie.driver", IEDriverLocation);
//		driver = new InternetExplorerDriver();

		System.setProperty("webdriver.chrome.driver", ChromeDriverLocation);
		driver = new ChromeDriver();
		System.out.println(driver.toString());

		if(driver.toString().contains("internet explorer")) {
			System.out.println("Click by javascript");
		} else {
			System.out.println("Click by Selenium WebElement");
		}
	}
	
	@Parameters("browser")
	public void TC_03_If_Else_If_Else(String browserName) {
		// Best Practice : Không nên if-else quá nhiều
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ChromeDriverLocation);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", FirefoxDriverLocation);
			driver = new FirefoxDriver();
		}  else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", IEDriverLocation);
			driver = new InternetExplorerDriver();
		}	else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", EdgeDriverLocation);
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input correct the borwser name!");
		}
		
		System.out.println(driver.toString() + "  " + browserName);
		driver.quit();
	}
	@Test
	public void TC_04_If_Else_If_Else() {
		String pageName = "Login";
		if(pageName.equals("Login")) {
			// Login page loginPage = new LoginPage();
			// return loginPage;
		} else if (pageName.equals("Register")) {
			// RegisterPage registerPage = new RegisterPage();
			// return registerPage;
		} else if (pageName.equals("New Customer")) {
			// CustomerPage customerPage = new CustomerPage();
			// return customerPage;
		} else {
			// HomePage homePage = new HomePage();
			// return homePage;
		}
	}
	
	


}
