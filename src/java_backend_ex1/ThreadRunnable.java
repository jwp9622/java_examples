package java_backend_ex1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

// 타이머쓰레드, 글자깜박임, 글자 비내리는 쓰레드

class RandomThread extends Thread {
	private Container contentPane;
	private boolean flag=false; // 스레드의 종료 명령을 표시하는 플래그. true : 종료 지시 
	public RandomThread(Container contentPane) { 
		this.contentPane = contentPane;
	}

	void finish() { // 스레드 종료 명령을 flag에 표시
		flag = true;
	}

	@Override
	public void run() {
		while(true) { 
			int x = ((int)(Math.random()*contentPane.getWidth())); 
			int y = ((int)(Math.random()*contentPane.getHeight())); 
			JLabel label = new JLabel("Java"); //새 레이블 생성
			label.setSize(80, 30); 
			label.setLocation(x, y);
			contentPane.add(label); 
			contentPane.repaint(); 
			try {
					Thread.sleep(300); // 0.3초 동안 잠을 잔다.
					if(flag==true) {
						contentPane.removeAll();
						label = new JLabel("finish"); 
						label.setSize(80, 30); 
						label.setLocation(100, 100); 
						label.setForeground(Color.RED);
						contentPane.add(label); 
						contentPane.repaint(); 
						return; // 스레드 종료
					}
			}catch(InterruptedException e) { return;   }
		}
	}
}



class FlickeringLabel extends JLabel implements Runnable {
	private long delay; 
	
	private Container contentPane;
	private boolean flag=false; // 스레드의 종료 명령을 표시하는 플래그. true : 종료 지시 


	void finish() { // 스레드 종료 명령을 flag에 표시
		flag = true;
	}

	public FlickeringLabel(String text, long delay) { 
		super(text);
		this.delay = delay;
		setOpaque(true);
		Thread th = new Thread(this);
		
		long id = Thread.currentThread().getId(); // 스레드 ID 얻기
		String name = Thread.currentThread().getName(); // 스레드 이름 얻기
		int priority = Thread.currentThread().getPriority(); // 스레드 우선순위 값 얻기 
		Thread.State s = Thread.currentThread().getState(); // 스레드 상태 값 얻기 
		System.out.println(text+" 현재 스레드 이름 = " + name);
		System.out.println(text+" 현재 스레드 ID = " + id);
		System.out.println(text+" 현재 스레드 우선순위 값 = " + priority); 
		System.out.println(text+" 현재 스레드 상태 = " + s);
		
		th.start();
	}
	
	@Override
	public void run() {

		//글자깜박이는 효과
		int n=0;
		while(true) {
			if(n == 0)
				setBackground(Color.YELLOW); 
			else
				setBackground(Color.GREEN); 
			if(n == 0) n = 1;
			else n = 0;
			try {
				Thread.sleep(delay); 
			}catch(InterruptedException e) { return;
			} 
		}	
		
	}
	
	
}


class TimerThreadCall extends Thread {
	private JLabel timerLabel;
	public TimerThreadCall(JLabel timerLabel) { 
		this.timerLabel = timerLabel;
	}

	@Override
	public void run() {
		int n=0; 
		while(true) {
			timerLabel.setText(Integer.toString(n)); 
			n++; 
			try {
				Thread.sleep(1000);
			}
				catch(InterruptedException e) {
				return;
			}
		}
	}
}

class SharedBoard {
	private int sum = 0; // 집계판의 합
	synchronized public void add() {
		
	int n = sum;
	Thread.yield(); // 현재 실행 중인 스레드 양보
	n += 10; // 10 증가
	sum = n; // 증가한 값을 집계합에 기록
	System.out.println(Thread.currentThread().getName() + " : " + sum); }
	public int getSum() { return sum; }
}

class StudentThread extends Thread {
	private SharedBoard board; // 집계판의 주소 
	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++)
			board.add();
	}
}



public class ThreadRunnable extends JFrame  {
	private RandomThread rth;
	private TimerThreadCall th;
	
	public ThreadRunnable() {
		setTitle("FlickeringLabelEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 깜박이는 레이블 생성
		FlickeringLabel fLabel = new FlickeringLabel("깜박",500);
		// 깜박이지 않는 레이블 생성
		JLabel label = new JLabel("안깜박");
		// 깜박이는 레이블 생성
		FlickeringLabel fLabel2 = new FlickeringLabel("여기도 깜박",300); 
		c.add(fLabel);
		c.add(label);
		c.add(fLabel2);
		
		//타이머 호출
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80)); 
		th = new TimerThreadCall(timerLabel);
		c.add(timerLabel);

		// 타이머 호출- 버튼을 생성하고 Action 리스너 등록
		JButton btn =new JButton("kill Timer");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				th.interrupt(); // 타이머 스레드 강제 종료 
				JButton btn = (JButton)e.getSource(); 
				btn.setEnabled(false); // 버튼 비활성화
			}
		});
		c.add(btn);
		
		//랜덤 쓰레드 호출
		c.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				rth.finish(); 
			}
		});
		
		setSize(300,300);
		setVisible(true);
		th.start();
		
		rth = new RandomThread(c);
		rth.start();
	}	

	
	public static void main(String[] args) {
		new ThreadRunnable();
		
		SharedBoard board = new SharedBoard(); 
		Thread th1 = new StudentThread("kitae", board);
		Thread th2 = new StudentThread("hyosoo", board);
		th1.start();
		th2.start();	
	}
	
}