package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = {5,15,10,20,8};

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        System.out.println(pq.poll() + " " + pq.poll());
        
    }
}
