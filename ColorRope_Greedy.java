class Solution {
    public int minCost(String col, int[] time) {
        int n = col.length(), sum = 0;
        for (int i = 1; i < n; i++) {
            if (col.charAt(i) == col.charAt(i - 1)) {
                sum += Math.min(time[i], time[i - 1]);
                time[i] = Math.max(time[i], time[i - 1]);
            }
        }
        return sum;
    }
}
