import java.util.*;

class Pair {
    int time;
    int dest;

    Pair(int time, int dest) {
        this.time = time;
        this.dest = dest;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Graph construction
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            // Convert to 0-based indexing
            adj.get(time[0] - 1).add(new Pair(time[2], time[1] - 1));
        }

        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        // Min-heap priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Pair(0, k - 1));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.dest;
            int currTime = curr.time;

            if (currTime > dist[u]) continue;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.dest;
                int w = neighbor.time;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Pair(dist[v], v));
                }
            }
        }

        // Compute max distance
        int maxTime = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) return -1; // Unreachable node
            maxTime = Math.max(maxTime, d);
        }

        return maxTime;
    }
}
