import java.util.*;
class Solution {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i])
            dfs(i,vis, adj, stack);
        }

    ArrayList<ArrayList<Integer>> adjT=new ArrayList<>();
    for(int i=0;i<V;i++){
        adjT.add(new ArrayList<Integer>());
    }
    for(int i=0;i<V;i++){
        vis[i]=false;
        for(Integer it: adj.get(i)){
            adjT.get(it).add(i);
        }
    }
    int scc=0;
    while(!stack.isEmpty()){
        int node= stack.peek();
        stack.pop();
        if(vis[node]==0){
            scc++;
            dfs2(node,vis,adjT);
        }
    }
    return scc;
    }
    void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node]=true;
        for(Integer it: adj.get(node)){
            if(!vis[it]){
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }
    void dfs2(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT){
        vis[node]=true;
        for(Integer it: adjT.get(node)){
            if(!vis[it]){
                dfs(it, vis, adjT);
            }
        }
    }
}

