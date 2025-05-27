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

//frame  �̹��� ǥ��, ��ư, üũ�ڽ�, ������ư ǥ��
//��ư ǥ��
public class FrameSwing extends JFrame{

	private JCheckBox[] fruits = new JCheckBox[3];
	private String [] names = {"���","��","ü��"};
	private JLabel sumLabel;
	private ImageIcon[] imagesIcons = {
			new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\apple_big.png"),
			new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\pear_big.png"),
			new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\cherry_big.png")
	};
	
	private JRadioButton [] radios = new JRadioButton[3];
	private JLabel imageLabel = new JLabel();

	public FrameSwing() {
		super("JComponent�� ���� �޼ҵ� ����");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//��ư����
		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton(" Disabled Button ");
		JButton b3 = new JButton("getX(), getY()");
		
		//��ư ������ ����
		b1.setBackground(Color.YELLOW); // ���� ����
		b1.setForeground(Color.MAGENTA); // ���ڻ� ����
		b1.setFont(new Font("Arial", Font.ITALIC, 20)); // Arial, 20�ȼ� ��Ʈ ���� 
		b2.setEnabled(false); // ��ư ��Ȱ��ȭ
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			FrameSwing frame = (FrameSwing)b.getTopLevelAncestor(); 
			frame.setTitle(b.getX() + "," + b.getY()); // Ÿ��Ʋ�� ��ư ��ǥ ���
		}
		});
		
		//��ư �߰�
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		//�̹��� ���̺� �߰�
		JLabel textLabel = new JLabel("����մϴ�");
		
		ImageIcon animal = new ImageIcon("D:\\\\workspace\\\\JAVA_work\\\\JAVA_BackEnd\\\\src\\\\java_backend_book_example\\\\dog.jpg");
		//JLabel imageLabel = new JLabel(animal);
		
		ImageIcon nomalIcon = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_book_example\\refresh.png");
		JLabel label = new JLabel("���� ������ ��ȭ�ϼ���",nomalIcon, SwingConstants.CENTER);
		c.add(textLabel);
		c.add(imageLabel);
		c.add(label);

		
		//�̹��� ��ư �߰�
		ImageIcon pressedIcon  = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_book_example\\zoomin.png");
		ImageIcon rolloverIcon = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_book_example\\zoomout.png");

		JButton btn = new JButton("call--", nomalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		c.add(btn);
		
		//üũ�ڽ� �߰�
		JCheckBox apple = new JCheckBox("���");
		JCheckBox pear = new JCheckBox("��",true);
		ImageIcon cherryIcon = new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_book_example\\cherry.png");
		JCheckBox cherry = new JCheckBox("ü��",cherryIcon);
		
		//üũ�ڽ� ������ �߰�
		c.add(new JLabel("��� 100��, �� 500��, ü�� 2,000��"));
		MyItemListener listener = new MyItemListener();
		for(int i=0;i<fruits.length;i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(listener);
		}
		sumLabel = new JLabel("���� 0�� �Դϴ�.");
		c.add(sumLabel);
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
		//���� ��ư
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
	
	
	//üũ�ڽ� ������
	class MyItemListener implements ItemListener { 
		private int sum = 0; // ������ ��
		public void itemStateChanged(ItemEvent e) {
			
			//üũ�ڽ� ���� ����
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
			sumLabel.setText("���� "+ sum + "�� �Դϴ�.");
			
			//���� ��������
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
