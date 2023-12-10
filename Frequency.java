//Assignment 16
import java.util.*;
class Frequency{
    private String word;//stores the user's entered word
    private String nword;//stores the modified word
    public void input(){//takes input from the user
        System.out.print("Enter a String: ");
        word=new Scanner(System.in).next().toUpperCase();
        nword=word;
    }//end of input()
    public int count(char ch){//calculate the frequency of a character ch
        int c=0;//counter
        String n1word="";
        for(int i=0;i<nword.length();i++){
            if(ch==nword.charAt(i))
                c++;
            else 
                n1word= n1word + Character.toString(nword.charAt(i));
        }//end of for loop
        nword=n1word;
        return c;
    }//end of count()
    public void traverse(){//traverse through the modified word
        System.out.println("Word: "+word);
        while(nword.length()!=0)
             System.out.println("Frequency of "+(nword.charAt(0))+" : "+count(nword.charAt(0)));
    }//end of traverse()
    public static void main(String args[]){
        Frequency ob=new Frequency();
        ob.input();
        ob.traverse();
    }//end of main()
}//end of class