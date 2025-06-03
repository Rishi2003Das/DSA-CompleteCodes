import java.util.*;
class NegArray{
     int m;
    int a[];
    void accept(){
        Scanner sc=new Scanner(System.in);
        do{
        System.out.println("Enter the size of the matrix");
        m=sc.nextInt();
    }while(m<2 || m>=10);
    a=new int[m];
    for(int i=0;i<m;i++){
            System.out.println("Enter the array elements:");
            a[i]=sc.nextInt();
    }
    System.out.println("The negative numbers are:");
    for(int i=0;i<m;i++){
            if(a[i]<0)
            System.out.print("  "+a[i]);
    }
    }
    public static void main(String args[]){
    NegArray ob= new NegArray();
    ob.accept();
    }
}