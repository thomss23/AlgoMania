package Graph;

import java.util.*;

/*

Logic:

u -> v in DFS Tree (u parent node of v)
for the following condition low[v] >= dis[v]



*/

public class ArticulationPoint {

        private int V; 
     
        private ArrayList<Integer>[] adj; 
        int time = 0; 
        static final int NIL = -1; 
    
        ArticulationPoint(int v) 
        { 
            V = v; 
            adj = new ArrayList[v]; 
            for (int i=0; i<v; ++i) 
                adj[i] = new ArrayList<>(); 
        } 
    
        void addEdge(int v, int w) 
        { 
            adj[v].add(w);  
            adj[w].add(v);  
        } 
     
        void APUtil(int u, boolean visited[], int disc[], 
                    int low[], int parent[], boolean ap[]) 
        { 
    
            int children = 0; 
    
            visited[u] = true; 
    
            disc[u] = low[u] = ++time; 
    
            Iterator<Integer> i = adj[u].iterator(); 
            while (i.hasNext()) 
            { 
                int v = i.next(); 
                if (!visited[v]) 
                { 
                    children++; 
                    parent[v] = u; 
                    APUtil(v, visited, disc, low, parent, ap); 
    
             
                    low[u] = Math.min(low[u], low[v]); 
    
    
                    if (parent[u] == NIL && children > 1) 
                        ap[u] = true; 
    
                    if (parent[u] != NIL && low[v] >= disc[u]) 
                        ap[u] = true; 
                } 
    
                else if (v != parent[u]) 
                    low[u] = Math.min(low[u], disc[v]); 
            } 
        } 
    
        void AP() 
        { 
            
            boolean visited[] = new boolean[V]; 
            int disc[] = new int[V]; 
            int low[] = new int[V]; 
            int parent[] = new int[V]; 
            boolean ap[] = new boolean[V];
    
        
            for (int i = 0; i < V; i++) 
            { 
                parent[i] = NIL; 
                visited[i] = false; 
                ap[i] = false; 
            } 
     
            for (int i = 0; i < V; i++) 
                if (visited[i] == false) 
                    APUtil(i, visited, disc, low, parent, ap); 
     
            for (int i = 0; i < V; i++) 
                if (ap[i] == true) 
                    System.out.print(i+" "); 
        } 
    
        public static void main(String args[]) 
        { 
            System.out.println("Articulation points in first graph "); 
            ArticulationPoint g = new ArticulationPoint(5); 
            g.addEdge(1, 0); 
            g.addEdge(0, 2); 
            g.addEdge(2, 1); 
            g.addEdge(0, 3); 
            g.addEdge(3, 4); 
            g.AP(); 
            System.out.println(); 
        } 

    
}
