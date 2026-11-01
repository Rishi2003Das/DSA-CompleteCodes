//LC 453
class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nums[n-1]-nums[i];
        }
        if(arr[0]==arr[n-1])
        return 0;
        int sum=0;
        int cnt=0;
        int zeroes=1;
        for(int i=n-2;i>=0;i--){
            if(arr[i+1]==arr[i]){
                zeroes++;
                continue;
            }
            sum+=((arr[i]-cnt)*zeroes);
            zeroes++;
            cnt=arr[i];
        }
        return sum;
    }
}
