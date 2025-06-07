class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int right=3;
        int sum=0;
            while(right<=s.length()){
                String z=s.substring(left,right);
                if(z.contains("a") && z.contains("b") && z.contains("c")){
                    sum+=(s.length()-right+1);
                    left++;
                }
                right++;
            }
            return sum;
    }   
}
