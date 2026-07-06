import java.util.*;

class Pair {
    int neighbour, weight;

    Pair(int neighbour, int weight) {
        this.neighbour = neighbour;
        this.weight = weight;
    }
}

class Solution {
    public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Pair>> adj, Stack<Integer> s) {
        visited[node] = true;
        for (Pair k : adj.get(node)) {
            int neighbour = k.neighbour;
            if (!visited[neighbour]) {
                dfs(neighbour, visited, adj, s);
            }
        }
        s.push(node);
    }

    public static ArrayList<Integer> shortestPath(int n, int e, int[][] edges) {
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        Stack<Integer> s = new Stack<>();
        dfs(0, visited, adj, s);

        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
        dist.set(0, 0);

        while (!s.isEmpty()) {
            int curr = s.pop();

            if (dist.get(curr) != Integer.MAX_VALUE) {
                for (Pair k : adj.get(curr)) {
                    int neighbour = k.neighbour;
                    int weight = k.weight;

                    if (dist.get(curr) + weight < dist.get(neighbour)) {
                        dist.set(neighbour, dist.get(curr) + weight);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist.get(i) == Integer.MAX_VALUE) {
                dist.set(i, -1);
            }
        }

        return dist;
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        ArrayList<Integer> dist = Solution.shortestPath(n, e, edges);
        for (int x : dist) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
*/
