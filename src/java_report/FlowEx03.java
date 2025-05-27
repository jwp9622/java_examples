package java_report;

public class FlowEx03 {

	public static void main(String[] args) {

		String msg = "";
		String cate= "";
		
		for(int i=1;i<=19;i++) {
			
			String blank = (i <=9) ? " ":"";
			
			if(i <=16) {
				msg = blank+i;
				if ((i % 3) == 0) msg += " foo" ;
				if ((i % 5) == 0) msg += " bar" ;
				if ((i % 7) == 0) msg += " baz" ;
			}else if(i<=18) {
				msg = "";
			}else {
				msg = "and so on.";
			}
			System.out.println(msg);
		}
		
	}

}


/*
System.out.println(" 1");
System.out.println(" 2");
System.out.println(" 3 foo");
System.out.println(" 4");
System.out.println(" 5 bar");
System.out.println(" 6 foo");
System.out.println(" 7 bza");
System.out.println(" 8");
System.out.println(" 9 foo");
System.out.println("10 bar");
System.out.println("11");
System.out.println("12 foo");
System.out.println("13");
System.out.println("14 baz");
System.out.println("15 foo bar");
System.out.println("16");
*/


