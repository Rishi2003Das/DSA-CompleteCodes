import java.util.*;
class Diamond{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n=sc.nextInt();
        for(int j=1;j<=(2*n)-1;j++){
            if(j<=n){
                for(int k=1;k<=(n-j);k++){
                    System.out.print(" ");
                }
                for(int k=1;k<=(2*j)-1;k++){
                    if(k%2!=0)
                    System.out.print("*");
                    else
                    System.out.print(" ");
                }
                for(int k=1;k<=(n-j);k++){
                    System.out.print(" ");
                }
            }
            else
            {
               for(int k=j-n;k>0;k--){
                    System.out.print(" ");
                }
               for(int k=(4*n-2*j-1);k>0;k--){
                   if(k%2!=0)
                    System.out.print("*");
                    else
                    System.out.print(" ");
               }
               for(int k=j-n;k>0;k--){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
