package javaTester;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Topic_01_Data_Type {
	// Ngáº§m Ä‘á»‹nh/ nguyÃªn thá»§y
	// Chá»©a kÃ­ tá»± ( Duy nháº¥t 1 kÃ­ tá»± )
	// char
	char a = 'a';
	
	
	
	// Chá»©a sá»‘ nguyÃªn ( k cÃ³ dáº¥u )
	// byte
	byte byteNumber = 127;
	// short
	short shortNumber = 6300;
	// int
	int intNumber = 500;
	// long
	long longNumber = 5000000;
	
	// Chá»©a sá»‘ thá»±c ( cÃ³ dáº¥u )
	// float
	float floatNumber = 59.635F;
	// double
	double doubleNumber = 5659.3999D;
	
	// Luáº­n lÃ­ ( Ä�Ãºng/ sai )
	// boolean
	boolean status = true;
	
// ======================================================
	// Tham chiáº¿u
	// Chá»©a chuá»—i kÃ­ tá»±
	// String
	String name = "ABC DEF";
	String address = "1009/352/5235/7345 NTH";
	String password ="@#$^#$%&#$%&";
	
	
	// Chá»©a class 
	// Class
	Topic_01_Data_Type topic01;
	
	
	
	// Kiá»ƒu Ä‘á»‘i tÆ°á»£ng
	// Object
	
	// Kiá»ƒu máº£ng
	// Array
	String[] students = {"A", "B", "C"};
	String[] stringvalue = {name, address, password};
	int[] salary = {byteNumber, shortNumber, intNumber};
	// Kiá»ƒu interface
	// Interface
	WebDriver driver;
	RemoteWebDriver remoteDriver;
	
	// Kiá»ƒu collection (List/Set/Queue nÃ³ lÃ  interface Interface)
	// Trong nÃ³ cÃ³ cÃ¡c class nhÆ° lÃ 
	// list: ArrayList/ LinkedList ...
	// 
	// Collection
	List<String> studentName = new ArrayList<String>();
	
	String fullName = "Phat";
	// String: Kiá»ƒu dá»¯ liá»‡u (data type: String/ int/ float/ double/ char/ Array/ Class/ Interface/ Collection/ ..)
	// fullName: tÃªn biáº¿n ( Variable/ field / Property )
	// Phat: Value of variable
	

	// 1 element ( email textbox )
	WebElement emailTextbox = driver.findElement(By.id(""));
	
	// Nhiá»�u element
	List <WebElement> checkboxes = driver.findElements(By.id(""));
	
}
