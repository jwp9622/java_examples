package java_backend_ex1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

//frame  이미지 표시, 버튼, 체크박스, 라디오버튼 표시
//버튼 표시
public class FrameSwing extends JFrame{

	private JCheckBox[] fruits = new JCheckBox[3];
	private String [] names = {"사과","배","체리"};
	private JLabel sumLabel;
	private ImageIcon[] imagesIcons = {
			new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\apple_big.png"),
			new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\pear_big.png"),
			new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\cherry_big.png")
	};
	
	private JRadioButton [] radios = new JRadioButton[3];
	private JLabel imageLabel = new JLabel();

	public FrameSwing() {
		super("JComponent의 공통 메소드 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//버튼지정
		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton(" Disabled Button ");
		JButton b3 = new JButton("getX(), getY()");
		
		//버튼 리스터 지정
		b1.setBackground(Color.YELLOW); // 배경색 설정
		b1.setForeground(Color.MAGENTA); // 글자색 설정
		b1.setFont(new Font("Arial", Font.ITALIC, 20)); // Arial, 20픽셀 폰트 설정 
		b2.setEnabled(false); // 버튼 비활성화
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			FrameSwing frame = (FrameSwing)b.getTopLevelAncestor(); 
			frame.setTitle(b.getX() + "," + b.getY()); // 타이틀에 버튼 좌표 출력
		}
		});
		
		//버튼 추가
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		//이미지 레이블 추가
		JLabel textLabel = new JLabel("사랑합니다");
		
		ImageIcon animal = new ImageIcon("D:\\\\workspace\\\\JAVA_work\\\\JAVA_BackEnd\\\\src\\\\java_backend_book_example\\\\dog.jpg");
		//JLabel imageLabel = new JLabel(animal);
		
		ImageIcon nomalIcon = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_book_example\\refresh.png");
		JLabel label = new JLabel("보고 싶으면 전화하세요",nomalIcon, SwingConstants.CENTER);
		c.add(textLabel);
		c.add(imageLabel);
		c.add(label);

		
		//이미지 버튼 추가
		ImageIcon pressedIcon  = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_book_example\\zoomin.png");
		ImageIcon rolloverIcon = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_book_example\\zoomout.png");

		JButton btn = new JButton("call--", nomalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		c.add(btn);
		
		//체크박스 추가
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배",true);
		ImageIcon cherryIcon = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_book_example\\cherry.png");
		JCheckBox cherry = new JCheckBox("체리",cherryIcon);
		
		//체크박스 리스너 추가
		c.add(new JLabel("사과 100원, 배 500원, 체리 2,000원"));
		MyItemListener listener = new MyItemListener();
		for(int i=0;i<fruits.length;i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(listener);
		}
		sumLabel = new JLabel("현재 0원 입니다.");
		c.add(sumLabel);
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
		//라디오 버튼
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(Color.GRAY);
		ButtonGroup g = new ButtonGroup();
		
		for(int i=0;i<radios.length;i++) {
			radios[i] = new JRadioButton(names[i]);
			g.add(radios[i]);
			radioPanel.add(radios[i]);
			radios[i].addItemListener(new MyItemListener());
		}
		radios[2].setSelected(true);
		
		c.add(radioPanel, BorderLayout.NORTH);
		c.add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

		
		setSize(600,600);
		setVisible(true);
	}
	
	
	//체크박스 리스너
	class MyItemListener implements ItemListener { 
		private int sum = 0; // 가격의 합
		public void itemStateChanged(ItemEvent e) {
			
			//체크박스 선택 조건
			if(e.getStateChange() == ItemEvent.SELECTED) { 
				if(e.getItem() == fruits[0])
					sum += 100;
				else if(e.getItem() == fruits[1])
					sum += 500;
				else
					sum += 20000;
			}else {
				if(e.getItem() == fruits[0])
					sum -= 100;
				else if(e.getItem() == fruits[1])
					sum -= 500;
				else
					sum -= 20000;
			}
			sumLabel.setText("현재 "+ sum + "원 입니다.");
			
			//라디온 선택조건
			if(e.getStateChange() == ItemEvent.DESELECTED)
				return;
			
			
			if(radios[0].isSelected())
				imageLabel.setIcon(imagesIcons[0]);
			else if(radios[1].isSelected())
				imageLabel.setIcon(imagesIcons[1]);
			else
				imageLabel.setIcon(imagesIcons[2]);
			
		}
	}	
	
	
	public static void main(String[] args) { 
		new FrameSwing();
	}
		
	
}
