class Pair{
    int first;
    int second;
    public Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        int vis[][]= new int[m][n];
        int c=0;

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(vis[row][col] == 0 && grid[row][col] == '1'){
                    bfs(row,col,vis,grid);
                    c++;
                }
            }
        }
        return c;
    }
    
    private void bfs(int r, int c, int vis[][], char grid[][]){
    vis[r][c] = 1;
    Queue<Pair> q = new LinkedList<Pair>();
    q.add(new Pair(r, c));
    int m = grid.length;
    int n = grid[0].length;

    // Direction arrays for moving up, down, left, and right
    int[] dRow = {-1, 1, 0, 0};
    int[] dCol = {0, 0, -1, 1};

    while (!q.isEmpty()) {
        int row = q.peek().first;
        int col = q.peek().second;
        q.remove();

        for (int i = 0; i < 4; i++) { // Only iterate over the 4 main directions
            int nrow = row + dRow[i];
            int ncol = col + dCol[i];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                vis[nrow][ncol] = 1;
                q.add(new Pair(nrow, ncol));
            }
        }
    }
}
}
