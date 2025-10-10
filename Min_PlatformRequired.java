import java.util.*;
class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        //your code goes here
        int n=Arrival.length;

        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int plat=1;
        int maxplat=1;
        int i=1;
        int j=0;

        while(i<n && j<n){
            if(Arrival[i]<=Departure[j]){
                plat++;
                i++;
            }
            else
            {
                plat--;
                j++;
            }
            maxplat=Math.max(maxplat, plat);
        }
        return maxplat;
    }
}
