/*
2075. A string originalText is encoded using a slanted transposition 
cipher to a string encodedText with the help of a matrix having a fixed number of rows.

originalText is placed first in a top-left to bottom-right manner.
The blue cells are filled first, followed by the red cells, then the yellow cells, and 
so on, until we reach the end of originalText. The arrow indicates the order in which the cells are filled. 
All empty cells are filled with ' '. The number of columns is chosen such that the rightmost column 
will not be empty after filling in originalText.

encodedText is then formed by appending all the matrix's characters in row-wise order.

The characters in the blue cells are appended first to encodedText, then the red cells, 
and so on, and finally the yellow cells. The arrow indicates the order in which the cells are accessed.
Given the encoded string encodedText and number of rows rows, return the original string originalText.

Note: originalText does not have any trailing spaces ' '. The test cases are generated 
such that there is only one possible originalText.

Input: encodedText = "iveo    eed   l te   olc", rows = 4
Output: "i love leetcode"
Explanation: The figure above denotes the matrix that was used to encode originalText. 
The blue arrows show how we can find originalText from encodedText.
*/

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 0) return "";
        
        int n = encodedText.length();
        int cols = n / rows;
        char[][] dp = new char[rows][cols];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = encodedText.charAt(idx++);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int startCol = 0; startCol < cols; startCol++) {
            int i = 0;
            int j = startCol;

            while (i < rows && j < cols) {
                ans.append(dp[i][j]);
                i++;
                j++;
            }
        }
        int end = ans.length() - 1;
        while (end >= 0 && ans.charAt(end) == ' ') {
            end--;
        }
        return ans.substring(0, end + 1);
    }
}
