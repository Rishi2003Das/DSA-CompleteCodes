class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        Arrays.sort(cuts);
        int[] arr = new int[len + 2];
        arr[0] = 0;
        arr[len+1] = n;
        for(int i=1; i<len+1; i++){
            arr[i] = cuts[i-1];
        }
        int[][] dp = new int[len+1][len+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return f(1,len,arr,dp);
    }
    private static int f(int i,int j,int[] cuts,int[][] dp){
        if(i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int mini  = Integer.MAX_VALUE;
        for(int ind=i; ind<=j; ind++){
            int cost = cuts[j+1] - cuts[i-1] + f(i,ind-1,cuts,dp) + f(ind+1,j,cuts,dp);
            mini = Math.min(mini,cost);
        }
        return dp[i][j] =  mini;
    }
}
