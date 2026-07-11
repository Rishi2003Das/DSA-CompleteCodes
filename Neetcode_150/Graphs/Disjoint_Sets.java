class Solution {
    private int[] root, rank, edgeCount; 

    // union(x, y) 
    private void union(int x, int y) {
        int rx = find(x), ry = find(y); 
        int rankx = root[rx], ranky = root[ry]; 

        if(rx == ry) {
            edgeCount[rx]++; 
            return; 
        }

        if(rankx > ranky) {
            // add y to x. 
            root[ry] = rx; 
            edgeCount[rx] += edgeCount[ry] + 1; 
        } else if(ranky > rankx) {
            // add x to y 
            root[rx] = ry; 
            edgeCount[ry] += edgeCount[rx] + 1; 
        } else {
            root[rx] = ry; 
            edgeCount[ry] += edgeCount[rx] + 1; 
            rank[ry] += 1; 
        }

        
    }
    private int find(int x) {
        if(root[x] == x) return x; 
        return root[x] = find(root[x]); // path compression 
    }
    public int countCompleteComponents(int n, int[][] edges) {
         // 1. root, rank, edgeCount, nodeCount <- we will prepare in the end 

        root = new int[n]; 
        rank = new int[n]; 
        edgeCount = new int[n]; 

        for(int i = 0; i < n; i++) {
            root[i] = i; 
            rank[i] = 1; 
            edgeCount[i] = 0; 
        }

        // prepare union 
        for(int[] e: edges) {
            union(e[0], e[1]); 
        }

        // NOde count 
        int[] nodeCount = new int[n]; 
        for(int i = 0; i < n; i++) {
            nodeCount[find(i)]++; 
        }

        // count connected components 
        int cnt = 0; 

        for(int i = 0; i < n; i++) {
            if(nodeCount[i] > 0) {
                // i -> root, it has nodecount 
                if(2 * edgeCount[i] == (nodeCount[i] * (nodeCount[i] - 1))) cnt++; 
            }
        }
        return cnt; 
    }
}
