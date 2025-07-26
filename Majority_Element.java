class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int n=arr.length;
        int t=n/3;
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0; i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i])>t && ans.contains(arr[i])==false)
            ans.add(arr[i]);
        }
        return ans;
    }
}
