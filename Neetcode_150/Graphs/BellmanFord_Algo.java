import java.util.*;

class Solution {
    public static int[] bellmanFord(int n, int start, int[][] edges) {
        int INF = 10000000;
        int[] dist = new int[n];
        
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        for (int i = 1; i <= n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];
                
                if (dist[u] != INF && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            if (dist[u] != INF && dist[u] + weight < dist[v]) {
                return new int[] {-1}; 
            }
        }
        
        return dist;
    }
}

public class Main {
    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int start = scanner.nextInt();
        
        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
        }
        
        Solution sol = new Solution();
        int[] dist = sol.bellmanFord(n, start, edges);
        
        for (int d : dist) {
            System.out.print(d + " ");
        }
    }
    */
}
