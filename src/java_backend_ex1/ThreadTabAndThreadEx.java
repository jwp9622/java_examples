package java_backend_ex1;

import java.awt.Point;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//�ƹ�Ű�� ��� ������ ��ũ������ ��Ÿ��
//wait(), notify()�� �̿��� �� ä���
class MyLabel extends JLabel {
	int barSize = 0; // ���� ũ��
	int maxBarSize;
	
	MyLabel(int maxBarSize) { 
		this.maxBarSize = maxBarSize;
	}
	
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width = (int)(((double)(this.getWidth()))/maxBarSize*barSize);
		if(width==0) return; 
		g.fillRect(0, 0, width, this.getHeight());
	}
	synchronized void fill() {
		if(barSize == maxBarSize) {
			try {
				wait(); 
			} catch (InterruptedException e) { return; } 
		}
		barSize++;
		repaint(); // �� �ٽ� �׸��� 
		notify(); 
	}
	
	synchronized void consume() {
		if(barSize == 0) {
			try {
				wait(); 
			} catch (InterruptedException e){ return; }
		}
		barSize--;
		repaint(); // �� �ٽ� �׸���
		notify(); 
	}
}

class ConsumerThread extends Thread { 
	MyLabel bar; ConsumerThread(MyLabel bar) {
			this.bar = bar;
	}
	public void run() {
		while(true) {
			try {
				sleep(200);
				bar.consume(); 
			} catch (InterruptedException e){ 
				return; 
			} 
		}
	} 
}




public class ThreadTabAndThreadEx extends JFrame {
	
	MyLabel bar = new MyLabel(100); 
	ThreadTabAndThreadEx(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Container c = getContentPane();
		
		c.setLayout(null);
		bar.setBackground(Color.ORANGE); 
		bar.setOpaque(true);
		bar.setLocation(20,  50);
		bar.setSize(300, 20); 
		c.add(bar);
		

		System.out.println("____111");
		c.addKeyListener(new KeyAdapter() { 
			public void keyPressed(KeyEvent e) {
				System.out.println("____333");
				bar.fill(); 
			}
		});
		setSize(350,200);
		setVisible(true);
		c.requestFocus(); 
		
		ConsumerThread ths = new ConsumerThread(bar); 
		ths.start(); // ������ ����
	}	
	
	
	public static void main(String[] args) {
		new ThreadTabAndThreadEx("�ƹ�Ű�� ���� ���� �� ä���");
	} 
}

