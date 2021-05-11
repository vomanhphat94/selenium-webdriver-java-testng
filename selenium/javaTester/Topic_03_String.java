package javaTester;

public class Topic_03_String {
	
	public static void main(String[] args) {
	String name ="Hello \"John\", What"	;
	String hello = "'s happened?";
	String address = "     US";
	String userID = "mngr303746";
	
	System.out.println(name.concat(hello).concat(address));
	
	System.out.println("//td[text()='Manager Id : " + userID + "']");
	}
}