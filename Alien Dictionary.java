//This is a TopoSort algorithm used for the pattern prediction question

class Solution {
    public String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>()); // Initialize adjacency list for each character
        }

        // Build the graph
        for (int i = 0; i < N - 1; i++) {
            String p = dict[i];
            String q = dict[i + 1];
            int minLen = Math.min(p.length(), q.length());
            for (int c = 0; c < minLen; c++) {
                if (p.charAt(c) != q.charAt(c)) {
                    int a = p.charAt(c) - 'a';
                    int b = q.charAt(c) - 'a';
                    adj.get(a).add(b);
                    break;
                }
            }
        }

        // Get topological sort
        return topoSort(K, adj);
    }

    public String topoSort(int V, List<List<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0)
                dfs(i, vis, st, adj);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append((char)(st.pop() + 'a'));
        }
        return sb.toString();
    }

    public void dfs(int node, int[] vis, Stack<Integer> st, List<List<Integer>> adj) {
        vis[node] = 1;
        for (int it: adj. get(node)) {
            if (vis[it] == 0)
                dfs(it, vis, st, adj);
        }
        st.push(node);
    }
}
