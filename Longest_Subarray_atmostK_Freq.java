//2958. Length of Longest subarray with atmost K frequency
import java.util.*;
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0;
        int max = 0;
        for (int r = 0; r < nums.length; r++) {
            int currentFreq = freq.getOrDefault(nums[r], 0) + 1;
            freq.put(nums[r], currentFreq);
            while (freq.get(nums[r]) > k) {
                freq.put(nums[l],freq.get(nums[l]) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
