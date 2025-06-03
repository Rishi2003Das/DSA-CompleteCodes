import java.util.*;
class DupArray{
    public static void main(String args[]){
         int mat[];
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter the length of the array: ");
         int n=sc.nextInt();
         mat=new int[n];
         for(int i=0;i<n;i++){
             System.out.println("Enter the array element: ");
             mat[i]=sc.nextInt();
         }
         int c=0;
         for(int i=0;i<n;i++){
         for(int j=i+1;j<n;j++){
             if(mat[i]==mat[j]){
             System.out.println("Duplicate element: "+mat[i]);
             c++;
            }
        }
        }
        if(c==0)
        System.out.println("NOT A DUPLICATE ARRAY");
    }
}