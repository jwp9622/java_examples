package program_baekjoon;

import java.util.Stack;

public class StackDFS_tree {

	public static void main(String[] args) {
        //1. Ʈ�� ����
        int[][] map= {
                {0,1},
                {0,2},
                {1,3},
                {1,4},
                {2,5},
                {3,6},
                {4,5},
                {5,6}
        };
        
        //[]
        //[2, 4]
        //[1, 3, 4]
        //[2, 4]
        //[1, 2, 3]
        //[]   
        
        //2. �ʿ��� ���� ����
        Stack<Integer> st=new Stack<Integer>();

        //3. �ʱⰪ �Է�
        int startNode=0;
        st.push(startNode);

        //4. DFS
        while(!st.isEmpty()) {
            //4-1. Stack�� ���� ���� ���� pop
            int now=st.pop();
            //4-2. ����� ��带 ã�� Stack�� ���� �� visited�� ǥ��
            for(int i=0;i<map.length;i++) {
                if(map[i][0]==now) {
                    int next=map[i][1];
                    st.push(next);
                    }
                }
	            System.out.println("pop : "+ now);
	            System.out.println("Stack : "+st.toString());
	            System.out.println("-----------------------");
	            //��°��
	            //pop : 0
	            //Stack : [1, 2]
	            // ...(�߷�)...
	            //pop : 6
	            //Stack : []
        	}
    	}

}
