package mission_basic;
import java.util.Scanner;

/*
 * (Java) ����ڷκ��� ���簢���� ���ο� ���θ� �Է¹޾� ���� ����ϱ�
 * */
public class java_basic_02_2 {

	public static void main(String[] args) {
		
		int width = 0;
		int height = 0;
		int area = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���̸� �Է��ϼ���=");//�迭�� �߰�
		width = sc.nextInt();

		System.out.print("���� ���̸� �Է��ϼ���=");//�迭�� �߰�
		height = sc.nextInt();
		
		area = width*height;
		sc.close();

		System.out.println("���簢�� ���� : "+area);//�迭�� �߰�
		
	}
}


