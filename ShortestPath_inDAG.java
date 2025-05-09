/*
Given a Directed Acyclic Graph of N vertices from 0 to N-1 and M edges and
a 2D Integer array edges, where there is a directed edge from vertex edge[i][0]
to vertex edge[i][1] with a distance of edge[i][2] for all i.
Find the shortest path from source vertex to all the vertices and if it is 
impossible to reach any vertex, then return -1 for that vertex. The source vertex is assumed to be 0.
*/
class Pair {
    int node;
    int dist;
    Pair(int n, int dis) {
        this.node = n;
        this.dist = dis;
    }

    public int getNode() {
        return node;
    }

    public int getDist() {
        return dist;
    }
}

class Solution {
    public int[] shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Building adjacency list
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) 1e9;
        }

        // Topological sort using DFS
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }

        // Initialize source distance
        ans[0] = 0;

        // Relax edges in topological order
        while (!st.isEmpty()) {
            int node = st.pop();

            if (ans[node] != (int) 1e9) { // Only process reachable nodes
                for (Pair it : adj.get(node)) {
                    int v = it.getNode();
                    int w = it.getDist();
                    if (ans[node] + w < ans[v]) {
                        ans[v] = ans[node] + w;
                    }
                }
            }
        }

        // Convert unreachable nodes to -1
        for (int i = 0; i < n; i++) {
            if (ans[i] == (int) 1e9) {
                ans[i] = -1;
            }
        }

        return ans;
    }

    void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for (Pair it : adj.get(node)) {
            if (vis[it.getNode()] == 0) {
                topoSort(it.getNode(), adj, vis, st);
            }
        }
        st.push(node);
    }
}
