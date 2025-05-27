package java_backend_ex1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;


// 마우스 움직이면 위치값과 색상변경
public class FrameMouseListenerAll extends JFrame {
	
	private JLabel la = new JLabel("No Mouse Event");
	
	public FrameMouseListenerAll() {
		
		setTitle("MouseListener와 MouseMotionListener 예제"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Container c = getContentPane();
		c.setLayout(new FlowLayout()); 
		
		MyMouseListener listener = new MyMouseListener(); 
		c.addMouseListener(listener); 
		c.addMouseMotionListener(listener); 
		
		c.add(la);
		setSize(300,200); 
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener{
		
		public void mousePressed(MouseEvent e) {
			la.setText("mousePressed("+e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("mouseReleased("+e.getX()+","+e.getY()+")");
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("mouseDragged("+e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("mouseMoved("+e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() ==2) {
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				Component c = (Component)e.getSource();
				c.setBackground(new Color(r,g,b));
			}
			
		}


		@Override
		public void mouseEntered(MouseEvent e) { //프레임안에 마우스가 들어왔을때
			Component c = (Component)e.getSource();
			c.setBackground(Color.CYAN); //엔터클릭할때는 하늘색
			
		}

		@Override
		public void mouseExited(MouseEvent e) { //프레임안에 마우스가 나갔을때
			Component c = (Component)e.getSource();
			c.setBackground(Color.YELLOW); //나가기는 노랑색
		}
	}
	
	
		
	public static void main(String[] args) {
		new FrameMouseListenerAll();
		

	}
}
