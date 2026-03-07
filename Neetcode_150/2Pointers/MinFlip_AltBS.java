/*

1888. MIN FLIPS FOR ALTERNATING BINARY STRING:
You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:
Type-1: Remove the character at the start of the string s and append it to the end of the string.
Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
Return the minimum number of type-2 operations you need to perform such that s becomes alternating
The string is called alternating if no two adjacent characters are equal.
For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
Example 1:
Input: s = "111000"
Output: 2
Explanation: Use the first operation two times to make s = "100011".
Then, use the second operation on the third and sixth elements to make s = "101010".


*/

class Solution {

    public int minFlips(String s) {

        int n = s.length();
        String str = s + s;

        int startWithOne = 0;
        int startWithZero = 0;

        int ans = Integer.MAX_VALUE;
        int i = 0;

        for(int j = 0; j < str.length(); j++) {

            boolean flag = (j % 2 == 0);

            if(flag) {
                if(str.charAt(j) != '1') startWithOne++;
                if(str.charAt(j) != '0') startWithZero++;
            } 
            else {
                if(str.charAt(j) != '0') startWithOne++;
                if(str.charAt(j) != '1') startWithZero++;
            }

            if(j - i + 1 > n) {

                boolean prevFlag = (i % 2 == 0);

                if(prevFlag) {
                    if(str.charAt(i) != '1') startWithOne--;
                    if(str.charAt(i) != '0') startWithZero--;
                } 
                else {
                    if(str.charAt(i) != '0') startWithOne--;
                    if(str.charAt(i) != '1') startWithZero--;
                }

                i++;
            }

            if(j - i + 1 == n) {
                ans = Math.min(ans, Math.min(startWithOne, startWithZero));
            }
        }

        return ans;
    }
}
