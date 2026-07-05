//BFS Approach

import java.util.*;

class Pair{
    int vertex, parent;
        Pair(int v, int p) {
            vertex = v;
            parent = p;
        }
}


class Solution {
    boolean bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        visited[start] = true;
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int curr = p.vertex;
            int parent = p.parent;
            
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(new Pair(neighbor, curr));
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean checkCycle(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                if (bfs(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}

//DFS Approach

import java.util.*;

class Solution {
    public boolean dfs(int cur, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[cur] = true;
        for (int i : adj.get(cur)) {
            if (i != parent) {
                if (visited[i]) return true; 
                else if (dfs(i, cur, adj, visited)) return true; 
            }
        }
        return false; 
    }
    
    boolean checkCycle(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) {
                    return true; 
                }
            }
        }
        return false; 
    }
}
/*public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        Solution sol = new Solution();
        System.out.println(sol.checkCycle(n, adj) ? "true" : "false");
        scanner.close();
    }
}*/
