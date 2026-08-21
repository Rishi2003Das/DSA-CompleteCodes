//3116
/* You are given an integer array coins representing coins of different denominations and an integer k.

You have an infinite number of coins of each denomination. However, you are not allowed to combine coins of different denominations.

Return the kth smallest amount that can be made using these coins. */

import java.util.*;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);

        List<Long> usefulList = new ArrayList<>();

        for (int coin : coins) {
            boolean redundant = false;

            for (long prev : usefulList) {
                if (coin % prev == 0) {
                    redundant = true;
                    break;
                }
            }

            if (!redundant) {
                usefulList.add((long) coin);
            }
        }

        int m = usefulList.size();

        long[] useful = new long[m];
        for (int i = 0; i < m; i++) {
            useful[i] = usefulList.get(i);
        }

        long low = 1;
        long high = useful[0] * k;

        int totalMasks = 1 << m;

        long[] lcms = new long[totalMasks];

        int[] signs = new int[totalMasks];

        for (int mask = 1; mask < totalMasks; mask++) {
            long currentLCM = 1;
            int bits = 0;

            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    long g = gcd(currentLCM, useful[i]);

                    currentLCM /= g;

                    if (currentLCM > high / useful[i]) {
                        currentLCM = high + 1;
                        break;
                    }

                    currentLCM *= useful[i];
                    bits++;
                }
            }

            lcms[mask] = currentLCM;

            signs[mask] = (bits % 2 == 1) ? 1 : -1;
        }

        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = 0;

            for (int mask = 1; mask < totalMasks; mask++) {
                if (lcms[mask] <= mid) {
                    count += signs[mask] * (mid / lcms[mask]);
                }
            }

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
