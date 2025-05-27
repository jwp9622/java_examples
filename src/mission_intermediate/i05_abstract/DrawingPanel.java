package mission_intermediate.i05_abstract;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


// ���� Ŭ����: ������ �׸� JPanel ����
class DrawingPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

		 // ��� �� ����
	     setBackground(Color.WHITE);
	     
	     //���׸���
	     Circle circle = new Circle(g);

	     //�簢�� �׸���
	     Square square = new Square(g);

	     //�ﰢ�� �׸���
	     Triangle triangle = new Triangle(g);
	     
		
		//�밢���׸���
		g.setColor(Color.RED); 
		g.drawLine(20, 20, 300, 300);
  
        // �� �׸���
        g.setColor(Color.GREEN);
        g.drawLine(50, 200, 300, 200);

        // �ؽ�Ʈ �׸���
        g.setColor(Color.BLACK);
        g.drawString("���� �׸��� ����", 180, 300);
 
        
    }
}	

