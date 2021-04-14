package javaTester;

public class Topic_3_String {
	
	public static void main(String[] args) {
	String name ="Hello \"John\", What"	;
	String hello = "'s happened?";
	String address = "     US";
	
	System.out.println(name.concat(hello).concat(address));
	}
}