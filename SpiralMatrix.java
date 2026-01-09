class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Edge case: empty matrix
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int lrow = 0, lcol = 0;
        int urow = m - 1, ucol = n - 1;

        while (lrow <= urow && lcol <= ucol) {

            // 1. Traverse top row
            for (int col = lcol; col <= ucol; col++) {
                result.add(matrix[lrow][col]);
            }

            // 2. Traverse right column
            for (int row = lrow + 1; row <= urow; row++) {
                result.add(matrix[row][ucol]);
            }

            // 3. Traverse bottom row (if exists)
            if (lrow < urow) {
                for (int col = ucol - 1; col >= lcol; col--) {
                    result.add(matrix[urow][col]);
                }
            }

            // 4. Traverse left column (if exists)
            if (lcol < ucol) {
                for (int row = urow - 1; row > lrow; row--) {
                    result.add(matrix[row][lcol]);
                }
            }

            // Shrink boundaries
            lrow++;
            lcol++;
            urow--;
            ucol--;
        }

        return result;
    }
}
