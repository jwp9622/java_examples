package mission_basic;

/*
(Java) �� ���� ������ ���ϰ� ���� �޼��� �ۼ��ϱ�
*/

public class java_basic_02_3 {
	public static void main(String[] args) {
		
		int no1 = 34;
		int no2 = 90;
		
		System.out.println("�� ���� ���Ѱ� : "+add(no1, no2));//�迭�� �߰�
		System.out.println("�� ���� �� �� : "+sub(no1, no2));//�迭�� �߰�
	}
	public static int add(int no1, int no2) {
		return no1 + no2;
	}
	public static int sub(int no1, int no2) {
		return no1 - no2;
	}
}

