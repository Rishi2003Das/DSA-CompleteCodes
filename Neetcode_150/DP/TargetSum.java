// Recurssive method with memoization
public class Solution {

    // Sum of all elements in the array
    int totalSum;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();

        int[][] memo = new int[nums.length][2 * totalSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculateWays(nums, 0, 0, target, memo);
    }

    private int calculateWays(
        int[] nums,
        int currentIndex,
        int currentSum,
        int target,
        int[][] memo
    ) {
        if (currentIndex == nums.length) {
            // Check if the current sum matches the target
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            // Check if the result is already computed
            if (
                memo[currentIndex][currentSum + totalSum] != Integer.MIN_VALUE
            ) {
                return memo[currentIndex][currentSum + totalSum];
            }
            // Calculate ways by adding the current number
            int add = calculateWays(
                nums,
                currentIndex + 1,
                currentSum + nums[currentIndex],
                target,
                memo
            );

            // Calculate ways by subtracting the current number
            int subtract = calculateWays(
                nums,
                currentIndex + 1,
                currentSum - nums[currentIndex],
                target,
                memo
            );

            // Store the result in memoization table
            memo[currentIndex][currentSum + totalSum] = add + subtract;

            return memo[currentIndex][currentSum + totalSum];
        }
    }
}
