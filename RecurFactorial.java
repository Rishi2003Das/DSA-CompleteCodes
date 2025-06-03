import java.util.*;
class RecurFactorial{
    int fact(int n){
        if(n==1)
        return 1;
        else
        return n*fact(n-1);
    }
    public static void main(String args[]){
        RecurFactorial ob=new RecurFactorial();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number who's factorial is to be found: ");
        int f=sc.nextInt();
        System.out.println(ob.fact(f));
    }
}