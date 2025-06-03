import java.util.*;
class Factors{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int n=sc.nextInt();
        int c=0;
        for(int i=1;i<=(n/2);i++){
            if(n%i==0){
            c++;
            System.out.println("The factor of n are: "+i);
        }
        }
        System.out.println("The factor of n are: "+n);
        if(c==1)
        System.out.println("Prime number");
        else
        System.out.println("Not a Prime number");
    }
}