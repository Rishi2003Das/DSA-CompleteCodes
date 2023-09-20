
//Creating bitMask for bit manipulation
import java.util.*;

class ClearBit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = sc.nextInt();
        System.out.println("Enter the position to be cleared: ");
        int i = sc.nextInt();
        int bm = 1 << i;
        int notbm = ~(bm);
        int s = (notbm & n);
        System.out.println("The new Number: " + s);
    }
}