package java_backend_ex1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

// Ÿ�̸Ӿ�����, ���ڱ�����, ���� �񳻸��� ������

class RandomThread extends Thread {
	private Container contentPane;
	private boolean flag=false; // �������� ���� ����� ǥ���ϴ� �÷���. true : ���� ���� 
	public RandomThread(Container contentPane) { 
		this.contentPane = contentPane;
	}

	void finish() { // ������ ���� ����� flag�� ǥ��
		flag = true;
	}

	@Override
	public void run() {
		while(true) { 
			int x = ((int)(Math.random()*contentPane.getWidth())); 
			int y = ((int)(Math.random()*contentPane.getHeight())); 
			JLabel label = new JLabel("Java"); //�� ���̺� ����
			label.setSize(80, 30); 
			label.setLocation(x, y);
			contentPane.add(label); 
			contentPane.repaint(); 
			try {
					Thread.sleep(300); // 0.3�� ���� ���� �ܴ�.
					if(flag==true) {
						contentPane.removeAll();
						label = new JLabel("finish"); 
						label.setSize(80, 30); 
						label.setLocation(100, 100); 
						label.setForeground(Color.RED);
						contentPane.add(label); 
						contentPane.repaint(); 
						return; // ������ ����
					}
			}catch(InterruptedException e) { return;   }
		}
	}
}



class FlickeringLabel extends JLabel implements Runnable {
	private long delay; 
	
	private Container contentPane;
	private boolean flag=false; // �������� ���� ����� ǥ���ϴ� �÷���. true : ���� ���� 


	void finish() { // ������ ���� ����� flag�� ǥ��
		flag = true;
	}

	public FlickeringLabel(String text, long delay) { 
		super(text);
		this.delay = delay;
		setOpaque(true);
		Thread th = new Thread(this);
		
		long id = Thread.currentThread().getId(); // ������ ID ���
		String name = Thread.currentThread().getName(); // ������ �̸� ���
		int priority = Thread.currentThread().getPriority(); // ������ �켱���� �� ��� 
		Thread.State s = Thread.currentThread().getState(); // ������ ���� �� ��� 
		System.out.println(text+" ���� ������ �̸� = " + name);
		System.out.println(text+" ���� ������ ID = " + id);
		System.out.println(text+" ���� ������ �켱���� �� = " + priority); 
		System.out.println(text+" ���� ������ ���� = " + s);
		
		th.start();
	}
	
	@Override
	public void run() {

		//���ڱ����̴� ȿ��
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
	private int sum = 0; // �������� ��
	synchronized public void add() {
		
	int n = sum;
	Thread.yield(); // ���� ���� ���� ������ �纸
	n += 10; // 10 ����
	sum = n; // ������ ���� �����տ� ���
	System.out.println(Thread.currentThread().getName() + " : " + sum); }
	public int getSum() { return sum; }
}

class StudentThread extends Thread {
	private SharedBoard board; // �������� �ּ� 
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
		setTitle("FlickeringLabelEx ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// �����̴� ���̺� ����
		FlickeringLabel fLabel = new FlickeringLabel("����",500);
		// �������� �ʴ� ���̺� ����
		JLabel label = new JLabel("�ȱ���");
		// �����̴� ���̺� ����
		FlickeringLabel fLabel2 = new FlickeringLabel("���⵵ ����",300); 
		c.add(fLabel);
		c.add(label);
		c.add(fLabel2);
		
		//Ÿ�̸� ȣ��
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80)); 
		th = new TimerThreadCall(timerLabel);
		c.add(timerLabel);

		// Ÿ�̸� ȣ��- ��ư�� �����ϰ� Action ������ ���
		JButton btn =new JButton("kill Timer");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				th.interrupt(); // Ÿ�̸� ������ ���� ���� 
				JButton btn = (JButton)e.getSource(); 
				btn.setEnabled(false); // ��ư ��Ȱ��ȭ
			}
		});
		c.add(btn);
		
		//���� ������ ȣ��
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