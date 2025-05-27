package mission_basic;

import java.util.Arrays;

/*
(Java) 1부터 10까지의 숫자 배열 출력하기
*/

public class java_basic_02_6 {

	public static void main(String[] args) {
		
		int num = 20;
		String str = (num % 2 == 0) ? "짝수" :  "홀수";
		
		System.out.println("현재 숫자는 : "+ str);//배열에 추가
		
	}
	
}

