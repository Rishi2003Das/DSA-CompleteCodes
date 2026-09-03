/* 115. Distinct subsequence->
Given two strings s and t, return the number of distinct subsequences of s which equals t.
The test cases are generated so that the answer fits on a 32-bit signed integer.
Example 1:
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit */
//Recursion
class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        return func(m-1,n-1,s,t);
    }
    int func(int i, int j, String s, String t){
        if(j<0)
        return 1;
        if(i<0)
        return 0;
        if(s.charAt(i)==t.charAt(j)){
            return func(i-1,j,s,t)+func(i-1,j-1,s,t);
        }
        else
        return func(i-1,j,s,t);
    }
}
//Memoization using 2D DP
class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int memo[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                memo[i][j]=-1;
            }
        }
        return func(m-1,n-1,s,t,memo);
    }
    int func(int i, int j, String s, String t, int dp[][]){
        if(j<0)
        return 1;
        if(i<0)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            dp[i][j]=func(i-1,j,s,t,dp)+func(i-1,j-1,s,t,dp);
        }
        else
            dp[i][j]=func(i-1,j,s,t,dp);

        return dp[i][j];
    }
}
