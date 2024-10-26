class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Edge case: only one house
        if (n == 1) return nums[0];

        // Robbing from 0 to n-2 (excluding the last house)
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int max1 = solveUtil(n - 2, nums, dp1, 0);

        // Robbing from 1 to n-1 (excluding the first house)
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int max2 = solveUtil(n - 1, nums, dp2, 1);

        // Return the maximum of both cases
        return Math.max(max1, max2);
    }

    // Helper method to solve the subproblem
    static int solveUtil(int ind, int[] nums, int[] dp, int start) {
        if (ind < start) 
            return 0;
        
        if (ind == start) 
            return nums[start];
        
        if (dp[ind] != -1) 
            return dp[ind];

        int pick = nums[ind] + solveUtil(ind - 2, nums, dp, start);
        int nonPick = solveUtil(ind - 1, nums, dp, start);
        
        return dp[ind] = Math.max(pick, nonPick);
    }
}
