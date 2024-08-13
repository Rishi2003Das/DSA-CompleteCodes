//Amazon interview question
import java.util.*;
class SearchInfinite{
    static int Range(int arr[], int t){
        int start = 0;
        int end = 1;
     while(t>arr[end]){
            int temp= end+1;
            end+=(2*(start-end+1));
            start=temp;
        }
    return bin(arr,t,start,end);
    }
    static int bin(int arr[], int t, int start, int end){
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
                return mid;
            }
        }
        return -1;
    }
}