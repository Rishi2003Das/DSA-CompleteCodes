class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        map.put(0,1);
        int total=0;
        int c=0;

        for(int n:nums){
            total+=n;

        if(map.containsKey(total-k))
        c+= map.get(total-k);
        map.put(total, map.getOrDefault(total,0)+1);
        }
        return c;
    }
}
