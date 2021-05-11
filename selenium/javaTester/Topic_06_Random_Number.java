package javaTester;

import java.util.Random;

public class Topic_06_Random_Number {
	
	public static void main(String[] args) {
		
		
		// Java class
		Random rand = new Random();
		System.out.println(rand.nextInt(9999999));
		int randomNumber = rand.nextInt(99999);
		// Random email 
		// Format: prefix + random + postfix ( web mail server: github/ gmail/ hotmail/.. )
		System.out.println("auto" + randomNumber + "gmail.com");
		
		// Java lib: faker/ jfairy
		
	}
}
