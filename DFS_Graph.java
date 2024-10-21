class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ls= new ArrayList<>();
        int c=0;
        for(ArrayList<Integer> sublist : adj){
            if(!sublist.isEmpty()){
                c++;
            }
        }
        boolean vis[]= new boolean[c+1];
        dfs(0,vis,adj,ls);
        return ls;
    }
    
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        vis[node]=true;
        ls.add(node);
        
        for(Integer it: adj.get(node)){
            if(vis[it]==false){
                dfs(it,vis,adj,ls);
            }
        }
    }
    
}
