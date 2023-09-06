import java.util.*;
class RecurFiboPattern{
    private int n;//stores the number of lines to be displayed
    public void input(){//take input from the user
        do{
            System.out.print("Enter the number of lines: ");
            n=new Scanner(System.in).nextInt();
            if(n<=0)
                System.out.println("Wrong input");
        }while(n<=0);
    }//end of input()
    public int fibo(int x){//generate a particular member of the fibonacci series
        if(x==1)
            return 0;
        else if(x==2)
            return 1;
        else 
            return fibo(x-1)+fibo(x-2);
    }//end of fibo()
    public void pattern(){//print the pattern of the Fibonacci series
        int c=1;//counter
        System.out.println("Output: ");
        for(int i=0;i<=n;i++){
            for(int j=0;j<n-i;j++)
                System.out.print(" ");
            for(int k=0;k<i;k++)
                System.out.print(fibo(c++)+" ");
            System.out.println();
        }//end of for loop
    }//end of pattern()
    public static void main(String args[]){
    RecurFiboPattern ob=new RecurFiboPattern();
        ob.input();
        ob.pattern();
    }//end of main()
}//end of class