import java.util.*;

public class Solution {
    public List<String> nextPossibleStrings(List<String> words) {
        List<String> ans= new ArrayList<>();
        for(int i=0;i<words.size();i++){
            ans.add(nextString(words.get(i)));
        }
        return ans;
    }
    public String nextString(String word){
        char[] letter=word.toCharArray();
        int i;
        int c=0;
        for(i=word.length()-1; i>0;i--){
               if(letter[i]>letter[i-1]){
                   c++;
               break;
               }
        }
        if (c==0) return "no changes";
        for(int j=i-1;j<word.length()-1;j++){
            char temp=letter[j];
            letter[j]=letter[j+1];
            letter[j+1]=temp;
        }
        return new String(letter);
    }
}
