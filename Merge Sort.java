import java.util.*;
class MergeSort{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter an elements of a unsorted array");
            arr[i]=sc.nextInt();
        }
        int s=0;
        int e=n-1;
        MergeSort ob=new MergeSort();
        ob.divide(arr, s, e);
        ob.conquer(arr, s, s, e);
        ob.display(arr);
    }
    public void divide(int arr[], int s, int e){
        if (s >= e)
        return;
        int mid=s+((e+s)/2);//Recursion
        divide(arr, s, mid);//Recusion of the first part of array
        divide(arr, mic+1 ,e);//Recursion of the second part of the array
        conquer(arr, s, mid, e);//To merge the divided array again
    }
    public void conquer(int arr[], int s, int mid, int e){
        int merger[]= new int[e-s+1];
        int i1 = s;
        int i2 = mid+1;
        int x=0;
        while(i1<= mid && i2<= e){
            if(arr[i1] <= arr[i2])
            merged[x++] = arr[i1++];
            else
            merged[x++] = arr[i2++];
        }
        while(i1<=mid){
            merged[x++] = arr[i1++];
        }
        while(i2<=e){
            merged[x++] = arr[i2++];  
        }
        for(int i=0, j=s; i<merged.length; i++, j++){
            arr[j] = merged[i];
        }
    }
    public void display(int arr[]){
         for(int i=0;i<n;i++){
            System.out.println(arr[i]+ " ");
        }
    }
}