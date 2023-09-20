
//Count the number of 1 in a binary number
import java.io.*;
import java.util.*;

class CountBit {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            int cnt = ob.setBits(N);
            System.out.println(cnt);
        }
    }
}

class Solution {
    static int setBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;// Bitwise AND
            n = n >> 1;// Bitwise Right shift
        }
        return count;
    }
}
