package mission_intermediate.i06_cal;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GetText {
	
	Scanner sc;
	String input;
	int num;
	
	GetText(){

	}
	
	public int GetTextInput(){

		try {
			System.out.print("숫자를 입력하세요 : ");
			sc = new Scanner(System.in);
			input = sc.nextLine(); //입력내용 받아오기			

			while(true) {
				if(!Pattern.matches("^[0-9]+$", input)) {
					System.out.println("숫자만 가능합니다.!!");
					System.out.print("숫자를 입력하세요 : ");
					input = sc.nextLine();
				}else {
					break;
				}
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		num = Integer.parseInt(input);

		
		return num;
	}

	
	
}
