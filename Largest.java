import java.util.*;
class Largest{
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
    public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
    int m;
    int arr[];
        do{
        System.out.println("Enter the size of the square matrix");
        m=sc.nextInt();
    }while(m<2 || m>=1000);
    arr=new int[m];
    for(int i=0;i<m;i++){
            System.out.println("Enter the array elements:");
            arr[i]=sc.nextInt();
    }
    Largest ob=new Largest();
    ob.bubbleSort(arr);
    System.out.println("The Largest Number: "+arr[m-1]+" and The Second Largest Number: "+arr[m-2]);
    }
}