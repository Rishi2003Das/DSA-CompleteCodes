//518. Coin Change II
//recurssive solution
class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        return rec(n-1, amount, coins);
    }
    int rec(int ind, int target, int[] arr){
        if(ind==0){
            if((target)%arr[0]==0) return 1;
            else return 0;
        }
        int notTake=rec(ind-1, target, arr);

        int take =0;
        if(arr[ind]<=target)
        take=rec(ind, target-arr[ind], arr);

        return (notTake+take);
    }
}

//Memoization solution
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }

        return rec(n - 1, amount, coins, dp);
    }

    int rec(int ind, int target, int[] coins, int[][] dp) {

        if (ind == 0) {
            if (target % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        int notTake = rec(ind - 1, target, coins, dp);

        int take = 0;
        if (coins[ind] <= target) {
            take = rec(ind, target - coins[ind], coins, dp);
        }

        dp[ind][target] = notTake + take;

        return dp[ind][target];
    }
}
