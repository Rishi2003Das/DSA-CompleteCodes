import java.util.*;
class PascalTriangle{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
                for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            int p=i;
            for(int k=1;k<=(2*i)-1;k++){
                    if(k<n){
                        System.out.print(p);
                        p--;
                    }
                    else
                    {
                        p++;
                        System.out.print(p);
                    }
                }
            for(int j=(n+i);j<2*n;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}