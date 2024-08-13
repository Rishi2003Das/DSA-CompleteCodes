//Merge Sort is a sorting algorithms for Data Structures using recursion
import java.util.*;
class MergeSort{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        MergeSort ob= new MergeSort();
        ob.mergeSort(arr);
        System.out.println("The elements of the array are:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    static int[] mergeSort(int arr[]){
        if(arr.length==1){
            return arr;
        }//Base Condition in a recursion
        int mid=arr.length/2;
        
        int left[] = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int right[] = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        
        return merge(left,right);
    }
    static int[] merge(int[] first, int[] second){
        int mix[]= new int[first.length + second.length];
        
        int i=0;
        int j=0;
        int k=0;
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }
            else
            {
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;
    }
}