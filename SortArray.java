import java.util.*;
class SortArray{
    void bubbleSort(int[]arr) {  
        int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){  
                                 temp = arr[j-1];  //Swaping
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                 }  
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
            SortArray ob=new SortArray();
            System.out.println("Unsorted array:");
            ob.display(arr);
            ob.bubbleSort(arr);
            System.out.println("Sorted Array:");
            ob.display(arr);
       }  
}