package mission_intermediate.i01_array;
import java.util.Arrays;

/*
 * �ڹ��߱� - 1. �迭�� ����Ͽ� ������ ���� �˰��� �����ϱ�
 */
public class Main {

	public static void main(String[] args) {
		
		int[] array = {34,24,78,10,100,32,44,55,22};
		
		//��������
		BubbleSort b = new BubbleSort();
		b.setArry(array);
		b.sort();
		System.out.println("�������ĵ� �迭 : "+Arrays.toString(b.getArry()));
		
		//��������
		SelectSort ss = new SelectSort();
		ss.setArry(array);
		ss.sort();
		System.out.println("�������ĵ� �迭 : "+Arrays.toString(ss.getArry()));
		
	}

}
