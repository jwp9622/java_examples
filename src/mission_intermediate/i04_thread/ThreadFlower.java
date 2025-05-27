package mission_intermediate.i04_thread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ThreadFlower extends Thread implements Interface{
	private Container contentPane;
	JLabel backgroundMap;
	JLabel label;
	int i=0;
	public ThreadFlower(Container contentPane, JLabel backgroundMap){
		this.contentPane = contentPane;
		this.backgroundMap = backgroundMap;
	}

	public void run() {
		
		label = new JLabel(new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\mission_i04_thread\\flower3_128.png"));
		label.setSize(128,128);
		label.setLocation(50,250);
        backgroundMap.add(label);
        
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
         // Ÿ�̸ӷ� �ִϸ��̼� ȿ�� �߰�
        Timer timer = new Timer(100, new ActionListener() {
            int xPosition = 50;
            int yPosition = 250;

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                // �г��� �̵���Ű�� (������ + ���� ������)
                xPosition += 5;  // ���������� �̵�
                //yPosition += 2;  // ���� �̵�

                // setBounds�� ��ġ�� ����
                label.setBounds(xPosition, yPosition, 128, 128);
                
                // ȭ�� ������ ������ �ִϸ��̼� ����
                if (xPosition > 60 ) {
                	xPosition = 50;
                }
                
            }
        });
        timer.start();
        
	}
}

