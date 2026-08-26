//2904. Smallest Beautiful String
/* You are given a binary string s and a positive integer k.
A substring of s is beautiful if the number of 1's in it is exactly k.
Let len be the length of the shortest beautiful substring.
Return the lexicographically smallest beautiful substring of string s with length equal to len. 
If s doesn't contain a beautiful substring, return an empty string.
A string a is lexicographically larger than a string b (of the same length) 
if in the first position where a and b differ, a has a character strictly
larger than the corresponding character in b.

For example, "abcd" is lexicographically larger than "abcc" because the first position they differ is at the fourth character, and d is greater than c. */

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int ones = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }

            while (ones == k && left <= right) {
                while (left <= right && s.charAt(left) == '0') {
                    left++;
                }

                int len = right - left + 1;
                String cur = s.substring(left, right + 1);

                if (len < minLen) {
                    minLen = len;
                    ans = cur;
                } else if (len == minLen && cur.compareTo(ans) < 0) {
                    ans = cur;
                }

                ones--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : ans;
    }
}
