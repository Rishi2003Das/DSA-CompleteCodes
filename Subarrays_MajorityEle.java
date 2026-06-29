//Easier
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
//Harder
class Solution {

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        // represents the occurrence count of prefix sums -n, -(n-1), ..., 0, 1, ..., n, with index offset by n.
        int[] pre = new int[n * 2 + 1];
        pre[n] = 1;
        int cnt = n;
        long ans = 0;
        long presum = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == target) {
                presum += pre[cnt];
                ++cnt;
                ++pre[cnt];
            } else {
                --cnt;
                presum -= pre[cnt];
                ++pre[cnt];
            }
            ans += presum;
        }
        return ans;
    }
}
