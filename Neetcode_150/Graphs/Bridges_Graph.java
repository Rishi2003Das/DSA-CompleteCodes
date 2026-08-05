/*
Tarjan's Algorithm- Bridges in a graph (Critical connections in a graphh)
1192. There are n servers numbered from 0 to n - 1 connected by undirected 
server-to-server connections forming a network where connections[i] = [ai, bi] 
represents a connection between servers ai and bi. Any server can reach other servers 
directly or indirectly through the network.
A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
Return all critical connections in the network in any order.
*/

class Solution {
    int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it: connections){
            int u=it.get(0);
            int v=it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[]=new int[n];
        int tin[]=new int[n];
        int low[]=new int[n];

        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0,-1,vis, tin, low, bridges, adj);
        return bridges;
    }

    void dfs(int node, int parent, int vis[], int tin[], int low[], List<List<Integer>> ans, ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        tin[node]=low[node]=timer;
        timer++;
        for(Integer it: adj.get(node)){
            if(it == parent) continue;
            if(vis[it]==0){
                dfs(it, node, vis, tin, low, ans, adj);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>tin[node]){
                    ans.add(Arrays.asList(it,node));
                }
            }
            else
            {
                low[node]=Math.min(low[node],low[it]);
            }
        }
    }
}
