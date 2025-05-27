package mission_intermediate.i04_thread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ThreadDog extends Thread implements Interface{
	private Container contentPane;
	JLabel backgroundMap;
	JLabel label;
	JLabel label2;
	
	int i =0;
	
	public ThreadDog(Container contentPane, JLabel backgroundMap){
		this.contentPane = contentPane;
		this.backgroundMap = backgroundMap;
	}

	public void run() {
		
		label = new JLabel(new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\mission_i04_thread\\dog_yellow_128.png"));
		label.setSize(128,128);
		label.setLocation(450,250);
        backgroundMap.add(label);
        
		
		
         // 타이머로 애니메이션 효과 추가
        Timer timer = new Timer(100, new ActionListener() {
            int xPosition = 450;
            int yPosition = 250;

            @Override
            public void actionPerformed(ActionEvent e) {

                // 패널을 이동시키기 (오른쪽 + 위로 날리기)
                //xPosition += 5;  // 오른쪽으로 이동
                yPosition += -5;  // 위로 이동

                // setBounds로 위치를 설정
                label.setBounds(xPosition, yPosition, 128, 128);
                
                // 화면 밖으로 나가면 애니메이션 종료
                if (yPosition < 245 ) {
                	yPosition = 250;
                }
            }
        });
        timer.start();
        
	}
}

