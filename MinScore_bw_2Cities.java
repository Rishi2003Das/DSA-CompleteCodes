/* 2492. Minimum score of path between 2 cities: You are given a positive integer n representing n cities numbered from 1 to n.
You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between
cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.
The score of a path between two cities is defined as the minimum distance of a road in this path.
Return the minimum possible score of a path between cities 1 and n.

Note:
A path is a sequence of roads between two cities.
It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
The test cases are generated such that there is at least one path between 1 and n.

*/

class Solution {
    public int minScore(int n, int[][] roads) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        vis[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int[] edge : adj.get(node)) {
                int nei = edge[0];
                int wt = edge[1];

                ans = Math.min(ans, wt);

                if (!vis[nei]) {
                    vis[nei] = true;
                    q.offer(nei);
                }
            }
        }

        return ans;
    }
}
