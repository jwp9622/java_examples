package mission_basic;

import java.util.regex.Pattern;

public class regexp_sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "abcd+-*&�����Դϴ�.";
		
		boolean bl = Pattern.matches("^[0-9]*$", str);
		System.out.println(bl);
		

	}

}
