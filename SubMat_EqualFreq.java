/*
3212. Count submatrices with equal frequency of X and Y->
Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of submatrices that contain:
- grid[0][0]
- an equal frequency of 'X' and 'Y'.
- at least one 'X'.
*/

//Brute Force solution
// T.C.=O(2*N^2) S.C.=O(N^2)
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] px = new int[m + 1][n + 1];
        int[][] py = new int[m + 1][n + 1]; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                px[i + 1][j + 1] = px[i][j + 1] + px[i + 1][j] - px[i][j];
                py[i + 1][j + 1] = py[i][j + 1] + py[i + 1][j] - py[i][j];

                if (grid[i][j] == 'X') px[i + 1][j + 1]++;
                if (grid[i][j] == 'Y') py[i + 1][j + 1]++;
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int xCount = px[i + 1][j + 1];
                int yCount = py[i + 1][j + 1];

                if (xCount > 0 && xCount == yCount) {
                    count++;
                }
            }
        }

        return count;
    }
}

//Optimised Solution using optimised Space complexity
//T.C.=O(N^2) S.C.=O(N)
import java.util.*;

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] colX = new int[n];
        int[] colY = new int[n];

        int result = 0;

        // Fix bottom row
        for (int i = 0; i < m; i++) {

            // Update column counts
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X') colX[j]++;
                if (grid[i][j] == 'Y') colY[j]++;
            }

            int diff = 0;
            int xCount = 0;

            // Since submatrix must start at column 0
            for (int j = 0; j < n; j++) {

                diff += colX[j] - colY[j];
                xCount += colX[j];

                // Valid condition
                if (diff == 0 && xCount > 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
