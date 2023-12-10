//Recursion 
import java.util.*;
class FiboRec{
    int a;
    int b;
    int c;
    int limit;
    FiboRec(){
        a=0;
        b=1;
        c=1;
        limit=0;
    }
    void input(){
        Scanner sc= new Scanner(System.in);
        do{
            System.out.println("Enter the value");
            limit=sc.nextInt();
        }while(limit<=0);
    }
    int fib(int n){
        if(n==1)
        return a;
        else if(n==2)
        return b;
        else if(n==3)
        return c;
        else
        return fib(n-1)+fib(n-2);
    }
    void generateFibSeries(){
        for(int i=1; i<=limit; i++){
            System.out.print(fib(i)+" ");
        }
    }
    public static void main(String args[]){
        FiboRec ob=new FiboRec();
        ob.input();
        ob.generateFibSeries();
    }
}