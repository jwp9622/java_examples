package java_backend_ex1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


//이미지 잘라서 보여주기
public class FrameGraphicsPicture extends JFrame {
	
	private MyPanel panel = new MyPanel();
	
	public FrameGraphicsPicture() {
		setTitle("원본 크기로 원하는 위치에 이미지 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setContentPane(panel);
		setSize(300, 420);
		setVisible(true);
	}	

	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\dog.jpg"); 
		private ImageIcon icon2 = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\pear_big.png"); 
		private Image img = icon.getImage(); // 이미지 객체 
		private Image img2 = icon2.getImage(); // 이미지 객체 
		public void paintComponent(Graphics g) {
			super.paintComponent(g); 
			//g.drawImage(img, 20, 20, this); //이미지 표시하기
			//g.drawImage(img, 0, 0, getWidth(), getHeight(), this); //가로세로 100%
			//g.drawImage(img, 20, 20, 250, 100, 100, 50, 200, 200, this); //이미지의 일부분 크기조절하여 그리기
			
			//클리핑 영역에 그리기, 특정영억만 잘라서 보여주기
			//g.setClip(100, 20, 150, 150);
			
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(img2, 0, 0, 50, 50, this);
			g.setColor(Color.YELLOW); // 글자표현
			g.setFont(new Font("Arial", Font.ITALIC, 40)); 
			g.drawString("Go Gator!!", 10, 150);
			
		}
	}

	public static void main(String[] args) {
		new FrameGraphicsPicture();

	}

}
