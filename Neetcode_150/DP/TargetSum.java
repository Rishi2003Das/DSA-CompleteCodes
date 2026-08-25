// Recurssive method with memoization
public class Solution {
    private int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();

        int[][] memo = new int[nums.length][2 * totalSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculateWays(nums, 0, 0, target, memo);
    }

    private int calculateWays(int[] nums,int currentIndex,int currentSum,int target,int[][] memo) {
        if (currentIndex == nums.length) {
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (
                memo[currentIndex][currentSum + totalSum] != Integer.MIN_VALUE
            ) {
                return memo[currentIndex][currentSum + totalSum];
            }
            int add = calculateWays(nums,currentIndex + 1,currentSum + nums[currentIndex],target,memo);

            int subtract = calculateWays(nums,currentIndex + 1,currentSum - nums[currentIndex],target,memo);

            memo[currentIndex][currentSum + totalSum] = add + subtract;

            return memo[currentIndex][currentSum + totalSum];
        }
    }
}
