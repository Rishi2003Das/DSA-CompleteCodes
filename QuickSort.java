import java.util.*;
class QuickSort{
    public static void main(String args[]){
        Scanner sc =  new Scanner(System.in);
                
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        QuickSort ob= new QuickSort();
        ob.sort(arr,arr[0],arr[n-1]);
        System.out.println("The elements of the array are:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    static void sort(int nums[], int low, int high){
        if(low>=high)
        return ;
        
        int s=low;
        int e=high;
        int mid= s+(e-s)/2;
        int pivot=nums[mid];
        
        //Pivot is brought at the correct position
        while(s<=e){
            while(nums[s]<pivot){
                s++;
            }
            while(nums[e]>pivot){
                e--;
            }
            
            if(s<=e){
                int temp=nums[s];
                nums[s]=nums[e];
                nums[e]=temp;
                s++;
                e--;
            }
        }
        //Sorting the 2 halves on the both side of the pivot
        sort(nums,low,e);
        sort(nums,s,high);
    }
}