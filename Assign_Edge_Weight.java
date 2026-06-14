/*
3558. No. of ways to assign edge weight in tree - 
There is an undirected tree with n nodes labelled from 1 to n, rooted at node 1. 
The tree is represented by a 2D integer array edges of length n - 1, where edges[i] = [ui, vi] 
indicates that there is an edge between nodes ui and vi.
Initially, all edges have a weight of 0. You must assign each edge a weight of either 1 or 2.
The cost of a path between any two nodes u and v is the total weight of all edges in the path connecting them.
Select any one node x at the maximum depth. Return the number of ways to assign edge weights 
in the path from node 1 to x such that its total cost is odd.
Since the answer may be large, return it modulo 109 + 7.

Note: Ignore all edges not in the path from node 1 to x.
*/

class Solution {

    private static final int MOD = 1_000_000_007;

    private int qpow(int x, int y) {
        long res = 1;
        long base = x;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            y >>= 1;
        }
        return (int) res;
    }

    private int dfs(List<List<Integer>> g, int x, int f) {
        int maxDep = 0;
        for (int y : g.get(x)) {
            if (y == f) continue;
            maxDep = Math.max(maxDep, dfs(g, y, x) + 1);
        }
        return maxDep;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        int maxDep = dfs(g, 1, 0);
        return qpow(2, maxDep - 1);
 
