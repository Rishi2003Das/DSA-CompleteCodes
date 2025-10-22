//My approach using Hashing and HashMaps

import java.util.*;

public class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> originalFreq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int delta = -k; delta <= k; delta++) {
                int newVal = nums[i] + delta;
                freqMap.put(newVal, freqMap.getOrDefault(newVal, 0) + 1);
            }
            originalFreq.put(nums[i], originalFreq.getOrDefault(nums[i], 0) + 1);
        }


        Iterator<Map.Entry<Integer, Integer>> iterator = freqMap.entrySet().iterator();

        return getMaxFrequencyRecursive(iterator, originalFreq, numOperations, n, 0);
    }

    private int getMaxFrequencyRecursive(
            Iterator<Map.Entry<Integer, Integer>> iterator,
            Map<Integer, Integer> originalFreq,
            int numOperations,
            int n,
            int currentMax
    ) {
     
        if (!iterator.hasNext()) {
            return currentMax;
        }

        Map.Entry<Integer, Integer> entry = iterator.next();
        int possibleFreq = entry.getValue();
        int currentFreq = originalFreq.getOrDefault(entry.getKey(), 0);

        int totalFreq = Math.min(n, currentFreq + numOperations);
        int newMax = currentMax;

        if (totalFreq > currentMax && totalFreq <= possibleFreq) {
            newMax = totalFreq;
        } else if (possibleFreq > currentMax && currentFreq + numOperations >= possibleFreq) {
            newMax = possibleFreq;
        }

        if (newMax == n) return n;

        return getMaxFrequencyRecursive(iterator, originalFreq, numOperations, n, newMax);
    }
}


//Optimised Approach

class Solution {
    public int maxFrequency(int[] nums, int k, int numOps) {
        int maxVal = Arrays.stream(nums).max().getAsInt() + k + 2;
        int[] count = new int[maxVal];

        for (int v : nums)
            count[v]++;

        for (int i = 1; i < maxVal; i++)
            count[i] += count[i - 1];

        int res = 0;
        for (int i = 0; i < maxVal; i++) {
            int left = Math.max(0, i - k);
            int right = Math.min(maxVal - 1, i + k);
            int total = count[right] - (left > 0 ? count[left - 1] : 0);
            int freq = count[i] - (i > 0 ? count[i - 1] : 0);
            res = Math.max(res, freq + Math.min(numOps, total - freq));
        }

        return res;
    }
}

//More space and time optimised


class Solution {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int ans = 0;
        Map<Integer, Integer> numCount = new HashMap<>();
        Set<Integer> modes = new TreeSet<>();

        Consumer<Integer> addMode = value -> {
            modes.add(value);
            if (value - k >= nums[0]) {
                modes.add(value - k);
            }
            if (value + k <= nums[nums.length - 1]) {
                modes.add(value + k);
            }
        };

        int lastNumIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != nums[lastNumIndex]) {
                numCount.put(nums[lastNumIndex], i - lastNumIndex);
                ans = Math.max(ans, i - lastNumIndex);
                addMode.accept(nums[lastNumIndex]);
                lastNumIndex = i;
            }
        }

        numCount.put(nums[lastNumIndex], nums.length - lastNumIndex);
        ans = Math.max(ans, nums.length - lastNumIndex);
        addMode.accept(nums[lastNumIndex]);

        IntUnaryOperator leftBound = value -> {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < value) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        };

        IntUnaryOperator rightBound = value -> {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (nums[mid] > value) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return left;
        };

        for (int mode : modes) {
            int l = leftBound.applyAsInt(mode - k);
            int r = rightBound.applyAsInt(mode + k);
            int tempAns;
            if (numCount.containsKey(mode)) {
                tempAns = Math.min(
                    r - l + 1,
                    numCount.get(mode) + numOperations
                );
            } else {
                tempAns = Math.min(r - l + 1, numOperations);
            }
            ans = Math.max(ans, tempAns);
        }

        return ans;
    }
}

