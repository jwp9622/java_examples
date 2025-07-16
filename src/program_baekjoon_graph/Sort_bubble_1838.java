package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
버블정렬 / https://www.acmicpc.net/problem/1838

입력
5
30 10 44 27 49

출력
2
*/
public class Sort_bubble_1838{
		
    public static void main(String args[]) throws NumberFormatException, IOException{
    	

		long startTime = System.currentTimeMillis();
		
		
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        //정수 입력
		int N = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Bubble> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		
		//PriorityQueue, 배열 입력
		for(int i=0;i<N;i++) {
			pq.add(  new Bubble(i, Integer.parseInt(st.nextToken()) ));
		}
		/*
		 // PriorityQueue
			0 = 1 10
			1 = 3 27
			2 = 0 30
			3 = 2 44
			4 = 4 49
		*/
		
		// 정렬된 결과에서 각 숫자가 원래 있던 위치보다 몇 칸 뒤로 가 있는지
		
		//횟수 구하기
		int result = 0;
		int i =0;
		while(!pq.isEmpty()) {
			Bubble bubble = pq.poll();
			
			if( result < bubble.index -i) {
				result = bubble.index - i;
			}
			i++;
		}
		
		//long endTime = System.currentTimeMillis();
		//System.out.println(endTime - startTime);
		
		//결과출력
		System.out.println(result);
		
    }
    
    static class Bubble implements Comparable<Bubble>{
    	int index;
    	int value;

    	public Bubble(int index, int value) {
    		this.index = index;
    		this.value = value;
    	}
		@Override
		public int compareTo(Bubble o) {
			return (this.value - o.value);
		}
    }
   }	
