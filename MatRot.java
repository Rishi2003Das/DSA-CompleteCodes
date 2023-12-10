import java.util.*;
class MatRot{
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
    System.out.println("Original Array:");
    display(a);
    System.out.println("Rotated Array:");
    rotate(a);
    display(a);
    System.out.println("Sum of the corner elements= "+(a[0][0]+a[0][m-1]+a[m-1][0]+a[m-1][m-1]));
    }
    void display(int x[][]){
    for(int i=0;i<m;i++){
        for(int j=0;j<m;j++){
            System.out.print(x[i][j]+" ");
    }
    System.out.println();
    }
    }
    void rotate(int x[][]){
    for(int i=0;i<(m/2);i++){
        int p[];
        p=new int[m];
        p=x[i];
        x[i]=x[m-i-1];
        x[m-i-1]=p;
    }
    }
    public static void main(String args[]){
        MatRot ob=new MatRot();
        ob.accept();
    }
}