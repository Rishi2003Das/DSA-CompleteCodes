import java.util.*;

public class Solution {
    public String browserHistory(int N, String[] S) {
        StringBuilder ans=new StringBuilder();
        List<String> list=new ArrayList<>();
        list.add("/home");
         int curr=0;
         
        for(int i=0;i<N;i++){
            if(S[i].equals("back")){
                if(curr>0){
                    curr--;
                }
            }
            else if(S[i].equals("forward")){
                if(curr<list.size()-1){
                    curr++;
                }
            }else{
                while(list.size()>curr+1){
                    list.remove(list.size()-1);
                }
                    list.add("/"+S[i]);
                    curr++;
            }
        }
        for(String str:list){
            ans.append(str);
        }
        return ans.toString();
    }
}
