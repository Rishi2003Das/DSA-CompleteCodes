import java.util.HashSet;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Use a HashSet for quick lookup
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int sum = 0; // Current sum of chosen numbers
        int count = 0; // Count of chosen numbers

        for (int i = 1; i <= n; i++) {
            if (!bannedSet.contains(i) && sum + i <= maxSum) {
                sum += i;
                count++;
            }
        }

        return count;
    }
}
