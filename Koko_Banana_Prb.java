import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) {
            throw new IllegalArgumentException("piles array must not be empty");
        }

        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        int ans = max;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            long hours = 0L; // use long to prevent overflow

            for (int pile : piles) {
                hours += (pile + mid - 1L) / mid; // ensure all operations are long
            }

            if (hours <= h) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return ans;
    }
}
