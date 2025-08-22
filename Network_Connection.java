class Solution {
    private int overlap = 0;  // extra cables
    private ArrayList<Integer> parent;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; // Not enough edges

        parent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
        }

        for (int[] conn : connections) {
            checkConnection(conn[0], conn[1]);
        }

        // Count unique components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (findParent(i) == i) {
                components++;
            }
        }

        // To connect `components` groups, we need `components - 1` cables
        return (overlap >= components - 1) ? (components - 1) : -1;
    }

    private void checkConnection(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) {
            overlap++; // redundant edge
        } else {
            parent.set(pu, pv); // union
        }
    }

    private int findParent(int node) {
        if (node == parent.get(node)) return node;
        int root = findParent(parent.get(node));
        parent.set(node, root); // path compression
        return root;
    }
}
