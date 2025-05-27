package programmers;

public class ThreadExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t1 = new MyThread("*");
		MyThread t2 = new MyThread("-");
		
		t1.start();
		t2.start();
		
		//메인쓰레드가 종료되도 쓰레드는 돌아감
		System.out.println("main end!!!"); 

	}

}
