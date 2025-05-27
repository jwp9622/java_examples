package mission_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
(Java) 배열의 평균을 계산하고 배열 요소를 변경하는 메서드 작성하기 / 평균, 더하기, 빼기, 곱하기, 나누기
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
	
	//평균 구하기
	public void avg() {
		float total = 0;
		for(int i=0;i< this.array.length;i++) {
			total += this.array[i];
		}
		this.avg_val = total / this.array.length;
	}

	//더하기
	public void add() {
		int no = this.array.length;
		this.array = Arrays.copyOf(this.array, this.array.length+1);
		this.array[no] = this.val;
	}
	
	//수정하기
	public void mod() {
		this.array[idx] = this.val;
	}
	
	//삭제
	public void del() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//배열의 값을 list에 넣기
		for(int num : this.array) {
			list.add(num);
		}
		//값 삭제
		list.remove(this.idx);
		
		//다시 배열에 넣기
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
		System.out.println("원래배열 : "+Arrays.toString(arry));
		
		Calculate2 cal = new Calculate2();
		cal.setArray(arry);
		
		//평균구하기
		cal.avg();
		System.out.println("평균 : "+cal.getAvg_val());
		
		//배열에 추가
		cal.setVal(78);
		cal.add();
		System.out.println("추가한 배열 : "+ Arrays.toString(cal.getArray()) );

		//배열 일부삭제
		cal.setIdx(4);
		cal.del();
		System.out.println("삭제한 배열 : "+ Arrays.toString(cal.getArray()) );
		
		//배열수정
		cal.setIdx(1);
		cal.setVal(90);
		cal.mod();
		System.out.println("수정한 배열 : "+ Arrays.toString(cal.getArray()) );
		
	}
}


