package Programs;
//The entity used in this darta structure is Queue 
import java.util.*;
class Diary{
    String Q[];
    int size;
    int start;
    int end;
    Diary(int max){
    size=max;
    Q=new String[size];
    start=end=0;
    }
    void pushadd(String n){
        if(end==(size-1))
        System.out.println("NO SPACE");
        else
        Q[++end]=n;
    }
    String popadd(){
        if(start==end)
        return ("???????");
        else
        {
        String k=Q[start++];
        return k;
    }
    }
    void show(){
        System.out.print("Adresses: ");
        for(int i=start;i<=end;i++)
        System.out.println(Q[i]);
    }
}