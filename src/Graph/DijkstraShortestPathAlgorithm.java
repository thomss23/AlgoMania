package Graph;

import java.util.*;

/*
Time Complexity: O(E*log(V))
  
Steps:

1) Maintain a 'dist' array where the distance to every node 
    is positive infinity. Mark the distance to the start node 's' to be 0
2) Maintain a PQ of key-value pairs of(node index, distance) pairs which
    tell you which node to visit next based on sorted min value
3) Insert (s, 0) into the PQ and loop while PQ is not empty pulling out
    the next most promising (node index, distance) pair
4) Iterate over all edges outwards from the current node and relax each edge
    appending a new (node index, distance) key-value pair to the PQ for
    every relaxtion.
*/

class Vertex implements Comparator<Vertex> { 
    public int node; 
    public int cost; 
   
    public Vertex(int node, int cost) { 
        this.node = node; 
        this.cost = cost; 
    } 

    @Override
    public int compare(Vertex node1, Vertex node2) 
    { 
        if (node1.cost < node2.cost) 
            return -1; 
        if (node1.cost > node2.cost) 
            return 1; 
        return 0; 
    }

}

public class DijkstraShortestPathAlgorithm {

    public static Object[] dijkstra(ArrayList<ArrayList<Vertex>> adj, int n, int s) {

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int[] prev = new int[n];

        for(int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }

        for(int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[s] = 0;

        pq.add(new Vertex(s, 0));

        while(!pq.isEmpty()) {

            Vertex nd = pq.poll();

            int index = nd.node;
            int minValue = nd.cost;
            visited[index] = true;


            //optimization
            if(dist[index] < minValue) {
                continue;
            }

            for(Vertex edge: adj.get(index)) {

                if(visited[edge.node]) {
                    continue;
                }

                int newDist = dist[index] + edge.cost;

                if(newDist < dist[edge.node]) {
                    prev[edge.node] = index;
                    dist[edge.node] = newDist;
                    pq.add(new Vertex(edge.node, newDist));
                }

            }
        }

        return new Object[] {dist, prev};
    }

    public static ArrayList<Integer> findShortestPath(ArrayList<ArrayList<Vertex>> adj, int n, int s, int e) {

        Object[] result = dijkstra(adj, n, s);
        int[] dist = (int[]) result[0];
        int[] prev =  (int[]) result[1];

        ArrayList<Integer> path = new ArrayList<>();

        if(dist[e] == Integer.MAX_VALUE) {
            return path;
        }

        for(int at = e;  at >= prev[at]; at--) {
            if(at != -1) {
                path.add(at);
            }

        }

        Collections.reverse(path);

        return path;
    }

    // MATRIX ALTERNATE VERSION
    //Time complexity O(V^2)

    int[] dijkstraMatrix(int graph[][], int src, int V) {

        int[] dist = new int[V];

    	Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

    	boolean[] fin = new boolean[V]; 
    
    	for (int count = 0; count < V-1 ; count++) { 
    		int u = -1; 
    
    		for(int i=0;i<V;i++)
    		    if(!fin[i] && (u==-1 || dist[i] < dist[u]))
    		        u=i;
    		fin[u] = true; 
    		
    		for (int v = 0; v < V; v++) 
    
    			if (graph[u][v]!=0 && fin[v] == false) 
    				dist[v] = Math.min(dist[v], dist[u] + graph[u][v]); 
    	} 
        return dist;
    }
}


