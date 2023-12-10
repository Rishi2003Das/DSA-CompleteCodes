//*      *
//**    **
//***  ***
//********
//********
//***  ***
//**    **
//*      *
import java.util.*;
class Pattern10{
    int n;
    void accept(){
        Scanner sc=new Scanner(System.in);
        do{
        System.out.println("Enter the number of lines:");
        n=sc.nextInt();
    }while(n<=0);
    }
    void display(){
        int p=(n*2)-2;
        for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++)
        System.out.print("*");
        for(int k=0;k<=p;k++)
        if(k!=0)
        System.out.print(" ");
        for(int j=0;j<=i;j++)
        System.out.print("*");
        p-=2;
        System.out.println();
    }
    int t=0;
    for(int i=n;i>0;i--){
        for(int j=i;j>0;j--)
        System.out.print("*");
        for(int k=0;k<=t;k++)
        if(k!=0)
        System.out.print(" ");
        for(int j=i;j>0;j--)
        System.out.print("*");
        t+=2;
        System.out.println();
    }
    }
    public static void main(String args[]){
        Pattern10 ob=new Pattern10();
        ob.accept();
        ob.display();
    }
}