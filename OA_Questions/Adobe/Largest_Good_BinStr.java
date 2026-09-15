import java.util.*;

public class Solution {
    public String largestMagical(String binString) {
        int len=binString.length();
        int cnt=0;
        int start=0;
        List<String> list=new ArrayList<>();
        for(int i=0;i<len;i++){
            cnt+=(binString.charAt(i)=='1'?1:-1);
            if(cnt==0){
                String inner=binString.substring(start+1,i);
                list.add("1"+largestMagical(inner)+"0");//Recursive function to check the good binString
                start=i+1;
            }
        }
        list.sort((a,b)->(b+a).compareTo(a+b));//sorted the list of substring
        StringBuilder ans= new StringBuilder();
        for(String p: list){
            ans.append(p);
        }
        return ans.toString();
    }
}
