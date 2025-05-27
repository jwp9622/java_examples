package mission_intermediate.i08_shapearray;

import java.util.*;

public class Circle extends Shape implements Interface{

	private double radius;	
	private int width;
	private int height;
	private double area;
	
    public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}
	
	@Override
	public void area() {
		this.area = this.radius * radius * 3.14;
	}

	@Override
	public void draw() {
		System.out.println("원을 그립니다.\n");
	}

	@Override
	public void printInfo() {
		System.out.println("원 색상 : "+this.color);
		System.out.println("원 넓이 : "+this.area);
	}
		

}	
