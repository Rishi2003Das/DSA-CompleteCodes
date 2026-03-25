/*
621. Task Scheduler->
You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n.
Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order,
but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.
Return the minimum number of CPU intervals required to complete all tasks.
*/

import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        
        // Count frequencies
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.add(f);
        }

        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            int workDone = 0;

            // Execute up to n+1 tasks
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    int curr = pq.poll();
                    if (curr - 1 > 0) {
                        temp.add(curr - 1);
                    }
                    workDone++;
                }
            }

            // Reinsert remaining tasks
            for (int t : temp) {
                pq.add(t);
            }

            // If heap empty → no idle needed
            if (pq.isEmpty()) {
                time += workDone;
            } else {
                time += cycle;
            }
        }

        return time;
    }
}
