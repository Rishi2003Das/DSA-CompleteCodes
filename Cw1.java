//Question3
import java.util.*;
class Cw1{
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n;
    System.out.println("Enter the value: ");
    n=sc.nextInt();
    System.out.print("Pre Increment value: ");
    System.out.println(++n);
    System.out.print("Pre Decrement value: ");
    System.out.println(--n);
    System.out.print("Post Increment value: ");
    System.out.println(n++);//No increment
    System.out.print("Post Decrement value: ");
    System.out.println(n--);//No decrement
}
}