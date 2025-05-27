package mission_intermediate.i05_abstract;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Circle extends Abstract implements Interface { //extends Abstract

	Graphics g;
	
	int x = 50;
	int y = 10;
	int width = 100;
	int height = 100;
	
	Circle(Graphics g){
		this.g = g;
		
		draw();
	}


	@Override
	public void draw() {
	      // 원 그리기
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
  
	}
	
}	
