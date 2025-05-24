//Largest Bitonic Subsequence using DP

class Solution{
static int longestBitonicSequence(int[] arr, int n) {
        // Arrays to store lengths of increasing and decreasing subsequences
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        // Initialize both arrays with 1, as each element itself is a subsequence of length 1
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // Calculate the lengths of increasing subsequences
        for (int i = 0; i < n; i++) {
            for (int prevIndex = 0; prevIndex < i; prevIndex++) {
                if (arr[prevIndex] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[prevIndex]);
                }
            }
        }

        // Reverse the direction of nested loops and calculate the lengths of decreasing subsequences
        for (int i = n - 1; i >= 0; i--) {
            for (int prevIndex = n - 1; prevIndex > i; prevIndex--) {
                if (arr[prevIndex] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[prevIndex]);
                }
            }
        }

        int maxi = -1;

        // Calculate the length of the longest bitonic subsequence
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }

        return maxi;
    }
}
