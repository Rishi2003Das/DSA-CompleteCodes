import java.util.*;

public class WarStrategy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            
            // We start with 1 soldier at base k on day 0
            // After m days, we have m+1 total soldiers
            long totalSoldiers = (long) m + 1;
            
            // We want to occupy as many bases as possible
            // Starting from base k, we can expand left and right
            
            // The optimal strategy is to expand outward
            // Distance from k to leftmost base: k-1
            // Distance from k to rightmost base: n-k
            
            int leftDist = k - 1;
            int rightDist = n - k;
            
            // We can fortify bases within a certain range from k
            // To reach distance d from k, we need at least d+1 soldiers
            // (1 at each position from k to k±d)
            
            // Binary search or direct calculation
            // Maximum reach is limited by total soldiers
            long maxFortified = Math.min(n, totalSoldiers);
            
            // But we need to check if we can actually fortify that many
            // Starting from k, expanding symmetrically when possible
            
            long fortified = 1; // base k is always fortified
            long soldiersUsed = 1;
            
            int left = k - 1;
            int right = k + 1;
            
            while (soldiersUsed < totalSoldiers && (left >= 1 || right <= n)) {
                // Expand to closer side(s)
                if (left >= 1 && right <= n) {
                    // Both sides available, need 2 soldiers
                    if (soldiersUsed + 2 <= totalSoldiers) {
                        fortified += 2;
                        soldiersUsed += 2;
                        left--;
                        right++;
                    } else if (soldiersUsed + 1 <= totalSoldiers) {
                        fortified += 1;
                        soldiersUsed += 1;
                        break;
                    } else {
                        break;
                    }
                } else if (left >= 1) {
                    // Only left side
                    if (soldiersUsed + 1 <= totalSoldiers) {
                        fortified += 1;
                        soldiersUsed += 1;
                        left--;
                    } else {
                        break;
                    }
                } else if (right <= n) {
                    // Only right side
                    if (soldiersUsed + 1 <= totalSoldiers) {
                        fortified += 1;
                        soldiersUsed += 1;
                        right++;
                    } else {
                        break;
                    }
                }
            }
            
            System.out.println(fortified);
        }
        
        sc.close();
    }
}


