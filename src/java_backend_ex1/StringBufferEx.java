package java_backend_ex1;

import java.util.StringTokenizer;

//StringBuffer를 이용하여 문자열을 조작하는 다음 코드의 실행 결과는 무엇인가?
		
public class StringBufferEx {
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("This");
		
		sb.append(" is pencil"); // 문자열 덧붙이기 
		System.out.println(sb);
		
		sb.insert(7, " my"); // "my" 문자열 삽입
		System.out.println(sb);
		
		sb.replace(8, 10, "your"); // "my"를 "your"로 변경 
		System.out.println(sb);
		
		sb.delete(8, 13); // "your " 삭제
		System.out.println(sb);
		
		sb.setLength(4); // 스트링 버퍼 내 문자열 길이 수정 
		System.out.println(sb);
		
		String query = "name=hong&add=seoul&age=21";
		StringTokenizer st = new StringTokenizer(query, "&");
		while(st.hasMoreTokens()) {
			System.out.println("token  : "+st.nextToken());
		}
		
		
		String str = "aaa bbb ccc ddd eee";
		String []tokens=str.split(" ");
		
		for(int i=0;i<tokens.length;i++){
			System.out.println(tokens[i]);
		}
		
		
	} 
}