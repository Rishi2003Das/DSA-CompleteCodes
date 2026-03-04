/*

1582. Special Position in Binary Matrix
Given an m x n binary matrix mat, return the number of special positions in mat.
A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).

*/


class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    boolean[][] vis = new boolean[m][n];
                    if(checkSpecial(i, j, m, n, i, j, mat, vis))
                        count++;
                }
            }
        }
        return count;
    }

    public boolean checkSpecial(int i, int j, int m, int n, int si, int sj, int[][] mat, boolean[][] vis){

        if(i < 0 || j < 0 || i >= m || j >= n || vis[i][j])
            return true;

        vis[i][j] = true;

        if((i == si || j == sj) && !(i == si && j == sj) && mat[i][j] == 1)
            return false;

        if(!checkSpecial(i-1, j, m, n, si, sj, mat, vis)) return false;
        if(!checkSpecial(i+1, j, m, n, si, sj, mat, vis)) return false;
        if(!checkSpecial(i, j-1, m, n, si, sj, mat, vis)) return false;
        if(!checkSpecial(i, j+1, m, n, si, sj, mat, vis)) return false;

        return true;
    }
}
