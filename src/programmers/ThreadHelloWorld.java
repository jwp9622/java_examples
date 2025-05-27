package programmers;


class ThreadMarket {
	private int count_product = 0;
	final private int MAX = 3; 
	final private int MIN = 0;
	
	synchronized public void add() {
		System.out.print("[�߰���" + count_product + "]");
		while (count_product >= MAX) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		count_product++;
		notifyAll();
		System.out.print("[�߰���" + count_product + "]");
	}
	
	synchronized public void remove() {
		System.out.print("[������" + count_product + "]");
		while (count_product <= MIN) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count_product--;
		notifyAll();
		System.out.print("[������" + count_product + "]");
		
	}

	synchronized public int getCount_product() {
		return count_product;
	}
}

class ProducerThread extends Thread {
	ThreadMarket m;
	
	public ProducerThread(ThreadMarket m) {
		this.m = m;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) {	
			ThreadHelloWorld.threadSleep((int)(Math.random()*10));
			m.add();
		}
	}
}

class ConsumerThread extends Thread {
	ThreadMarket m;
	
	public ConsumerThread(ThreadMarket m) {
		this.m = m;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			ThreadHelloWorld.threadSleep((int)(Math.random()*10));
			m.remove();
		}
	}
}





public class ThreadHelloWorld {
	public static void main(String[] args) {
		ThreadMarket m = new ThreadMarket();
		ProducerThread pt = new ProducerThread(m);
		ConsumerThread ct = new ConsumerThread(m);
		
		pt.start();
		ct.start();
		
		try {
			pt.join();
			ct.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("%nResult: " + m.getCount_product());
	}
	
	static void threadSleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	