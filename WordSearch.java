/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
or vertically neighbouring. The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int index=0;
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(index)) {
                    if (searchNext(board, word, i, j, index, m, n))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean searchNext(char[][] board, String word, int row, int col, int index, int m, int n){

        if(index==word.length())
        return true;

        if (row < 0 || col < 0 || row == m || col == n || board[row][col] != 
        word.charAt(index) || board[row][col] == '!')
            return false;

        char c = board[row][col];
        board[row][col] = '!';

        // top direction
        boolean top = searchNext(board, word, row - 1, col, index + 1, m, n);
        // right direction
        boolean right = searchNext(board, word, row, col + 1, index + 1, m, n);
        // bottom direction
        boolean bottom = searchNext(board, word, row + 1, col, index + 1, m, n);
        // left direction
        boolean left = searchNext(board, word, row, col - 1, index + 1, m, n);

        board[row][col] = c;

        return top || right || bottom || left;
    }
}
