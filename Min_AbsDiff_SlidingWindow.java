/*
3567. Minimum absolute difference in Sliding Window ->
You are given an m x n integer matrix grid and an integer k.
For every contiguous k x k submatrix of grid, compute the minimum absolute difference between any two distinct values within that submatrix.
Return a 2D array ans of size (m - k + 1) x (n - k + 1), where ans[i][j] is the minimum absolute difference in the submatrix whose top-left corner is (i, j) in grid.
Note: If all elements in the submatrix have the same value, the answer will be 0.
A submatrix (x1, y1, x2, y2) is a matrix that is formed by choosing all cells matrix[x][y] where x1 <= x <= x2 and y1 <= y <= y2.
Example 1:

Input: grid = [[1,8],[3,-2]], k = 2
Output: [[2]]
Explanation:
There is only one possible k x k submatrix: [[1, 8], [3, -2]].
Distinct values in the submatrix are [1, 8, 3, -2].
The minimum absolute difference in the submatrix is |1 - 3| = 2. Thus, the answer is [[2]].

*/
class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n-k+1][m-k+1];
        if(k==1)return result;
        for(int i=0; i<n-k+1; i++){
            for(int j=0; j<m-k+1; j++){
                int[] arr = new int[k*k];
                int idx=0;
                for(int start =i; start<i+k; start++){
                    for(int end = j; end<j+k; end++){
                        arr[idx++]=grid[start][end];
                    }
                }
                Arrays.sort(arr);
                int min=Integer.MAX_VALUE;
                for(int l=1; l<k*k; l++){
                    if(arr[l]!=arr[l-1]){
                     min  = Math.min(min,Math.abs(arr[l]-arr[l-1]));                       
                    }

                }
                if (min == Integer.MAX_VALUE) {
    min = 0;
}
                result[i][j]=min;
            }
        }
        return result;
    }
}
