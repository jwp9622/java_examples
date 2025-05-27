package java_backend_ex1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java_backend_ex1.FrameKeyEvent.MyKeyListener;

//키보드로 상하좌우 움직이기
public class FrameFlying extends JFrame{

	private JLabel [] lb; 
	private JLabel lb2 = new JLabel("HELLO");
	private final int FLYING_UNIT = 10;
	
	Container c = getContentPane();
	
	public FrameFlying() {
		
		setTitle("상,하,좌,우 키를 이용하여 텍스트 움직이기"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		c = getContentPane();
		c.setLayout(null);
		

		c.addKeyListener(new MyKeyListener());
		
		lb2.setLocation(50,50);
		lb2.setSize(100,20);
		c.add(lb2);
		
		setSize(300,300);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
		
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Component com = (Component)e.getSource();
				com.setFocusable(true);
				com.requestFocus();
				super.mouseClicked(e);
			}
		});
		
	}
		
	
	class MyKeyListener extends KeyAdapter { 
		public void keyPressed(KeyEvent e) {

			int KeyCode = e.getKeyCode();
			//마우스 따라다느닌 기능 상,화,좌,우 키로 텍스트 움직이기
			System.out.println(KeyCode);
			switch (KeyCode) {
				case KeyEvent.VK_UP:
					lb2.setLocation(lb2.getX(), lb2.getY()-FLYING_UNIT );
					break;
				case KeyEvent.VK_DOWN:
					lb2.setLocation(lb2.getX(), lb2.getY()+FLYING_UNIT );
					break;
				case KeyEvent.VK_LEFT:
					lb2.setLocation(lb2.getX()-FLYING_UNIT, lb2.getY());
					break;
				case KeyEvent.VK_RIGHT:
					lb2.setLocation(lb2.getX()+FLYING_UNIT, lb2.getY());
					break;
			}
			
		}
	}	
	
	
	public static void main(String[] args) {
		new FrameFlying();
	}

}
