package javaTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Topic_01_Variable {


	// Đây là hàm khởi tạo ( Phải trùng tên vs class )
	// Biến được tạo trong đây cũng là biến local
	public Topic_01_Variable() {
		String studentNameabc;
	}
	
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
	Topic_01_Variable topic01;
	
	
	
	// Kiểu đối tượng
	// Object
	
	// Kiểu mảng
	// Array
	String[] students = {"A", "B", "C"};
	String[] stringvalue = {name, address, password};
	int[] salary = {byteNumber, shortNumber, intNumber};
	// Kiểu interface
	// Interface
	WebDriver driver;
	RemoteWebDriver remoteDriver;
	
	// Kiểu collection (List/Set/Queue nó là interface Interface)
	// Trong nó có các class như là
	// list: ArrayList/ LinkedList ...
	// 
	// Collection
	List<String> studentName = new ArrayList<String>();
	
	String fullName = "Phat";
	// String: Kiểu dữ liệu (data type: String/ int/ float/ double/ char/ Array/ Class/ Interface/ Collection/ ..)
	// fullName: tên biến ( Variable/ field / Property )
	// Phat: Value of variable
	

	// 1 element ( email textbox )
	//WebElement emailTextbox = driver.findElement(By.id(""));
	
	// Nhiều element
	//List <WebElement> checkboxes = driver.findElements(By.id(""));
	
	
	protected static int studentNumber;
	protected int price;
	// Value of this Variable will not be replace
	static final String BROWSER_NAME = "Chrome"; // Constant
	static Boolean statusValue;
	String StudentAddress;
	public static void main(String[] args) {
		
		Topic_01_Variable address = new Topic_01_Variable();
		address.StudentAddress = "hahahaha";
		System.out.println(address.StudentAddress);
		System.out.println(studentNumber);
		System.out.println(Topic_01_Variable.studentNumber); 
		int num = 0;
		System.out.println(num);
		
		System.out.println(Topic_01_Variable.BROWSER_NAME);
		Topic_01_Variable test = new Topic_01_Variable();
		Topic_01_Variable test2 = new Topic_01_Variable();
		Topic_01_Variable test3 = new Topic_01_Variable();
		System.out.println(test.price);
		System.out.println(test2.price);
		System.out.println(test3.BROWSER_NAME);
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println(name);
		System.out.println(name);
		System.out.print(name);
		System.out.print(name);
		System.out.println(statusValue instanceof Boolean);
		
		
	}
	
	public void getStudentprice() {
		price = 2;
	}
	
	String studentName_2;
	// Getter: getCurrentUrl/ getTitle/get Attribute/....
	public String getStudentName() {
		return this.studentName_2;
	}
	// Setter: click/ sendkey/ clear/select/back/forward/refresh/accept....
	public void setStudentName(String sdtName) {
		this.studentName_2 = sdtName;
	}
	

	
	
	
}
