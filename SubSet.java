import java.util.*;
class SubSet{
    public static void main(String args[]){
        int arr[]={1,2,3,4,5};
        List<List<Integer>> ans = subset(arr);
        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer =new ArrayList<>();
        
        outer.add(new ArrayList<>());
        
        for (int num : arr){
            int n= outer.size();
            for(int i=0; i<n;i++){
                List<Integer> inter = new ArrayList<>(outer.get(i));
                inter.add(num);
                outer.add(inter);
            }
        }
        return outer;
    }
}