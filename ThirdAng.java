//Question10
import java.util.*;
class ThirdAng{
    public static void main(String args[]){
        int a1,a2;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first angle: ");
        a1=sc.nextInt();
        System.out.println("Enter the second angle: ");
        a2=sc.nextInt();
        System.out.println("The third angle will be: "+(180-(a1+a2)));
    }
}