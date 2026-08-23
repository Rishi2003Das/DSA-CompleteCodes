import java.util.*;

public class Solution {
    public List<Integer> highlyInfluentialNodes(int[][] arr) {
        int n=arr.length;
        int c;
        int count[]=new int[n];
        int max=Integer.MIN_VALUE;
        ArrayList<Integer> node=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            c=0;
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    list.get(i).add(j);
                    c++;
                }
            }
            count[i]=c;
            if(c>max){
                max=c;
                node.clear();
                node.add(i);
            }
            else if(c==max){
                node.add(i);
            }
        }
        int MAX=Integer.MIN_VALUE;
        int s=0;
        for(int i: node){
            s=0;
            for(int it: list.get(i)){
                s+=count[it];
            }
            if(s>MAX){
                MAX=s;
                ans.clear();
                ans.add(i);
            }
            else if(s==MAX){
                ans.add(i);
            }
        }
        return ans;
    }
}
