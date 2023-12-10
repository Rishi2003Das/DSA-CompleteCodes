//Assignment 11
import java.util.*;
class DupSen{
   private String v="aeiouAEIOU";//Initialising instance variables
   void accept(){
        Scanner sc=new Scanner(System.in);
        String s="";
        do{
          System.out.println("Enter a sentence");
          s=(sc.nextLine()).trim();//Input from the user
        if(s.charAt(s.length()-1)!='.'&&s.charAt(s.length()-1)!='?'&&s.charAt(s.length()-1)!='!')
          System.out.println("Wrong input");//Error message
        }while(s.charAt(s.length()-1)!='.'&&s.charAt(s.length()-1)!='?'&&s.charAt(s.length()-1)!='!');
        StringTokenizer st=new StringTokenizer(s.substring(0,s.length()-1));
        String sen="";
        while(st.hasMoreTokens())
        {
            sen=sen+mod(st.nextToken())+" ";//Sentence modification
        }//end of while
        System.out.println("Modified Sentence is: ");
        System.out.println(sen.trim()+s.charAt(s.length()-1));//displaying the required sentence
    }//end of accept()
    String mod(String str){
        String wd=str.toLowerCase();//converting all the alphabet to lower case
        int fg=0;
        for(int i=0;i<wd.length();i++){
            if((wd.indexOf(wd.charAt(i))!=wd.lastIndexOf(wd.charAt(i)))&&(v.indexOf(wd.charAt(i))==-1)){
              wd=replace(wd,wd.charAt(i));//to replace with required modification
              fg=1;//counter 
            }//end of if
        }//end of for
        if(fg==1){
            if(str.charAt(0)>=65 && str.charAt(0)<=90)//checking the string by converting into unicode
            return ((char)((int)(wd.charAt(0))-32)+wd.substring(1));//explicit type casting            
            else
            return wd;
        }//end of if
        return rev(str);
   }//end of mod()
   public String replace(String w, char c){
        String f="";//to store the new string
        for(int i=0;i<w.length();i++){
           if(w.charAt(i)==c)
           f=f+nextVowel(c);
           else
           f=f+w.charAt(i);
        }//end of for
        return f;//returning the modified string
    }//end of replace()
   public String nextVowel(char ch){
        char ab[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a'};
        int i=0;
        for(;i<ab.length;i++){
            if(ab[i]==ch)
            break;//checking whether the string has any common element with that of array.
        }//end of for
        String vowel="";//to store the next vowel
        for(;i<ab.length;i++){
            if(v.indexOf(ab[i])!=-1){
              vowel= Character.toString(ab[i]);//converting the letter to string and storing it together in a single string
              break;
            }//end of if
        }//end of for
        return vowel;//returning the value of the vowel
    }//end of nextVowel()
   public String rev(String wd){
        if(wd.isEmpty())  
        return wd;      
        return rev(wd.substring(1))+wd.charAt(0);// returning the reverse word  
    }//end of rev()
   public static void main(String args[]){
        DupSen s=new DupSen();
        s.accept();//calling the method
    }//end of main
}//end of class
