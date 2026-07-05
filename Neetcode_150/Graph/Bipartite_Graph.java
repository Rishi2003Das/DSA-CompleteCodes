//BFS Approach
import java.util.*;

class Solution {
    public boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int k : adj.get(cur)) {
                if (visited[k] == -1) {
                    q.add(k);
                    visited[k] = 1 - visited[cur];
                } else if (visited[k] == visited[cur]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bipartite(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        for (int i = 0; i < n; ++i) {
            if (visited[i] == -1) {
                if (!bfs(i, adj, visited)) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Solution sol = new Solution();
        System.out.println(sol.bipartite(adj) ? "true" : "false");
        scanner.close();
    }
}*/
//DFS Approach

import java.util.*;

class Solution {
    public static boolean dfs(int cur, int color, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[cur] = color;

        for (int next : adj.get(cur)) {
            if (visited[next] == -1) {
                if (!dfs(next, 1 - color, adj, visited)) {
                    return false;
                }
            } else if (visited[next] == color) {
                return false;
            }
        }

        return true;
    }

    public static boolean bipartite(ArrayList<ArrayList<Integer>> adj, int n) {
        int v = adj.size();
        int[] visited = new int[v];
        Arrays.fill(visited, -1);

        for (int i = 0; i < v; i++) {
            if (visited[i] == -1) {
                if (!dfs(i, 0, adj, visited)) {
                    return false;
                }
            }
        }

        return true;
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        System.out.println(bipartite(adj, n) ? "true" : "false");
    }
}
*/
