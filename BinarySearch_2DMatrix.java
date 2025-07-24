class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // First, identify the correct row using binary search
        int low = 0, high = m - 1;
        int row = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                row = mid;
                break;
            } else if (target < matrix[mid][0]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // If no valid row found
        if (row == -1) return false;

        // Binary search in the identified row
        return binarySearch(matrix[row], target);
    }

    private boolean binarySearch(int[] row, int target) {
        int low = 0, high = row.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] == target) return true;
            else if (target < row[mid]) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }
}
