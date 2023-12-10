package Inheritance;
//Sub-class
import java.util.*;
class Highest extends Record{
    protected int ind;
    Highest(int capacity){
        super(capacity);
        ind=0;
    }
    void find(){
        int max=super.m[0];
        for(int i=0;i<m.length;i++){
            if(m[i]>max)
            {
            max=super.m[i];
            ind =i;
            }
        }
    }
    void display(){
        super.display();
        System.out.println("Highest marks obtained: ");
        for(int i=0;i<(super.m).length;i++){
            if(m[i]==m[ind])
            System.out.println(super.n[i]);
        }
    }
    public static void main(String args[]){
        Highest ob=new Highest(5);
        ob.readarray();
        ob.find();
        ob.display();
    }
}