Solution 1:
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        int time = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Initialize the queue with all initially rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // Step 2: If there are no fresh oranges, return 0 immediately
        if (freshCount == 0) return 0;
        
        // Directions for moving up, down, left, right
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        
        // Step 3: Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedAny = false;
            
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];
                
                for (int d = 0; d < 4; d++) {
                    int nRow = r + dRow[d];
                    int nCol = c + dCol[d];
                    
                    // If valid and contains a fresh orange, rot it
                    if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1) {
                        grid[nRow][nCol] = 2; // Mark as rotten
                        freshCount--; // Decrease fresh count
                        queue.add(new int[]{nRow, nCol}); // Add newly rotten to queue
                        rottedAny = true;
                    }
                }
            }
            
            // Increment time if we rotted any fresh oranges in this round
            if (rottedAny) time++;
        }
        
        // Step 4: If there are fresh oranges left, return -1; otherwise, return the time
        return freshCount == 0 ? time : -1;
    }
}


Solution 2:
class Solution{
public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                if(grid[i][j] != 0) {
                    count_fresh++;
                }
            }
        }
       
        if(count_fresh == 0) return 0;
        int countMin = 0, cnt = 0;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt += size; 
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int j = 0;j<4;j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || 
                    grid[x][y] == 2) continue;
                    
                    grid[x][y] = 2;
                    queue.offer(new int[]{x , y});
                }
            }
            if(queue.size() != 0) {
                countMin++;
            }
        }
        return count_fresh == cnt ? countMin : -1;
    }
}
