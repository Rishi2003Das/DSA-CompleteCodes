package Inheritance;
import java.util.*;
class Employee{
    int empNo;
    String empName;
    String empDesig;
    Employee(int eno, String ename, String empdesig){
        empNo=eno;
        empName=ename; 
        empDesig=empdesig;
    }
    void display(){
        System.out.println("empNo="+empNo+"\nempName="+empName+"\nempDesig="+empDesig);
    }
}