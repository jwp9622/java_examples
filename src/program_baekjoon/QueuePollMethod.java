package program_baekjoon;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePollMethod {

	public static void main(String[] args) {
		// create a queue of die rolls
        Queue dieRoll   = new LinkedList();

        // Add 6 integers one by one
        dieRoll.add(1);
        dieRoll.add(2);
        dieRoll.add(3);
        dieRoll.add(4);
        dieRoll.add(5);
        dieRoll.add(6);

        
        // print the original queue
        System.out.println("Queue:\t" + dieRoll + "\n");

        // after calling poll()
        System.out.println("poll() returned : " + dieRoll.poll());
        System.out.println("Queue Updated!\t" + dieRoll + "\n");

        // after calling poll()
        System.out.println("poll() returned : " + dieRoll.poll());
        System.out.println("Queue Updated!\t" + dieRoll + "\n");

        // after calling poll()
        System.out.println("poll() returned : " + dieRoll.poll());
        System.out.println("Queue Updated!\t" + dieRoll + "\n");

	}

}
