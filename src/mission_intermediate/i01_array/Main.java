package mission_intermediate.i01_array;
import java.util.Arrays;

/*
 * 자바중급 - 1. 배열을 사용하여 간단한 정렬 알고리즘 구현하기
 */
public class Main {

	public static void main(String[] args) {
		
		int[] array = {34,24,78,10,100,32,44,55,22};
		
		//버블정렬
		BubbleSort b = new BubbleSort();
		b.setArry(array);
		b.sort();
		System.out.println("버블정렬된 배열 : "+Arrays.toString(b.getArry()));
		
		//선택정렬
		SelectSort ss = new SelectSort();
		ss.setArry(array);
		ss.sort();
		System.out.println("선택정렬된 배열 : "+Arrays.toString(ss.getArry()));
		
	}

}
