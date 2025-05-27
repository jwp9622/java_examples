package mission_intermediate.i05_abstract;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


// 내부 클래스: 도형을 그릴 JPanel 정의
class DrawingPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

		 // 배경 색 설정
	     setBackground(Color.WHITE);
	     
	     //원그리기
	     Circle circle = new Circle(g);

	     //사각형 그리기
	     Square square = new Square(g);

	     //삼각형 그리기
	     Triangle triangle = new Triangle(g);
	     
		
		//대각선그리기
		g.setColor(Color.RED); 
		g.drawLine(20, 20, 300, 300);
  
        // 선 그리기
        g.setColor(Color.GREEN);
        g.drawLine(50, 200, 300, 200);

        // 텍스트 그리기
        g.setColor(Color.BLACK);
        g.drawString("도형 그리기 예제", 180, 300);
 
        
    }
}	

