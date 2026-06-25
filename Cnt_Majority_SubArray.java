class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == target) cnt++;

                int len = j - i + 1;

                if (2 * cnt > len)
                    ans++;
            }
        }

        return (int)ans;
    }
}
