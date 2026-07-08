//Shortest path in unit weight undirected graph
import java.util.*;

class Solution {
    public static List<Integer> shortestPath(int n, int e, List<List<Integer>> edges, int start) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        List<Integer> visited = new ArrayList<>(Collections.nCopies(n, 0));
        visited.set(start, 1);

        List<Integer> dist = new ArrayList<>(Collections.nCopies(n, -1));
        dist.set(start, 0);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int k : adj.get(curr)) {
                if (visited.get(k) == 0) {
                    dist.set(k, dist.get(curr) + 1);
                    visited.set(k, 1);
                    q.add(k);
                }
            }
        }

        return dist;
    }
}
/*
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int start = scanner.nextInt();

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            edges.add(Arrays.asList(scanner.nextInt(), scanner.nextInt()));
        }

        List<Integer> dist = Solution.shortestPath(n, e, edges, start);

        for (int i = 0; i < dist.size(); i++) {
            System.out.print(dist.get(i) + " ");
        }

        scanner.close();
    }
}
*/

//Dijkstra's Algorithm or Shortest path with a weighted undirected graph
import java.util.*;

class Pair {
        int vertex, weight;
    
        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
    }
}

class Solution {
    int[] dijkstra(int n, ArrayList<ArrayList<Pair>> adj, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Pair(start, 0));
    
        while (!pq.isEmpty()) {
            Pair x = pq.poll();
            int cur = x.vertex;
    
            for (Pair k : adj.get(cur)) {
                int neighbour = k.vertex;
                int weight = k.weight;
                if (dist[cur] + weight < dist[neighbour]) {
                    dist[neighbour] = dist[cur] + weight;
                    pq.add(new Pair(neighbour, dist[neighbour]));
                }
            }
        }
        return dist;
    }
}

/*public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }
    
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); 
        }
    
        int start = scanner.nextInt();

        Solution sol = new Solution();
        int[] dist = sol.dijkstra(n, adj, start);
    
        for (int d : dist) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}*/
