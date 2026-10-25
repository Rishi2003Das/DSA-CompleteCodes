class Solution {

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int c = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    if (dfs(i, j, grid, vis)) {
                        c++;
                    }
                }
            }
        }

        return c;
    }

    boolean dfs(int i, int j, int[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        boolean closed = true;

        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
            closed = false;
        }

        // Up
        if (i - 1 >= 0 &&
            grid[i - 1][j] == 0 &&
            !vis[i - 1][j]) {

            closed = dfs(i - 1, j, grid, vis) && closed;
        }

        // Down
        if (i + 1 < m &&
            grid[i + 1][j] == 0 &&
            !vis[i + 1][j]) {

            closed = dfs(i + 1, j, grid, vis) && closed;
        }

        // Left
        if (j - 1 >= 0 &&
            grid[i][j - 1] == 0 &&
            !vis[i][j - 1]) {

            closed = dfs(i, j - 1, grid, vis) && closed;
        }

        if (j + 1 < n &&
            grid[i][j + 1] == 0 &&
            !vis[i][j + 1]) {

            closed = dfs(i, j + 1, grid, vis) && closed;
        }

        return closed;
    }
}
