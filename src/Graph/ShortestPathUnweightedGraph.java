package Graph;

import java.util.*;

public class ShortestPathUnweightedGraph {

    public static void shortestPath(ArrayList<ArrayList<Integer>> adj, int s, int V, int[] dist) {
	    
	    boolean[] visited = new boolean[V + 1];
	    Queue<Integer> q = new LinkedList<Integer>();

        q.add(s);
        visited[s] = true;
        dist[s] = 0;
        
        while(!q.isEmpty()) {
            
            int u = q.poll();

            for(int v : adj.get(u)) {
                if(visited[v] == false) {
                    dist[v] = dist[u] + 1;
                    visited[v] = true;
                    q.add(v); 
                }
            }

        }

	}
    
}
