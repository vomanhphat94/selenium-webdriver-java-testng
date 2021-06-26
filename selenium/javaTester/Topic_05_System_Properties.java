package javaTester;

import java.io.File;

public class Topic_05_System_Properties {
	
	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		String projectOS = System.getProperty("os.name");
		System.out.println(projectLocation);
		System.out.println(projectOS);
		System.out.println(File.separator);
		
		
	}
}
