import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Precompute the maximum frequency of each character in words2
        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] freq = computeFrequency(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        // Use DP with 2D arrays to check if words1 strings satisfy the maxFreq
        List<String> result = new ArrayList<>();
        for (String a : words1) {
            if (isUniversalUsingDP(a, maxFreq)) {
                result.add(a);
            }
        }

        return result;
    }

    // Helper to compute frequency of each character in a string
    private int[] computeFrequency(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // DP-based check for universal strings
    private boolean isUniversalUsingDP(String a, int[] maxFreq) {
        int n = a.length();
        int[][] dp = new int[n + 1][26]; // DP table: dp[i][j] tracks frequency till i

        // Build DP table for `a`
        for (int i = 1; i <= n; i++) {
            System.arraycopy(dp[i - 1], 0, dp[i], 0, 26); // Copy previous row
            dp[i][a.charAt(i - 1) - 'a']++;
        }

        // Check if `a` satisfies maxFreq
        for (int i = 0; i < 26; i++) {
            if (dp[n][i] < maxFreq[i]) {
                return false;
            }
        }

        return true;
    }
}
