package Graph;

import java.util.*;

// lazy version Time Complexity: O(E*log(E))
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
    
    private static PriorityQueue<Edge> pq = new PriorityQueue<>();

    static void addEdges(int nodeIndex, boolean[] visited, ArrayList<ArrayList<Node>> adj) {

        // mark the current node as visited
        visited[nodeIndex] = true;

        //Iterate over all edges going outwards from the current node.
        // Add edges to the PQ which point to unvisited nodes
        for(Node node: adj.get(nodeIndex)) {

            if(visited[node.getV()] == false) {
                pq.add(new Edge(nodeIndex, node.getV(), node.getWeight()));
            }
        }
        

    }

    public static Object[] lazyPrims(int s, int n, ArrayList<ArrayList<Node>> adj) {

        int m = n - 1; // number of edges in MST
        int edgeCount = 0;
        int mstCost = 0;

        Object[] result = new Object[2];

        boolean[] visited = new boolean[n];

        ArrayList<Edge> mstEdges = new ArrayList<>();
        addEdges(s, visited, adj);

        while(!pq.isEmpty() && edgeCount!= m) {

            Edge edge = pq.poll();
            int nodeIndex = edge.to;

            if(visited[edge.to]) {
                continue;
            }

            mstEdges.add(edge);
            mstCost = edgeCount + mstCost;

            addEdges(nodeIndex, visited, adj);

        }

        // We make sure we found the mst by checking if the edge count is equal to n - 1 (m)
        if(edgeCount != m) {
            return null;
        }

        result[0] = mstCost;
        result[1] = mstEdges;
        
        return result;
    }

}
