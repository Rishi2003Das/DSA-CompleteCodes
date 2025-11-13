//You are given a 0-indexed array nums consisiting of positive integers. You can do the following operation on the array any number of times:

//Select an index i such that 0 <= i < n - 1 and replace either of nums[i] or nums[i+1] with their gcd value.
//Return the minimum number of operations to make all elements of nums equal to 1. If it is impossible, return -1.

//The gcd of two integers is the greatest common divisor of the two integers.

class Solution {

    public int minOperations(int[] nums) {
        int n = nums.length;
        int num1 = 0;
        int g = 0;
        for (int x : nums) {
            if (x == 1) {
                num1++;
            }
            g = gcd(g, x);
        }
        if (num1 > 0) {
            return n - num1;
        }
        if (g > 1) {
            return -1;
        }

        int minLen = n;
        for (int i = 0; i < n; i++) {
            int currentGcd = 0;
            for (int j = i; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen + n - 2;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
