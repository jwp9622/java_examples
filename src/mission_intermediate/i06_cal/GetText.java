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
			System.out.print("���ڸ� �Է��ϼ��� : ");
			sc = new Scanner(System.in);
			input = sc.nextLine(); //�Է³��� �޾ƿ���			

			while(true) {
				if(!Pattern.matches("^[0-9]+$", input)) {
					System.out.println("���ڸ� �����մϴ�.!!");
					System.out.print("���ڸ� �Է��ϼ��� : ");
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
