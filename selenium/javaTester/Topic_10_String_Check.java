package javaTester;

import org.openqa.selenium.support.Color;
import org.testng.Assert;



public class Topic_10_String_Check {

	public static void main(String[] args) {
		// Java
		// JaVA
		// JAVA
		// jAvA
		String article = "Lập trình JAVA trong 4 tuần";
		
		Assert.assertTrue(article.contains("JAVA"));
		System.out.println(article);
		article = article.toLowerCase();
		
		Assert.assertTrue(article.contains("java"));
		System.out.println(article);
		article = article.toUpperCase();
		
		Assert.assertTrue(article.contains("JAVA"));
		System.out.println(article);
		String articlev2 = "JAVA";

		Assert.assertTrue(articlev2.equals("JAVA"));
		Assert.assertTrue(articlev2.equalsIgnoreCase("java"));
	}
	
	
	
}
