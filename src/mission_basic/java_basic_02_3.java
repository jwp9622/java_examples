package mission_basic;

/*
(Java) 두 개의 정수를 더하고 빼는 메서드 작성하기
*/

public class java_basic_02_3 {
	public static void main(String[] args) {
		
		int no1 = 34;
		int no2 = 90;
		
		System.out.println("두 수의 더한값 : "+add(no1, no2));//배열에 추가
		System.out.println("두 수의 뺀 값 : "+sub(no1, no2));//배열에 추가
	}
	public static int add(int no1, int no2) {
		return no1 + no2;
	}
	public static int sub(int no1, int no2) {
		return no1 - no2;
	}
}

