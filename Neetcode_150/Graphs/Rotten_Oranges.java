class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        Queue<int[]> queue=new LinkedList<>();
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                    vis[i][j]=true;
                }
                else if(grid[i][j]==1)
                fresh++;
            }
        }
        if(fresh==0)
        return 0;
        int mins=-1;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                for(int[] dir: directions){
                    int nr=curr[0]+dir[0];
                    int nc=curr[1]+dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc] && grid[nr][nc]==1){
                        grid[nr][nc]++;
                        fresh--;
                        queue.offer(new int[]{nr, nc});
                        vis[nr][nc]=true;
                    }
                }
            }
            mins++;
        }
        if(fresh==0)
        return mins;
        else
        return -1;
    }
}
