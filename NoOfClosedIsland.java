class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(i,j,grid)) {
                        count++;
                }
            }
        }
        return count;
    }

    boolean dfs(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //Edge cases
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;//Marked Visited

        boolean up = dfs(i - 1, j, grid);
        boolean down = dfs(i + 1, j, grid);
        boolean left = dfs(i, j - 1, grid);
        boolean right = dfs(i, j + 1, grid);

        return up && down && left && right;
    }
}
