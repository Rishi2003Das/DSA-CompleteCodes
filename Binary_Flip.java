//Codeforces Contest Question
import java.util.Scanner;

public class Binary_Flip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            
            int initialAlt = 0;
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    initialAlt++;
                }
            }

            // Maximum possible gain from a single flip is 2
            int result = Math.min(initialAlt + 2, n - 1);
            System.out.println(result);
        }
        sc.close();
    }
}
