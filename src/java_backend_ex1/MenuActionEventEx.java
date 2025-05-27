package java_backend_ex1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.filechooser.FileNameExtensionFilter;


//������ �޴�, ����, ��ư, ��, �̹��� ǥ��
public class MenuActionEventEx extends JFrame {

	private JLabel imgLabel = new JLabel(); 
	private Container contentPane;
	private Container contentPane2;
	JTextField tf;
	private JButton okButton = new JButton("OK");
	private MyDialog dialog;
	private MyModalDialog modaldialog;
	//private MyPopupDialog popupdialog;

	private JLabel imageLabel = new JLabel();
	private JLabel label = new JLabel("Hello");
	
	
	private JButton btns[] = { 
			new JButton("play"), 
			new JButton("stop"), 
			new JButton("play again")
	}; 
	private Clip clip;
	
	//����� ����
	private String song="D:\\\\workspace\\\\JAVA_work\\\\JAVA_BackEnd\\\\src\\\\java_backend_ex1\\\\alarm_accept.wav";

	public MenuActionEventEx() {
		setTitle("Menu�� Action ������ ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu();
		getContentPane().add(imgLabel, BorderLayout.CENTER);
		
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//���� ȣ��
		createToolBar();

		//���� �����ð�
		ToolTipManager m = ToolTipManager.sharedInstance(); 
		m.setInitialDelay(0);
		m.setDismissDelay(10000);	
		
		
		//���̾�α� ��ư
		JButton btn  = new JButton("Show Dialog");
		dialog = new MyDialog(this, "Test Dialog"); 
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				dialog.setVisible(true);
			}
		});
		contentPane.add(btn); //content�� ���̾�α� �߰�
		
		
		//��޴��̾�α� �����ֱ�
		contentPane2 = getContentPane();
		JButton btn2  = new JButton("Show Modal Dialog"); 
		modaldialog = new MyModalDialog(this, "Test Modal Dialog");
		btn2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				modaldialog.setVisible(true);
				String text = modaldialog.getInput(); 
				if(text == null) return; 
					JButton btn2 = (JButton)e.getSource(); 
					btn2.setText(text);
				}
		});
		getContentPane().add(btn2); //content�� ��� ���̾�α� �߰�
		
		//�˾� ���̾�α�
		contentPane.add(new MyPanel(), BorderLayout.NORTH);		
		
		//�� �̸� ǥ���ϱ�
		contentPane.setLayout(new FlowLayout());
		label.setHorizontalAlignment(SwingConstants.CENTER); //���̾ƿ� ��ġ����
		label.setFont(new Font("Ravie", Font.ITALIC, 30));  //��Ʈ����
		contentPane.add(label, BorderLayout.CENTER); //�� ǥ���ϱ�
		
		//���� �����
		JTabbedPane tappane = createTabbedPane();
		contentPane.add(tappane, BorderLayout.CENTER);
		
		
		//����� ���
		MyActionListener al = new MyActionListener(); 
		for(int i=0; i<btns.length; i++) {
			contentPane.add(btns[i]);
			btns[i].addActionListener(al);
		}
		loadAudio(song); //����� ���� ����

		
		setSize(500,500);
		setVisible(true);
	}
	
	
	//����� ��� �޼ҵ�
	private void loadAudio(String pathName) {
		try {
			
			File audioFile = new File(pathName); // ����� ������ ��θ� 
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile); 
			
			clip = AudioSystem.getClip(); // ����ִ� ����� Ŭ�� ����� 
			clip.addLineListener(new LineListener() {
				public void update(LineEvent e) {
					if (e.getType() == LineEvent.Type.STOP) {
						try {
							getContentPane().setBackground(Color.ORANGE); label.setText(song + " ���� ��!");
							audioStream.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			clip.open(audioStream);
			clip.start(); 

			
		}catch (LineUnavailableException e) { 
			e.printStackTrace(); 
		} catch (UnsupportedAudioFileException e) { 
			e.printStackTrace(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
	}
	
	
	//����� ��� Ŭ���� 
	class MyActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				switch(e.getActionCommand()) {
				case "play": clip.start(); // ����� ��� ���� break;
				case "stop": clip.stop(); // ����� ��� �ߴ� break;
				case "play again": clip.setFramePosition(0); clip.start();
				break;
			}
		}
	}
		
	
	//���� 
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT); 
		pane.addTab("tab1", new JLabel(new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\dog.jpg"))); 
		pane.addTab("tab2", new JLabel(new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\kakao.png"))); 
		pane.addTab("tab3", new MyTabPanel());
		return pane;
	}

	//����  
	class MyTabPanel extends JPanel { 
		public MyTabPanel() {
			this.setBackground(Color.YELLOW);
		}
			
		public void paintComponent(Graphics g) { 
			g.setColor(Color.RED);
			g.fillRect(10,10,50,50);
			g.setColor(Color.BLUE);
			g.fillOval(10,70,50,50);
			g.setColor(Color.BLACK);
			g.drawString("tab 3�� ���� JPanel �Դϴ�.", 30, 50);
		}
	}


	//�˾����̾�α�
	class MyPanel extends Panel {
		private JButton inputBtn = new JButton("Input Name"); 
		private JTextField tf = new JTextField(10);
		private JButton confirmBtn = new JButton("Confirm"); 
		private JButton messageBtn = new JButton("Message"); 
		public MyPanel() {
			
			setBackground(Color.LIGHT_GRAY);
			add(inputBtn);
			add(confirmBtn);
			add(messageBtn);
			add(tf);
			
			inputBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String name = JOptionPane.showInputDialog("�̸��� �Է��ϼ���");
					if(name == null)
						tf.setText(name);
				}
			});
			
			confirmBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, 
							"����� ���Դϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.CLOSED_OPTION)
						tf.setText("Juse Closed without SElection");
					else if(result == JOptionPane.YES_OPTION)
						tf.setText("Yes");
					else
						tf.setText("No");
				}
			});
			
			messageBtn.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, 
					"�����ϼ���", "Message", 
					JOptionPane.ERROR_MESSAGE); 
				}
			});
			
			
		}
		
	}
		
		
	//��� ���̾�α�
	class MyModalDialog extends JDialog {
		private JTextField tf = new JTextField(10);
		private JButton okButton = new JButton("OK"); 
		public MyModalDialog(JFrame frame, String title) {
			super(frame,title, true); // ��� ���̾�α׷� ���� 
			setLayout(new FlowLayout());
			add(tf);
			add(okButton);
			setSize(200, 100);
			okButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
		
		public String getInput() {
			if(tf.getText().length() == 0) return null; else return tf.getText();
		} 
	}
	
	//�Ϲ� ���̾�α�
	class MyDialog extends JDialog {
		private JTextField tf = new JTextField(10);
		private JButton okButton = new JButton("OK"); 
		
		public MyDialog(JFrame frame, String title) {
			super(frame,title);
			setLayout(new FlowLayout());
			add(tf);
			add(okButton);
			setSize(200, 100);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
	}	
	
	//�޴������
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem [] menuItem = new JMenuItem [6];
		String[] itemTitle = {"Load", "Hide", "ReShow", "Opens", "Color", "Exit"};
		JMenu screenMenu = new JMenu("Screen");
	
		// 4���� �޴��������� Screen �޴��� �����Ѵ�. 
		MenuActionListener listener = new MenuActionListener(); 
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); 
			menuItem[i].addActionListener(listener);
			screenMenu.add(menuItem[i]); 
		}
		mb.add(screenMenu);
		setJMenuBar(mb);
	}
	
	//ù��° �ֻ�� �޴� 
	class MenuActionListener implements ActionListener {
		private JFileChooser chooser;
		public MenuActionListener() {
			chooser = new JFileChooser(); 
		}
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) { // �޴� �������� ���� ����
				case "Load" :
				if(imgLabel.getIcon() != null)
					return; // �̹� �ε��Ǿ����� ����
				imgLabel.setIcon(new ImageIcon("images/img.jpg"));
				break;
			case "Hide" :
				imgLabel.setVisible(false);
				break;
			case "ReShow" :
				imgLabel.setVisible(true);
				break;
			case "Opens" :
				imgLabel.setVisible(true);
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) { 
					JOptionPane.showMessageDialog(null, 
					"������ �������� �ʾҽ��ϴ�", "���", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String filePath = chooser.getSelectedFile().getPath(); 
				System.out.println("filePath="+filePath);
				imageLabel.setIcon(new ImageIcon(filePath)); 
				//pack(); // �̹����� ũ�⿡ ���߾� ������ ũ�� ����		
				setSize(chooser.getWidth()+100, chooser.getHeight()+200); // �̹����� ũ�⿡ ���߾� ������ ũ�� ����		
				contentPane.add(imageLabel);
				
				break;
				
			case "Color":
				Color selectedColor = JColorChooser.showDialog(null, "Color", Color.YELLOW);
				if(selectedColor != null) label.setForeground(selectedColor);			
				break;
			case "Exit" :
				System.exit(0);
				break;
			}
		}
		
	}
	
	//�ι��� ����
	private void createToolBar() {
		
		JToolBar toolBar = new JToolBar("Kitae Menu");
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		JButton newBtn = new JButton("New");
		newBtn.setToolTipText("������ �����մϴ�.");
		toolBar.add(newBtn);
		
		JButton openBtn = new JButton(new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\file_open.png")); 
		openBtn.setToolTipText("������ ���ϴ�.");
		toolBar.add(openBtn);
			
		toolBar.addSeparator();
		
		JButton saveBtn = new JButton(new ImageIcon("D:\\workspace\\JAVA_work\\JAVA_BackEnd\\src\\java_backend_ex1\\file_save.png")); 
		saveBtn.setToolTipText("������ �����մϴ�.");
		toolBar.add(saveBtn);
		
		toolBar.add(new JLabel("search"));
		JTextField tf = new JTextField("text field");
		tf.setToolTipText("ã�����ϴ� ���ڿ��� �Է��ϼ���");
		
		toolBar.add(tf);
		
		JComboBox combo = new JComboBox(); combo.addItem("Java");
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		toolBar.add(combo);
		
		contentPane.add(toolBar, BorderLayout.NORTH);
		
	}
	
	
	public static void main(String [] args) {
		new MenuActionEventEx();
	}

}
