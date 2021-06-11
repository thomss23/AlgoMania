package Graph;
import java.util.*;
public class TopoSortWithDFS {
    
    public int[] topoSortDFS(ArrayList<ArrayList<Integer>> adj, int n) {

        boolean[] visited = new boolean[n];
        
        int[] ordering = new int[n];

        int i = n - 1;

        for(int at = 0; at < n; at++) {
            if(visited[at] == false) {
                ArrayList<Integer> visitedNodes = new ArrayList<>();

                DFSUndirectedGraph.DFS(at, visited, visitedNodes, adj);

                for(int nodeId : visitedNodes) {
                    ordering[i] = nodeId;
                    i = i - 1;
                }
            }
        }

        return ordering;

    }

}
