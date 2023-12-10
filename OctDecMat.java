import java.util.*;
class OctDecMat{
    private int m,n;
    private int a[][];
    void accept(){
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Enter the number of rows: ");
            m=sc.nextInt();
            System.out.println("Enter the number of coloumns: ");
            n=sc.nextInt();
        }while(m<=0 || m>=10 || n<=2 || n>=6);
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                do{
                System.out.println("Enter digits within 0 to 7");
                a[i][j]=sc.nextInt();
                }while(a[i][j]<0 || a[i][j]>7);
            }
        }
            System.out.println("The Original Matrix:");
            for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
            for(int i=0;i<m;i++){
                int p=2;
                int d=0;
                for(int k=0;k<n;k++){
                d+=(a[i][k]*(int)Math.pow(8,p));
                p--;
            }
            System.out.println("The decimal value of the row "+(i+1)+": "+d);
            }
    }
    public static void main(String args[]){
        OctDecMat ob=new OctDecMat();
        ob.accept();
    }
}