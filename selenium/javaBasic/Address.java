package javaBasic;

public class Address {
	private  static String address;

	public static void main(String[] args) {

	setAddress("Hello");
	System.out.println(getAddress());
	
	setAddress("Hi");
	System.out.println(getAddress());
	}

	public static void setAddress(String add) {
		address = add;
	}
	public static String getAddress() {
		return address;
	}

}
