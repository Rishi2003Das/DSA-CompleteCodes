// BFS
import java.util.*;
public class Solution {
    List<Integer> bfs(int n, List<List<Integer>> adj) {
        // Write your code here...
        Queue<Integer> queue=new LinkedList<>();
        boolean vis[]=new boolean[n];
        queue.add(0);
        vis[0]=true;
        List<Integer> ans=new ArrayList<>();
        
        while(!queue.isEmpty()){
            int node=queue.poll();
            ans.add(node);
            for(int it: adj.get(node)){
                if(vis[it]==false){
                    vis[it]=true;
                    queue.add(it);
                }
            }
        }
        return ans;
    }
}
//DFS
import java.util.*;

class Solution {
    void dfsRecursive(int cur, ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> ans) {
        ans.add(cur);  
        visited[cur] = true;  
        for (int k : adj.get(cur)) {
            if (!visited[k]) dfsRecursive(k, adj, visited, ans);
        }
    }

    List<Integer> dfs(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n]; 
        List<Integer> ans = new ArrayList<>();  
        dfsRecursive(0, adj, visited, ans);  
        return ans;
    }
}
