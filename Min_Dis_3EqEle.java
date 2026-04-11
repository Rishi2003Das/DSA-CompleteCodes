/*
You are given an integer array nums.
A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].
The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.
Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.
*/

import java.util.*;
class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new HashSet<>());
            map.get(nums[i]).add(i);
        }

        int dis = Integer.MAX_VALUE;
        boolean found = false;

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> set = entry.getValue();

            if (set.size() < 3) continue;

            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            for (int i = 0; i <= list.size() - 3; i++) {
                int a = list.get(i);
                int b = list.get(i + 1);
                int c = list.get(i + 2);

                int curr = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
                dis = Math.min(dis, curr);
                found = true;
            }
        }

        return found ? dis : -1;
    }
}
