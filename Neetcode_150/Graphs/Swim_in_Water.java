/*
778. Swim in Rising Water- You are given an n x n integer matrix grid 
where each value grid[i][j] represents the elevation at that point (i, j).
It starts raining, and water gradually rises over time. At time t, 
the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.
You can swim from a square to another 4-directionally adjacent square 
if and only if the elevation of both squares individually are at most t.
You can swim infinite distances in zero time. 
Of course, you must stay within the boundaries of the grid during your swim.
Return the minimum time until you can reach the bottom right square (n - 1, n - 1) 
if you start at the top left square (0, 0).
*/

class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Set<String> seen = new HashSet<>();
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int max_d = curr[0], r = curr[1], c = curr[2];
            
            String key = r + "," + c;
            if (seen.contains(key)) continue;
            seen.add(key);
            
            if (r == m-1 && c == n-1) return max_d;
            
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !seen.contains(nr + "," + nc)) {
                    int new_d = Math.max(max_d, grid[nr][nc]);
                    pq.offer(new int[]{new_d, nr, nc});
                }
            }
        }
        return -1;
    }
}
