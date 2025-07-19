import java.util.*;
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int i=0;
        int sum=0;
        while(i<n){
            sum+=weights[i];
            i++;
        }

        int l=Arrays.stream(weights).max().getAsInt();
        int r=sum;
        while(l<=r){
            int mid=l+((r-l)/2);

            if(check(weights, mid, days)){
            r=mid-1;
            }
            else
            l=mid+1;
        }
        return l;
    }

    public boolean check(int arr[], int ans, int days){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>ans){
            i--;
            sum=0;
            days--;
            }
        }
        if(days>=1)
        return true;
        else 
        return false;
    }
}
