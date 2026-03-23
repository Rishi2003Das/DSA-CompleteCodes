/*
1594. Maximum Non-Negative Product in a Matrix ->
You are given a m x n matrix grid. Initially, you are located at the top-left corner (0, 0),
and in each step, you can only move right or down in the matrix.
Among all possible paths starting from the top-left corner (0, 0)
and ending in the bottom-right corner (m - 1, n - 1),
find the path with the maximum non-negative product.
The product of a path is the product of all integers in the grid cells visited along the path.
Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative, return -1.
Notice that the modulo is performed after getting the maximum product.(MOD-> 1000000007)
*/

class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long MOD = 1000000007;

        long[][] maxProd = new long[m][n];
        long[][] minProd = new long[m][n];

        maxProd[0][0] = minProd[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            maxProd[i][0] = minProd[i][0] = maxProd[i - 1][0] * grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            maxProd[0][j] = minProd[0][j] = maxProd[0][j - 1] * grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];

                long a = maxProd[i-1][j] * val;
                long b = minProd[i-1][j] * val;
                long c = maxProd[i][j-1] * val;
                long d = minProd[i][j-1] * val;

                maxProd[i][j] = Math.max(Math.max(a,b), Math.max(c,d));
                minProd[i][j] = Math.min(Math.min(a,b), Math.min(c,d));
            }
        }

        long ans = maxProd[m-1][n-1];
        if(ans < 0) return -1;
        return (int)(ans % MOD);
    }
}
