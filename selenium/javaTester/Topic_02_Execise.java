package javaTester;


import org.testng.annotations.Test;

public class Topic_02_Execise {
		int a = 6;
		int b = 2;
		int p1 = a+b;
		int p2 = a-b;
		int p3 = a*b;
		int p4 = a/b;

		@Test		
		public void TC01() {
			System.out.println("a + b =" + p1);
			System.out.println("a - b =" + p2);
			System.out.println("a * b =" + p3);
			System.out.println("a / b =" + p4);
			
			float width = 7.5f;
			float height = 3.8f;
			System.out.println("S of rectangle =" + (width * height));
			
			String Hello ="Hello Automation Testing";
			System.out.println(Hello);
		}
		
		


	

	
}
