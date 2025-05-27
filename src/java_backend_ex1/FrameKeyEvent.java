package java_backend_ex1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//Ű���� Ű�� ������� ���� ǥ��
public class FrameKeyEvent extends JFrame {

	private JLabel [] lb; 
	private JLabel lb2 = new JLabel("HELLO");
	Container c = getContentPane();
	private final int FLYING_UNIT = 10;
	 
	public FrameKeyEvent() {
		
		setTitle("keyListener ����"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addKeyListener(new MyKeyListener());
		
		lb = new JLabel [3]; 
		lb[0] = new JLabel(" getKeyCode() "); 
		lb[1] = new JLabel(" getKeyChar() "); 
		lb[2] = new JLabel(" getKeyText() "); 
	
		for(int i=0; i<lb.length; i++) {
			c.add(lb[i]);
			lb[i].setOpaque(true); 
			lb[i].setBackground(Color.YELLOW);
		}	
		
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
			
			//Ű�� ���� ����ȭ
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar(); 
			lb[0].setText(Integer.toString(keyCode)); 
			lb[1].setText(Character.toString(keyChar)); 
			lb[2].setText(e.getKeyText(keyCode));
			
			if(e.getKeyChar() =='%') //%Ű�� ��������
				c.setBackground(Color.YELLOW);
			else if(e.getKeyCode()==KeyEvent.VK_F1) //F1 Ű�� ��������
				c.setBackground(Color.GREEN);
			
			//Ű���� ����ٴ��� ��� ��,ȭ,��,�� Ű�� �ؽ�Ʈ �����̱�
			System.out.println("keyCode="+keyCode);
			
			switch (keyCode) {
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
		new FrameKeyEvent();
	}
	
}
