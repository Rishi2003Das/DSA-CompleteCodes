class Pair{
    int first;
    int second;
    public Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {  // To avoid infinite recursion if color is already the target color
            bfs(sr, sc, image, color, originalColor);
        }
        return image;
    }

    private void bfs(int r, int c, int[][] grid, int color, int originalColor) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        grid[r][c] = color; // Set starting cell to target color

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = row + dRow[i];
                int ncol = col + dCol[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == originalColor) {
                    grid[nrow][ncol] = color; // Set cell to target color
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}
