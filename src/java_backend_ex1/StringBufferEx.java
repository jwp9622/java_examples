package java_backend_ex1;

import java.util.StringTokenizer;

//StringBuffer�� �̿��Ͽ� ���ڿ��� �����ϴ� ���� �ڵ��� ���� ����� �����ΰ�?
		
public class StringBufferEx {
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("This");
		
		sb.append(" is pencil"); // ���ڿ� �����̱� 
		System.out.println(sb);
		
		sb.insert(7, " my"); // "my" ���ڿ� ����
		System.out.println(sb);
		
		sb.replace(8, 10, "your"); // "my"�� "your"�� ���� 
		System.out.println(sb);
		
		sb.delete(8, 13); // "your " ����
		System.out.println(sb);
		
		sb.setLength(4); // ��Ʈ�� ���� �� ���ڿ� ���� ���� 
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