import java.util.*;
class SubSetwithDup{
    public static List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);//To bring the duplicates side by side
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start =0;
        int end = 0;
        for(int i=0; i<arr.length; i++){
            start=0;
            if(i>0 && arr[i] == arr[i-1]){
                start = end+1;
            }
            end= outer.size()-1;
            int n=outer.size();
            for(int j=start;j<n;j++){
                List<Integer> internal =new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
    public static void main(String args[]){
        int arr[]={1,2,2,3,3,4,5};
        List<List<Integer>> ans = subsetsWithDup(arr);
        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }
}