package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSUndirectedGraph {

    static void BFS(ArrayList<ArrayList<Integer>> adj,int V,int s) 
	{ 
		boolean[] visited=new boolean[V]; 
    	for(int i = 0; i < V; i++) 
    		visited[i] = false; 
    
    	Queue<Integer> q=new LinkedList<>();
    	
    	visited[s] = true; 
    	q.add(s); 
    
    	while(q.isEmpty()==false) 
    	{ 
    		int u = q.poll(); 
    		System.out.print(u + " "); 
    		 
    		for(int v:adj.get(u)){
    		    if(visited[v]==false){
    		        visited[v]=true;
    		        q.add(v);
    		    }
    		} 
    	} 
	} 

    // Time complexity O(V + E)
    static void BFS(ArrayList<ArrayList<Integer>> adj,int V, boolean[] visited) 
	{ 
    	for(int i = 0; i < V; i++) 
    		visited[i] = false; 
    
    	Queue<Integer> q=new LinkedList<>();
    	
    	visited[s] = true; 
    	q.add(s); 
    
    	while(q.isEmpty()==false) 
    	{ 
    		int u = q.poll(); 
    		System.out.print(u + " "); 
    		 
    		for(int v:adj.get(u)){
    		    if(visited[v]==false){
    		        visited[v]=true;
    		        q.add(v);
    		    }
    		} 
    	} 
	} 

    static void BFSDin(ArrayList<ArrayList<Integer>> adj, int V){
	    boolean[] visited=new boolean[V]; 
        int count = 0;
    	for(int i = 0; i < V; i++) 
    		visited[i] = false;
    	for(int i=0;i<V;i++){
            if(visited[i]==false) {
                count++;
                BFS(adj,i,visited);
            }

        }
	}

    static int numberOfIslands(ArrayList<ArrayList<Integer>> adj, int V){
	    boolean[] visited=new boolean[V]; 
        int count = 0;
    	for(int i = 0; i < V; i++) 
    		visited[i] = false;
    	for(int i=0;i<V;i++){
            if(visited[i]==false) {
                count++;
                BFS(adj,i,visited);
            }

        }
        return count;
	}

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0 ; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        AdjacencyListImplementation.addEdge(adj, 0, 1);
        AdjacencyListImplementation.addEdge(adj, 0, 2);
        AdjacencyListImplementation.addEdge(adj, 2, 3);
        AdjacencyListImplementation.addEdge(adj, 2, 4);

        BFS(adj, 5, 2);
    }
    
}
