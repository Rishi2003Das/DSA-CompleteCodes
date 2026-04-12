/*
1320. You have a keyboard layout as shown above in the X-Y plane, where each English uppercase letter is located at some coordinate.
For example, the letter 'A' is located at coordinate (0, 0), the letter 'B' is located at coordinate (0, 1), 
The letter 'P' is located at coordinate (2, 3) and the letter 'Z' is located at coordinate (4, 1).
Given the string word, return the minimum total distance to type such string using only two fingers.
The distance between coordinates (x1, y1) and (x2, y2) is |x1 - x2| + |y1 - y2|.

Note that the initial positions of your two fingers are considered free so do not count towards your total 
distance, also, your two fingers do not have to start at the first letter or the first two letters.
Example 1:

Input: word = "CAKE"
Output: 3
Explanation: Using two fingers, one optimal way to type "CAKE" is: 
Finger 1 on letter 'C' -> cost = 0 
Finger 1 on letter 'A' -> cost = Distance from letter 'C' to letter 'A' = 2 
Finger 2 on letter 'K' -> cost = 0 
Finger 2 on letter 'E' -> cost = Distance from letter 'K' to letter 'E' = 1 
Total distance = 3
Example 2:

Input: word = "HAPPY"
Output: 6
Explanation: Using two fingers, one optimal way to type "HAPPY" is:
Finger 1 on letter 'H' -> cost = 0
Finger 1 on letter 'A' -> cost = Distance from letter 'H' to letter 'A' = 2
Finger 2 on letter 'P' -> cost = 0
Finger 2 on letter 'P' -> cost = Distance from letter 'P' to letter 'P' = 0
Finger 1 on letter 'Y' -> cost = Distance from letter 'A' to letter 'Y' = 4
Total distance = 6

*/

// Graph Approach 

import java.util.*;

public class Solution {

    static class State {
        int index, f1, f2, cost;

        State(int index, int f1, int f2, int cost) {
            this.index = index;
            this.f1 = f1;
            this.f2 = f2;
            this.cost = cost;
        }
    }

    public int minimumDistance(String word) {
        int n = word.length();

        // Precompute coordinates
        int[][] pos = new int[26][2];
        for (int i = 0; i < 26; i++) {
            pos[i][0] = i / 6; // row
            pos[i][1] = i % 6; // col
        }

        // Distance helper
        java.util.function.BiFunction<Integer, Integer, Integer> dist = (a, b) -> {
            if (a == 26) return 0; // unused finger
            return Math.abs(pos[a][0] - pos[b][0]) +
                   Math.abs(pos[a][1] - pos[b][1]);
        };

        // Min-heap (Dijkstra)
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));

        // Distance map: key = (index, f1, f2)
        Map<String, Integer> best = new HashMap<>();

        pq.offer(new State(0, 26, 26, 0)); // both fingers unused

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            String key = cur.index + "," + cur.f1 + "," + cur.f2;

            if (best.containsKey(key) && best.get(key) < cur.cost) continue;

            if (cur.index == n) {
                return cur.cost; // reached end
            }

            int target = word.charAt(cur.index) - 'A';

            // Option 1: move finger 1
            int cost1 = cur.cost + dist.apply(cur.f1, target);
            String key1 = (cur.index + 1) + "," + target + "," + cur.f2;

            if (!best.containsKey(key1) || best.get(key1) > cost1) {
                best.put(key1, cost1);
                pq.offer(new State(cur.index + 1, target, cur.f2, cost1));
            }

            // Option 2: move finger 2
            int cost2 = cur.cost + dist.apply(cur.f2, target);
            String key2 = (cur.index + 1) + "," + cur.f1 + "," + target;

            if (!best.containsKey(key2) || best.get(key2) > cost2) {
                best.put(key2, cost2);
                pq.offer(new State(cur.index + 1, cur.f1, target, cost2));
            }
        }

        return -1; // should never reach
    }
}
//3D- DP Approach
class Solution {

    private int getDistance(int p, int q) {
        int x1 = p / 6;
        int y1 = p % 6;
        int x2 = q / 6;
        int y2 = q % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        Arrays.fill(dp[0], 0);

        for (int i = 1; i < n; i++) {
            int cur = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';
            int d = getDistance(prev, cur);

            for (int j = 0; j < 26; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + d);
                if (prev == j) {
                    for (int k = 0; k < 26; k++) {
                        int d0 = getDistance(k, cur);
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + d0);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE / 2;
        for (int value : dp[n - 1]) {
            ans = Math.min(ans, value);
        }
        return ans;
    }
}
