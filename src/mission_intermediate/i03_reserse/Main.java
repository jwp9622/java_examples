package mission_intermediate.i03_reserse;

import java.util.Scanner;

/*
 * 자바중급 - 3.문자열 뒤집기 및 대소문자 변환 프로그램 작성하기
 */

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = "";
		
		//문자 입력받기
		GetText gt = new GetText();
		str = gt.GetTextInput();
		
		//문자 뒤집기, 대소문자 변환
		if(!str.equals("")) {
			Reverse r = new Reverse();
			r.setOri_str(str);
			r.reverse();
			System.out.println("뒤집은 문자 : "+ r.getResult());
		}
				
	}		
}