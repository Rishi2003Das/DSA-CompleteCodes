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
        int m=grid.length;//row
        int n=grid[0].length;//column

        boolean vis[][]=new boolean[m][n];//vising array

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=false;
            }
        }

        int c=0;

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(vis[row][col] == false && grid[row][col] == '1'){
                    bfs(row,col,vis,grid);
                    c++;//counting the number of islands
                }
            }
        }
        return c;
    }

    void bfs(int row, int col, boolean vis[][], char grid[][]){
        vis[row][col]=true;

        Queue<Pair> queue=new LinkedList<Pair>();

        queue.add(new Pair(row, col));
        int m=grid.length;
        int n=grid[0].length;

        while(!queue.isEmpty()){
            int r=queue.peek().first;
            int c=queue.peek().second;

            queue.remove();

            int dRow[]={-1,1,0,0};
            int dCol[]={0,0,-1,1};

            for(int i=0;i<4;i++){
                int newRow=r+dRow[i];
                int newCol=c+dCol[i];
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && vis[newRow][newCol]==false && grid[newRow][newCol]=='1'){
                    vis[newRow][newCol]=true;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}
