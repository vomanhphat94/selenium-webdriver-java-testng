package HaNoi;

public class DongDa {
	
	// Private chỉ truy cập trong phạm vi Class
	private String vanMieu;
	
	// Nếu k set access modifer, nó sẽ là default
	// Phạm vi truy cập trong package
	String bridge;
	// Trong package và ngoài package nhưng phải là class con của nó
	protected String street;
	
	public String food;
	
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	protected static void clickToLoginButton() {
		
	}

	protected void setStreet(String street) {
		this.street = street;
	}
	
	protected String getStreet() {
		return street;
	}
	
	String getBridge() {
		return bridge;
	}

	void setBridge(String bridge) {
		this.bridge = bridge;
	}

	private void setVanMieu(String vanMieu) {
		this.vanMieu = vanMieu;
	}
	
	private String getVanMieu() {
		return vanMieu; 
	}

	public static void main(String[] args) {
		// biến dongda có kiểu dữ liệu là Object, nó đại diện cho class DongDa
		// 1 class mà muốn truy cập dữ liệu của 1 class khác thì có nhiều cách
//		// Cách này là khởi tạo 1 đối tượng đại diện cho class đó
//		DongDa dongda = new DongDa();
//		// instance/ object
//		// Phạm vi trong cùng 1 class là lấy được hết
//		dongda.setVanMieu("Quoc Tu Giam");
//		
//		System.out.println(dongda.getVanMieu());
//		
//		dongda.vanMieu ="ABC";
//		System.out.println(dongda.getVanMieu());

	}
}
