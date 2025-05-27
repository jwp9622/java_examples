package mission_intermediate.i05_abstract;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

class Triangle extends Abstract  {
	
	Graphics g;
	
	int[] xPoints = {100, 150, 50};
    int[] yPoints = {50, 150, 150};
    int nPoints = 3;
    
	Triangle(Graphics g){
		this.g = g;
		
		draw();
	}


	@Override
	public void draw() {
	      // 삼각형 그리기
        //g.setColor(Color.PINK);
        //g.fillOval(x, y, width, height);
        
        g.setColor(Color.GREEN);
        g.fillPolygon(xPoints, yPoints, nPoints);
	}
	

}
