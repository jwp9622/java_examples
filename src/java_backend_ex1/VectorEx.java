package java_backend_ex1;

import java.util.Vector;


class PointVector {
	private int x, y; public PointVector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "(" + x + "," + y + ")";  
	}
}


//점 (x, y)를 표현하는 Point 클래스를 만들고, Point의 객체만 다루는 벡터를 작성하라.
//정수만 다루는 벡터를 생성하고, 활용하는 기본 사례를 보인다.
public class VectorEx {
	

	public static void main(String[] args) {
		
		// 정수 값만 다루는 제네릭 벡터 생성
		Vector<PointVector> v = new Vector<PointVector>(); 
		v.add(new PointVector(2,3)); // 5 삽입
		v.add(new PointVector(-5,20)); // 4 삽입
		v.add(new PointVector(30,-8)); // -1 삽입
		v.remove(1); // 인덱스 1의 Point(-5, 20) 객체 삭제
		
		// 벡터 중간에 삽입하기
		//v.add(2, 100); // 4와 -1 사이에 정수 100 삽입
		
		System.out.println("벡터 내의 요소 객체 수 : " + v.size()); 
		System.out.println("벡터의 현재 용량 : " + v.capacity()); 
		
		// 모든 요소 정수 출력하기
		for(int i=0; i<v.size(); i++) { 
			PointVector p = v.get(i); 
			System.out.println(p);
		}
	
		
	}
}
