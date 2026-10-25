/* 3886. Sum of Sortable integers->
You are given an integer array nums of length n.
An integer k is called sortable if k divides n and 
you can sort nums in non-decreasing order by sequentially performing the following operations:
Partition nums into consecutive subarrays of length k.
Cyclically rotate each subarray independently any number of times to the left or to the right.
Return an integer denoting the sum of all possible sortable integers k. */

//My approach- Brute Force (Time Limit exceeded!)
import java.util.*;
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }
            int[] arr = nums.clone();
            boolean possible = true;

            for (int i = 0; i < n; i += k) {
                int[] subarray = Arrays.copyOfRange(nums, i, i + k);
                if (!sortable(subarray)) {
                    possible = false;
                    break;
                }
                doSort(arr, i, i + k);
            }

            if (possible) {
                int[] target = nums.clone();
                Arrays.sort(target);
                if (Arrays.equals(target, arr)) {
                    ans += k;
                }
            }
        }
        return ans;
    }

    public boolean sortable(int[] subarray) {
        int[] sorted = subarray.clone();
        Arrays.sort(sorted);
        int n = subarray.length;
        for (int shift = 0; shift < n; shift++) {

            boolean match = true;

            for (int i = 0; i < n; i++) {

                int rotatedIndex = (i + shift) % n;

                if (subarray[rotatedIndex] != sorted[i]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return true;
            }
        }

        return false;
    }

    public void doSort(int[] arr, int start, int end) {

        int[] subarray = Arrays.copyOfRange(arr, start, end);
        int[] sorted = subarray.clone();
        Arrays.sort(sorted);
        int n = subarray.length;

        for (int shift = 0; shift < n; shift++) {
            boolean match = true;
            for (int i = 0; i < n; i++) {
                int rotatedIndex = (i + shift) % n;
                if (subarray[rotatedIndex] != sorted[i]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                for (int i = 0; i < n; i++) {
                    arr[start + i] = sorted[i];
                }
                return;
            }
        }
    }
}
// Faster and optimised approach
class Solution {

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        List<Integer> fac = new ArrayList<>();

        for (int x = 1; x * x <= n; x++) {
            if (n % x == 0) {
                fac.add(x);
                if (n / x != x) {
                    fac.add(n / x);
                }
            }
        }

        int[] target = nums.clone();
        Arrays.sort(target);

        int ans = 0;

        for (int d : fac) {
            boolean allGood = true;
            for (int left = 0; left < n; left += d) {
                int right = left + d - 1;
                int[] sub1 = Arrays.copyOfRange(nums, left, right + 1);
                int[] sub2 = Arrays.copyOfRange(target, left, right + 1);

                if (!check(sub1, sub2)) {
                    allGood = false;
                    break;
                }
            }
            if (allGood) {
                ans += d;
            }
        }

        return ans;
    }

    private boolean check(int[] nums1, int[] nums2) {
        // Check whether cyclic rotations of nums1 can produce nums2
        int[] doubled = new int[nums1.length * 2];
        System.arraycopy(nums1, 0, doubled, 0, nums1.length);
        System.arraycopy(nums1, 0, doubled, nums1.length, nums1.length);

        return kmp(doubled, nums2);
    }

    private boolean kmp(int[] text, int[] pattern) {
        int n = text.length,
            m = pattern.length;
        int[] pi = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (pattern[i] == pattern[j]) {
                j++;
            }
            pi[i] = j;
        }

        j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && text[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (text[i] == pattern[j]) {
                j++;
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }
}
