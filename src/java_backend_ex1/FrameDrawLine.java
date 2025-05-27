package java_backend_ex1;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

//라인 그리기 예제
public class FrameDrawLine extends JFrame {

	private Vector<Point> vStart = new Vector<Point>(); 
	private Vector<Point> vEnd = new Vector<Point>(); 
	private MyPanel panel = new MyPanel();
	
	public FrameDrawLine() {
		setTitle("drawing Line by Mouse 예제"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setContentPane(panel);
		setSize(500,500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public MyPanel() {
			addMouseListener(new MouseAdapter(){ 
				public void mousePressed(MouseEvent e) {
					Point startP = e.getPoint();
					vStart.add(startP);
				}
				public void mouseReleased(MouseEvent e) { 
					Point endP = e.getPoint();
					vEnd.add(endP);
					repaint();
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) { 
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			for(int i=0; i<vStart.size(); i++) {
				Point s = vStart.elementAt(i);
				Point e = vEnd.elementAt(i);

				g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());
			} 
		}
		
	}
	
	
	public static void main(String[] args) {
		new FrameDrawLine();
	}

}
