//General Solution
// T.C.-> O(N^3)
// s.c.-> O(1)

class Solution {
    public int numberOfPairs(int[][] points) {
        int count=0;
        int n=points.length;

        for(int i=0; i<n; i++) {
            int x1=points[i][0],y1=points[i][1];
            for(int j=0; j<n; j++) {
                if(i==j) continue;
                int x2=points[j][0],y2=points[j][1];
                if(x1>x2 || y1<y2) continue;

                boolean flag=true;
                for(int k=0; k<n; k++) {
                    if(k==i || k==j) continue;
                    int x=points[k][0],y=points[k][1];

                    if(x>=x1 && x<=x2 && y<=y1 && y>=y2) {
                        flag=false;
                        break;
                    }                        
                }
                if(flag==true) count++;
            }
        }

        return count;
    }

}


//Optimised solution
// T.C.-> O(N^2)
// s.c.-> O(1)

import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        // Sort points by x ascending, then y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];  // descending y if x is equal
            }
            return a[0] - b[0];      // ascending x
        });

        int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int maxi = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (maxi < points[j][1] && points[i][1] >= points[j][1]) {
                    maxi = Math.max(maxi, points[j][1]);
                    ans++;
                }
            }
        }
        return ans;
    }
}

