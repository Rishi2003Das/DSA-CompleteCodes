//309. With cooldown of 1 day after selling
import java.util.*;

//recursion
class Solution {
    public int maxProfit(int[] prices) {
        return f(0, true, prices);
    }
    int f(int ind, boolean buy, int prices[]){
        if(ind>=prices.length) return 0;
        if(buy){
            return Math.max(
                -prices[ind]+f(ind+1,false, prices),
                0+f(ind+1, true, prices)
            );
        }
        else{
            return Math.max(
                prices[ind]+f(ind+2, true, prices),
                0+f(ind+1, false, prices)
            );
        }
    }
}

//Memoization
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=-1; 
            dp[i][1]=-1;
        } 

        return f(0, 1, prices, dp);
    }
    int f(int ind, int buy, int prices[], int dp[][]){
        if(ind>=prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        if(buy==1){
            return dp[ind][buy]= Math.max(
                -prices[ind]+f(ind+1,0, prices,dp),
                0+f(ind+1, 1, prices,dp)
            );
        }
        else{
            return dp[ind][buy]=Math.max(
                prices[ind]+f(ind+2, 1, prices,dp),
                0+f(ind+1, 0, prices,dp)
            );
        }
    }
}
