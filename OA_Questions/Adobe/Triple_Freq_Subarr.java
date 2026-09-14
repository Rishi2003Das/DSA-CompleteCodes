
import java.util.*;

public class Solution {
    public long good_subarrays(int n, int[] arr, int x) {
        return countAtMost(n, arr, x)-countAtMost(n,arr,x-1);
    }
    long countAtMost(int n, int arr[], int k){
        HashMap<Integer, Integer> freq=new HashMap<>();
        int l=0;
        int c=0;
        long ans=0;
        
        for(int r=0;r<n;r++){
            int newF=freq.getOrDefault(arr[r],0)+1;
            freq.put(arr[r],newF);
            if(newF==3) c++;
            while(c>k){
                int left=arr[l++];
                int f=freq.get(left);
                if(f==3){
                    c--;
                }
                if(f==1){
                    freq.remove(left);
                }
                else{
                    freq.put(left,f-1);
                }
            }
            ans+=r-l+1L;
        }
        return ans;
    }
}
