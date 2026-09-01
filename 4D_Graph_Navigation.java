//3568. Minimum moves to clean the classroom->
/* You are given an m x n grid classroom where a student volunteer is tasked with cleaning 
up litter scattered around the room. Each cell in the grid is one of the following:

'S': Starting position of the student
'L': Litter that must be collected (once collected, the cell becomes empty)
'R': Reset area that restores the student's energy to full capacity, 
regardless of their current energy level (can be used multiple times)
'X': Obstacle the student cannot pass through
'.': Empty space
You are also given an integer energy, representing the student's maximum energy capacity. 
The student starts with this energy from the starting position 'S'.
Each move to an adjacent cell (up, down, left, or right) costs 1 unit of energy. 
If the energy reaches 0, the student can only continue if they are on a reset area 'R', 
which resets the energy to its maximum capacity energy.

Return the minimum number of moves required to collect all litter items, or -1 if it's impossible. */


import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startX = -1, startY = -1;

        // Assign a unique bit to every litter cell
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int litterCount = 0;

        // Find S and assign IDs to all L cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char cell = classroom[i].charAt(j);

                if (cell == 'S') {
                    startX = i;
                    startY = j;
                }

                if (cell == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        // No litter to collect
        if (litterCount == 0) {
            return 0;
        }

        int allCollected = (1 << litterCount) - 1;

        class State {
            int x, y, energy, mask, moves;

            State(int x, int y, int energy, int mask, int moves) {
                this.x = x;
                this.y = y;
                this.energy = energy;
                this.mask = mask;
                this.moves = moves;
            }
        }

        Queue<State> queue = new LinkedList<>();

 
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << litterCount];

        // Starting state
        queue.offer(new State(
                startX,
                startY,
                energy,
                0,
                0
        ));

        visited[startX][startY][energy][0] = true;

        int[][] dirs = {
                {-1, 0}, // up
                {1, 0},  // down
                {0, -1}, // left
                {0, 1}   // right
        };

        while (!queue.isEmpty()) {

            State current = queue.poll();

            int x = current.x;
            int y = current.y;
            int currentEnergy = current.energy;
            int mask = current.mask;
            int moves = current.moves;

            // All litter collected
            if (mask == allCollected) {
                return moves;
            }

            // If energy is 0, the student can only continue from R
            if (currentEnergy == 0 &&
                    classroom[x].charAt(y) != 'R') {
                continue;
            }

            for (int[] dir : dirs) {

                int nx = x + dir[0];
                int ny = y + dir[1];

                // Boundary check
                if (nx < 0 || nx >= m ||
                        ny < 0 || ny >= n) {
                    continue;
                }

                // Obstacle check
                if (classroom[nx].charAt(ny) == 'X') {
                    continue;
                }

                int newEnergy = currentEnergy - 1;

                if (newEnergy < 0) {
                    continue;
                }

                if (classroom[nx].charAt(ny) == 'R') {
                    newEnergy = energy;
                }

                /*
                 * If we enter a litter cell, collect it.
                 */
                int newMask = mask;

                if (classroom[nx].charAt(ny) == 'L') {

                    int id = litterId[nx][ny];

                    newMask = mask | (1 << id);
                }

                /*
                 * Avoid visiting the exact same state again.
                 */
                if (!visited[nx][ny][newEnergy][newMask]) {

                    visited[nx][ny][newEnergy][newMask] = true;

                    queue.offer(new State(
                            nx,
                            ny,
                            newEnergy,
                            newMask,
                            moves + 1
                    ));
                }
            }
        }

        // All possible states exhausted
        return -1;
    }
}
