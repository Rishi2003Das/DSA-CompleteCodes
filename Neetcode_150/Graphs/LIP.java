//329. Longest Increasing Path in a matrix

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }

        int max = 0;
        int[][] memo = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (memo[i][j] == 0) {
                    max = Math.max(max, dfs(matrix, memo, i, j));
                }
            }
        }

        return max;
    }

    public int dfs(int[][] matrix, int[][] memo, int x, int y) {
        if (memo[x][y] > 0) {
            return memo[x][y];
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int ans = 1;

        int row = matrix.length;
        int col = matrix[0].length;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                continue;
            }

            if (matrix[nextX][nextY] <= matrix[x][y]) {
                continue;
            }

            ans = Math.max(ans, dfs(matrix, memo, nextX, nextY) + 1);
        }

        memo[x][y] = ans;
        return ans;
    }
}
