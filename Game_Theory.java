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
