//Dynamic programming
import java.util.*;
class JobSchedulingProfit {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        // Sort jobs by their end times
        Arrays.sort(jobs, (a, b) -> a.endTime - b.endTime);

        // DP array to store the maximum profit until each job
        int[] T = new int[n];
        T[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            // Include the current job
            int includeProfit = jobs[i].profit;
            int l = binarySearch(jobs, i);
            if (l != -1) {
                includeProfit += T[l];
            }

            // Exclude the current job
            T[i] = Math.max(includeProfit, T[i - 1]);
        }

        return T[n - 1];
    }

    private int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].endTime <= jobs[index].startTime) {
                if (jobs[mid + 1].endTime <= jobs[index].startTime) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    class Job {
        int startTime, endTime, profit;

        Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}

