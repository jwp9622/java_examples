package java_backend_ex1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//���� ����� ��Ʈ��
public class FileClass {

	public static void listDirectory(File dir) {
		System.out.println("-----" + dir.getPath() +"�� ���� ����Ʈ �Դϴ�.-----");
		File[] subFiles = dir.listFiles(); 
		for(int i=0; i<subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t���� ũ��: " + f.length()); 
			System.out.printf("\t������ �ð�: %tb %td %ta %tT\n\n",t, 		t, t, t);
			
		} 
	}
	
	public static void main(String[] args) {
		
		
		//���� �б�
		File f1 = new File("d:\\Temp\\temp.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName()+"\n");
		String res="";
		
		if(f1.isFile()) res = "����";
		else if(f1.isDirectory()) res = "���丮";
		System.out.println(f1.getPath() + "�� " + res + "�Դϴ�.");
		
		File f2 = new File("d:\\Temp\\java_sample"); 
		if(!f2.exists()) {
			f2.mkdir(); // �������� ������ ���丮 ����
		}
		listDirectory(new File("d:\\Temp")); 
		f2.renameTo(new File("d:\\Temp\\java_sample")); 
		listDirectory(new File("c:\\Temp"));
		

		//���� ����
		File src;
		File dest;	
		int c;
		
		
		//���� ��Ʈ�� FileReader�� FileWriter�� �̿��Ͽ� c:\windows\system.ini�� c:\Temp\system.txt ���Ϸ� �����ϴ� ���α׷��� �ۼ��϶�.
		src = new File("d:\\hangul.txt"); 
		dest = new File("d:\\Temp\\hangul.txt");
		try {
			FileReader fr = new FileReader(src); 
			FileWriter fw = new FileWriter(dest); 
		
			while((c = fr.read()) != -1) {
				fw.write((char)c); // ���� �ϳ� ����
			}
			fr.close();
			fw.close();
		
			System.out.println(src.getPath()+ "�� " + dest.getPath()+ "�� �����Ͽ����ϴ�.");
		} catch (IOException e) {
			System.out.println("���� ���� ����"); 
		}		
		
		
		//����Ʈ ��Ʈ���� �̿��Ͽ� ���̳ʸ� ������ �����ϴ� ���α׷��� �ۼ��϶�
		src = new File("d:\\dog.jpg"); 
		dest = new File("d:\\Temp\\dog.jpg");
		try {
			FileInputStream fi = new FileInputStream(src); 
			FileOutputStream fo = new FileOutputStream(dest); 
		
			while((c = fi.read()) != -1) {
				fo.write((byte)c);
			}
			fi.close();
			fo.close();
		
			System.out.println(src.getPath()+ "�� " + dest.getPath()+ "�� �����Ͽ����ϴ�.");
		} catch (IOException e) {
			System.out.println("���� ���� ����"); 
		}
		
		//10KB ������ �а� ������ �����Ͽ� ������� ������ �����϶�.
		src = new File("d:\\cat.jpg"); 
		dest = new File("d:\\Temp\\cat2.jpg"); 
		try {
		FileInputStream fi = new FileInputStream(src); 
		FileOutputStream fo = new FileOutputStream(dest);
		byte [] buf = new byte [1024*10]; // 10KB ����
		while(true) {
			int n = fi.read(buf); // ���� ũ�⸸ŭ �б�. n�� ���� ���� ����Ʈ 
			fo.write(buf, 0, n); // buf[0]���� n ����Ʈ ����
			if(n <buf.length)
				break;
			}
			fi.close();
			fo.close();
			System.out.println( src.getPath() + "�� " + dest.getPath() + "�� �����Ͽ����ϴ�.");
		} catch (IOException e) { 
			System.out.println("���� ���� ����"); 
		}
		
		
		
		
	}
}
