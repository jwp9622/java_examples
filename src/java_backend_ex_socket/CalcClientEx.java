package java_backend_ex_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalcClientEx {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in); 
		
		try {
			socket = new Socket("localhost", 9888);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				System.out.print("계산식(빈칸으로 띄어 입력,예:24 + 42)>>"); // 프롬프트 
				String outputMessage = scanner.nextLine(); // 키보드에서 수식 읽기 

				System.out.println("outputMessage="+outputMessage.equalsIgnoreCase("bye"));
				if (outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n"); // "bye" 문자열 전송
					out.flush();
					break; // 사용자가 "bye"를 입력한 경우 서버로 전송 후 연결 종료
				}
				System.out.println("____555");
				out.write(outputMessage + "\n"); // 키보드에서 읽은 수식 문자열 전송 out.flush();
				String inputMessage = in.readLine(); // 서버로부터 계산 결과 수신 
				System.out.println("계산 결과: " + inputMessage);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				if(socket != null) socket.close(); // 클라이언트 소켓 닫기 
			} catch (IOException e) {
				System.out.println("서버와 채팅 중 오류가 발생했습니다."); 
			}
		} 
	}

}
