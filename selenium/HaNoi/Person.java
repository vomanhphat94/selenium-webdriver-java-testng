package HaNoi;

public class Person {
	// Thuộc tính
	// Biến Global ( Toàn cục ): Phạm vi cho toàn class này dùng
	private String name ="";
	
	// Hàm setter : Gán dữ liệu
	// Phương thức
	public void setName(String name) { // Biến Local ( Cục bộ ): Chỉ dùng trong hàm/khối lệnh
		this.name = name;
	}
	
	// Hàm Getter : Lấy dữ liệu
	public String getName() {
		return name;
	}
}
