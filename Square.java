//Assignment 20
import java.util.*;
class Square{
    void accept(){
        System.out.println("Enter the size of matrix");
        int n = new Scanner (System.in) . nextInt();
        int a[][] = new int[n][n];//Array to store the value
        int x = 1;
        for (int i = 0; i<(n+1)/2 ; i++){
            for (int j = i ; j<n-i-1 ; j++){
                a[j][i] = x++;
            }//end of for
            for (int j = i ; j<=n-i-1 ; j++){
                a[n-i-1][j] = x++;
            }//end of for
            x--;
            for (int j = n-i-1; j>=i ; j--){
                a[j][n-i-1]=x++;
            }//end of for
            x--;
            for (int j = n-i-1; j>i ; j--){
                a[i][j]=x++;
            }//end of for
        }//end of outer for loop
        for ( int i = 0 ; i<n ; i++){//displaying the elements of the matrix
            for ( int j = 0 ; j<n ; j++){
                System.out.print(a[i][j] + " ");
            }//end of for loop
            System.out.println();//To change line
        }//end of for loop
    }//end of accept()
    public static void main(String args[]){
        new Square().accept();
    }//end of main
}//end of class
