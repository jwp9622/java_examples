package mission_intermediate.i08_shapearray;

import java.util.Arrays;

/*
 * �ڹ��߱� - 8. ���� Ŭ������ ���� �迭 �ٷ��
 */
public class Main {
	public static void main(String[] args) {
		
		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle("����",4.0);
		shapes[1] = new Square("���",200,300);
		shapes[2] = new Triangle("���",200,300);

		for(Shape s : shapes) {
			s.area();
			s.printInfo();
			s.draw();	
		}
		
		
	}

}

