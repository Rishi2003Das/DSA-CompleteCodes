// Minimum sum of squared difference
/*
The solution is done by my approach. 
Using priority queue in a brute-force form.
The solution has a time complexity of O(log n) and 
Space complexity of O(m).
This solution will face a TLE error. 
*/
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long sum = 0;
        long s = 0;
        long k = (long) k1 + k2;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int dif = Math.abs(nums1[i] - nums2[i]);
            s += dif;
            pq.add(dif);
        }

        if (s <= k) {
            return 0;
        }

        while (k > 0) {
            int num = pq.poll();

            if (num > 0) {
                pq.add(num - 1);
                k--;
            } else {
                pq.add(num);
                break;
            }
        }

        while (!pq.isEmpty()) {
            long diff = pq.poll();
            sum += diff * diff;
        }

        return sum;
    }
}
// The optimised solution with the best approach using binary search algorithm 
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];
        int max = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }

        if (total <= k) {
            return 0;
        }

        int left = 0, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long ops = 0;

            for (int d : diff) {
                if (d > mid) {
                    ops += d - mid;
                }
            }

            if (ops <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long ans = 0;
        long remaining = k;

        for (int d : diff) {
            if (d > left) {
                long reduction = d - left;
                ans += (long) left * left;
                remaining -= reduction;
            } else {
                ans += (long) d * d;
            }
        }

        if (remaining > 0) {
            for (int d : diff) {
                if (d == left && remaining > 0) {
                    ans -= (long) left * left;
                    ans += (long) (left - 1) * (left - 1);
                    remaining--;
                }
            }
        }

        return ans;
    }
}
