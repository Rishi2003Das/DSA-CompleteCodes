package Inheritance;
//Super class
import java.util.*;
class Record{
    protected String n[];
    protected int m[];
    protected int size;//Instance variables
    Record(int cap){//Parameterised constructor
        size=cap;
        m=new int[size];
        n=new String[size];
    }
    void readarray(){
        Scanner sc= new Scanner(System.in);
        for(int i=0;i<size;i++){
        System.out.println("Enter the name: ");
        n[i]=(new Scanner(System.in)).nextLine();
        System.out.println("Enter the marks: ");
        m[i]=sc.nextInt();
    }
    }
    void display(){
        for(int i=0;i<size;i++){
        System.out.println("Name of the student: "+n[i]);
        System.out.println("Marks of the student: "+m[i]);
    }
    }
}