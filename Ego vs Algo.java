//CodeForces Contest
import java.util.*;
public class Ego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int bestLIS = LIS(arr);  // No reverse case

            for (int l = 0; l < n; l++) {
                for (int r = l; r < n && r - l + 1 <= k; r++) {
                    int[] tmp = arr.clone();
                    reverse(tmp, l, r);
                    int newLIS = LIS(tmp);
                    bestLIS = Math.max(bestLIS, newLIS);
                }
            }
            System.out.println(bestLIS);
        }
        sc.close();
    }

    private static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    private static int LIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLen = 1;
        for (int x : dp) {
            maxLen = Math.max(maxLen, x);
        }
        return maxLen;
    }
}
