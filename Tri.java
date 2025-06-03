import java.util.*;
class Tri{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the angle : ");
        int a=sc.nextInt();
        System.out.println("Enter the angle : ");
        int b=sc.nextInt();
        System.out.println("Enter the angle : ");
        int c=sc.nextInt();
        if((a+b+c)==180)
            System.out.println("VALID");
            else
            System.out.println("NOT VALID");
    }
}