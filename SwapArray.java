import java.util.*;
class SwapArray{
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the number of elements: ");
    int n=sc.nextInt();
    int a[]=new int[n];
    int b[]=new int[n];
    for(int i=0;i<n;i++){
        System.out.println("Enter the first array elements: ");
        a[i]=sc.nextInt();
        System.out.println("Enter the second array elements: ");
        b[i]=sc.nextInt();
    }
    for(int i=0;i<n;i++){
        int temp = a[i];
        a[i] = b[i];
        b[i] = temp;
    }
    System.out.println("The new first array: ");
    for(int i=0;i<n;i++){
        System.out.print(a[i]);
    }
    System.out.println("The new second array: ");
    for(int i=0;i<n;i++){
        System.out.print(b[i]);
    }
    }
}