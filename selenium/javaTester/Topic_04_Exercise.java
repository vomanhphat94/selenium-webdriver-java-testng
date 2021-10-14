package javaTester;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_Exercise {

	int p2 = 23;

	public void TC_01() {
		String p1 = "Tuan";
		//int futureOld = p2 + 15;
		
		Scanner scanner = new Scanner(System.in);
		int  p3 = scanner.nextInt();
		int futureOld = p3 + 15;
		
		System.out.println(p1 + " after 15 years will be " + futureOld + "year old" );
	}

	public void TC_02() {
		int a = 3;
		int b = 4;
		a = a + b;
		System.out.println(a);
		b = a - b;
		System.out.println(b);
		a = a - b;
		System.out.println(a);
	}
	
	
	@Test
	public void TC_03() {
		int c = 3;
		int d = 4;
		boolean status = (c > d) ? true : false;
	}
	
	
}

