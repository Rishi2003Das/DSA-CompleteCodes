//Selection sort is a way to sort elements in a row
import java.util.*;
class SelectionSort{
    void selectionSort(int arr[]){int temp=0;
        for(int i=0;i<arr.length-1;i++){
            int s=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[s]>arr[j])
                s=j;
            }
            temp = arr[i];  //Swaping
            arr[i] = arr[s];  
            arr[s] = temp;  
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
            SelectionSort ob=new SelectionSort();
            System.out.println("Unsorted array:");
            ob.display(arr);
            ob.selectionSort(arr);
            System.out.println("Sorted Array:");
            ob.display(arr);
    }  
}