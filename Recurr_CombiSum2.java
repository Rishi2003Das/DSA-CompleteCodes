class Solution {
    public List<List<Integer>> combinationSum2(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        int arr[]=new int[k-1];
        for(int i=0;i<=k-1;i++){
            arr[i]=i+1;
        }
        Arrays.sort(arr);
        combi(0, arr, n, ans, new ArrayList<>());
        return ans;
    }
    public List<List<Integer>> combi(int ind, int arr[], int target, List<List<Integer>> ans, List<Integer> ds){
        if(target == 0){
        ans.add(new ArrayList<>(ds));
        return ans;
        }

        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i] == arr[i-1])
            continue;

            if(arr[i]>target)
            break;

            ds.add(arr[i]);
            combi(i+1,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
        return ans;
    }
}
