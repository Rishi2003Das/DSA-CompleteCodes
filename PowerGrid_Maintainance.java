//Disjoint Set Method

//Time complexity: O((n+m+q)⋅logn)

//Space complexity: O(n)


import java.util.*;

class Solution {
    int[] parent, size;
    Map<Integer, PriorityQueue<Integer>> mp = new HashMap<>();

    int findParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    void Union(int u, int v) {
        int up = findParent(u);
        int vp = findParent(v);

        if (up == vp) return;

        if (size[up] > size[vp]) {
            size[up] += size[vp];
            parent[vp] = up;
            PriorityQueue<Integer> pqV = mp.get(vp);
            PriorityQueue<Integer> pqU = mp.get(up);
            while (!pqV.isEmpty()) pqU.offer(pqV.poll());
        } else {
            size[vp] += size[up];
            parent[up] = vp;
            PriorityQueue<Integer> pqU = mp.get(up);
            PriorityQueue<Integer> pqV = mp.get(vp);
            while (!pqU.isEmpty()) pqV.offer(pqU.poll());
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c];
        size = new int[c];
        boolean[] offline = new boolean[c];

        for (int i = 0; i < c; i++) {
            parent[i] = i;
            size[i] = 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(i);
            mp.put(i, pq);
        }

        for (int[] conn : connections) {
            int u = conn[0] - 1, v = conn[1] - 1;
            Union(u, v);
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int node = q[1] - 1;

            if (type == 1) {
                if (!offline[node]) {
                    ans.add(node + 1);
                    continue;
                }
                int par = findParent(node);
                PriorityQueue<Integer> pq = mp.get(par);
                while (!pq.isEmpty() && offline[pq.peek()]) pq.poll();
                ans.add(pq.isEmpty() ? -1 : pq.peek() + 1);
            } else {
                offline[node] = true;
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}


//DFS Graph method

//Time complexity: O(c+e+qlogn)

//Space complexity: O(c+e)
import java.util.*;

class Solution {
    void dfs(int id, int node, List<List<Integer>> adj, boolean[] vis, Map<Integer, TreeSet<Integer>> mp, Map<Integer, Integer> mpp) {
        vis[node] = true;
        mp.get(id).add(node);
        mpp.put(node, id);
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(id, it, adj, vis, mp, mpp);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < c; i++) adj.add(new ArrayList<>());

        for (int[] it : connections) {
            adj.get(it[0] - 1).add(it[1] - 1);
            adj.get(it[1] - 1).add(it[0] - 1);
        }

        boolean[] vis = new boolean[c];
        boolean[] online = new boolean[c];
        Arrays.fill(online, true);

        int id = 0;
        Map<Integer, TreeSet<Integer>> mp = new HashMap<>();
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < c; i++) {
            if (!vis[i]) {
                mp.put(id, new TreeSet<>());
                dfs(id, i, adj, vis, mp, mpp);
                id++;
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int node = q[1] - 1;
            int compId = mpp.get(node);

            if (type == 2) {
                mp.get(compId).remove(node);
                online[node] = false;
                continue;
            }

            if (online[node]) {
                ansList.add(node + 1);
            } else if (!mp.get(compId).isEmpty()) {
                ansList.add(mp.get(compId).first() + 1);
            } else {
                ansList.add(-1);
            }
        }

        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) ans[i] = ansList.get(i);
        return ans;
    }
}
