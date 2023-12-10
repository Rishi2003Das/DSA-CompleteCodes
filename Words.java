import java.util.*;
class Words{
    private String sen;
    Words(String s){
        sen=s;
    }
    void show(){
        System.out.println("Original Sentence:"+sen);
        System.out.println("Updated Sentence:"+extractWord(sen));
    }
    String extractWord(String x){
        if(x.indexOf(" ")<0){
            x=dele(x);
            return x;
        }
        else
        {
            String p=(x.substring(0,x.indexOf(" ")));
            p=dele(p);
            return (p+" "+extractWord(x.substring(x.indexOf(" ")+1)));
        }
    }
    String dele(String v){
        return v.substring(1,v.length()-1);
    }
    public static void main(String args[]){
        Words ob=new Words("This book is an interesting book");
        ob.show();
    }
}