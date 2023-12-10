package Inheritance;
import java.util.*;
class Compmain{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);//Taking the inputs through Scanner class 
System.out.println("Enter the name of the book");
String n=new Scanner(System.in).nextLine();
System.out.println("Enter the author of the book");
String a=new Scanner(System.in).nextLine();
System.out.println("Enter the price of the book");
int x=sc.nextInt();
System.out.println("Enter the number of days for which the book was taken");
int day=sc.nextInt();
Compute ob=new Compute(n,a,x,day);
ob.display();
}//end of main
}//end of class