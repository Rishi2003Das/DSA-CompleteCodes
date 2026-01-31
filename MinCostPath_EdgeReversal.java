import java.util.*;

class Pair {
    int node;
    int weight;
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int minCost(int n, int[][] edges) {

        // Step 1: Build adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2] * 2));
        }

        // Step 2: Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;

        // Step 3: Min-Heap (weight, node)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(0, 0)); // (node, distance)

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.weight;

            // remove costlier paths
            if (d > dist[node]) continue;

            // Step 4: Relax neighbors
            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int weight = neighbor.weight;

                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.offer(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        return dist[n - 1] == (int) 1e9 ? -1 : dist[n - 1];
    }
}
