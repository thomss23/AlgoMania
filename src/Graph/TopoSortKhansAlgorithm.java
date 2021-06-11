package Graph;

import java.util.*;

public class TopoSortKhansAlgorithm {

    public int[] topoSortKhan(ArrayList<ArrayList<Integer>> adj, int n) {
        
        int[] inDegree = new int[n];

        // setting the degree array
        for(int i = 0; i < n; i++) {
            for(int to: adj.get(i)) {
                inDegree[to] = inDegree[to] + 1;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        // enqueue nodes with degree = 0
        for(int i = 0 ; i < n; i++) {
            
            if(inDegree[i] == 0) {
                q.add(i);
            }

        }

        int index = 0;
        int[] order = new int[n];

        while(!q.isEmpty()) {
            int at = q.poll();

            order[index++] = at;

            for(int to : adj.get(at)) {
                inDegree[to] = inDegree[to] - 1;

                if(inDegree[to] == 0) {
                    q.add(to);
                }
            }
        }
        // if index doesn't reach n, that means that not all nodes have been processed. so => there was a cycle somewhere in the graph
        if(index != n) {
            return null;
        }

        return order;
    }

}
