class Solution {

    boolean helper(int mid, int[] nums, int threshold) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] + mid - 1) / mid; 
            // Equivalent to ceil(nums[i] / mid)
        }
        return sum <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int l = 1, r = 0;
        for (int i = 0; i < n; i++) {
            r = Math.max(r, nums[i]);
        }

        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (helper(mid, nums, threshold)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
