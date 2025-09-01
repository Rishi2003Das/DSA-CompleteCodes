class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int res=0;
        for(int num : nums){
            if(!map.containsKey(num)){
            map.put(num, map.getOrDefault(num-1,0)+map.getOrDefault(num+1,0)+1);
            map.put(num-map.getOrDefault(num-1,0),map.get(num));
            map.put(num+map.getOrDefault(num+1,0),map.get(num));
            }
            res=Math.max(res,map.get(num));
        }
        return res;
    }
}
