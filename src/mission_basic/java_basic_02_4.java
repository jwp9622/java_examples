package mission_basic;

import java.util.Arrays;

/*
(Java) 5개의 정수 오름차순 정렬하기
*/

public class java_basic_02_4 {

	public static void main(String[] args) {
		
		int[] num = {34,2,56,86,19};
		Arrays.sort(num);
		System.out.println("오름차순의 값은 : "+ Arrays.toString(num));//배열에 추가
	}
}

