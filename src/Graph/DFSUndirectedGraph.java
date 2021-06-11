package Graph;

import java.util.ArrayList;

public class DFSUndirectedGraph {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        boolean[] visited = new boolean[V + 1];

        DFS(0, visited, result, adj);
        
        return result;
        
    }

    
    public ArrayList<Integer> dfsOfGraphDisconnected(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        boolean[] visited = new boolean[V + 1];

        for(int i = 0; i < V; i++) {
            if(visited[i] == false) {
                DFS(i, visited, result, adj);
            }
        }

        
        return result;
        
    }

    public int dfsCountIslands(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 0;
        boolean[] visited = new boolean[V + 1];

        for(int i = 0; i < V; i++) {
            if(visited[i] == false) {
                count++;
                DFS(i, visited, result, adj);
            }
        }

        
        return count;
        
    }
    

    
    public static void DFS(int vertex, boolean[] visited, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> adj) {
        
        result.add(vertex);
        visited[vertex] = true;
        
        for(int v: adj.get(vertex)) {
            
            if (visited[v] == false) {

                DFS(v, visited, result, adj); 
                
            }

        }
    }


    
    
}
