package java_backend_ex1;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


//ȸ�� ���� ��� ��
public class FrameSwingTextInput extends JFrame {
	
	private JTextField tf = new JTextField(20);
	private JTextArea ta = new JTextArea(7, 20);
	
	private String [] fruits= {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
	private ImageIcon [] images = { 
									new ImageIcon("D:\\\\workspace\\\\JAVA_work\\\\JAVA_BackEnd\\\\src\\\\java_backend_book_example\\\\zoomin.png"),
									new ImageIcon("D:\\\\workspace\\\\JAVA_work\\\\JAVA_BackEnd\\\\src\\\\java_backend_book_example\\\\zoomout.png")
	};	
	
	//����Ʈ ������ ����
	private JTextField tf2 = new JTextField(10);
	private Vector<String> v = new Vector<String>(); 
	private JList<String> nameList = new JList<String>(v);	
	
	
	//�޺��ڽ� 
	//private String [] fruits = {"apple", "banana", "kiwi", "mango", "pear",
	//		"peach", "berry", "strawberry", "blackberry"};
	private String [] names = {"kitae", "jaemoon", "hyosoo", "namyun"};
			
	private JLabel imgLabel = new JLabel(images[0]); 
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);
	
	//jslider change
	private JLabel colorLabel;
	private JSlider [] sl = new JSlider [3];
	
	public FrameSwingTextInput() {
		setTitle("�ؽ�Ʈ�ʵ� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		//�ؽ�Ʈ �ڽ�
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		c.add(new JLabel("�̸�"));
		c.add(new JTextField(20));
		c.add(new JLabel("�а�"));
		c.add(new JTextField("��ǻ�Ͱ��а�",20));
		c.add(new JLabel("�ּ�"));
		c.add(new JTextField("�����...",20));
		
		//textarea
		c.setLayout(new FlowLayout());
		c.add(new JLabel("�Է� �� <Enter> Ű�� �Է��ϼ���")); c.add(tf);
		c.add(new JScrollPane(ta));
		tf.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource(); 
				ta.append(t.getText() + "\n");
				t.setText(""); 
			}
		});
		
		//����Ʈ ���ùڽ� 
		JList<String> strList = new JList<String>(fruits);
		c.add(strList);
		
		JList<ImageIcon> imageList = new JList<ImageIcon>(); 
		
		imageList.setListData(images);
		c.add(imageList);
		
		JList<String> scrollList = new JList<String>(fruits); 
		c.add(new JScrollPane(scrollList)); 		
		
		
		//����Ʈ�� ������ �����ϱ�
		c.add(new JLabel("�̸� �Է� �� <Enter> Ű>>"));
		c.add(tf2);
		v.add("Ȳ����");
		v.add("���繮");
		nameList.setVisibleRowCount(5); 
		nameList.setFixedCellWidth(270); 
		c.add(new JScrollPane(nameList));		
		
		// JTextField�� ActionLister ���. <Enter> Ű ó�� 
		tf2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				JTextField t = (JTextField)e.getSource();
				v.add(t.getText()); 
				t.setText("");
				nameList.setListData(v);
			}
		});
		
		
		//�޺��ڽ�
		JComboBox<String> strCombo = new JComboBox<String>(fruits); 
		c.add(strCombo);
		
		JComboBox<String> nameCombo = new JComboBox<String>(); 
		for(int i=0; i<names.length; i++)
			nameCombo.addItem(names[i]); 
			c.add(nameCombo);
		
		
		//���ùڽ� �̹��� ǥ��
		c.add(strCombo);
		c.add(imgLabel);		
		strCombo.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource(); 
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
			}
		});	
		
		//JSlider ��ȭ
		colorLabel = new JLabel(" SLIDER EXAMPLE ");
		for(int i=0; i<sl.length; i++) {
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128); 
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			sl[i].addChangeListener(new MyChangeListener()); 
			c.add(sl[i]);
		}
		sl[0].setForeground(Color.RED); 
		sl[1].setForeground(Color.GREEN); 
		sl[2].setForeground(Color.BLUE);
		
		int r = sl[0].getValue(); 
		int g = sl[1].getValue(); 
		int b = sl[2].getValue(); 
		
		colorLabel.setOpaque(true); 
		colorLabel.setBackground(new Color(r,g,b));
		c.add(colorLabel);

		
		setSize(300,900);
		setVisible(true);
		
	}
	
	
	
	class MyChangeListener2 implements ChangeListener { 
		public void stateChanged(ChangeEvent e) {
			int r = sl[0].getValue();
			int g = sl[1].getValue();
			int b = sl[2].getValue();
			colorLabel.setBackground(new Color(r,g,b));
		}
	}
	
	class MyChangeListener implements ChangeListener { 
		public void stateChanged(ChangeEvent e) {
			int r = sl[0].getValue();
			int g = sl[1].getValue();
			int b = sl[2].getValue();
			colorLabel.setBackground(new Color(r,g,b));
		}
	}

	
	public static void main(String[] args) {
		new FrameSwingTextInput();
	}
	
}
