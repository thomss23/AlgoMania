package Graph;

import java.util.ArrayList;

public class DetectCycleDirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {

        int[] flag = new int[V + 1];
        
        for(int i = 0; i < V; i++) {
            flag[i] = -1;
        }
        
        for(int i = 0; i < V; i++) {
            
            if(flag[i] == -1) {
                
                if (DFS(i, flag, adj) == true) {
                    return true;
                } 
                
            }
        }
        
        return false;


    }
    
    
        
    public static boolean DFS(int vertex, int[] flag, ArrayList<ArrayList<Integer>> adj) {
        
        flag[vertex] = 0;
        
        for(int next: adj.get(vertex)) {
            
            if(flag[next] == -1) {
                
                if(DFS(next, flag, adj) == true) {
                    return true;
                }
                
            } else if(flag[next] == 0) {
                return true;
            } 
                
        }
        flag[vertex] = 1;
        return false;
        
    }
}
