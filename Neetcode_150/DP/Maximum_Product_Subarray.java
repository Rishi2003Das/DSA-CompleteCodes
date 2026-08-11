//152. Maximum Product Subarray
//Using Kadane's algo
class Solution {
    public int maxProduct(int[] nums) {
        int n= nums.length;
        int prod=1;
        //edge cases
        if(n==0) return 0;

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            prod*=nums[i];
            max=Math.max(prod,max);
            if(prod==0){//edge case
            prod=1;
            }
        }
        prod=1;
        for(int i=n-1;i>=0;i--){
            prod*=nums[i];
            max=Math.max(prod,max);
            if(prod==0){//edge case
            prod=1;
            }
        }
        return max;
    }
}
