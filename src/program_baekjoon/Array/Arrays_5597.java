package program_baekjoon.Array;
import java.io.*;
import java.util.*;

//���� �� ���� ��..?
public class Arrays_5597 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//30�� �⼮��ȣ ����
		int max_cnt = 30;
		List<Integer> list1 = new ArrayList<>();
		for(int i=0;i<max_cnt;i++) {
			list1.add(i+1);
		}
		
		//���������ȣ �ޱ�
		List<Integer> list2 = new ArrayList<>();
		for(int i=0;i<max_cnt-2;i++) {
			int a = Integer.parseInt(br.readLine());
			list2.add(a);
		}
		
		//list2���� list2 ����
		list1.removeAll(list2);
		
		//����
		Collections.sort(list1);
		
		for(int i=0;i<list1.size();i++) {
			bw.write(list1.get(i)+"\n");
		}		
		bw.flush();
		bw.close();
		
	}

}