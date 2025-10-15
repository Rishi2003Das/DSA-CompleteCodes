import java.util.Arrays;

public class SJFWaitingTime {
    public static int averageWaitingTime(int[] bt) {
        // Sort burst times to schedule shortest jobs first
        Arrays.sort(bt);
        int n = bt.length;

        long totalWaitingTime = 0;
        long cumulativeTime = 0;

        // Calculate waiting time for each process
        for (int i = 0; i < n - 1; i++) {
            cumulativeTime += bt[i];
            totalWaitingTime += cumulativeTime;
        }

        // Return floor of average waiting time
        return (int)(totalWaitingTime / n);
    }

    // Example test
    public static void main(String[] args) {
        int[] bt = {6, 8, 7, 3};
        System.out.println(averageWaitingTime(bt));  // Output: 6
    }
}
