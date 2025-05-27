package mission_intermediate.i05_abstract;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class Square extends Abstract  {
	
	Graphics g;
	
	int x = 100;
	int y = 130;
	int width = 100;
	int height = 100;
	
	Square(Graphics g){
		this.g = g;
		
		draw();
	}


	@Override
	public void draw() {
	      // 사각형 그리기
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
  
	}

}
