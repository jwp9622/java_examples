package program_algorithms_backend_lecture;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
�Է�
11
215
15
344
372
294
100
8
145
24
198
831 

���
8
15
24
100
145
198
215
294
344
372
831

*/
public class Sort_gisu {

	public static int[] A;
	public static long result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Radix_Sort(A, 5);
		for(int i=0;i<N;i++) {
			bw.write(A[i]+"\n");
		}
		bw.flush();
		bw.close();
		
	}
	public static void Radix_Sort(int[] A, int max_size) {
		int[] output = new int[A.length];
		System.out.println("output="+A.length);
		int jarisu = 1;
		int count = 0;
		while(count != max_size) { //�ִ� �ڸ�����ŭ �ݺ��ϱ�
			int[] bucket = new int[10];
			for(int i=0;i<A.length;i++) {
				bucket[(A[i]/jarisu) % 10]++; //���� �ڸ����� �����ϱ�
			}
			for(int i=1;i<10;i++) { // �� �迭�� �̿��� index ����ϱ�
				System.out.println("i="+i);
				bucket[i] += bucket[i-1];
			}
			for(int i=A.length-1;i>=0;i--) { //���� �ڸ����� �������� �����ϱ�
				output[bucket[(A[i]/jarisu %10)]-1]=A[i];
				bucket[(A[i]/jarisu)%10]--;
			}
			for(int i=0;i<A.length;i++) {
				//���� �ڸ����� �̵��ϱ� ���� ���� �ڸ��� ���� ���� ������ �����ϱ�
				A[i] = output[i];
			}
			jarisu = jarisu*10; //�ڸ��� ������Ű��
			count++;
			
		}
	}
}
