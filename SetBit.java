//Creating bitMask for bit manipulation
import java.util.*;
class SetBit{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        System.out.println("Enter the position:");
        int i=sc.nextInt();
        int bm=1<<i;
        int Setbit=bm | n;
        System.out.println("The new Number: "+Setbit);
    }
}