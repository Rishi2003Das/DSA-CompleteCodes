import java.util.*;

public class ArrayGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int zeroCount = 0;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x == 0) zeroCount++;
            }

            if (zeroCount % 2 == 1) {
                System.out.println("Alice");
            } else {
                System.out.println("Bob");
            }
        }
        sc.close();
    }
}
