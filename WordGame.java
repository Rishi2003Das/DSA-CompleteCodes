package Programs;
import java.util.*;
class WordGame{
    private String s;
    void accept(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a sentence which will be terminated only by '.' , '?' or '!'");
        s=sc.next();
        s=s.trim();
        String str="";
        for(int i=0;i<(s.length());i++){
            char z=s.charAt(i);
            if(z=='.' || z=='?' || z=='!')
            break;
            else
            str=str+z;
        }
        s=str;
    }
    void delete(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the word to be deleted and its position");
        String d=sc.next();
        int p=sc.nextInt();
        for(int i=0;i<(s.length());i++){
            char k=s.charAt(i);
            if(k==' ')
            if(p==(i+1))
            i=i+(d.length());
            else
            s=s+k;
        }
        s=s.toUpperCase();
        System.out.println("The New Sentence: "+s);
    }
    public static void main(String args[]){
        WordGame ob=new WordGame();
        ob.accept();
        ob.delete();
    }
}