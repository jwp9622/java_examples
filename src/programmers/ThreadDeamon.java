package programmers;

public class ThreadDeamon implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println("���� �����尡 �������Դϴ�.");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}

	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadDeamon());
		thread.setDaemon(true);
		thread.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("���� �����尡 ����˴ϴ�.");
	}

}
