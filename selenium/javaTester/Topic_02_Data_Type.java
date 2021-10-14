package javaTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetAllWindowHandles;

public class Topic_02_Data_Type {
	
	// Primitive type
	
	byte bNumber;
	short sNumber;
	int iNumber;
	long lNumber;
	float fNumber = 5.5f;
	double dNumber = 5.9d;
	char cChar ;
	boolean bBoolean;
	
	// Reference type
	// String
	String address ="HCM";
	// Array
	String[] studentAddress = {address,"HN","DN"};
	Integer[] studentNumber = {1,3,7,13};
	
	// Class
	Topic_02_Data_Type topic;
	
	// Interface
	WebDriver driver;
	
	// Object
	Object aObject;
	
	// Collection
	// List/ Set/ Queue/ Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	
	List<String> productName = new ArrayList<String>();
	
	// Reference type will have function();
	// Primitive type don't have function()
	public void clickToELement() {
		address.trim();
		homePageLinks.size();
		allWindows.addAll(productName);
	}
	
	public static void main(String[] args) {

	}
	
	
	
}
