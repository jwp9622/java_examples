package program_baekjoon_graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


//����  19701�� ���� /���̽�Ʈ�� �˰���
public class graph_dijkstra_19701 {

	static int v,e;
	static int[][] dist;
	static ArrayList<Node>[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//�ްԼ����� �Է¹���
		v = Integer.parseInt(st.nextToken());
		
		//��ӵ��� �Է¹���
		e = Integer.parseInt(st.nextToken());
		
		// �Ÿ� �迭 �ʱ�ȭ
		dist= new int[v+1][2]; // [����ȣ][0:�ȸ���, 1:����]
		
		//������� arrayList map ����
		map= new ArrayList[v+1];
		
		//�� ��庰 �迭 ����
		for(int i=0;i<v+1;i++) {	
			map[i]= new ArrayList<>();
			dist[i][0]=Integer.MAX_VALUE; // �ſ� ū ���� �ʱ�ȭ
			dist[i][1]=Integer.MAX_VALUE; // �ſ� ū ���� �ʱ�ȭ
		}
		
		//for(int i=0;i<dist.length;i++) {
		//	for(int j=0;j<dist[i].length;j++) {
		//		System.out.println(i+"__"+j+"__"+dist[i][j]);
		//	}
		//}
		
		//������� �Է¹���
		for(int i=0;i<e;i++) {
			 st = new StringTokenizer(br.readLine()); 
			 int x = Integer.parseInt(st.nextToken());  // ��� ���
			 int y = Integer.parseInt(st.nextToken()); // ���� ���
			 int w = Integer.parseInt(st.nextToken()); // ���� ���
			 int f = Integer.parseInt(st.nextToken()); // ������ ��
			 
			// ����� �׷���
			 map[x].add(new Node(y,w,f));
			 map[y].add(new Node(x,w,f));
			 
		}

		
		System.out.println("--------------------------");
		
		for(int i=0;i<map.length;i++) {
			System.out.println(i);
			for(int j=0;j<map[i].size();j++) {
				System.out.println("__"+j+"__"+map[i].get(j).idx+"_"+map[i].get(j).weight+"_"+map[i].get(j).food+"_"+map[i].get(j).eat);
			}
			System.out.println("  ");
		}
		
		for(int i=0;i<v+1;i++) {
			System.out.println(i+"_0_"+dist[i][0]);
			System.out.println(i+"_1_"+dist[i][1]);
		}

		System.out.println("--------------------------");
		
		
		
		//Ž�� ����
		dij(1);
		
		//��� ���� ���
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<v+1;i++) {
			// �������� �Ծ��� ���� �� �Ծ��� �� �� �ּҰ� ���
			sb.append(Math.min(dist[i][0], dist[i][1])).append("\n");
		}
		System.out.println(sb.toString());
	}
	//Comparable<Node> Ŭ������ �⺻ ���� ������ �����ϴ� �������̽�
	static class Node implements Comparable<Node>{
		int idx,weight,food;
		int eat; // �������� �Ծ����� ���� (0:�ȸ���, 1:����)
		// ���� ���� ������
		Node(int idx, int weight,int food){
			this.idx=idx; 
			this.weight=weight;	
			this.food=food;
		}
		// �켱���� ť�� ������
		Node(int idx, int weight,int food,int eat){
			this.idx=idx;
			this.weight=weight;
			this.food=food;
			this.eat=eat;
		}
		@Override
		public int compareTo(Node o) { //��ü���� ������
			return this.weight-o.weight;
		}
	}
	
	
	//
	static void dij(int idx) {

		//System.out.println("idx="+idx);
		
		PriorityQueue<Node> p = new PriorityQueue<>(); //�켱���� ����(���� ũ�� ��)���� ���ĵ� ������ ó���ϰ� ���� �� ���
		//Queue<Integer> q = new LinkedList<>(); //�Է� ������ �״�� ó���ϰ� ���� �� ���
		
		p.add(new Node(idx,0,0));
		dist[idx][0]=0; // ���� ���� ����� �� ���� ���·� 0
		dist[idx][1]=0;
		
		while(!p.isEmpty()) {
			Node node = p.poll(); //��������� �ִ� �Ÿ� ��带 �����ϴ�.
			
			// ���� �������� �Ÿ����� ����� ũ�� ����
			if(dist[node.idx][node.eat]<node.weight) continue; //59�� �ð��ʰ� �ذ�,,
			
			// ������ ������ Ž��
			for(int i=0;i<map[node.idx].size();i++) {
				Node temp = map[node.idx].get(i); //�ڽĳ�岨��

				//����� �Դ� ���, ���ݱ��� �ȸԾ�����
				if(node.eat==0) { 
					// ����� ���� �ʾҴٸ� ����� ����ؼ� ���ι��� �� ����.
					int costWithFood = node.weight + temp.weight - temp.food;
					if(dist[temp.idx][1]> costWithFood) { //��� �Ծ����� �� ������ ��
						dist[temp.idx][1] = costWithFood;  //��� ���� ǥ�÷� eat 1
						p.add(new Node(temp.idx,dist[temp.idx][1],0,1));
					}
				}
				
				//����� �ȸ԰ų� �̹� ���� ���
				// dist[temp.idx][0] ó���ϸ� �̸̹Ծ������� ������ �� �� ���� ���·� �����ϸ� �� ������.
				int costWithoutFood = node.weight + temp.weight;
				if(dist[temp.idx][node.eat]>costWithoutFood) {
					dist[temp.idx][node.eat] = costWithoutFood;
					p.add(new Node(temp.idx,dist[temp.idx][node.eat],0,node.eat));
				}
				
			}
			
			
		}
	}
	
}