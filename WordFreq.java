//Assignment 12
import java.util.*;
class WordFreq{
    void accept() {
        String s = "";//String variable
        System.out.println("Enter number of sentences:");
        int n = new Scanner(System.in).nextInt();
        if (n > 4 || n < 1){
            System.out.println("Limit Exceeds");
            System.exit(0);
        }//end of if
        System.out.println("Enter "+n+ " sentences in uppercase:");
        for (int i = 1; i <= n; i++) {
        s += new Scanner(System.in).nextLine() + " ";
        }//end of for loop
        s=s.trim();//triming the string value
        System.out.println("Total number of words:" + word_num(s));
        s += " ";
        String r = "";
        int c = 0, b = 0;
        String str[] = new String[word_num(s)];//taking string array
        int a[] = new int[word_num(s)];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                r += s.charAt(i);
            else {
                str[c++] = r;
                a[b++] = freq(r, s);
                r = "";
            }//end of else
        }//end of for
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];//swapping
                    String tmp1 = str[j];
                    a[j] = a[j + 1];
                    str[j] = str[j + 1];
                    a[j + 1] = tmp;
                    str[j + 1] = tmp1;
                }//end of if
            }//end of for loop
        }//end of for loop
        for (int i = 0; i < word_num(s); i++){
        for(int j=i+1;j<a.length;j++){
            if(str[j]!=null && str[i]!=null && str[i].equals(str[j]) )
                str[j]="";//
        }//end of for loop
        }//end of for loop
        System.out.println("WORD                FREQUENCY");
        for (int i = 0; i < word_num(s); i++)
        {
            if(str[i]!="" && a[i]>0)
            System.out.println(str[i] + "\t                 " + a[i]);
        }
    }
    int word_num(String s)
        {
            String r=""; int c=0; s+=" ";
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)!=' ')
                    r+=s.charAt(i);
                else
                {
                    c++;
                    r = "";

                }
            }
            return c;
        }
    int freq(String w, String s)
        {
            String r=""; int c=0;s+=" ";
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)!=' ')
                    r+=s.charAt(i);
                else
                {
                    if(w.equals(r)==true)
                        c++;
                    r="";
                }
            }
            return c;
        }
    public static void main(String args[])
        {
           new WordFreq().accept();
        }
    }