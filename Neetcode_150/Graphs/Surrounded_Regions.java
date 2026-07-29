class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        //edge case
        if(m<3 || n<3)
        return;

        boolean vis[][]=new boolean[m][n];

        //Navigating throught the boundary elements
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && !vis[i][0])
            dfs(i,0,board,vis);
            if(board[i][n-1]=='O' && !vis[i][n-1])
            dfs(i,n-1,board,vis);
        }

        for(int i=0;i<n;i++){
            if(board[0][i]=='O' && !vis[0][i])
            dfs(0,i,board,vis);
            if(board[m-1][i]=='O' && !vis[m-1][i])
            dfs(m-1,i,board,vis);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && !vis[i][j]){
                board[i][j]='X';
                vis[i][j]=true;
                }
            }
        }
    }

    void dfs(int row, int col, char[][] board, boolean[][] vis){
        int m=board.length;
        int n=board[0].length;

        if(row<0 || row>=m || col<0 || col>=n || vis[row][col]==true || board[row][col]=='X'){
            return;
        }

        vis[row][col]=true;

        dfs(row-1, col, board, vis);
        dfs(row, col-1, board, vis);
        dfs(row+1, col, board, vis);
        dfs(row, col+1, board, vis);
    }
}
