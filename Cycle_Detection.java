class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[]=new int[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) { // If node is unvisited, start DFS
                if (dfs(i, -1, vis, adj)) 
                    return true;
            }
        }
        return false;
    }
        
    }
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, int vis[]){
        vis[node]=1;
         for(int adjacentNode: adj.get(node)) {
            if(vis[adjacentNode]==0) {
                if(dfs(adjacentNode, node, vis, adj) == true) 
                    return true; 
            }
            else if(adjacentNode != parent) 
            return true; 
        }
        return false; 
    }
}
