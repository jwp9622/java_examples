package mission_basic;
import java.util.Scanner;
public class java_basic_01 {
	public static void main(String[] args) {
		int input1 = 0;
		int input2 = 0;
		int max_num;
		String str;
		
		int total;
		String name;
		int old;
		name = "박다희";
		old = 10;
				
		Scanner sc = new Scanner(System.in); //scanner 호출

		//첫번재 숫자 입력 받기
		System.out.print(chkMsg(1,"i"));
		str = sc.nextLine(); //입력내용 받아오기
		
		try {
			while(true) {
				if(inNumeric(str) == false) { //숫자가 아니면
					System.out.println(chkMsg(1,"e"));
					System.out.print(chkMsg(1,"i"));
					str = sc.nextLine(); //내용 다시 받기
				}else {	//숫자이면
					input1 = Integer.parseInt(str); //숫자이면 정수형으로 변환
					break;
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		//첫번재 숫자 입력 받기
		System.out.print(chkMsg(2,"i"));
		str = sc.nextLine(); //입력내용 받아오기
		
		try {
			while(true) {
				if(inNumeric(str) == false) { //숫자가 아니면
					System.out.println(chkMsg(2,"e"));
					System.out.print(chkMsg(2,"i"));
					str = sc.nextLine(); //내용 다시 받기
				}else {	//숫자이면
					input2 = Integer.parseInt(str); //숫자이면 정수형으로 변환
					break;
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		sc.close();  //scanner 닫기
		
		max_num = (input1 > input2) ? input1:input2;
		System.out.println("가장 큰수는 \""+max_num+"\" 숫자입니다");
		
		total = input1+input2;
		System.out.println("두 수의 합계는 \""+total+"\" 입니다");
		
		System.out.println("이름은 "+ name+" 입니다");
		System.out.println("나이는 "+ old+"살 입니다");
	}
	public static String chkMsg(int num, String cate) {
		String alert_msg = "숫자만 입력가능합니다!! ";
		String info_msg = "번째 숫자를 입력하세요 : ";
		String str = "";
			
		if (cate == "i") {
			str = num+info_msg;
		}else {
			str = alert_msg;
		}
		return str;
	}
	public static boolean inNumeric(String s){
		
		//정규식 - 문자열 형식 체크할때 사용
		/********자바 정규식 ************
		 * [+-]?\\d+ --> 숫자체크
		 * [] : 괄호 안의 문자가 있는지를 확인
		 * + : 하나 또는 많이 반복
		 * - : 문자 범위 지정
		 * ? : 없음 또는 1개이상
		 * \\d+ : 숫자가 1개이상
		 *
		 */
		/*
		 * replaceAll 문자열을 변환
		 * equals에서 공백있는지 체크
		 * 
		 * [] : 괄호 안의 문자가 있는지를 확인
		 * + : 문자가 숫자가 여러개 올수 있다. 하나 또는 많이 반복
		 * - : 문자 범위 지정
		 * ? : 없음 또는 1개이상
		 * \\d+ : 숫자가 1개이상
		 * replaceAll에서 [+-]괄호안에 1개이상의 모든 문자범위에서, 
		 * ?는앞의 요소개 1개이상 내용중에서 
		 * \\d 로 숫자를 찾아서 ""공백으로 치환한다.
		 * \d 숫자인데, 자바에서는 다르게 사용해서 \\를 2개 붙인다.
		 */
		return s.replaceAll("[+-]?\\d+","").equals("") ? true : false; //정규식, 문자열에서 숫자를 없앤다.
		
	}	
}



