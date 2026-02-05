//BFS code

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int c=0;
        for(ArrayList<Integer> sublist : adj){
                c++;
        }
        boolean vis[]= new boolean[c+1];
        if(check(0,adj,vis))
            return true;
            else
            return false;
    }
    
    public boolean check(int src,ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        vis[src]=true;
        Queue<Pair> q=new LinkedList<>();
        
        q.add(new Pair(src,-1));
        while(!q.isEmpty()){
            int pres=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            
            for(int i: adj.get(pres)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.add(new Pair(i,pres));
                }
                else if(parent != i){
                    return true;
                }
            }
        }
        return false;
    }
}

//DFS Code

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V=0;
        for(ArrayList<Integer> sublist : adj){
                V++;
        }
               int vis[] = new int[V]; 
       for(int i = 0;i<V;i++) {
           if(vis[i] == 0) {
               if(dfs(i, vis, adj, -1)) return true; 
           }
       }
       return false; 

    }
    
    public static boolean dfs(int node, int vis[], ArrayList<ArrayList<Integer>> adj, int parent){
        vis[node]=1;
        
        for(Integer it: adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,vis,adj,parent)){
                    return true;
                }
            else if(parent!=it)
            return true;
            }
        }
        return false;
    }
}
