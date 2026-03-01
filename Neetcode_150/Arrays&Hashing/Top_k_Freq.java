/*
347.Top K-Frequency Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
        }


        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll()[0];
        }

        return result;
    }
}
