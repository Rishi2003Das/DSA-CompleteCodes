*/
1415. The kth Happy String:
A happy string is a string that:
1. consists only of letters of the set ['a', 'b', 'c'].
2. s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.
Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
Return the kth string of this list or return an empty string if there are fewer than k happy strings of length n.

*/

class Solution {

    List<String> happyStrings = new ArrayList<>();

    public String getHappyString(int n, int k) {
        String currentString = "";
        // Generate all happy strings of length n
        generateHappyStrings(n, currentString);

        // Check if there are at least k happy strings
        if (happyStrings.size() < k) return "";

        return happyStrings.get(k - 1);
    }

    protected void generateHappyStrings(int n, String currentString) {
        // If the current string has reached the desired length, add it to the
        // list
        if (currentString.length() == n) {
            happyStrings.add(currentString);
            return;
        }

        // Try adding each character ('a', 'b', 'c') to the current string
        for (char currentChar = 'a'; currentChar <= 'c'; currentChar++) {
            // Skip if the current character is the same as the last character
            if (
                currentString.length() > 0 &&
                currentString.charAt(currentString.length() - 1) == currentChar
            ) continue;

            // Recursively generate the next character
            generateHappyStrings(n, currentString + currentChar);
        }
    }
}
