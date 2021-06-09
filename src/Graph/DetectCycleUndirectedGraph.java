package Graph;

import java.util.ArrayList;

public class DetectCycleUndirectedGraph {
    
    public boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int V) {


        boolean[] visited = new boolean[V + 1];

        for(int i = 0 ; i < V; i++) {
            if(DFS(i, i, visited, adj) == true) {
                return true;
            }
        }

        return false;

    }

    public boolean DFS(int startVertex, int vertex, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        
        visited[vertex] = true;
        
        for(int v: adj.get(vertex)) {
            
            if (visited[v] == false) {
                if(v == startVertex) {
                    return true;
                } else
                return DFS(startVertex, v, visited, adj); 
                
            }

        }
        return false;
    }

}
