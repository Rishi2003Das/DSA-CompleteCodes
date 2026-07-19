class Solution {
    public static String smallestSubsequence(String s) {

        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // One occurrence of ch is processed
            freq[ch - 'a']--;

            // Skip if already present in stack
            if (visited[ch - 'a']) {
                continue;
            }

            // Remove larger characters if they appear later
            while (!stack.isEmpty() &&
                   stack.peek() > ch &&
                   freq[stack.peek() - 'a'] > 0) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        // Build answer from stack
        StringBuilder ans = new StringBuilder();

        for (char c : stack) {
            ans.append(c);
        }

        return ans.toString();
    }
