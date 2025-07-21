import java.util.*;
class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Arrays.stream(nums).max().getAsInt();
        int high=Arrays.stream(nums).sum();
        int ans=0;
        while(high>=low){
            int mid=low+((high-low)/2);

            if(check(nums, mid)<k)
            high=mid-1;

            else if(check(nums, mid)>k)
            low=mid+1;

            else
            {
                ans=mid;
                high=mid-1;
            }
        }
        return ans>low?ans:low;
    }


public int check(int[] arr, int maxSum) {
    int subarrays = 1;
    int currentSum = 0;
    for (int num : arr) {
        if (currentSum + num > maxSum) {
            subarrays++;
            currentSum = num;
        } else {
            currentSum += num;
        }
    }
    return subarrays;
}

}
