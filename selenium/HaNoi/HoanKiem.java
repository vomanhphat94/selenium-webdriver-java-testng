package HaNoi;

public class HoanKiem {
	public static void main (String[] args) {
		DongDa dongda = new DongDa();
		dongda.bridge ="Cau long Bien";
		System.out.println(dongda.bridge);
		
		dongda.setBridge("Cau Trang TIen");
		System.out.println(dongda.getBridge());
		
		dongda.street ="Hoan Kiem Street";
		dongda.setStreet("Le Loi");
		System.out.println(dongda.getStreet());
		
		DongDa.clickToLoginButton();
		dongda.clickToLoginButton();
		
		
		dongda.food="Nem";
		dongda.setFood("Pho");
		System.out.println(dongda.getFood());
		
	}
	
	public void clickToAddress() {
		DongDa.clickToLoginButton();
	}
	
	

}
