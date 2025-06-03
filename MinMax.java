import java.util.*;
class MinMax{
public static void main(String args[]){
        int large,small;
        Scanner sc=new Scanner(System.in);
         System.out.println("Enter the length of the array: ");
         int n=sc.nextInt();
    int a[] = new int[n];
    large=small=a[0];
     for(int i=0;i<n;i++){
             System.out.println("Enter the array element: ");
             a[i]=sc.nextInt();
         }
    for(int i=1;i<n;++i){
if(a[i]>large)
large=a[i];
if(a[i]<small)
small=a[i];
}
System.out.println("The smallest element is: "+ small );
System.out.println("The largest element is: "+ large );
}
}