//Optimised 2-D DP solution
//T.C.=O(n^2)
//S.C.=O(n^2)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();

        int dp[][]=new int[m+1][n+1];

        for(int i=0;i<=m;i++) dp[i][0]=0;
        for(int i=1;i<=n;i++) dp[0][i]=0;
        String res="";
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)!=text2.charAt(j-1))
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                else
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                    res=res+text1.charAt(i-1);
                }
            }
        }
        return dp[m][n];
    }
}
//More faster and efficient 1-D DP Solution
//T.C.=O(n)
//S.C.=O(n)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text1.length()];
        int longest = 0;

        for (char c : text2.toCharArray()) {
            int curLength = 0;
            for (int i = 0; i < dp.length; i++) {
                if (curLength < dp[i]) {
                    curLength = dp[i];
                } else if (c == text1.charAt(i)) {
                    dp[i] = curLength + 1;
                    longest = Math.max(longest, curLength + 1);
                }
            }
        }

        return longest;        
    }
}
