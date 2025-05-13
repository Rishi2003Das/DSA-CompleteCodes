class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        
        // Initialize dp with the values of the last row (base case)
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[n - 1][i];
        }

        // Process each row from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                // Check the values directly below, left diagonal, and right diagonal
                int down = dp[j];
                int leftDiag = j > 0 ? dp[j - 1] : Integer.MAX_VALUE;
                int rightDiag = j < n - 1 ? dp[j + 1] : Integer.MAX_VALUE;
                
                // Update the dp for the current cell
                temp[j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
            }
            dp = temp;  // Update dp for the next iteration
        }

        // Find the minimum value in the first row (the result)
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp[i]);
        }
        return minSum;
    }
}
