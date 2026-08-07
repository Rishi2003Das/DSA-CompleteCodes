import java.util.*;

public class Solution {

    public int unboundedKnapsack(int[] weights, int[] profits, int capacity) {
        int n = weights.length;

        int[][] dp = new int[n][capacity + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(n - 1, capacity, weights, profits, dp);
    }

    int func(int ind, int W, int[] wt, int[] pr, int[][] dp) {

        if (ind == 0) {
            return (W / wt[0]) * pr[0];
        }

        if (dp[ind][W] != -1)
            return dp[ind][W];

        int notTake = func(ind - 1, W, wt, pr, dp);

        int take = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            take = pr[ind] + func(ind, W - wt[ind], wt, pr, dp);
        }

        return dp[ind][W] = Math.max(take, notTake);
    }
}
