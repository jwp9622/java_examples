package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class io_bufferReader_console {
	public static void main(String[] args) {
		
		//console ����ڿ��Լ� �Է¹������� ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(line);
		
	}
}
