//97. Interleaving String->
/* Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
An interleaving of two strings s and t is a configuration 
where s and t are divided into n and m substrings respectively, such that:
E.g:
s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b. */

//Recursion Brute force solution

class Solution {
    public boolean solve(String s1, String s2, String s3, int ind1, int ind2, int[][] dp) {
        if (ind1 + ind2 == s3.length()) return true;
        if (dp[ind1][ind2] != -1) return dp[ind1][ind2] == 1;
        boolean ans = false;
        
        if (ind1 < s1.length() && s1.charAt(ind1) == s3.charAt(ind1 + ind2)) {
            ans |= solve(s1, s2, s3, ind1 + 1, ind2, dp);
        }
        
        if (ind2 < s2.length() && s2.charAt(ind2) == s3.charAt(ind1 + ind2)) {
            ans |= solve(s1, s2, s3, ind1, ind2 + 1, dp);
        }
        
        dp[ind1][ind2] = ans ? 1 : 0;
        return ans;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(s1, s2, s3, 0, 0, dp);
    }
}

//Memoization through 2D DP
import java.util.*;
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) return false;
        
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(dp[i],-1);
        return helper(s1,s2,s3,0,0,dp);
    }
    public boolean helper(String s1, String s2, String s3, int i, int j, int dp[][]){
        if(i+j==s3.length()){
            return true;
        }//base case
        if(dp[i][j]!= -1){
            return (dp[i][j]==1);
        }//base case
        boolean ans=false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j))
        ans|=helper(s1,s2,s3,i+1,j,dp);
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j))
        ans|=helper(s1,s2,s3,i,j+1,dp);

        dp[i][j]=(ans==true)?1:0;
        return ans;
    }
}
//Bottom Up
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i - 1][j];
                }

                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
