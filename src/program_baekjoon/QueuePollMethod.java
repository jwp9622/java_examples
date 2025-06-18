package program_baekjoon;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePollMethod {

	public static void main(String[] args) {
		// create a queue of die rolls
        Queue queue   = new LinkedList();

        // Add 6 integers one by one
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        
        
        // print the original queue
        System.out.println("Queue:\t" + queue + "\n");

        // after calling poll()
        System.out.println("poll() returned : " + queue.poll());
        System.out.println("Queue Updated!\t" + queue + "\n");

        // after calling poll()
        System.out.println("poll() returned : " + queue.poll());
        System.out.println("Queue Updated!\t" + queue + "\n");

        // after calling poll()
        System.out.println("poll() returned : " + queue.poll());
        System.out.println("Queue Updated!\t" + queue + "\n");

	}

}
