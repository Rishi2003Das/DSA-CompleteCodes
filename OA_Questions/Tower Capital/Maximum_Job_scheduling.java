import java.util.*;

public class Solution {
    public int getMaximumTeamSize(int[] startTime, int[] endTime) {
        //Write your code here...
        int n=startTime.length;
        int[] starts=startTime.clone();
        int[] ends=endTime.clone();
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int start=startTime[i];
            int end=endTime[i];
            
            int started=upperBound(starts, end);
            int finished=lowerBound(ends, start);
            
            int overlapping= started-finished;
            max=Math.max(max,overlapping);
        }
        return max;
    }
    private int upperBound(int[] arr, int target){
        int left=0;
        int right=arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<=target)
                left=mid+1;
                else
                right=mid;
        }
        return left;
    }
    private int lowerBound(int[] arr, int target){
        int left=0;
        int right=arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<target)
                left=mid+1;
                else
                right=mid;
        }
        return left;
    }
}
