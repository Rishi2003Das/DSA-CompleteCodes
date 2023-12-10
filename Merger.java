package Programs;
import java.util.*;
class Merger{
    private int n1;
    private int n2;
    private long N3;
    Merger(int num1,int num2){
        n1=num1;
        n2=num2;
        N3=0;
    }
    void mergeNumber(){
        String p1=Integer.toString(n1);
        String p2=Integer.toString(n2);
        String p=p1+p2;
        N3=Long.valueOf(p);
    }
    void show(){
        System.out.println("Original number: "+n1+" and "+n2);
        System.out.println("Concated number: "+N3);
    }
    public static void main(String args[]){
        Merger ob=new Merger(23,729);
        ob.mergeNumber();
        ob.show();
    }
}