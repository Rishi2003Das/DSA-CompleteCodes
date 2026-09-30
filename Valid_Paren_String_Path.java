//2267. Check if there is a valid parenthesis string path->
/* A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

It is ().
It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
It can be written as (A), where A is a valid parentheses string.
You are given an m x n matrix of parentheses grid. A valid parentheses string path in the grid is a path satisfying all of the following conditions:

The path starts from the upper left cell (0, 0).
The path ends at the bottom-right cell (m - 1, n - 1).
The path only ever moves down or right.
The resulting parentheses string formed by the path is valid.
Return true if there exists a valid parentheses string path in the grid. Otherwise, return false. */

//Recursive method using backtracking 
import java.util.*;
class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Length of every path is fixed: m + n - 1
        // A valid parentheses string must have even length.
        if ((m + n - 1) % 2 != 0) {
          return false;
        }
        Stack<Character> st = new Stack<>();
        return dfs(0, 0, m, n, st, grid);
    }

    public boolean dfs(int i, int j, int m, int n, Stack<Character> st, char[][] grid) {

        // Check bounds BEFORE accessing grid[i][j]
        if (i >= m || j >= n) {
            return false;
        }
        // If current cell is ')', there must be an unmatched '(' to pair with it.
        if (grid[i][j] == ')' && st.isEmpty()) {
            return false;
        }
        if (grid[i][j] == '(') {
            st.push('(');
        } else {
            st.pop();
        }
        // Final case check
        if (i == m - 1 && j == n - 1) {
            boolean valid = st.isEmpty();
            // Backtrack before returning
            if (grid[i][j] == '(') {
                st.pop();
            } else {
                st.push('(');
            }
            return valid;
        }
        // Explore both possible directions
        boolean down = dfs(i + 1, j, m, n, st, grid);
        boolean right = false;
        if (!down) {
            right = dfs(i, j + 1, m, n, st, grid);
        }
        // BACKTRACK: Restore stack to the state before processing grid[i][j]
        if (grid[i][j] == '(') {
            st.pop();
        } else {
            st.push('(');
        }
        return down || right;
    }
}

// memoization using 3D-DP (dp[][][])
class Solution {

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Length of every path is m + n - 1.
        // A valid parentheses string must have even length.
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // balance can range from 0 to m+n-1
        int[][][] dp = new int[m][n][m + n];

        // -1 = not calculated
        //  0 = false
        //  1 = true
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m + n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return dfs(0, 0, 0, grid, dp);
    }

    private boolean dfs(int i, int j, int balance,
                        char[][] grid, int[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        // Out of bounds
        if (i >= m || j >= n) {
            return false;
        }

        // Process current character
        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Invalid prefix
        if (balance < 0) {
            return false;
        }

        // Memoization
        if (dp[i][j][balance] != -1) {
            return dp[i][j][balance] == 1;
        }

        // Destination
        if (i == m - 1 && j == n - 1) {
            dp[i][j][balance]=(balance == 0 ? 1 : 0);
            return balance==0;
        }

        boolean down = dfs(i + 1, j, balance, grid, dp);
        boolean right = dfs(i, j + 1, balance, grid, dp);

        boolean ans = down || right;

        dp[i][j][balance] = ans ? 1 : 0;

        return ans;
    }
}
