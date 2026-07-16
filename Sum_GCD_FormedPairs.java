class Solution {

    public long gcdSum(int[] nums) {
        int n = nums.length;

        int[] mx = new int[n];
        int prefixMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            prefixMax = Math.max(prefixMax, nums[i]);
            mx[i] = prefixMax;
        }

        int[] prefixGcd = new int[n];
        for (int i = 0; i < n; ++i) {
            prefixGcd[i] = gcd(nums[i], mx[i]);
        }

        Arrays.sort(prefixGcd);

        long ans = 0;
        int left = 0,
            right = n - 1;
        while (left < right) {
            ans += gcd(prefixGcd[left], prefixGcd[right]);
            ++left;
            --right;
        }

        return ans;
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
