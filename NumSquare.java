import java.util.*;
class NumSquare{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n=sc.nextInt();
        n=2*n;
        for(int row=0;row<=n;row++){
            for(int col=0;col<=n;col++){
                int p= row>col?(n-row>col?(n-col>col?col:n-col):(n-col>n-row?n-row:n-col)):(n-row>row?(n-col>row?row:n-col):(n-row<n-col?n-row:n-col));
              System.out.print(p);  
            }
            System.out.println();
        }
    }
}