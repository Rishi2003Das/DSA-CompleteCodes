import java.util.*;
class Exchange{
    private String sent;
    private String rev;
    private int size;
    Exchange(){
        sent=rev="";
        size=0;
    }
    void readsentence(){
        System.out.println("Enter a sentence");
        sent=new Scanner(System.in).nextLine();
        int i=0;
        for(i=0;i<size;i++){
        if(sent.charAt(i)=='.')
        break;
    }
    size=i+1;
    }
    void exfirstlast(){
        String q=""; 
        String m="";
        for(int i=0;i<size;i++){
            char z=sent.charAt(i);
            if(z!=' ')
            q+=z;
            else
            {
                if(q.length()>=2){
                char t;
                char p[]=q.toCharArray();
                t=p[(q.length()-1)];
                p[(q.length()-1)]=p[0];
                p[0]=t;
                q=String.valueOf(p);
            }
            else
            m=m+q+" ";
            }
            q="";
        }
        rev=m;
    }
    void display(){
        System.out.println("Original Sentence="+sent);
        System.out.println("New Sentence="+rev);
    }
    public static void main(String args[]){
        Exchange ob=new Exchange();
        ob.readsentence();
        ob.exfirstlast();
        ob.display();
    }
}