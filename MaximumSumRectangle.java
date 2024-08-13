// Java Program to find max sum rectangular submatrix

import java.io.*;
import java.lang.*;
import java.util.*;

class MaximumSumRectangle {

    // Function to find maximum sum rectangular
    // submatrix
    private static int maxSumRectangle(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;
        int preSum[][] = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j] = preSum[i][j] + mat[i][j];
            }
        }

        int maxSum = -1;
        int minSum = Integer.MIN_VALUE;
        int negRow = 0, negCol = 0;
        int rStart = 0, rEnd = 0, cStart = 0, cEnd = 0;
        for (int rowStart = 0; rowStart < m; rowStart++) {
            for (int row = rowStart; row < m; row++) {
                int sum = 0;
                int curColStart = 0;
                for (int col = 0; col < n; col++) {
                    sum += preSum[row + 1][col]
                           - preSum[rowStart][col];
                    if (sum < 0) {
                        if (minSum < sum) {
                            minSum = sum;
                            negRow = row;
                            negCol = col;
                        }
                        sum = 0;
                        curColStart = col + 1;
                    }
                    else if (maxSum < sum) {
                        maxSum = sum;
                        rStart = rowStart;
                        rEnd = row;
                        cStart = curColStart;
                        cEnd = col;
                    }
                }
            }
        }

        // Printing final values
        if (maxSum == -1) {
            System.out.println("from row - " + negRow
                               + " to row - " + negRow);
            System.out.println("from col - " + negCol
                               + " to col - " + negCol);
        }
        else {
            System.out.println("from row - " + rStart
                               + " to row - " + rEnd);
            System.out.println("from col - " + cStart
                               + " to col - " + cEnd);
        }
        return maxSum == -1 ? minSum : maxSum;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[][] = new int[][] { { 1, 2, -1, -4, -20 },
                                    { -8, -3, 4, 2, 1 },
                                    { 3, 8, 10, 1, 3 },
                                    { -4, -1, 1, 7, -6 } };

        // Function call
        System.out.println(maxSumRectangle(arr));
    }
}