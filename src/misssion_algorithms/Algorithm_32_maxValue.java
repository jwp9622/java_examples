package misssion_algorithms;

import java.util.Arrays;

//32	�迭���� �ִ밪ã��˰������ϱ�
public class Algorithm_32_maxValue {
	public static void main(String[] args) {
		
		int array[] = {10,12,1233,54,5,25,257,235,125};
		int max = Arrays.stream(array).max().getAsInt();
		int min = Arrays.stream(array).min().getAsInt();
		
		System.out.println("�ִ밪 : "+max);
		System.out.println("�ּҰ� : "+min);
		
	}

}
