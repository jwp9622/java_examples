package mission_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
(Java) �迭�� ����� ����ϰ� �迭 ��Ҹ� �����ϴ� �޼��� �ۼ��ϱ� 
*/

class Calculate{
	int[] array;
	double avg_val;
	
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array) {
		this.array = array;
	}
	public double getAvg_val() {
		return avg_val;
	}
	public void setAvg_val(double avg_val) {
		this.avg_val = avg_val;
	}

	//��� ���ϱ�
	public void avg() {
		int total = 0;
		for(int i=0;i< this.array.length;i++) {
			total += this.array[i];
		}
		double num = (double) total/ this.array.length; //��հ��
		this.avg_val = Math.round(num*10)/10.0; //�Ҽ� ù��°�ڸ����� �ڸ���
	}
	
	
	//��ճ����� �ٽ� �迭�� �ֱ�
	public void reAvg() {
		for(int i=0;i< this.array.length;i++) {
			this.array[i] = (int) Math.round(avg_val); //�ݿø�
		}
	}

}


public class java_basic_02_1 {

	public static void main(String[] args) {
		
		int[] arry = {10,28,65,87,50,38,78,54,90};
		System.out.println("�����迭 : "+Arrays.toString(arry));
		
		Calculate cal = new Calculate();
		cal.setArray(arry);
		
		//��ձ��ϱ�
		cal.avg();
		System.out.println("��� : "+cal.getAvg_val());
		
		//��հ����� �迭 ����
		cal.reAvg();
		System.out.println("��հ����� ����� �迭 : "+ Arrays.toString(cal.getArray()));
		
	}
	
}


