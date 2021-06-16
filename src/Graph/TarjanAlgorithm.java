package Graph;

import java.util.ArrayList;
import java.util.Stack;

/*
Time Complexity: O(V + E)

Theory: 

Strongly Connected Components can be thought of as self-contained cycles within a directed graph
where every vertex in a given cycle can reach every other vertex in the same cycle

The low-link value of a node is the smallest[lowest] node id reachable from that node when doing a DFS(including itself)

IMPORTANT: Depending on where the DFS starts, and the otrder in which nodes/edges are visited, the low-link values
        for identifying SCCs could be wrong. In the context of Tarjan's SCC algorithm, we maintain an invariant that prevents
        SCCs to interfere with the low link value of other SCCs.

To cope with the random traversal order of the DFS, Tarjan's algorithm maintains a set (often as a stack) of valid
nodes from which to update low-link values from.

Nodes are added to the stack [set] of valid nodes as they're explored for the first time.

Nodes are removed from the stack [set] each time a complete SCC is found

New low-link update condition: If u and v are nodes in a graph and we're currently exploring u then our new low-link update
condition is that:

To update node u's low-link value to node v's low-link value there has to be a path of edges from u to v and 
node v must be on the stack

Algorithm Steps:

1) Mark the id of each node as unvisited.
2) Start DFS. Upon visiting a node assign it and id and a low-link value. Also mark current nodes as visited and add them to a seen stack.
3) On DFS callback, if the previous node is on the stack then min the current node's low-link value with the last node's low-link value 
(this allows low-link values to propagate throughout cycles)
4) After visiting all neighbours, if the current node started a connected component ( as we will see, a node started a connected component if its id equals its low link value) 
    then pop nodes off stack until current node is reached.

*/

public class TarjanAlgorithm {

    public final int UNVISITED = -1;

    public int n; // no. of nodes in a graph
    public ArrayList<ArrayList<Integer>> g; // adjacency list with directed edges

    public int id = 0; // used to give each node an id
    public int sccCount = 0; // Used to count number of SCCs found

    // Index i in these arrays represents node i
    int[] ids = new int[n];
    int[] low = new int[n];
    boolean[] onStack = new boolean[n];
    Stack<Integer> stack = new Stack<>();

    public int[] findSccs() {

        for(int i = 0; i < n; i++) {
            ids[i] = UNVISITED;
        }

        for(int i = 0; i < n; i++) {
            if(ids[i] == UNVISITED) {
                dfs(i);
            }
        }
        return low;
    }

    private void dfs(int at) {
        
        stack.push(at);
        onStack[at] = true;
        ids[at] = low[at] = id++;

        //Visit all neighbours and min low-link on callback
        for(int to: g.get(at)) {
            if(ids[to] == UNVISITED) {
                dfs(to);
            }

            if(onStack[to]) {
                low[at] = Math.min(low[at], low[to]);
            }
        }

        // After having visited all the neighbours of 'at'
        // if we're at the start of a SCC, empty the seen
        // stack until we're back to the start of the SCC.
        if(ids[at] == low[at]) {
            while(!stack.isEmpty()) {
                int node = stack.pop();
                onStack[node] = false;
                low[node] = ids[at]; // mark the strongly connected components
                // if(node == at) {
                //     break;
                // }
            }
        }
        sccCount++;
    }

}
