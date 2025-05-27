package mission_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
(Java) �迭�� ����� ����ϰ� �迭 ��Ҹ� �����ϴ� �޼��� �ۼ��ϱ� / ���, ���ϱ�, ����, ���ϱ�, ������
*/

class Calculate2{
	int[] array;
	float avg_val;
	int idx;
	int val;
	
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array) {
		this.array = array;
	}
	public float getAvg_val() {
		return avg_val;
	}
	public void setAvg_val(float avg_val) {
		this.avg_val = avg_val;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	
	//��� ���ϱ�
	public void avg() {
		float total = 0;
		for(int i=0;i< this.array.length;i++) {
			total += this.array[i];
		}
		this.avg_val = total / this.array.length;
	}

	//���ϱ�
	public void add() {
		int no = this.array.length;
		this.array = Arrays.copyOf(this.array, this.array.length+1);
		this.array[no] = this.val;
	}
	
	//�����ϱ�
	public void mod() {
		this.array[idx] = this.val;
	}
	
	//����
	public void del() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//�迭�� ���� list�� �ֱ�
		for(int num : this.array) {
			list.add(num);
		}
		//�� ����
		list.remove(this.idx);
		
		//�ٽ� �迭�� �ֱ�
		int[] reArray= new int[list.size()];
		for(int i=0;i<list.size();i++) {
			reArray[i] = list.get(i);
		}
		this.array = reArray;
	}
		
	
}



public class java_basic_02_1_ori {

	public static void main(String[] args) {
		
		int[] arry = {10,20,30,40,50,60,70,80,90};
		System.out.println("�����迭 : "+Arrays.toString(arry));
		
		Calculate2 cal = new Calculate2();
		cal.setArray(arry);
		
		//��ձ��ϱ�
		cal.avg();
		System.out.println("��� : "+cal.getAvg_val());
		
		//�迭�� �߰�
		cal.setVal(78);
		cal.add();
		System.out.println("�߰��� �迭 : "+ Arrays.toString(cal.getArray()) );

		//�迭 �Ϻλ���
		cal.setIdx(4);
		cal.del();
		System.out.println("������ �迭 : "+ Arrays.toString(cal.getArray()) );
		
		//�迭����
		cal.setIdx(1);
		cal.setVal(90);
		cal.mod();
		System.out.println("������ �迭 : "+ Arrays.toString(cal.getArray()) );
		
	}
}


