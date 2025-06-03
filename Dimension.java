//Question 5
import java.util.*;
class Dimension{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the side of a cube: ");
        int a=sc.nextInt();
        System.out.println("Enter the radius of a cone: ");
        int r=sc.nextInt();
        System.out.println("Enter the height of a cone: ");
        int h=sc.nextInt();
        System.out.println("Enter the radius of a sphere: ");
        int s=sc.nextInt();
        System.out.println("Enter the radius of a cylinder: ");
        int p=sc.nextInt();
        System.out.println("Enter the heigth of a cylinder: ");
        int k=sc.nextInt();
        System.out.println("The volume of cube: "+(a*a*a));
        System.out.println("The volume of cone: "+((r*r*h)/3));
        System.out.println("The volume of sphere: "+(s*s*s));
        System.out.println("The volume of cylinder : "+(p*p*k));
    }
}