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
	@Test
	public void TC_05() {
		int numberD = scanner.nextInt();
		if (10 <= numberD && numberD <= 100) {
			System.out.println(numberD + " in the range");
		} else
			System.out.println(numberD + " not in the range");
	}

}

