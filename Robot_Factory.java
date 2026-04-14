/*
2463. Min distance Robot and Factory->
There are some robots and factories on the X-axis. 
You are given an integer array robot where robot[i] is the position of the ith robot. 
You are also given a 2D integer array factory where factory[j] = [positionj, limitj] indicates 
that positionj is the position of the jth factory and that the jth factory can repair at most limitj robots.
The positions of each robot are unique. The positions of each factory are also unique. 
Note that a robot can be in the same position as a factory initially.

All the robots are initially broken; they keep moving in one direction. 
The direction could be the negative or the positive direction of the X-axis. 
When a robot reaches a factory that did not reach its limit, the factory repairs the robot, 
and it stops moving.
At any moment, you can set the initial direction of moving for some robot. 
Your target is to minimize the total distance traveled by all the robots.
Return the minimum total distance traveled by all the robots. 
The test cases are generated such that all the robots can be repaired.

Note that
All robots move at the same speed.
If two robots move in the same direction, they will never collide.
If two robots move in opposite directions and they meet at some point, they do not collide. They cross each other.
If a robot passes by a factory that reached its limits, it crosses it as if it does not exist.
If the robot moved from a position x to a position y, the distance it moved is |y - x|.

*/

import java.util.*;

class Solution {
    long[][] dp;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int n = robot.size();
        int m = factory.length;

        dp = new long[n][m];
        for (long[] row : dp) Arrays.fill(row, -1);

        return solve(0, 0, robot, factory);
    }

    private long solve(int i, int j, List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;

        // all robots assigned
        if (i == n) return 0;

        // no factory left
        if (j == m) return (long)1e15;

        if (dp[i][j] != -1) return dp[i][j];

        long res = solve(i, j + 1, robot, factory); // skip factory

        long cost = 0;
        int pos = factory[j][0];
        int limit = factory[j][1];

        // assign k robots to this factory
        for (int k = 0; k < limit && i + k < n; k++) {
            cost += Math.abs(robot.get(i + k) - pos);
            res = Math.min(res, cost + solve(i + k + 1, j + 1, robot, factory));
        }

        return dp[i][j] = res;
    }
}
