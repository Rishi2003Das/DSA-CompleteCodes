/*
1727. Largest Matrix with Rearrangements ->
You are given a binary matrix of size m x n, and you are allowed to
rearrange the columns of the matrix in any order. Return the area of 
the largest submatrix within the matrix, where every element of the submatrix
is 1 after reordering the columns optimally.
*/

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }
            
            int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, currRow[i] * (n - i));
            }
        }
        
        return ans;
    }
}
