package mission_intermediate.i02_ramda;

import java.util.Arrays;

/*
 * �ڹ��߱� - 2. ���� ǥ������ Ȱ���� ������ ���� ���α׷� �ۼ��ϱ� 
 */

public class Main   {
	public static void main(String[] args) {

		double a = 23;
		double b = 20;
		
		//���ٽ�
		Interface add = (no1,no2) -> no1+no2;
		Interface sub = (no1,no2) -> no1-no2;
		Interface mul = (no1,no2) -> no1*no2;
		Interface div = (no1,no2) -> {
			double no = (no2==0)? 0 : no1/no2;
			return no;
		};

		System.out.println("���ϱ� : "+add.exec(a, b));
		System.out.println("���ϱ� : "+add.exec(a, b));
		System.out.println("���� : "+sub.exec(a, b));
		System.out.println("���ϱ� : "+mul.exec(a, b));
		System.out.println("������ : "+div.exec(a, b));
		
	}
}

