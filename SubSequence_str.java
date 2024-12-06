class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0; // Pointer for str2
        int j = 0; // Pointer for str1
        
        while (i < str2.length() && j < str1.length()) {
            char c1 = str1.charAt(j);
            char c2 = str2.charAt(i);
            
            // Check if characters match directly or after incrementing c1
            if (c1 == c2 || (c1 + 1 - 'a') % 26 + 'a' == c2) {
                i++; // Move to the next character in str2
            }
            
            j++; // Always move to the next character in str1
        }
        
        return i == str2.length(); // Check if all characters in str2 are matched
    }
}
