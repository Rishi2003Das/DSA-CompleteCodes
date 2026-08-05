//3310. Remove mehtods from object-
lass Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ans = new ArrayList<>();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it : invocations) {
            adj.get(it[0]).add(it[1]);
        }

        boolean[] vis = new boolean[n];

        dfs(k, vis, adj);

        // Check if any outside method invokes a suspicious method
        for (int[] it : invocations) {
            int u = it[0];
            int v = it[1];

            if (!vis[u] && vis[v]) {
                // Cannot remove anything
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (int nxt : adj.get(node)) {
            if (!vis[nxt]) {
                dfs(nxt, vis, adj);
            }
        }
    }
}
