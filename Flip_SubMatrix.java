class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int j = y; j < y + k; j++) {
            for (int i = x; i < x + k / 2; i++) {
                int mirrorRow = x + k - 1 - (i - x);
                
                int temp = grid[i][j];
                grid[i][j] = grid[mirrorRow][j];
                grid[mirrorRow][j] = temp;
            }
        }
        return grid;
    }
}
