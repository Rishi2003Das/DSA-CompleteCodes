//Brute Force solution
import java.util.*;
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int arr[]=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=bloomDay[i];
        }
        Arrays.sort(arr);
        int minimum=arr[0];
        int maximum=arr[n-1];

        for(int i=minimum;i<=maximum;i++){
            if (check(bloomDay, m, k, i)){
                return i;
            }
        }
        return -1;
    }
    public boolean check(int arr[], int num, int k, int day){

        int sum=0;
        int cnt=0;
        int n=arr.length;
        for(int i=0; i<n;i++){
            if(arr[i]<=day)
            cnt++;
            else{
                sum+=(cnt/k);
                cnt=0;
            }
        }

        sum+=(cnt/k);

        if(sum>=num){
            return true;
        }
        return false;
    }
}


//Optimised Solution with Binary Search

import java.util.*;
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int arr[]=new int[n];
        if(n < (m*k))
        return -1;
        for(int i=0; i<n; i++){
            arr[i]=bloomDay[i];
        }
        Arrays.sort(arr);
        int minimum=arr[0];
        int maximum=arr[n-1];
        int c=0;
        int days[]=new int[maximum-minimum+1];
        for(int i=minimum;i<=maximum;i++){
            days[c]=i;
        }
        while(minimum<=maximum){
            int mid=minimum+((maximum-minimum)/2);
            if(check(bloomDay,m,k,mid))
            maximum=mid-1;
            else
            minimum=mid+1;
        }
        return minimum;
    }
    public boolean check(int arr[], int num, int k, int day){

        int sum=0;
        int cnt=0;
        int n=arr.length;
        for(int i=0; i<n;i++){
            if(arr[i]<=day)
            cnt++;
            else{
                sum+=(cnt/k);
                cnt=0;
            }
        }

        sum+=(cnt/k);

        if(sum>=num){
            return true;
        }
        return false;
    }
}
