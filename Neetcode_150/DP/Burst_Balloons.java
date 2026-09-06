class Solution {
    Integer dp[][];
    public int maxCoins(int[] nums) {
        int n = nums.length;

        dp = new Integer[n+2][n+2];

        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i=0;i<n;i++)
            arr[i+1] = nums[i];
        
        return dfs(arr,n,0,n+1);
    }

    private int dfs(int arr[],int n,int l,int r){        
        if(l == 0 && r == 0)
            return 1;
        
        if(l == n+1 && r == n+1)
            return 1;
        
        if(dp[l][r] != null)
            return dp[l][r];

        dp[l][r] = 0;
        for(int i=l+1;i<r;i++){
            int sum = dfs(arr,n,l,i) + (arr[l] * arr[i] * arr[r]) + dfs(arr,n,i,r);

            dp[l][r] = Math.max(dp[l][r],sum);
        }

        return dp[l][r];
    }

}
