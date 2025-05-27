package java_backend_ex1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//파일 입출력 스트림
public class FileClass {

	public static void listDirectory(File dir) {
		System.out.println("-----" + dir.getPath() +"의 서브 리스트 입니다.-----");
		File[] subFiles = dir.listFiles(); 
		for(int i=0; i<subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t파일 크기: " + f.length()); 
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n\n",t, 		t, t, t);
			
		} 
	}
	
	public static void main(String[] args) {
		
		
		//파일 읽기
		File f1 = new File("d:\\Temp\\temp.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName()+"\n");
		String res="";
		
		if(f1.isFile()) res = "파일";
		else if(f1.isDirectory()) res = "디렉토리";
		System.out.println(f1.getPath() + "은 " + res + "입니다.");
		
		File f2 = new File("d:\\Temp\\java_sample"); 
		if(!f2.exists()) {
			f2.mkdir(); // 존재하지 않으면 디렉토리 생성
		}
		listDirectory(new File("d:\\Temp")); 
		f2.renameTo(new File("d:\\Temp\\java_sample")); 
		listDirectory(new File("c:\\Temp"));
		

		//파일 복사
		File src;
		File dest;	
		int c;
		
		
		//문자 스트림 FileReader와 FileWriter를 이용하여 c:\windows\system.ini를 c:\Temp\system.txt 파일로 복사하는 프로그램을 작성하라.
		src = new File("d:\\hangul.txt"); 
		dest = new File("d:\\Temp\\hangul.txt");
		try {
			FileReader fr = new FileReader(src); 
			FileWriter fw = new FileWriter(dest); 
		
			while((c = fr.read()) != -1) {
				fw.write((char)c); // 문자 하나 쓰고
			}
			fr.close();
			fw.close();
		
			System.out.println(src.getPath()+ "를 " + dest.getPath()+ "로 복사하였습니다.");
		} catch (IOException e) {
			System.out.println("파일 복사 오류"); 
		}		
		
		
		//바이트 스트림을 이용하여 바이너리 파일을 복사하는 프로그램을 작성하라
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
		
			System.out.println(src.getPath()+ "를 " + dest.getPath()+ "로 복사하였습니다.");
		} catch (IOException e) {
			System.out.println("파일 복사 오류"); 
		}
		
		//10KB 단위로 읽고 쓰도록 수정하여 고속으로 파일을 복사하라.
		src = new File("d:\\cat.jpg"); 
		dest = new File("d:\\Temp\\cat2.jpg"); 
		try {
		FileInputStream fi = new FileInputStream(src); 
		FileOutputStream fo = new FileOutputStream(dest);
		byte [] buf = new byte [1024*10]; // 10KB 버퍼
		while(true) {
			int n = fi.read(buf); // 버퍼 크기만큼 읽기. n은 실제 읽은 바이트 
			fo.write(buf, 0, n); // buf[0]부터 n 바이트 쓰기
			if(n <buf.length)
				break;
			}
			fi.close();
			fo.close();
			System.out.println( src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
		} catch (IOException e) { 
			System.out.println("파일 복사 오류"); 
		}
		
		
		
		
	}
}
