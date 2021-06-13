package Graph;
// lazy version Time Complexity: O(E*log(E))
// eager version Time Complexity: O(E*log(V))

import java.util.*;


class Node {

    private int v;
    private int weight;

    Node(int v, int w) { 
        this.v = v; 
        this.weight = w;
    }

    int getV() { return v; }

    int getWeight() { return weight; }
}


class Edge implements Comparable<Edge>{
    //from vertex
    int from;
    //to vertex
    int to;
    //edge weight or cost
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    } 

    /*
      *function compares two edges based on their cost
      *Will be used by the priority queue
    */
    @Override
    public int compareTo(Edge e) {
      return (int) (this.cost - e.cost);
    }

}




public class PrimsMinimumSpanningTreeAlgorithm {
    
    PriorityQueue<Edge> pq = new PriorityQueue<>();
  
    void addEdges(int nodeIndex) {
        
    }

    public static int[] lazyPrims(int s, int n, ArrayList<ArrayList<Node>> adj) {

        int m = n - 1; // number of edges in MST
        int edgeCount = 0;
        int mstCount = 0;

        ArrayList<Edge> mstEdges = new ArrayList<>();


    }

    
}
