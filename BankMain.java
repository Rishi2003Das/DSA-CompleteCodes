//Assignment 18
package Inheritance;
import java.util.*;
class BankMain{
    public static void main(String args[]){
        System.out.println("Enter the name, account number and the principal value: ");    
        Account ob = new Account(new Scanner(System.in).next(),new Scanner(System.in).nextLong(),new Scanner(System.in).nextDouble());
        ob.deposit();//Calling the method
        ob.withdraw();
        ob.display();
    }//end of main method
}//end of class