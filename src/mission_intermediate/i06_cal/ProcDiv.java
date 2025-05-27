package mission_intermediate.i06_cal;

public class ProcDiv implements Interface {

	@Override
	public int exec(int a, int b) {
		return (a>=b) ? 0 : a/b ;
	}

	
}
