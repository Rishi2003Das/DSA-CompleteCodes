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
/* 940. Distinct Subsequence II-
Given a string s, return the number of distinct non-empty subsequences of s.
Since the answer may be very large, return it modulo 109 + 7.
A subsequence of a string is a new string that is formed from the original string 
by deleting some (can be none) of the characters without disturbing the relative 
positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not.
 */
class Solution {
    public int distinctSubseqII(String S) {
        int MOD = 1_000_000_007;
        int N = S.length();
        int[] dp = new int[N+1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < N; ++i) {
            int x = S.charAt(i) - 'a';
            dp[i+1] = dp[i] * 2 % MOD;
            if (last[x] >= 0)
                dp[i+1] -= dp[last[x]];
            dp[i+1] %= MOD;
            last[x] = i;
        }

        dp[N]--;
        if (dp[N] < 0) dp[N] += MOD;
        return dp[N];
    }
}
