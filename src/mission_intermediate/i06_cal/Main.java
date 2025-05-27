package mission_intermediate.i06_cal;

import java.util.Arrays;


/*
 * 자바중급 - 6. 예외 처리가 포함된 계산기 프로그램 작성하기
 */

public class Main {
	public static void main(String[] args) {
		
		int in1;
		int in2;
		
		//문자 입력받기
		GetText gt;
		gt = new GetText();
		in1 = gt.GetTextInput();
		
		in2 = gt.GetTextInput();		
		
		//더하기
		ProcAdd add = new ProcAdd();
		int num1 = add.exec(in1, in2);
		
		//빼기
		ProcSub sub = new ProcSub();
		int num2 = sub.exec(in1, in2);
			
		//곱하기
		ProcMul mul = new ProcMul();
		int num3 = mul.exec(in1, in2);
		
		//나누기
		ProcDiv div = new ProcDiv();
		int num4 = div.exec(in1, in2);
		
		System.out.println("더하기 : "+num1);
		System.out.println("빼기 : "+num2);
		System.out.println("곱하기 : "+num3);
		System.out.println("나누기 : "+num4);
		
		
		
	}
}
