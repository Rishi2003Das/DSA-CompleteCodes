import java.util.*;

public class Solution {
    public int goodCitizens(int N, int[] Behaviour) {
        int arr[]=new int[N+2];
        arr[0]=arr[N+1]=0;
        for(int i=1;i<=N;i++){
            arr[i]=Behaviour[i-1];
        }
        int c=0;
        for(int i=1;i<=N;i++){
            if(arr[i]>((arr[i-1]+arr[i+1])/2))
            c++;
        }
        return c;
    }
}
