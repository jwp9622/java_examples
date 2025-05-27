package java_backend_ex1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;

public class Frame extends JFrame {
	
	JLabel lb = new JLabel("Hello");
	public Frame() {
		setTitle("500x500 스윙 프레임 만들기"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane(); // 객체넣을 컨텐트팬 지정
		c.setBackground(Color.ORANGE); //배경색 
		c.setLayout(new FlowLayout()); //순차적으로 배치
		
		/*
		//borderlayout 위치지정
		c.setLayout(new BorderLayout(30, 20));
		c.add(new JButton("Calculate"), BorderLayout.CENTER); 
		c.add(new JButton("add"), BorderLayout.NORTH); 
		c.add(new JButton("sub"), BorderLayout.SOUTH); 
		c.add(new JButton("mul"), BorderLayout.EAST);
		c.add(new JButton("div"), BorderLayout.WEST);		
		*/
		
		//gridLayout
		/*//계산기 모양
		c.setLayout(new GridLayout(4,3,5,5)); // 4×3 분할로 배치 
		c.add(new JButton("1")); // 상단 왼쪽 첫 번째 셀에 버튼 배치 
		c.add(new JButton("2")); // 그 옆 셀에 버튼 배치
		c.add(new JButton("3")); // 그 옆 셀에 버튼 배치
		c.add(new JButton("4")); // 그 옆 셀에 버튼 배치
		c.add(new JButton("5")); // 그 옆 셀에 버튼 배치
		c.add(new JButton("6")); // 그 옆 셀에 버튼 배치
		*/
		
		/*
		//입력 폼 모양
		c.setLayout(new GridLayout(4,2)); // 4×3 분할로 배치 
		c.add(new JLabel(" 이름"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학번"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학과"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 과목"));
		c.add(new JTextField(""));
		*/
		
		/*
		 * // 버튼 생성 
		for(int i=1; i<=9; i++) {
			JButton b = new JButton(Integer.toString(i)); // 버튼 생성 
			b.setLocation(i*15, i*15);
			b.setSize(50, 20);
			c.add(b); // 버튼을 컨텐트팬에 부착 
		}
		*/
			
		//ok버튼 리스너 넣기 - 내부 클래스로이벤트 리스터 만들기
		JButton btn_ok = new JButton("OK");
		c.add(btn_ok);
		btn_ok.addActionListener(new MyActionListener()); // Action 리스너 달기
		
		//취소버튼 리스너 넣기 - 익명 클래스로 리스너 만들기
		JButton btn_cancel = new JButton("Cancel");
		c.add(btn_cancel);
		btn_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("Cancel"))
					b.setText("취소");
				else
					b.setText("Cancel");
					//setTile(b.getText());
			}
		});

		//레이블 표시
		lb.setBackground(Color.red);
		lb.setLocation(130, 50);
		lb.setSize(200, 20);
		c.add(lb);

		//Ignore 어댑터 리스터 호출
		JButton btn_ignore = new JButton("Ignore");
		c.add(btn_ignore);	
		new MyActionAdapter();
		
		btn_ignore.addMouseListener(new MyActionAdapter()); // Action 리스너 달기
		

		
		//마우스 클릭 어댑터 리스너
		c.addMouseListener(new MouseAdapter() {
			public void mousePressend(MouseEvent e) {
				int x = e.getY();
				int y = e.getY();
				lb.setLocation(x,y);
			}
		});

		//마우스 클릭 리스너
		c.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				lb.setLocation(x,y);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		setSize(500,300); // 프레임 크기 300x300 
		setVisible(true); // 프레임 출력
	}
	
	private class MyActionAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.println(x+"__"+y);
			lb.setLocation(x,y);
		}
	}
	
	private class MyActionListener implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource(); 
			if(b.getText().equals("Action"))
				b.setText("액션");
			else
				b.setText("Action");
		}
	}	

	public static void main(String[] args) {
		new Frame();
	}
	
}