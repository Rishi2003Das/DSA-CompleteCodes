package Programs;
import java.util.*;
class Kaprekar{
    void accept(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the lower and upper limits");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=0;
        System.out.println("The Kaprekar numbers are: ");
        for(int i=a;i<=b;i++){
            if(isKap(i)){
                System.out.print(i+",");
            c++;
            }
        }
        System.out.println();
        System.out.println("The frequency of the kaprekar numbers is: "+c);
    }
    boolean isKap(int p){
        if(p==1)
        return true;
        int l=(int)(Math.log10(p)+1);
        int m=(p*p)/(int)(Math.pow(10,l));
        int n=(p*p)-(m*(int)(Math.pow(10,l)));
        if((m*n)==p)
        return true;
        else
        return false;
    }
    public static void main(String args[]){
        Kaprekar ob=new Kaprekar();
        ob.accept();
    }
}