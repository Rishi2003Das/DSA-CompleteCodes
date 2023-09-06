//The sorting technique for insertion sort
import java.util.*;
class InsertionSort{
    void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){int j;
            int c=arr[i];
            for(j=i-1;j>=0;j--){
                if(arr[j]>c)
                arr[j+1]=arr[j];
        }
        arr[j+1]=c;
    }
    }
    void display(int arr[]){
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+"   ");
    }
    public static void main(String args[]){  
        int arr[],l;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the length of the required array: ");
            l=sc.nextInt();
            arr=new int[l];
            for(int i=0;i<arr.length;i++){
            System.out.println("Enter the array element: ");
            arr[i]=sc.nextInt();
        }  
            InsertionSort ob=new InsertionSort();
            System.out.println("Unsorted array:");
            ob.display(arr);
            ob.insertionSort(arr);
            System.out.println("Sorted Array:");
            ob.display(arr);
    }  
}