package javaTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
<<<<<<< HEAD
import org.openqa.selenium.remote.RemoteWebDriver;

public class Topic_02_Data_Type {
	// Primitive type/ value type : Nguyên thủy
	// Ngầm định/ nguyên thủy
	// Chứa kí tự ( Duy nhất 1 kí tự )
	// char
	char a = 'a';
	
	
	
	// Chứa số nguyên ( k có dấu )
	// byte
	byte byteNumber = 127;
	// short
	short shortNumber = 6300;
	// int
	int intNumber = 500;
	// long
	long longNumber = 5000000;
	
	// Chứa số thực ( có dấu )
	// float
	float floatNumber = 59.635F;
	// double
	double doubleNumber = 5659.3999D;
	
	// Luận lí ( Đúng/ sai )
	// boolean
	boolean status = true;
	
// ======================================================
	// Tham chiếu
	// Chứa chuỗi kí tự
	// String
	String name = "ABC DEF";
	String address = "1009/352/5235/7345 NTH";
	String password ="@#$^#$%&#$%&";
	
	
	// Chứa class 
	// Class
	Topic_02_Data_Type topic01;
	
	
	
	// Kiểu đối tượng
	// Object
	Object aObject;
	
	// Kiểu mảng
	// Array
	String[] students = {"A", "B", "C"};
	String[] stringvalue = {name, address, password};
	int[] salary = {byteNumber, shortNumber, intNumber};
	
	
	// Kiểu interface
	// Interface
	WebDriver driver;
	RemoteWebDriver remoteDriver;
	
	// Kiểu collection (List/Set/Queue/Map nó là interface Interface)
	// Trong nó có các class như là
	// list: ArrayList/ LinkedList ...
	// 
	// Collection
	List<String> studentName = new ArrayList<String>();
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	String fullName = "Phat";
	// String: Kiểu dữ liệu (data type: String/ int/ float/ double/ char/ Array/ Class/ Interface/ Collection/ ..)
	// fullName: tên biến ( Variable/ field / Property )
	// Phat: Value of variable
	

	// 1 element ( email textbox )
	//WebElement emailTextbox = driver.findElement(By.id(""));
	
	// Nhiều element
	//List <WebElement> checkboxes = driver.findElements(By.id(""));
	
	
	// Biến nguyên thủy thì k có function detail
	// Biến Reference Type thì có 
	public void clickToElement() {
		fullName.trim();
		
		
=======
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
>>>>>>> branch 'master' of https://github.com/vomanhphat94/selenium-webdriver-java-testng
	}
	
	public static void main(String[] args) {

	}
	
	
	
}
