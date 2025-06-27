package program_baekjoon_graph;

import java.io.*;
import java.util.*;


//������ ��θ��� Ư¡�� �����ص־� �Ҷ��� DFS
//�ִܰŸ��� BFS

//�׷����� ũ�ٸ� DFS�� ���
//�׷����� ũ���ʰ� ���ϴ� ����� ���� ���� ������ BFS

// 14496 ����
public class graph_dijstra_14496 {
	
	static ArrayList<Node>[] graph; // �������� ������ ����� �׷���
    static boolean[] visited; // �湮�� ������ ����� �迭
    static int count; // �湮 ����
    
    static int A, B;
    static int N,M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        //�ٲٷ��� ���� a,b �Է� ����
        st = new StringTokenizer(br.readLine()," ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        //N��, M �Է¹���
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // ��ȸ���� �迭 �⺻�� ����
        visited = new boolean[N+1];

        //�׷��� �⺻�� ����
        graph= new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {	
			graph[i]= new ArrayList<>();
		}
		
        for(int i=1;i<M+1;i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
        	graph[n].add(new Node(m,1));
        	graph[m].add(new Node(n,1));
        }
        

        
        //////////////////////////////////
        
		System.out.println("--------------------------");
		
		for(int i=0;i<graph.length;i++) {
			System.out.println(i);
			for(int j=0;j<graph[i].size();j++) {
				System.out.println("__"+j+"="+graph[i].get(j).end+","+graph[i].get(j).cost);
			}
			System.out.println("  ");
		}
		System.out.println("--------------------------");
		
		
        	
        // ���� �켱 Ž�� ��� ����
        dijkstra(A, B);

        bw.write(count+"");
        bw.flush();
        bw.close();
        
    }
/*
1 2
4 4
1 3
1 4
3 2
4 2

2
----------------------
2 3
3 3
1 2
1 3
3 2

1
*/
    
	static class Node implements Comparable<Node>{
		int end;
		int cost; // �������� �Ծ����� ���� (0:�ȸ���, 1:����)
		// ���� ���� ������
		Node(int end,int cost){
			this.end=end; 
			this.cost=cost;	
		}
		@Override
		public int compareTo(Node o) { //��ü���� ������
			return this.cost-o.cost;
		}
	}
	
	
	// ���� �켱 Ž�� �޼���
    private static void dijkstra(int start, int last) {
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(start,0));
    	visited[start] = true;

		System.out.println("start="+start);
    	while(!pq.isEmpty()) {
    		Node node = pq.poll(); //�ڽĳ�岨��

			System.out.println("node.end="+node.end+",node.cost="+node.cost);
			
			//�������� ������.
    		if(node.end==last) {
    			count =node.cost; 
    			return;
    		}
    		
            for (Node neighbor : graph[node.end]) {
            	
                if (!visited[neighbor.end]) {
                    visited[neighbor.end] = true;
                    pq.add(new Node(neighbor.end, node.cost + 1));
        			System.out.println("       "+neighbor.end+"_"+(node.cost + 1));
                }
            }

    		/*
    		for(int i=0;i< graph[node.end].size();i++) {
    			//int v = graph.get(poll).get(i);
    			//if(count == end) continue;
    			Node temp = graph[node.end].get(i); //�ڽĳ�岨��
    	    	
    			//System.out.println(i+"___"+ temp.end+"_"+temp.cost);
	    		//System.out.println("====="+ temp.end +"__"+temp.cost);
    	    	if(visited[temp.end] == fal��se) {
    	    		//System.out.println("___=="+ temp.end);
    				visited[temp.end] = true;
    				p.add(new Node(temp.end, node.cost+1));
    				//System.out.println("       "+temp.end +"__"+(int)(node.cost+1));
    	    	}
    		}	
    		*/

            System.out.println("-------");
            
        }
    	count = -1;
    }
    
	
}
