class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(nums[mid]==target)
            return mid;
            else if(nums[mid]>nums[start]){//Left part is sorted wrt mid
                if(nums[start]>=target && nums[mid]<=target){//check target is in the sorted part?
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
            else{//Right part is sorted wrt mid
                if(nums[mid]<=target && nums[end]>=target){
                    start=mid+1;
                }
                else
                {
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
