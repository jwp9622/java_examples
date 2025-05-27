package java_backend_ex1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

//��������ϱ�
public class FrameGraphicsShape extends JFrame {
	private MyPanel panel = new MyPanel();
	public FrameGraphicsShape() {
		setTitle("JPanel�� paintComponent() ����"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setContentPane(panel);
		setSize(500,500);
		setVisible(true);
	}
	
	
	class MyPanel extends JPanel { 
		public void paintComponent(Graphics g) {
			super.paintComponent(g); 
			
			//�׸� ���� ���
			g.setColor(Color.BLUE);
			g.drawRect(10,10,50,50); 
			g.fillRect(10,10,50,50);
			
			//�׸� ���� ���
			g.setColor(Color.YELLOW);
			g.drawRect(100,50,50,50);
			g.fillRect(100,50,50,50);
			
			//�� �׸� ���� ���
			g.setColor(Color.MAGENTA); 
			g.drawRect(90,100,50,50);
			
			

			//���� ���
			g.setColor(Color.BLACK); 
			g.drawString("Hello World",100,50);
			g.drawString("We are the world",100,60);
			
			
			//���ڿ� ����ϱ�
			g.drawString("I Love Java.~~", 30,100); 
			g.setColor(new Color(255, 0, 0));
			g.setFont(new Font("Arial", Font.ITALIC, 30));
			g.drawString("How much?", 30, 80); 
			g.setColor(new Color(0x00ff00ff));
			for(int i=1; i<=5; i++) {
				g.setFont(new Font("Jokerman", Font.ITALIC, i*10)); 
				g.drawString("This much!!", 30, 60+i*60);
			}
			
			//�밢���׸���
			g.setColor(Color.RED); 
			g.drawLine(20, 20, 300, 300);
			
			//���׸���
			g.setColor(Color.CYAN); 
			g.drawLine(20, 20, 300, 300); 
			
			//�簢�� �׸���
			g.setColor(Color.BLUE); 
			g.drawRect(100,100,80,80);
			g.fillRect(100,100,80,80);
			
			//�簢�� �׸���
			g.setColor(Color.GREEN); 
			g.drawRoundRect(20,20,120,80, 40,60);
			g.fillRoundRect(20,100,80,80,90,270);
			
			// ��ȣ
			g.setColor(Color.CYAN);
			g.drawArc(20,100,80,80,90,270);
			g.fillArc(20,100,80,80,90,270);
			
			//��ٰ��� �׸���
			g.setColor(Color.ORANGE);
			int []x = {80,40,80,120}; 
			int []y = {40,120,200,120}; 
			g.drawPolygon(x, y, 4);
			g.fillPolygon(x, y, 4);
			
			
			
			
		}
	}
	
	public static void main(String [] args) { 
		new FrameGraphicsShape();
	}	
	
}
