import java.util.*;
class Employee{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Employee ID: ");
        int e=sc.nextInt();
        System.out.println("Enter the Employee name: ");
        String n=new Scanner(System.in).nextLine();
        System.out.println("Enter the Employee designation: ");
        String d=new Scanner(System.in).nextLine();
        System.out.println("Enter the Employee department: ");
        String p=new Scanner(System.in).nextLine();
        System.out.println("Enter the Employee salary: ");
        int s=new Scanner(System.in).nextInt();
        System.out.println("Enter the Employee ID: "+ e);
        System.out.println("Enter the Employee name: "+ n);
        System.out.println("Enter the Employee designation: "+ d);
        System.out.println("Enter the Employee department: "+ p);
        System.out.println("Enter the Employee salary: "+ s);
    }
}