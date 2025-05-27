package mission_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
(Java) 배열의 평균을 계산하고 배열 요소를 변경하는 메서드 작성하기 
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

	//평균 구하기
	public void avg() {
		int total = 0;
		for(int i=0;i< this.array.length;i++) {
			total += this.array[i];
		}
		double num = (double) total/ this.array.length; //평균계산
		this.avg_val = Math.round(num*10)/10.0; //소수 첫번째자리까지 자르기
	}
	
	
	//평균내용을 다시 배열에 넣기
	public void reAvg() {
		for(int i=0;i< this.array.length;i++) {
			this.array[i] = (int) Math.round(avg_val); //반올림
		}
	}

}


public class java_basic_02_1 {

	public static void main(String[] args) {
		
		int[] arry = {10,28,65,87,50,38,78,54,90};
		System.out.println("원래배열 : "+Arrays.toString(arry));
		
		Calculate cal = new Calculate();
		cal.setArray(arry);
		
		//평균구하기
		cal.avg();
		System.out.println("평균 : "+cal.getAvg_val());
		
		//평균값으로 배열 변경
		cal.reAvg();
		System.out.println("평균값으로 변경된 배열 : "+ Arrays.toString(cal.getArray()));
		
	}
	
}


