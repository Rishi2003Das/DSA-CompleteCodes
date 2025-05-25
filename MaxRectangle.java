class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int maxRect = 0;

        // Step 1: Build the "heights" histogram row by row
        int[][] heights = new int[n][m];

        for (int col = 0; col < m; col++) {
            // First row is just '0' or '1' converted to int
            heights[0][col] = matrix[0][col] - '0';

            // Fill heights based on vertical stacking
            for (int row = 1; row < n; row++) {
                heights[row][col] = matrix[row][col] == '0' ? 0 : 1 + heights[row - 1][col];
            }
        }

        // Step 2: For each row (which is now a histogram), calculate max rectangle area
        for (int row = 0; row < n; row++) {
            maxRect = Math.max(maxRect, findLargestRectangleArea(heights[row]));
        }

        return maxRect;
    }

    // From below here its the exact same code as of "Largest Rectangle in Histogram" (Leetcode 84)

    // Standard Largest Rectangle in Histogram
    private int findLargestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        int[] nse = findNse(heights);  // Next Smaller Element index
        int[] pse = findPse(heights);  // Previous Smaller Element index

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nse[i] - pse[i] - 1;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    // Find indices of Next Smaller Elements to the right
    private int[] findNse(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    // Find indices of Previous Smaller Elements to the left
    private int[] findPse(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }
}
