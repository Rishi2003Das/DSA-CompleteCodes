//TopoSort or Kahn's Algorithm for Directed Acyclic Graph
class Solution {
    public int[] topoSort(int V, List<List<Integer>> adj) {
    int vis[]=new int[V];
    int ans[]=new int[V];
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<V; i++){
        if(vis[i]==0)
        dfs(i, vis, st, adj);
    }
    for(int i=0;i<V;i++){
        ans[i]=st.peek();
        st.pop();
    }
    return ans;
    }
    public static void dfs(int node, int vis[], Stack<Integer> st, List<List<Integer>> adj){
        vis[node]=1;
        for(int it : adj.get(node)){
            if(vis[it]==0)
            dfs(it,vis,st,adj);
        }
        st.push(node);
    }
}
