class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        int pos=0;
        int neg=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                pos++;
                arr[(pos*2)-2]=nums[i];
            }
            else{
                neg++;
                arr[(neg*2)-1]=nums[i];
            }
        }
        return arr;
    }
}
