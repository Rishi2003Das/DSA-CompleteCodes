/*
874. Robot Walking Simulation I ->
A robot on an infinite XY-plane starts at point (0, 0) facing north. 
The robot receives an array of integer commands, which represent a sequence of moves that it needs to execute. 
There are only three possible types of instructions the robot can receive:
-2: Turn left 90 degrees.
-1: Turn right 90 degrees.
1 <= k <= 9: Move forward k units, one unit at a time.
Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). 
If the robot runs into an obstacle, it will stay in its current 
location (on the block adjacent to the obstacle) and move onto the next command.

Return the maximum squared Euclidean distance that the robot reaches at any point in its path.
Note:
There can be an obstacle at (0, 0). If this happens, the robot will ignore the obstacle until it has moved off the origin. However, it will be unable to return to (0, 0) due to the obstacle.
North means +Y direction.
East means +X direction.
South means -Y direction.
West means -X direction.
*/
import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> blocked = new HashSet<>();
        for (int[] o : obstacles) {
            blocked.add(o[0] +" "+ o[1]);
        }

        int[][] directions = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        int x = 0, y = 0;
        int dir = 0; // initially facing North
        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                dir = (dir + 1) % 4; // turn right
            } 
            else if (cmd == -2) {
                dir = (dir + 3) % 4; // turn left
            } 
            else {
                while (cmd-- > 0) {
                    int nx = x + directions[dir][0];
                    int ny = y + directions[dir][1];

                    // check obstacle
                    if (blocked.contains(nx +" "+ ny)) break;

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}

/*
A width x height grid is on an XY-plane with the bottom-left cell at (0, 0) and the top-right cell at (width - 1, height - 1). 
The grid is aligned with the four cardinal directions ("North", "East", "South", and "West").
A robot is initially at cell (0, 0) facing direction "East".
The robot can be instructed to move for a specific number of steps. For each step, it does the following.
Attempts to move forward one cell in the direction it is facing.
If the cell the robot is moving to is out of bounds, the robot instead turns 90 degrees counterclockwise and retries the step.
After the robot finishes moving the number of steps required, it stops and awaits the next instruction.

Implement the Robot class:
Robot(int width, int height) Initialises the width x height grid with the robot at (0, 0) facing "East".
void step(int num) Instructs the robot to move forward num steps.
int[] getPos() Returns the current cell the robot is at, as an array of length 2, [x, y].
String getDir() Returns the current direction of the robot, "North", "East", "South", or "West".
*/

class Robot {
    private int w;
    private int h;
    private int p;
    private int a;
    private int b;
    private int dir;

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private String[] dirs = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.w=width;
        this.h=height;
        this.p=2*(w+h)-4;
        
        this.a = 0;
        this.b = 0;
        this.dir = 0;
    }
    
    public void step(int num) {
        num%=p;
        if(num==0)
        num=p;
        while(num>0){
            int na=a+dx[dir];
            int nb=b+dy[dir];

            if (na < 0 || na >= w || nb < 0 || nb >= h) {
                dir = (dir + 1) % 4;
                continue;
            }

            a=na;
            b=nb;
            num--;
        }
    }
    
    public int[] getPos() {
        return new int[]{a,b};
    }
    
    public String getDir() {
        return dirs[dir];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
