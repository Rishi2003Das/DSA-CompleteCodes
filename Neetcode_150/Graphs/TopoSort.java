import java.util.*;

class Solution {
    public void dfs(int cur, List<List<Integer>> adj, boolean[] visited, Stack<Integer> s) {
        visited[cur] = true;
        for(int k : adj.get(cur)) {
            if(!visited[k]) {
                dfs(k, adj, visited, s);
            }
        }
        s.push(cur);
    }

    public List<Integer> topologicalSort(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, adj, visited, s);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!s.isEmpty()) {
            ans.add(s.pop());
        }
        return ans;
    }
}

/*public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
        }
        Solution sol = new Solution();
        List<Integer> res = sol.topologicalSort(adj);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}*/


//Kahn's algorithm using BFS

import java.util.*;

public class Solution {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        List<Integer> indegree = new ArrayList<>(Collections.nCopies(n, 0));
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int k : adj.get(i)) {
                indegree.set(k, indegree.get(k) + 1);
            }
        }
        for(int i = 0; i < n; i++) {
            if(indegree.get(i) == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int front = q.poll();
            ans.add(front);

            for(int k : adj.get(front)) {
                indegree.set(k, indegree.get(k) - 1);
                if(indegree.get(k) == 0) {
                    q.add(k);
                }
            }
        }
        return ans;
        
    }
}

/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        Solution sol = new Solution();
        List<Integer> res = sol.topologicalSort(adj);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}*/
