/*
2812. You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:
A cell containing a thief if grid[r][c] = 1
An empty cell if grid[r][c] = 0
You are initially positioned at cell (0, 0).
In one move, you can move to any adjacent cell in the grid, including cells containing thieves.
The safety factor of a path on the grid is defined as the minimum
Manhattan distance from any cell on the path to any thief on the grid.
Return the maximum safety factor among all paths leading to the cell (n - 1, n - 1).

An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it exists.
The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|, where |val| denotes the absolute value of val.
*/
class Solution {
    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
            return 0;

        int[][] A = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = grid.get(i).get(j);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (A[i][j] == 1)
                    q.add(new int[]{i, j});

        while (q.size() > 0) {
            int[] head = q.poll();
            int i = head[0];
            int j = head[1];
            int v = A[i][j];

            for (int[] d : dirs) {
                int x = i + d[0];
                int y = j + d[1];

                if (Math.min(x, y) >= 0 && Math.max(x, y) < n && A[x][y] == 0) {
                    A[x][y] = v + 1;
                    q.add(new int[]{x, y});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[]{A[0][0], 0, 0});

        while (pq.size() > 0) {
            int[] head = pq.poll();
            int sf = head[0];
            int i = head[1];
            int j = head[2];

            if (i == n - 1 && j == n - 1)
                return sf - 1;

            for (int[] d : dirs) {
                int x = i + d[0];
                int y = j + d[1];

                if (Math.min(x, y) >= 0 && Math.max(x, y) < n && A[x][y] > 0) {
                    pq.add(new int[]{Math.min(sf, A[x][y]), x, y});
                    A[x][y] *= -1;
                }
            }
        }

        return A[n - 1][n - 1] - 1;
    }
}
