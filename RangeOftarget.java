//Facebook Interview question
import java.util.*;
class RangeOftarget {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int s=sc.nextInt();
        int arr[] = new int[s];
        int i=0;
        while(i!=(s)){
            System.out.println("Enter the array element: ");
            arr[i]=sc.nextInt();
            i++;
        }
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1,-1};
        ans[0] = search(nums, target, true);
        ans[1] = search(nums, target, false);
        return ans;
    }
    int search(int arr[], int t, boolean findStart){
        int ans=-1;
        int start=0;
        int end=arr.length - 1;
        while(start <= end){
            int mid= start + (end -start)/2;
            if(t < arr[mid]){
                end = mid-1;
            }
            else if(t > arr[mid]){
                start = mid+1;
            }
            else
            {
                ans=mid;
                if(findStart)
                end=mid-1;
                else 
                start=mid+1;
            }
        }
        return ans;
    }
}