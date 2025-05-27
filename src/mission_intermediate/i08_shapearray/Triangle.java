package mission_intermediate.i08_shapearray;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;

class Triangle extends Shape  {
	
	private int width;
	private int height;
	private double area;

    public Triangle(String color, int width, int height) {
		super(color);
		this.width = width;
		this.height = height;
	}

	@Override
	public void area() {
		this.area = (width * height)/2;
	}	

	@Override
	public void draw() {
		System.out.println("�ﰢ���� �׸��ϴ�.\n");
	}

	@Override
	public void printInfo() {
		System.out.println("�ﰢ�� ���� : "+this.color);
		System.out.println("�ﰢ�� ���� : "+this.area);
	}
		
	
	

}
