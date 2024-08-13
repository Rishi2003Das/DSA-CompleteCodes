//Binary Search Algoritm used
import java.util.*;
class CeilingNumber{
    static int k=0;
    static int s=0;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        s=sc.nextInt();
        int arr[] = new int[s];
        int i=1;
        System.out.println("Enter the array element: ");
            arr[0]=sc.nextInt();
        int min=arr[0];
        while(i!=(s)){
            System.out.println("Enter the array element: ");
            arr[i]=sc.nextInt();
            i++;
        }
        System.out.println("Enter the number you want to search: ");
        int target=sc.nextInt();
        System.out.println("The ceiling no. is: "+bin(arr,target));
    }
    static int bin(int arr[], int t){
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
                return t;
            }
        }
        while((t+1)<=arr[s-1]){
        k=bin(arr,(t+1));
        if(k!=0)
        return k;
        }
        return -1;
    }
}