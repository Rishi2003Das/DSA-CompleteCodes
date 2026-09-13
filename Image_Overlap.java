//835. Image Overlap->
/* You are given two images, img1 and img2, represented as binary, square matrices of size n x n.
A binary matrix has only 0s and 1s as values. We translate one image however we choose by sliding
all the 1 bits left, right, up, and/or down any number of units. We then place it on top of the
other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.
Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.
Return the largest possible overlap. */

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        List<int[]> list1=new ArrayList<>();
        List<int[]> list2=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img1[i][j]==1) list1.add(new int[]{i,j});
                if(img2[i][j]==1) list2.add(new int[]{i,j});
            }
        }
        int cnt[][]=new int[2*n][2*n];
        int max=0;
        for(int[] arr1: list1){
            for(int[] arr2: list2){
                int dx=arr2[0]-arr1[0]+n;
                int dy=arr2[1]-arr1[1]+n;
                max=Math.max(max, ++cnt[dx][dy]);
            }
        }
        return max;
    }
}
