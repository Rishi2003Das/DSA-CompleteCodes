//Assignment 18 (sub class)
package Inheritance;
import java.util.*;
class Account extends Bank{
    double amt;//instance variable
    Account(String n, long l, double x){ //Parameterized constructor
        super(n,l,x);//calling the variables from the super class
        amt = 0;
    }//end of Account()
    void deposit(){
        System.out.println("Enter the amount to deposit: ");
        amt = new Scanner(System.in).nextDouble();
        super.p += amt; //amount being deposited 
    }//end of deposit()
    void withdraw(){
        System.out.println("Enter the amount to withdraw: ");
        amt = new Scanner(System.in).nextDouble();
        if(super.p<amt)
            System.out.println("Insufficient Balance");
        else
            super.p -= amt;
        if(super.p<500)
            super.p = super.p - (500-super.p)/10; //withdraw fine
    }//end of withdraw()
    void display(){
        super.display(); //displaying the details
    }//end of display()
}//end of class