class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // +1 because problem expects 1-indexed output
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;  // move left pointer forward
            } else {
                right--; // move right pointer backward
            }
        }

        // Should never reach here if input guarantees exactly one solution
        return new int[] {-1, -1};
    }
}
