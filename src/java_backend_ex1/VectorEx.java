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


//�� (x, y)�� ǥ���ϴ� Point Ŭ������ �����, Point�� ��ü�� �ٷ�� ���͸� �ۼ��϶�.
//������ �ٷ�� ���͸� �����ϰ�, Ȱ���ϴ� �⺻ ��ʸ� ���δ�.
public class VectorEx {
	

	public static void main(String[] args) {
		
		// ���� ���� �ٷ�� ���׸� ���� ����
		Vector<PointVector> v = new Vector<PointVector>(); 
		v.add(new PointVector(2,3)); // 5 ����
		v.add(new PointVector(-5,20)); // 4 ����
		v.add(new PointVector(30,-8)); // -1 ����
		v.remove(1); // �ε��� 1�� Point(-5, 20) ��ü ����
		
		// ���� �߰��� �����ϱ�
		//v.add(2, 100); // 4�� -1 ���̿� ���� 100 ����
		
		System.out.println("���� ���� ��� ��ü �� : " + v.size()); 
		System.out.println("������ ���� �뷮 : " + v.capacity()); 
		
		// ��� ��� ���� ����ϱ�
		for(int i=0; i<v.size(); i++) { 
			PointVector p = v.get(i); 
			System.out.println(p);
		}
	
		
	}
}
