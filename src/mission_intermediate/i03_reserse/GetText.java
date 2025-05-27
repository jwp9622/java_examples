package mission_intermediate.i03_reserse;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GetText {
	
	Scanner sc;
	String str = "";
	
	GetText(){

	}
	
	public String GetTextInput(){

		try {
			System.out.print("알파벳을 입력하세요 : ");
			sc = new Scanner(System.in);
			str = sc.nextLine(); //입력내용 받아오기			
			
			while(true) {
				if(!Pattern.matches("^[a-zA-z]*$", str)) {
					System.out.println("알파벳만 가능합니다.!!");
					System.out.print("알파벳을 입력하세요 : ");
					str = sc.nextLine();
				}else {
					break;
				}
			}
		}catch (Exception e) {
			System.out.println(e);
		}	
		return str;
	}

	
	
}
