package mission_intermediate.i10_company;

public class Abstract implements Interface{

	int x;
	int y;
	int square;
	
	@Override
	public void area() {
		this.square= this.x * this.y;
	}
	
	void set(int x, int y) {
		this.x=x;
		this.y=y;
	}
	void show(){
		System.out.println("≥–¿Ã: "+this.square);
	}

}
