//Best Brute force solution
//T.C=O(n^2)
//S.C.=O(1)
class Solution {
    public String longestPalindrome(String s) {
        String res="";
        int resLen=0;

        for(int i=0;i<s.length();i++){
        //Odd length
            int l=i;
            int r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>resLen){
                    res=s.substring(l,r+1);
                    resLen=r-l+1;
                }
                l-=1;
                r+=1;
            }
            //Even length
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>resLen){
                    res=s.substring(l,r+1);
                    resLen=r-l+1;
                }
                l-=1;
                r+=1;
            }
        }
        return res;
    }
}

//Best Optimised solution (Maracher's Algorithm)
//T.C=O(n)
//S.C.=O(n)

