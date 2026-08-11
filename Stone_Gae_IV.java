1510. Stone Game IV
class Solution {
    int[] memo;
    public boolean winnerSquareGame(int n) {
        memo = new int[n+1];
        return canWin(n);
    }

    public boolean canWin(int n) {
        if (n == 0) return false;
        if (memo[n] != 0) return memo[n] == 1;
        boolean win = false;
        for (int i = 1; i * i <= n; i++) {
            if (!canWin(n - i * i)) {
                win = true;
                break;
            }
        }
        memo[n] = win ? 1 : 2;
        return win;
    }
}
