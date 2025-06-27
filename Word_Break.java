class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict); // Use HashSet for O(1) lookup
        return func(0, s, dict, new Boolean[s.length()]); // Use memoization to optimize
    }

    private boolean func(int start, String str, HashSet<String> dict, Boolean[] memo) {
        if (start == str.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int i = start + 1; i <= str.length(); i++) {
            String check = str.substring(start, i);
            if (dict.contains(check) && func(i, str, dict, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }
}

