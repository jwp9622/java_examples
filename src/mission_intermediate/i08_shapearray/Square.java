package mission_intermediate.i08_shapearray;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;

public class Square extends Shape  {
	
	private int width;
	private int height;
	private double area;
	
    public Square(String color, int width, int height) {
		super(color);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void area() {
		this.area = width * height;
	}
	
	@Override
	public void draw() {
		System.out.println("�簢���� �׸��ϴ�.\n");
	}
	
	@Override
	public void printInfo() {
		System.out.println("�簢�� ���� : "+this.color);
		System.out.println("�簢�� ���� : "+this.area);
	}
		
	
	

}
