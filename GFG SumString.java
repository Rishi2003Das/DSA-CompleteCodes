
//SUMString
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.isSumString(S));
        }
    }
}

class Solution {
    private String addString(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int j = t.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0)
                sum += s.charAt(i--) - '0';
            if (j >= 0)
                sum += t.charAt(j--) - '0';
            int rem = sum % 10;
            carry = sum / 10;
            sb.append(rem);
        }
        return sb.reverse().toString();
    }

    private boolean check(String s, int start, int len1, int len2, int n) {
        String s1 = s.substring(start, start + len1);
        String s2 = s.substring(start + len1, start + len1 + len2);
        String s3 = addString(s1, s2);
        int len3 = s3.length();
        if (n - start - len1 - len2 < len3)
            return false;
        if (s3.equals(s.substring(start + len1 + len2, start + len1 + len2 + len3))) {
            if (start + len1 + len2 + len3 == n)
                return true;
            return check(s, start + len1, len2, len3, n);
        }
        return false;
    }

    public int isSumString(String S) {
        int n = S.length();
        for (int i = 1; i < n; i++) {
            for (int j = 1; i + j < n; j++) {
                if (check(S, 0, i, j, n))
                    return 1;
            }
        }
        return 0;
    }
}
