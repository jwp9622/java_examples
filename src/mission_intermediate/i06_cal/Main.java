package mission_intermediate.i06_cal;

import java.util.Arrays;


/*
 * �ڹ��߱� - 6. ���� ó���� ���Ե� ���� ���α׷� �ۼ��ϱ�
 */

public class Main {
	public static void main(String[] args) {
		
		int in1;
		int in2;
		
		//���� �Է¹ޱ�
		GetText gt;
		gt = new GetText();
		in1 = gt.GetTextInput();
		
		in2 = gt.GetTextInput();		
		
		//���ϱ�
		ProcAdd add = new ProcAdd();
		int num1 = add.exec(in1, in2);
		
		//����
		ProcSub sub = new ProcSub();
		int num2 = sub.exec(in1, in2);
			
		//���ϱ�
		ProcMul mul = new ProcMul();
		int num3 = mul.exec(in1, in2);
		
		//������
		ProcDiv div = new ProcDiv();
		int num4 = div.exec(in1, in2);
		
		System.out.println("���ϱ� : "+num1);
		System.out.println("���� : "+num2);
		System.out.println("���ϱ� : "+num3);
		System.out.println("������ : "+num4);
		
		
		
	}
}
