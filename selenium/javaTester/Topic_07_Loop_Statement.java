package javaTester;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Topic_07_Loop_Statement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] studentName = {"Trường", "Tiến", "Thơm","Thu", "Thảo", "Trà" };
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
		for (int i = 0; i < studentName.length; i++) {
			System.out.println(studentName[i]); 
		}
		
		
		List<String> address = new ArrayList<String>();
		address.add("Trường");
		address.add("Tiến");
		address.add("Thoa");
		address.add("Nam");
		
		for (Iterator iterator = address.iterator(); iterator.hasNext();) {
			System.out.println("Interator" + iterator.next());
			
		}
		
		for (String add : studentName) {
			System.out.println("add" + add);
		}
		// Duyệt qua chuỗi studentName
		for (String student : studentName) {
			// Lấy từng giá trị của vòng for đầu tiên để sử dụng cho vòng for thứ 2 
			for (int i = 0; i < 2; i++) {
				System.out.println(student);
			}
		}
		
	}

}
