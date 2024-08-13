//Google Interview question
//Happy Number
import java.util.*;
class Happy {
    public boolean isHappy(int x) {
        int slow = x;
        int fast = x;
        
        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);
        
        return slow == 1;
    }
    
    private int sumOfSquares(int x) {
        int sum = 0;
        while (x > 0) {
            int digit = x % 10;
            sum += digit * digit;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Happy ob = new Happy();
        System.out.println(ob.isHappy(1111111)); // Test with the given number
    }
}
