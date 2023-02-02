package javaTester;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Exercise {
	
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	Scanner scanner03 = new Scanner(System.in);
	

	public void TC_01() {
		int number = scanner.nextInt();
		System.out.println(number);
		if (number%2==0) {
			System.out.println("This is số chẵn bỏi vì chia lấy số dư = 0");
		} else {
			System.out.println("This is số lẻ bởi vì chia lấy số dư không = 0");
		}
	}
	
	

	public void TC_02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		if(numberA >= numberB) {
			System.out.println(numberA +  " >= " + numberB);
		} else {
			System.out.println(numberA +  " < " + numberB);
		}
	}
	
	public void TC_03() {
		String nameA = scanner03.nextLine();
		String nameB = scanner03.nextLine();
		// Thường dùng cho primitive type
		// == Chỉ kiểm tra value thôi
		if(nameA == nameB) {
			System.out.println(nameA + " trùng tên với " + nameB );
		} else {
			System.out.println(nameA + " khác tên với " + nameB );
		}
		// Thường dùng cho Reference type
		// Kiểm tra cái value của biến
		// Kiểm tra vị trí của biến trong vùng nhớ
		if(nameA.equals(nameB)) {
			System.out.println(nameA + " trùng tên với " + nameB );
		} else {
			System.out.println(nameA + " khác tên với " + nameB );

		}
	}
	

	public void TC_04() {
		int numbera = scanner.nextInt();
		int numberb = scanner.nextInt();
		int numberc = scanner.nextInt();
		if ( numbera > numberb && numbera > numberc) {
			System.out.println(numbera + " is biggest number");
		} else if ( numberb > numbera && numberb > numberc) {
			System.out.println(numberb + " is biggest number");
		} else {
			System.out.println(numberc + " is biggest number");
		}
	}

	public void TC_05() {
		int numberD = scanner.nextInt();
		if (10 <= numberD && numberD <= 100) {
			System.out.println(numberD + " in the range");
		} else
			System.out.println(numberD + " not in the range");
	}


	public void TC_06() {
		float studentPoint = scanner.nextFloat();
		if (studentPoint <=10 && studentPoint >= 8.5) {
			System.out.println("Hệ số A");
		} else if (studentPoint <8.5 && studentPoint >= 7.5) {
			System.out.println("Hệ số B");
		} else if (studentPoint <7.5 && studentPoint >= 5) {
			System.out.println("Hệ số C");
		} else if(studentPoint <5 && studentPoint >= 0){
			System.out.println("hệ số D");
		} else {
			System.out.println("Vui lòng nhập lại");
		}
	}
	@Test
	public void TC_07() {
		int month = scanner.nextInt();
		// 1 3 5 7 8 10 12
		if (month ==1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ) {
			System.out.println("This month have 31 ngày");
		} else if (month == 2) {
			System.out.println("This month have 28 ngày");
		} else if (month ==2 || month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("This month have 30 ngày");
		} else {
			System.out.println("Vui lòng nhập lại");
		}
	}
}

