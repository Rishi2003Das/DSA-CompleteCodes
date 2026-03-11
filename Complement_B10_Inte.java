import java.util.*;
class Solution {
    public int bitwiseComplement(int n) {
        String s=Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(s);
            for(int i=0;i<s.length();i++){
                if(sb.charAt(i)=='0')
                sb.setCharAt(i,'1');
                else
                sb.setCharAt(i,'0');
            }
            String str=sb.toString();
            return Integer.parseInt(str,2);
    }
}
