//Assignment 12
import java.util.*;
class Word{
    void accept(){
        String s="";//Instance variable
        System.out.println("Enter number of sentences:");
        int n = new Scanner(System.in).nextInt();
        if (n > 4 || n < 1) {
            System.out.println("LIMIT EXCEEDED");
            System.exit(0);
        }//end of if
        System.out.println("Enter "+ n+ " sentences in uppercase:");
        for (int i = 1; i <= n; i++) {
            s += new Scanner(System.in).nextLine() + " ";
        }//end of for
        s=s.trim();//trimming the string
        System.out.println("Total number of words:" + word_num(s));
        s += " ";
        String r="";
        int c = 0, b = 0;
        String str[] = new String[word_num(s)];
        int a[] = new int[word_num(s)];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                r += s.charAt(i);
            else 
            {
                str[c++] = r;
                a[b++] = freq(r, s);
                r = "";
            }//end of else
        }//end of for
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];//Swapping
                    String tmp1 = str[j];
                    a[j] = a[j + 1];
                    str[j] = str[j + 1];
                    a[j + 1] = tmp;
                    str[j + 1] = tmp1;
                }//end of if
            }//end of for
        }//end of for
        for (int i = 0; i < word_num(s); i++){
        for(int j=i+1;j<a.length;j++){
            if(str[j]!=null && str[i]!=null && str[i].equals(str[j]) )
                str[j]="";
        }//end of for
        }//end of for
        System.out.println("WORD                FREQUENCY");
        for (int i = 0; i < word_num(s); i++){
            if(str[i]!="" && a[i]>0)
            System.out.println(str[i] + "\t                 " + a[i]);
        }//end of for
    }//end of accept()
    int word_num(String s){
            String r=""; 
            int c=0; 
            s+=" ";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=' ')
                    r+=s.charAt(i);
                else
                {
                    c++;
                    r = "";
                }//end of else
            }//end of for
            return c;
    }//end of word_num
    int freq(String w, String s){
            String r=""; 
            int c=0;s+=" ";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=' ')
                    r+=s.charAt(i);
                else
                {
                    if(w.equals(r)==true)
                        c++;
                    r="";
                }//end of else
            }//end of for
            return c;
    }//end of freq()
    public static void main(String args[]){
    Word ob=new Word();
    ob.accept();
    }//end of main
}//end of class