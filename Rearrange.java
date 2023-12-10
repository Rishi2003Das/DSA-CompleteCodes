import java.util.*;
class Rearrange{
    String Txt;
    String Cxt;
    int len;
    Rearrange(){
        Txt=Cxt="";
        len=0;
    }
    void readword(){
        System.out.println("Enter a word");
        Txt=new Scanner(System.in).next().toUpperCase();
        convert();
    }
    void convert(){int i=-1;
        if("AEIOU".indexOf(Txt.charAt(0))>=0)
        Cxt=Txt+"Y";
        else
        {
            for(i=0;i<Txt.length();i++){
                char p=Txt.charAt(i);
                if("AEIOU".indexOf(Txt.charAt(0))>=0)
                break;
            }
            if(i==-1)
            Cxt=Txt+"c";
            else
            Cxt=Txt.substring(i)+Txt.substring(0,i)+"N";
        }
    }
    void display(){
        readword();
        System.out.println("Original String ="+Txt);
        System.out.println("Updated String ="+Cxt);
    }
    public static void main(String args[]){
        Rearrange ob=new Rearrange();
        ob.display();
    }
}