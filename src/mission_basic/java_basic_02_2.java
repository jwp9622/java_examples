package mission_basic;
import java.util.Scanner;

/*
 * (Java) 사용자로부터 직사각형의 가로와 세로를 입력받아 넓이 출력하기
 * */
public class java_basic_02_2 {

	public static void main(String[] args) {
		
		int width = 0;
		int height = 0;
		int area = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 길이를 입력하세요=");//배열에 추가
		width = sc.nextInt();

		System.out.print("세로 길이를 입력하세요=");//배열에 추가
		height = sc.nextInt();
		
		area = width*height;
		sc.close();

		System.out.println("직사각형 넓이 : "+area);//배열에 추가
		
	}
}


