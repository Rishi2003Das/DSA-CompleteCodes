//Creating bitMask for bit manipulation
import java.util.*;
class UpdateBit{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        System.out.println("Enter the position:");
        int i=sc.nextInt();
        System.out.println("Enter the number to which you want to update: ");
        int u=sc.nextInt();
        int bm=1<<i;
        int up=0;
        if(u==1)
        up=(bm | n);
        else
        up=((~bm) & n);
        System.out.println("The new Number: "+up);
    }
}