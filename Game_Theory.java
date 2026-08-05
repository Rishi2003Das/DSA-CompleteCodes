/* 486. Predict Winner-
You are given an integer array nums. 
Two players are playing a game with this array: player 1 and player 2.
Player 1 and player 2 take turns, with player 1 starting first. 
Both players start the game with a score of 0. 
At each turn, the player takes one of the numbers from either end of the array 
(i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. 
The player adds the chosen number to their score. 
The game ends when there are no more elements in the array.

Return true if Player 1 can win the game. If the scores of both players are equal, 
then Player 1 is still the winner, and you should also return true. 
You may assume that both players are playing optimally.
*/
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) return true;
        
        int[] dp = nums.clone();
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] >= 0;
    }
}
/*
1406. Game Theory II-
Alice and Bob continue their games with piles of stones. 
There are several stones arranged in a row, and each stone has 
an associated value which is an integer given in the array stoneValue.
Alice and Bob take turns, with Alice starting first. On each player's turn, 
that player can take 1, 2, or 3 stones from the first remaining stones in the row.

The score of each player is the sum of the values of the stones taken. 
The score of each player is 0 initially.
The objective of the game is to end with 
the highest score, and the winner is the player with the highest score 
and there could be a tie. The game continues until all the stones have been taken.
Assume Alice and Bob play optimally.

Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they will end the game with the same score.
*/
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        int total = 0;

        for (int i = stoneValue.length - 1; i >= 0; i--) {
            total += stoneValue[i];

            int current = total - Math.min(
                s1,
                Math.min(s2, s3)
            );

            s3 = s2;
            s2 = s1;
            s1 = current;
        }

        int bob = total - s1;

        if (s1 > bob) {
            return "Alice";
        }

        if (s1 < bob) {
            return "Bob";
        }

        return "Tie";
    }
}

        return s[Integer.signum(dp[0]) + 1];
    }
}
