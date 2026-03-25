/*
3546. Equal Sum Grid Partition I- You are given an m x n matrix grid of positive integers.
Your task is to determine if it is possible to make either one horizontal or one
vertical cut on the grid such that: Each of the two resulting sections formed by the
cut is non-empty. The sum of the elements in both sections is equal.
Return true if such a partition exists; otherwise, return false.
*/

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        long hori[]=new long[m];
        long ver[]=new long[n];
        long sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum+=grid[i][j];
            }
            hori[i]=sum;
        }
        sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=grid[j][i];
            }
            ver[i]=sum;
        }
        for(int i=0;i<m-1;i++){
            if((hori[i]*2)==hori[m-1])
            return true;
        }
        for(int i=0;i<n-1;i++){
            if((ver[i]*2)==ver[n-1])
            return true;
        }
        return false;
    }
}
