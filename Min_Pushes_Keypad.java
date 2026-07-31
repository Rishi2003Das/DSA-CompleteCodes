//Greedy Algorithms
import java.util.*;
 class Solution {
    static class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public int minimumPushes(String word) {

        int[] count = new int[26];

        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> b.freq - a.freq
        );

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer(new Pair((char) ('a' + i), count[i]));
            }
        }

        int pushes = 1;
        int used = 0;
        int ans = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            ans += curr.freq * pushes;

            used++;

            if (used == 8) {
                pushes++;
                used = 0;
            }
        }

        return ans;
    }
}
