class Solution {
    public int minimumCost(int[] nums) {
        int f=nums[0];
        Arrays.sort(nums);
        if(f==nums[0])
        return f+nums[1]+nums[2];
        else if(f==nums[1])
        return f+nums[0]+nums[2];
        else
        return f+nums[0]+nums[1];
    }
}
