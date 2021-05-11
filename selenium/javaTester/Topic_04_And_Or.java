package javaTester;

public class Topic_04_And_Or {
	
	public static void main(String[] args) {
	
	// Male
		boolean firstStatus = true;
	// Female
		boolean secondStatus = false;
		System.out.println("================AND================");
	// And: True & False = False
		System.out.println(firstStatus & secondStatus);
		
		// And: False & True  = False
		firstStatus = true;
		secondStatus = false;
		System.out.println(firstStatus & secondStatus);
		
		// And: False & False  = False
		firstStatus = false;
		secondStatus = false;
		System.out.println(firstStatus & secondStatus);
		
		// And: True & True  = True
		firstStatus = true;
		secondStatus = true;
		System.out.println(firstStatus & secondStatus);
		
		//====================================================
		System.out.println("================OR================");
		// Or: True & False = True
		firstStatus = true;
		secondStatus = false;
		System.out.println(firstStatus || secondStatus);
		// Or: False & True = True
		firstStatus = false;
		secondStatus = true;
		System.out.println(firstStatus || secondStatus);
		// Or: False & False = False
		firstStatus = false;
		secondStatus = false;
		System.out.println(firstStatus || secondStatus);
		// Or: True & True = True
		firstStatus = true;
		secondStatus = true;
		System.out.println(firstStatus || secondStatus);
	}
}