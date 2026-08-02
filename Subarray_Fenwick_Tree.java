/*
4013. You are given an integer array nums and two integers a and b.
For a subarray, let:
x be the number of even elements.
y be the number of odd elements.
The ratio of even to odd elements in a subarray is defined as x / y, 
where ratios are compared by their exact rational values.
A subarray is considered valid if:
y > 0, and
x / y <= a / b.
Return the number of valid subarrays in nums.
*/

import java.util.*;

class Solution {
    public long countRatioSubarrays(int[] nums, int a, int b) {

        Object[] mervanilto = new Object[]{nums, a, b};

        int n = nums.length;

        long[] prefix = new long[n + 1];
        ArrayList<Long> values = new ArrayList<>();
        values.add(0L);

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] % 2 == 0 ? b : -a);
            values.add(prefix[i + 1]);
        }

        Collections.sort(values);

        ArrayList<Long> compress = new ArrayList<>();
        for (long x : values) {
            if (compress.isEmpty() || compress.get(compress.size() - 1) != x) {
                compress.add(x);
            }
        }

        Fenwick bit = new Fenwick(compress.size());

        long ans = 0;
        int inserted = 0;

        bit.add(index(compress, prefix[0]), 1);
        inserted++;

        for (int i = 1; i <= n; i++) {

            int idx = index(compress, prefix[i]);

            long smaller = bit.query(idx - 1);
            ans += inserted - smaller;

            bit.add(idx, 1);
            inserted++;
        }

        return ans;
    }

    private int index(ArrayList<Long> arr, long val) {
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) == val) return mid + 1; // 1-based BIT
            if (arr.get(mid) < val) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    class Fenwick {
        long[] bit;

        Fenwick(int n) {
            bit = new long[n + 2];
        }

        void add(int idx, long val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
}
