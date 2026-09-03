//3875 & 3876
/* You are given an array nums1 of n distinct integers.
You want to construct another array nums2 of length n such that the elements in nums2 are either all odd or all even.
For each index i, you must choose exactly one of the following (in any order):
  Rules:
nums2[i] = nums1[i]​​​​​​​
nums2[i] = nums1[i] - nums1[j], for an index j != i, such that nums1[i] - nums1[j] >= 1
Return true if it is possible to construct such an array, otherwise return false. */

//3875
class Solution {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}

//3876
class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        boolean hasOdd=false;
        int mn=nums1[0];
        for(int i=0;i<n;i++){
            if(nums1[i]<mn){
                mn=nums1[i];
            }
            if((nums1[i]&1)==1){
                hasOdd=true;//As tailing binary digit of odd number is always 1
            }
        }
        if((mn&1)==1){//checking if the minimum value in the array is odd or not
        return true;
        }
        return !hasOdd;//So, if min is even then hasOdd should be false
    }
}
