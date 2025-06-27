package program_baekjoon_graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int start, end, weight;
 
    public Node(int start, int end, int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }
 
	@Override
    public int compareTo(Node o) {
    	//System.out.println((this.weight)+"-"+(o.weight)+"="+(this.weight-o.weight));
        return this.weight-o.weight;
    }
}

public class min_spanning_tree_1197 {
	
    static int [] parent;
    static PriorityQueue<Node> pq;
    static int n, k, start, end;
    
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        parent= new int[n+1];	//�θ��Ʈ�� 1�� �߰�
        pq= new PriorityQueue<>();	// FIFO ������ �ڷᱸ������
        
        for(int i=1; i<=n; i++){	
            parent[i]=i;	//parent = [0,1,2,3]
        }
        //System.out.println("n="+n);
       // System.out.println("k="+k);
       //System.out.println("parent="+Arrays.toString(parent)); //parent �迭 ���
        //System.out.println("pq="+pq.toString());
        
        for(int i=0; i<k; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            //System.out.println(" ");
            //System.out.println("Node="+a+","+b+","+c);
            pq.add(new Node(a,b,c)); //�켱���� �����ͺ��� ����, ������ ���
            //.out.println("----------");
        }
       
        while(!pq.isEmpty()) {
        	Node nd = pq.poll();
        	//System.out.println(nd.start+"__"+nd.end+"__"+nd.weight);
        }

        System.out.println(solve());
	}

	//����
	private static int solve() {
        int sum=0;
        while(!pq.isEmpty()){
            Node node = pq.poll();	//�ֻ��� ��� �˻��ؼ� ������.
            int parentS = find(node.start);
            int parentE = find(node.end);
            if(parentS!=parentE){
                Union(parentS,parentE);
                sum+=node.weight;
            }
        }
        return sum;
	}
   
    private static int find(int x){
        if(parent[x]==x){
            return x;
        }
        else{
            return parent[x]=find(parent[x]);
        }
    }
    
    private static void Union(int a, int b){
        a=find(a);
    	b=find(b);
        if(a!=b){
        	parent[b]=a;
        }
    }	

	
}
