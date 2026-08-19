class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        int l = 0, r = 0, prev = 0;
        int sz = reservedSeats.length;

        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);

        boolean[] isReserved = new boolean[11];
        int ans = 0;

        while (r < sz) {

            // Count rows with no reservations
            ans += 2 * (reservedSeats[r][0] - prev - 1);

            prev = reservedSeats[r][0];

            // Mark all reserved seats in the current row
            while (r < sz && reservedSeats[l][0] == reservedSeats[r][0]) {
                isReserved[reservedSeats[r][1]] = true;
                r++;
            }

            // Check the three possible groups
            boolean twoToFive = check(isReserved, 2, 5);
            boolean fourToSeven = check(isReserved, 4, 7);
            boolean sixToNine = check(isReserved, 6, 9);

            // Two non-overlapping groups
            if (twoToFive && sixToNine) {
                ans += 2;
            }
            // At least one group is available
            else if (twoToFive || fourToSeven || sixToNine) {
                ans++;
            }

            l = r;

            // Reset for the next row
            Arrays.fill(isReserved, false);
        }

        // Remaining rows are completely empty
        ans += 2 * (n - prev);

        return ans;
    }

    public boolean check(boolean[] b, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (b[i]) {
                return false;
            }
        }
        return true;
    }
}
