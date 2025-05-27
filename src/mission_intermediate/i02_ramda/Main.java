package mission_intermediate.i02_ramda;

import java.util.Arrays;

/*
 * 자바중급 - 2. 람다 표현식을 활용한 간단한 계산기 프로그램 작성하기 
 */

public class Main   {
	public static void main(String[] args) {

		double a = 23;
		double b = 20;
		
		//람다식
		Interface add = (no1,no2) -> no1+no2;
		Interface sub = (no1,no2) -> no1-no2;
		Interface mul = (no1,no2) -> no1*no2;
		Interface div = (no1,no2) -> {
			double no = (no2==0)? 0 : no1/no2;
			return no;
		};

		System.out.println("더하기 : "+add.exec(a, b));
		System.out.println("더하기 : "+add.exec(a, b));
		System.out.println("빼기 : "+sub.exec(a, b));
		System.out.println("곱하기 : "+mul.exec(a, b));
		System.out.println("나누기 : "+div.exec(a, b));
		
	}
}

