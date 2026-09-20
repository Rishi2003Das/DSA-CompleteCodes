import java.util.*;

public class Solution {
    public int[] findValidSizes(int[] memoryBlocks) {
        //Write your code here...
        int n=memoryBlocks.length;
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(memoryBlocks);
        int maxMex=0;
        for(int value:memoryBlocks){
            if(value<=maxMex){
                maxMex++;
            }
        }
        if(n>1){
            list.add(0);
        }
        for(int mex=1;mex<=maxMex;mex++){
            if(mex==n-1 && memoryBlocks[n-1]==n-1){
                continue;
            }
            list.add(mex);
        }
        int ans[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
