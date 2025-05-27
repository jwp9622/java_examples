package mission_intermediate.i04_thread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//������ ȣ��
public class CallThread extends JFrame {

	private JLabel imglabel = new JLabel();
	private ThreadFlower fth;
	private ThreadDog dth;

	JLabel backgroundMap;
	JLabel flower;
	JLabel dog;
	
	public CallThread(){
		initData();
		//setData();
	}
	private void initData() {
		setTitle("������ �����Ͽ� ���ÿ� �����ϱ�"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		Container contentPane = getContentPane();
		setLayout(new FlowLayout());

		//��� �̹��� ����
		ImageIcon img = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\mission_i04_thread\\spring.jpg");
		backgroundMap = new JLabel(img);
		backgroundMap.setSize(600,400);
		backgroundMap.setLocation(0,0);
		add(backgroundMap);
		
		
		//ù��° ������ ȣ��
		fth = new ThreadFlower(contentPane, backgroundMap);
		fth.start();
		

		//�ι�° ������ ȣ��
		dth = new ThreadDog(contentPane, backgroundMap);
		dth.start();
		
		
		setVisible(true);
		
	}
	
	
}
