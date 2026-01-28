class Solution{
    public int longestPalindromeSubseq(String s) {
        String r="";
        for(int i=s.length()-1;i>=0;i--) r+=s.charAt(i);
        return longestCommonSubsequence(s,r);
    }
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
