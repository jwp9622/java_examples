package java_backend_ex1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


//�̹��� �߶� �����ֱ�
public class FrameGraphicsPicture extends JFrame {
	
	private MyPanel panel = new MyPanel();
	
	public FrameGraphicsPicture() {
		setTitle("���� ũ��� ���ϴ� ��ġ�� �̹��� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setContentPane(panel);
		setSize(300, 420);
		setVisible(true);
	}	

	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\dog.jpg"); 
		private ImageIcon icon2 = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\pear_big.png"); 
		private Image img = icon.getImage(); // �̹��� ��ü 
		private Image img2 = icon2.getImage(); // �̹��� ��ü 
		public void paintComponent(Graphics g) {
			super.paintComponent(g); 
			//g.drawImage(img, 20, 20, this); //�̹��� ǥ���ϱ�
			//g.drawImage(img, 0, 0, getWidth(), getHeight(), this); //���μ��� 100%
			//g.drawImage(img, 20, 20, 250, 100, 100, 50, 200, 200, this); //�̹����� �Ϻκ� ũ�������Ͽ� �׸���
			
			//Ŭ���� ������ �׸���, Ư�����︸ �߶� �����ֱ�
			//g.setClip(100, 20, 150, 150);
			
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(img2, 0, 0, 50, 50, this);
			g.setColor(Color.YELLOW); // ����ǥ��
			g.setFont(new Font("Arial", Font.ITALIC, 40)); 
			g.drawString("Go Gator!!", 10, 150);
			
		}
	}

	public static void main(String[] args) {
		new FrameGraphicsPicture();

	}

}
