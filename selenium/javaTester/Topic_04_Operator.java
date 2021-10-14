package javaTester;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_04_Operator {
	
		public static void main(String[] args) {
			int number = 10;
			
			number+= 5;
			number = number + 5;
			System.out.println(number);
			
			System.out.println(number / 5);
			System.out.println(number % 7);
			
			System.out.println(number++);
			System.out.println(number--);
			
			int numb = 10;
			System.out.println(numb++);
			// in number trước
			// lệnh ++ sau => 11
			System.out.println(++numb);
			// lệnh ++ trước => 12 
			// in number sau
			
			int minus = 10;
			System.out.println(minus--);
			// in number trước
			// lệnh ++ sau => 11
			System.out.println(--minus);
			// lệnh ++ trước => 12 
			// in number sau
			
			for(int i = 0; i < 3; ++i ) {
				System.out.println(i);
			}
			for(int i = 0; i < 3; i++ ) {
				System.out.println(i);
			}
			
			Assert.assertTrue(5<6);
			
			String address ="HCM";
			if(address=="HN" || address =="HCM") {
				System.out.println("adress the same");
			}
			if(!(address=="HN")) {
				
				System.out.println("adress the same");
			}
					
			boolean status = ( address=="HN") ? true : false;
			System.out.println(status);
			boolean statusfake = ( address=="HN") ? false : true;
			System.out.println(statusfake);
			
			
			
		}
		
		


}