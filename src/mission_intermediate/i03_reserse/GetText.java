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
			System.out.print("���ĺ��� �Է��ϼ��� : ");
			sc = new Scanner(System.in);
			str = sc.nextLine(); //�Է³��� �޾ƿ���			
			
			while(true) {
				if(!Pattern.matches("^[a-zA-z]*$", str)) {
					System.out.println("���ĺ��� �����մϴ�.!!");
					System.out.print("���ĺ��� �Է��ϼ��� : ");
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
