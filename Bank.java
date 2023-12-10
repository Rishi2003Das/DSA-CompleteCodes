//Assignment 18
package Inheritance;

import java.util.*;
class Bank{
    String name;//Instance variable
    long accno;
    double p;
    Bank(String n, long l, double p){//Constructor
        name = n;
        accno = l;
        p = this.p;
    }//end of Bank()
    void display(){
        System.out.println("Name: " + name);
        System.out.println("Account number: " + accno);
        System.out.println("Principal: " + p);
    }//end of display()
}//end of class