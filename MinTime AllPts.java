class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n=points.length;
        int s=0;
        for(int i=0; i<n-1; i++){
            int r=points[i+1][0]-points[i][0];
            int c=points[i+1][1]-points[i][1];
        while(r!=0 || c!=0){
            s++;
            if(r==0 && c>0){
                c--;
            }
            else if(r>0 && c>0){
                r--;
                c--;
            }
            else if(r>0 && c==0){
                r--;
            }
            else if(r>0 && c<0){
                r--;
                c++;
            }
            else if(r==0 && c<0){
                c++;
            }
            else if(r<0 && c<0){
                r++;
                c++;
            }
            else if(r<0 && c==0){
                r++;
            }
            else{
                r++;
                c--;
            }
        }
        }
        return s;
    }
}
