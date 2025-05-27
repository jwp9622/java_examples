package mission_intermediate.i08_shapearray;

import java.util.Arrays;

/*
 * 자바중급 - 8. 도형 클래스와 도형 배열 다루기
 */
public class Main {
	public static void main(String[] args) {
		
		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle("빨강",4.0);
		shapes[1] = new Square("노랑",200,300);
		shapes[2] = new Triangle("노랑",200,300);

		for(Shape s : shapes) {
			s.area();
			s.printInfo();
			s.draw();	
		}
		
		
	}

}

