import java.util.*;
class PeakOfMountainArr {
    public static int peakIndexInMountainArray(int[] arr) {
    int start = 0;
    int end = arr.length -1;
        while(start < end){
            int mid= start + (end -start)/2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }
            else 
                start = mid+1;
        }
        return start;
    }
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
        System.out.println("The Peak of the Mountain Array: "+(peakIndexInMountainArray(arr)+1));
    }
}