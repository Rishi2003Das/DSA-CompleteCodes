
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int ans = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
            } else {
                // We need two consecutive ')' for each '('.
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // Found a valid closing pair.
                    i += 2;
                } else {
                    // Insert one ')' to complete the pair.
                    ans++;
                    i++;
                }

                if (open > 0) {
                    open--;
                } else {
                    // No matching '(' exists, so insert one.
                    ans++;
                }
            }
        }

        // Every unmatched '(' requires two closing ')'.
        ans += open * 2;

        return ans;
    }
}
