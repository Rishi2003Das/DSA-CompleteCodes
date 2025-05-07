class Solution {
    public int[] shortestPath(int[][] edges, int n, int m){
        Queue<Integer> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        for(int i = 0;i<m;i++) {
            adj.get(edges[i][0]).add(edges[i][1]); 
            adj.get(edges[i][1]).add(edges[i][0]); 
        }
        int ans[] = new int[n];
        for(int i = 0;i<n;i++) 
        ans[i] = (int)1e9;
        ans[0]=0;
        q.add(0);

        while(!q.isEmpty()) {
            int node = q.peek(); 
            q.remove(); 
            for(int it : adj.get(node)) {
                if(ans[node] + 1 < ans[it]) {
                    ans[it] = 1 + ans[node]; 
                    q.add(it); 
                }
            }
        }
        for(int i = 0;i<n;i++) {
            if(ans[i] == 1e9) {
                ans[i] = -1; 
            }
        }
        return ans;
    }
}
