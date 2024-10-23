class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m =isConnected.length;
        int n =isConnected[0].length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ; i<m ;i++){
            adj.add(new ArrayList());
        }
        for(int i =0;i<m;i++){
            for(int  j =0 ;j< m ;j++){
                 if(i==j) continue;
                if(isConnected[i][j] ==1){
                    adj.get(i).add(j);
                }
            }
        }
        int[] vis = new int[m];
        int count =0;
        for(int i = 0; i< m;i++){
            if(vis[i] != 1){
                count++;
                dfs(i , adj , vis);
            }
        }
        return count;
    }

     void dfs(int v , List<List<Integer>> list , int[] vis){
        vis[v] =1;
        for(int i : list.get(v)){
            if(vis[i] != 1){
                dfs(i , list , vis);
            }
        }
    }
}
