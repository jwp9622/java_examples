package mission_intermediate.i08_shapearray;

abstract class Shape implements Interface {
	String color;
	public Shape(String color) {
		this.color = color;
	}
	public void draw() {}
	public abstract void printInfo();
	public void area() {};
}
