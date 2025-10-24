// my approach
import java.util.*;
class Solution {
    public int nextBeautifulNumber(int n) {
        HashMap<Integer, Integer> map= new HashMap<>();
        n=n+1;
        int l=n;
        while(n>0){
            int b=n%10;
            if (b==0) return nextBeautifulNumber(l+1);
            map.put(b,map.getOrDefault(b,0)+1);
            n/=10;
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getKey()!=entry.getValue()) return nextBeautifulNumber(l+1);            
        }
        return l;
    }
}

//Other approach
class Solution {
    public boolean solve(int x){
        String s = String.valueOf(x);
        int[] vec = new int[10];
        for (char ch : s.toCharArray()) vec[ch - '0']++;
        for (char ch : s.toCharArray()){
            int c = ch - '0';
            if (c == 0 || vec[c] != c) return false;
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) if (solve(i)) return i;
    }
}
