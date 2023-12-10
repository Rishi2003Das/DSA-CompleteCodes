package Programs;
import java.util.*;
class StrRot{
    String st1;
    String st2;
    StrRot(){
        st1=st2="";
    }
    void accept(){
        do{
        System.out.println("Enter the first word:-");
        st1=new Scanner(System.in).nextLine();
        System.out.println("Enter the second word:-");
        st2=new Scanner(System.in).nextLine();
        }while((st1.length())!=(st2.length()));
        st1=st1.trim();
        st2=st2.trim();
    }
    boolean rot(){
        String r=st1+st1;
        for(int i=0;i<st1.length();i++){
        if((r.substring(i,(i+st1.length()))).equals(st2))
        return true;
    }
        return false;
        }
    void display(){
        if(rot())
        System.out.println(""+st1+" is a rotation of "+st2);
        else
        System.out.println(""+st1+" is not a rotation of "+st2);
    }
    public static void main(String args[]){
        StrRot ob=new StrRot();
        ob.accept();
        ob.display();
    }
}