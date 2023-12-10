package Inheritance;
import java.util.*;
class Student{
    protected String name; 
    protected int age;
    protected String  blGr;
    Student(String n,int a,String b){
        name=n;
        age=a;
        blGr=b;
    }
    void display(){
        System.out.println("The name of the student: "+ name);
        System.out.println("The age of the student: "+ age);
        System.out.println("The blood group of the student: "+ blGr);
    }
}