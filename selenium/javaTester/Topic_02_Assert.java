package javaTester;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Assert {
	
	public static void main(String[] args) {
		
		boolean status = true;
		
		// Option 1 : Compare 
		String errorMessage = "This is required field.";
		Assert.assertEquals("This is required field.", errorMessage);
		
		// Option 2
		// Check an expected respond correct
		Assert.assertTrue(status);
		// Check an expected respond incorrect]
		status = false;
		Assert.assertFalse(status);
	}
	

}