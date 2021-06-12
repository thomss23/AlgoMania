package Graph;

import java.util.*;

class AdjListNode {
    private int v;
    private int weight;

    AdjListNode(int _v, int _w) { 
        v = _v; weight = _w;
    }

    int getV() { return v; }

    int getWeight() { return weight; }
}

public class ShortestPathDAG {

    /* Steps:
    1) Initialize dist vector
    2) dist[s] = 0;
    3) Find a topological sort of the graph
    4) For every vertex u in the topological sort
        For every adjacent v of u
            if(dist[v] > dist[u] + weight(u, v))
                dist[v] = dist[u] + weight(u, v)
    
    Time Complexity: O(V+E)
    */


    public static int[] shortestPath(ArrayList<ArrayList<AdjListNode>> adj, int n, AdjListNode source) {

        int[] dist = new int[n];
        
        for(int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[source.getV()] = 0;

        int[] topoSort = topoSortKhan(adj, n);

        for(int u: topoSort) {

            for(AdjListNode v: adj.get(u)) {

                if(dist[v.getV()] > dist[u] + v.getWeight())
                    dist[v.getV()] = dist[u] + v.getWeight();
            }
        }

        return dist;
    }

    public static int[] topoSortKhan(ArrayList<ArrayList<AdjListNode>> adj, int n) {
        
        int[] inDegree = new int[n];

        // setting the degree array
        for(int i = 0; i < n; i++) {
            for(AdjListNode to: adj.get(i)) {
                inDegree[to.getV()] = inDegree[to.getV()] + 1;
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

            for(AdjListNode to : adj.get(at)) {
                inDegree[to.getV()] = inDegree[to.getV()] - 1;

                if(inDegree[to.getV()] == 0) {
                    q.add(to.getV());
                }
            }
        }
        // if index doesn't reach n, that means that not all nodes have been processed. so => there was a cycle somewhere in the graph
        if(index != n) {
            return null;
        }

        return order;
    }
    
    public static void main(String[] args) {

        ArrayList<ArrayList<AdjListNode>> adj = new ArrayList<>();

        int n = 6;

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<AdjListNode>());
        }

        adj.get(0).add(new AdjListNode(1, 2));
        adj.get(0).add(new AdjListNode(4, 1));

        adj.get(1).add(new AdjListNode(2, 3));

        adj.get(2).add(new AdjListNode(3, 6));

        adj.get(4).add(new AdjListNode(2, 2));

        adj.get(4).add(new AdjListNode(5, 4));

        adj.get(5).add(new AdjListNode(3, 1));

       int[] result = shortestPath(adj, n, new AdjListNode(0, 0));

       for(int i = 0; i < result.length; i++) {
           System.out.print(result[i] + " ");
       }

    }
    
}



    // public static int[] shortestPath(ArrayList<ArrayList<AdjListNode>> adj, int n, AdjListNode source) {

    //     int[] dist = new int[n];
        
    //     for(int i = 0; i < dist.length; i++) {
    //         dist[i] = Integer.MAX_VALUE;
    //     }
    //     Queue<AdjListNode> q = new LinkedList<>();

    //     q.add(source);

    //     dist[source.getV()] = 0;

    //     while(!q.isEmpty()) {

    //         AdjListNode out = q.poll();

    //         for(AdjListNode adjNode : adj.get(out.getV())) {

    //             if(dist[adjNode.getV()] > dist[out.getV()] + adjNode.getWeight() ) {
    //                 dist[adjNode.getV()] = dist[out.getV()] + adjNode.getWeight();
    //             }

    //             q.add(adjNode);
    //         }

    //     }

    //     return dist;
    // }
