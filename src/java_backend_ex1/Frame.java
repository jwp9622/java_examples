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
		setTitle("500x500 ���� ������ �����"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane(); // ��ü���� ����Ʈ�� ����
		c.setBackground(Color.ORANGE); //���� 
		c.setLayout(new FlowLayout()); //���������� ��ġ
		
		/*
		//borderlayout ��ġ����
		c.setLayout(new BorderLayout(30, 20));
		c.add(new JButton("Calculate"), BorderLayout.CENTER); 
		c.add(new JButton("add"), BorderLayout.NORTH); 
		c.add(new JButton("sub"), BorderLayout.SOUTH); 
		c.add(new JButton("mul"), BorderLayout.EAST);
		c.add(new JButton("div"), BorderLayout.WEST);		
		*/
		
		//gridLayout
		/*//���� ���
		c.setLayout(new GridLayout(4,3,5,5)); // 4��3 ���ҷ� ��ġ 
		c.add(new JButton("1")); // ��� ���� ù ��° ���� ��ư ��ġ 
		c.add(new JButton("2")); // �� �� ���� ��ư ��ġ
		c.add(new JButton("3")); // �� �� ���� ��ư ��ġ
		c.add(new JButton("4")); // �� �� ���� ��ư ��ġ
		c.add(new JButton("5")); // �� �� ���� ��ư ��ġ
		c.add(new JButton("6")); // �� �� ���� ��ư ��ġ
		*/
		
		/*
		//�Է� �� ���
		c.setLayout(new GridLayout(4,2)); // 4��3 ���ҷ� ��ġ 
		c.add(new JLabel(" �̸�"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �й�"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �а�"));
		c.add(new JTextField(""));
		c.add(new JLabel(" ����"));
		c.add(new JTextField(""));
		*/
		
		/*
		 * // ��ư ���� 
		for(int i=1; i<=9; i++) {
			JButton b = new JButton(Integer.toString(i)); // ��ư ���� 
			b.setLocation(i*15, i*15);
			b.setSize(50, 20);
			c.add(b); // ��ư�� ����Ʈ�ҿ� ���� 
		}
		*/
			
		//ok��ư ������ �ֱ� - ���� Ŭ�������̺�Ʈ ������ �����
		JButton btn_ok = new JButton("OK");
		c.add(btn_ok);
		btn_ok.addActionListener(new MyActionListener()); // Action ������ �ޱ�
		
		//��ҹ�ư ������ �ֱ� - �͸� Ŭ������ ������ �����
		JButton btn_cancel = new JButton("Cancel");
		c.add(btn_cancel);
		btn_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("Cancel"))
					b.setText("���");
				else
					b.setText("Cancel");
					//setTile(b.getText());
			}
		});

		//���̺� ǥ��
		lb.setBackground(Color.red);
		lb.setLocation(130, 50);
		lb.setSize(200, 20);
		c.add(lb);

		//Ignore ����� ������ ȣ��
		JButton btn_ignore = new JButton("Ignore");
		c.add(btn_ignore);	
		new MyActionAdapter();
		
		btn_ignore.addMouseListener(new MyActionAdapter()); // Action ������ �ޱ�
		

		
		//���콺 Ŭ�� ����� ������
		c.addMouseListener(new MouseAdapter() {
			public void mousePressend(MouseEvent e) {
				int x = e.getY();
				int y = e.getY();
				lb.setLocation(x,y);
			}
		});

		//���콺 Ŭ�� ������
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
		
		
		setSize(500,300); // ������ ũ�� 300x300 
		setVisible(true); // ������ ���
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
				b.setText("�׼�");
			else
				b.setText("Action");
		}
	}	

	public static void main(String[] args) {
		new Frame();
	}
	
}