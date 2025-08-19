// Prism's Algorithm Implementation

import java.util.*;

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        primsAlgorithm(graph);
    }

    // Function to implement Prim's Algorithm
    public static void primsAlgorithm(int[][] graph) {
        int n = graph.length;
        boolean[] inMST = new boolean[n];
        int[] key = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));
        pq.offer(new Pair(0, key[0]));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;

            if (inMST[u]) continue;
            inMST[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    pq.offer(new Pair(v, key[v]));
                }
            }
        }

        System.out.println("Minimum Spanning Tree cost: " + Arrays.stream(key).sum());
    }
}
