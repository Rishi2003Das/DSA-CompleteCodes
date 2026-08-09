/* 1140.
Alice and Bob continue their games with piles of stones. 
There are a number of piles arranged in a row, and each pile 
has a positive integer number of stones piles[i]. 
The objective of the game is to end with the most stones.

Alice and Bob take turns, with Alice starting first.
On each player's turn, that player can take all the stones in 
the first X remaining piles, where 1 <= X <= 2M. Then, 
we set M = max(M, X). Initially, M = 1.
The game continues until all the stones have been taken.
Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
 */
// Recursion solution
import java.util.Arrays;

class Solution {

    private int[][] memo;
    private int[] suffix;

    /**
     * Returns the maximum number of additional stones Alice can obtain
     * starting from index 'i' with the given M.
     *
     * aliceTurn = true  -> Alice chooses X to maximize Alice's stones
     * aliceTurn = false -> Bob chooses X to minimize Alice's stones
     */
    private int dfs(int[] piles, int i, int m, boolean aliceTurn) {
        // All piles have been taken.
        if (i == piles.length) {
            return 0;
        }

        // If the remaining piles can all be taken in this move.
        if (2 * m >= piles.length - i) {
            return aliceTurn ? suffix[i] : 0;
        }

        int state = aliceTurn ? 1 : 0;

        // Encode (i, m, turn) into a memo table.
        // We use separate tables through the third dimension.
        if (memo[i * 2 + state][m] != -1) {
            return memo[i * 2 + state][m];
        }

        int limit = Math.min(2 * m, piles.length - i);

        if (aliceTurn) {
            // Alice wants to maximize her final score.
            int best = 0;
            int taken = 0;

            for (int x = 1; x <= limit; x++) {
                taken += piles[i + x - 1];

                int nextM = Math.max(m, x);

                int candidate = taken
                        + dfs(piles, i + x, nextM, false);

                best = Math.max(best, candidate);
            }

            memo[i * 2 + state][m] = best;
            return best;

        } else {
            // Bob wants to minimize Alice's final score.
            int best = Integer.MAX_VALUE;

            for (int x = 1; x <= limit; x++) {
                int nextM = Math.max(m, x);

                int candidate = dfs(piles, i + x, nextM, true);

                best = Math.min(best, candidate);
            }

            memo[i * 2 + state][m] = best;
            return best;
        }
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // suffix[i] = sum of piles[i ... n-1]
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        /*
         * memo[state][m]
         *
         * state = i * 2 + turn
         * turn = 1 for Alice
         * turn = 0 for Bob
         *
         * m can be at most n.
         */
        memo = new int[2 * n][n + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(piles, 0, 1, true);
    }
}

//DP solution

class Solution {
    public int stoneGameII(int[] piles) {
        int len=piles.length;
        int dp[][]=new int[len+1][len+1];
        int suffixSum[]=new int[len+1];
        for(int i=len-1;i>=0;i--){
            suffixSum[i]=suffixSum[i+1]+piles[i];
        }
        for(int i=0; i<=len;i++){
            dp[i][len]=suffixSum[i];
        }
        for(int i=len-1;i>=0;i--){
            for(int max_now=len-1;max_now>=1;max_now--){
                for(int X=1;X<=2*max_now && i+X<=len;X++){
                    dp[i][max_now]=Math.max(dp[i][max_now],suffixSum[i]-dp[i+X][Math.max(max_now,X)]);
                }
            }
        }
        return dp[0][1];
    }
}
