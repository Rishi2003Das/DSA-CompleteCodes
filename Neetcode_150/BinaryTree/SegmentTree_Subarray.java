/*
3691. You are given an integer array nums of length n and an integer k.
You must select exactly k distinct non-empty subarrays nums[l..r] of nums. 
Subarrays may overlap, but the exact same subarray (same l and r) cannot be chosen more than once.
The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).
The total value is the sum of the values of all chosen subarrays.
Return the maximum possible total value you can achieve.
*/

class SegTree {

    int[] maxv;
    int[] minv;
    int n;

    SegTree(int[] nums) {
        n = nums.length;
        maxv = new int[n * 4];
        minv = new int[n * 4];
        build(1, 0, n - 1, nums);
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            maxv[node] = minv[node] = nums[l];
            return;
        }
        int m = (l + r) / 2;
        build(node * 2, l, m, nums);
        build(node * 2 + 1, m + 1, r, nums);
        maxv[node] = Math.max(maxv[node * 2], maxv[node * 2 + 1]);
        minv[node] = Math.min(minv[node * 2], minv[node * 2 + 1]);
    }

    int queryMax(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return maxv[node];
        }
        int m = (l + r) / 2;
        int res = Integer.MIN_VALUE;
        if (ql <= m) {
            res = Math.max(res, queryMax(node * 2, l, m, ql, qr));
        }
        if (qr > m) {
            res = Math.max(res, queryMax(node * 2 + 1, m + 1, r, ql, qr));
        }
        return res;
    }

    int queryMin(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return minv[node];
        }
        int m = (l + r) / 2;
        int res = Integer.MAX_VALUE;
        if (ql <= m) {
            res = Math.min(res, queryMin(node * 2, l, m, ql, qr));
        }
        if (qr > m) {
            res = Math.min(res, queryMin(node * 2 + 1, m + 1, r, ql, qr));
        }
        return res;
    }
}

class Solution {

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SegTree seg = new SegTree(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int l = 0; l < n; l++) {
            pq.offer(
                new int[] {
                    seg.queryMax(1, 0, n - 1, l, n - 1) -
                    seg.queryMin(1, 0, n - 1, l, n - 1),
                    l,
                    n - 1,
                }
            );
        }
        long ans = 0;
        while (k-- > 0) {
            int[] top = pq.poll();
            ans += top[0];
            int l = top[1];
            int r = top[2];
            if (r > l) {
                pq.offer(
                    new int[] {
                        seg.queryMax(1, 0, n - 1, l, r - 1) -
                        seg.queryMin(1, 0, n - 1, l, r - 1),
                        l,
                        r - 1,
                    }
                );
            }
        }
        return ans;
    }
}
