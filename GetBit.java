//Creating bitMask for bit manipulation
import java.util.*;
class GetBit{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        System.out.println("Enter the position:");
        int i=sc.nextInt();
        int bm=1<<i;
        if((bm & n) ==0)
        System.out.println("The bit at "+i+" position is 0");
        else
        System.out.println("The bit at "+i+" position is 1");
    }
}