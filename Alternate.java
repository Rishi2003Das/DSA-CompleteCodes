package Programs;
import java.util.*;
class Alternate{
    private String str;
    private String newStr;
    private int len;
    Alternate(){
        newStr=str="";
        len=0;
    }
    void readWord(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the word");
        str=new Scanner(System.in).nextLine();
    }
    void change(){
        int p=0;
        newStr=""+(str.charAt(0));
        if(Character.isUpperCase(str.charAt(0)))
        p=1;
        else 
        p=2;
        if(p==1){
        for(int i=1;i<str.length();i++){
             char z=str.charAt(i);
             if(i%2!=0)
             newStr+=(Character.toLowerCase(z));
             else
             newStr+=(Character.toUpperCase(z));
            }
        }
        else
        {
         for(int i=1;i<str.length();i++){
             char z=str.charAt(i);
             if(i%2!=0)
             newStr+=(Character.toUpperCase(z));
             else
             newStr+=(Character.toLowerCase(z));
            }   
        }
    }
    void display(){
        System.out.println("ORIGINAL WORD: "+str);
        System.out.println("NEW WORD: "+newStr);
    }
    public static void main(String args[]){
        Alternate ob= new Alternate();
        ob.readWord();
        ob.change();
        ob.display();
    }
}