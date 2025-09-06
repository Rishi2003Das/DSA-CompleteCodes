class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int max=0;
        Map<Character,Integer>map=new HashMap<>();
        int left=0;
        int right=0;
        while(right < s.length())
        {
            char rightChar=s.charAt(right);
            if(map.containsKey(rightChar) && map.get(rightChar) >= left) left=map.get(rightChar)+1;
            map.put(rightChar,right);
            max=Math.max(max,right-left+1);
            right++;
        }   
        return max;
    }
}
