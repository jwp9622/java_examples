package programmers;

public class ThreadExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t1 = new MyThread("*");
		MyThread t2 = new MyThread("-");
		
		t1.start();
		t2.start();
		
		//���ξ����尡 ����ǵ� ������� ���ư�
		System.out.println("main end!!!"); 

	}

}
