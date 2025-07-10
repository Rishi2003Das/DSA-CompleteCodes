import java.util.*;
public class Ratio_Raiders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long l = sc.nextLong();
        long r = sc.nextLong();
        sc.close();

        // 1. Total sum of coins 1..n
        long total = n * (n + 1) / 2;
        long denom = l + r;

        // 2. Feasibility check
        if (total % denom != 0) {
            System.out.println("NO");
            return;
        }

        // 3. Target sum for Saswat
        long target = total / denom * l;

        // 4. Greedily pick largest coins until we reach 'target'
        boolean[] inSaswat = new boolean[(int)n + 1];
        for (long coin = n; coin > 0 && target > 0; coin--) {
            if (coin <= target) {
                inSaswat[(int)coin] = true;
                target -= coin;
            }
        }

        // 5. Build and output both subsets
        List<Long> saswat = new ArrayList<>();
        List<Long> srikant = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (inSaswat[i]) saswat.add((long)i);
            else             srikant.add((long)i);
        }

        System.out.println("YES");
        System.out.print(saswat.size());
        for (long c : saswat) System.out.print(" " + c);
        System.out.println();
        System.out.print(srikant.size());
        for (long c : srikant) System.out.print(" " + c);
        System.out.println();
    }
}
