package javaTester;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Topic_01_Data_Type {
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
	Topic_01_Data_Type topic01;
	
	
	
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
	
}
