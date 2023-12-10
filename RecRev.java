//Reccursive letter removal
import java.util.*;
class RecRev{
    private String str;
    RecRev(){
        str="";
    }
    void read(){
        System.out.println("Enter the sentence");
        str=new Scanner(System.in).nextLine();
    }
    String remove(){
        String m=str.substring(0,1);
        for(int i=1;i<str.length();i++){
            char z=str.charAt(i);
            if(z==str.charAt(i-1))
                continue;
                m=m+z;
            }
            return m;
    }
    void print(){
        String x=remove();
        System.out.println("The sentence: "+x);
    }
    public static void main(String args[]){
        RecRev ob=new RecRev();
        ob.read();
        ob.print();
    }
}