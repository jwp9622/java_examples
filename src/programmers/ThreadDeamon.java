package programmers;

public class ThreadDeamon implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println("데몬 쓰레드가 실험중입니다.");
			
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
		System.out.println("메인 쓰레드가 종료됩니다.");
	}

}
