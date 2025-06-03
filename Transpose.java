import java.util.*;
class Transpose{
      int m;
    int a[][];
    void accept(){
        Scanner sc=new Scanner(System.in);
        do{
        System.out.println("Enter the size of the square matrix");
        m=sc.nextInt();
    }while(m<2 || m>=10);
    a=new int[m][m];
    for(int i=0;i<m;i++){
        for(int j=0;j<m;j++){
            System.out.println("Enter the array elements:");
            a[i][j]=sc.nextInt();
    }
    }
    System.out.println("Original Array");
    display(a);
    int[][] transpose = new int[m][m];
    for(int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
                transpose[j][i] = a[i][j];
            }
        }
        System.out.println("New Array");
    display(transpose);
}
void display(int x[][]){
    for(int i=0;i<m;i++){
        for(int j=0;j<m;j++){
            System.out.print(x[i][j]+" ");
    }
    System.out.println();
    }
    } 
    public static void main(String args[]){
        Transpose ob=new Transpose();
        ob.accept();
    }
}