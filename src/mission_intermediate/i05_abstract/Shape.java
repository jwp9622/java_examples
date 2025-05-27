package mission_intermediate.i05_abstract;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Shape extends JFrame{

	DrawingPanel panel = new DrawingPanel();
	
	public Shape() {
		
		setTitle("도형 프로그램 작성하기"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		//contentPane = getContentPane();
		setSize(600, 400);
		
		setLayout(new FlowLayout());
		setVisible(true);
		
	}
	
	
 


}
