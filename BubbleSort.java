//Bubble Sort
import java.util.*;
class BubbleSort{
    void bubbleSort(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=1;j<arr.length - i;j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
