class Pair{
    int first;
    int sec;
    Pair(int rows,int cols){
        int first=rows;
        int sec=cols;
    }
}

class Solution {

    int countDistinctIslands(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        Arrays.fill(vis,0);
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]!=1){
                    //Then this can serve as a starting point
                    c++;
                    bfs(i,j,vis,grid);
                    
                }
            }
        }
        return c;
    }
    
    public void bfs(int r, int c, int vis[][], int grid[][]){
        vis[r][c]=1;
        Queue<Pair> q= new LinkedList<Pair>();
        int m=grid.length;
        int n=grid[0].length;
        q.offer(new Pair(r,c));
        
        // until the queue becomes empty
      while(!q.isEmpty()) {
          int row = q.peek().first; 
          int col = q.peek().sec; 
          q.remove(); 
          
          // traverse in the neighbours and mark them if its a land 
          for(int delrow = -1; delrow<=1;delrow++) {
              for(int delcol = -1; delcol <= 1; delcol++) {
                  int nrow = row + delrow; 
                  int ncol = col + delcol; 
          // check if neighbour row and column is valid, and is an unvisited land
                  if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
                  && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                      vis[nrow][ncol] = 1; 
                      q.add(new Pair(nrow, ncol)); 
                  }
              }
          }
      }
    }
}
