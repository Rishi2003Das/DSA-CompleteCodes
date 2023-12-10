//Removing a substring from a string
import java.util.*;
class Eliminate{
    String str;
    Eliminate(){
        str="";
    }
    Eliminate(String s){
        str=s;
    }
    void remove(String ss){
        String m="";int c=0;
        int l=ss.length();
        int i;
        for(i=0;i<=str.length()-l;i++){
            if(str.substring(i,i+l).equals(ss)){
                c++;
                i+=l;
                m+=str.charAt(i);
            }
            else
            m+=str.charAt(i);
        }
        m+=str.substring(i);
        if(c==0)
        System.out.println("Not found");
        str=m;
    }
    void print(){
        System.out.println("Original sentence="+str);
        remove(new Scanner(System.in).nextLine());
        System.out.println("New sentence="+str);
    }
    public static void main(String args[]){
        new Eliminate(new Scanner(System.in).nextLine()).print();
    }
}