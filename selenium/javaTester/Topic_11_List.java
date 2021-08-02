package javaTester;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;



public class Topic_11_List {

	public static void main(String[] args) {
		List<String> addresses = new ArrayList<>();
		addresses.add("HCM");
		addresses.add("HN");
		addresses.add("HNam");
		
		System.out.println(addresses.size());
		Assert.assertEquals(addresses.size(), 3);
		WebDriver driver = null;
		List<WebElement> checkboxes = driver.findElements(By.xpath(""));
	}
	
	
	
}
