//Asignment 16
import java.util.*;
class StrFrequency{
  private String st;//instance variables
  int f[];
  char c[];
  public void accept(){
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the string value");
      st=sc.next();//User value entered
      st=st.toUpperCase();//Converted to upper class
      f=new int[st.length()];
      c=new char[st.length()];
      for(int i=0;i<st.length();i++){
       c[i]=st.charAt(i); 
      }//end of for loop
   }//end of accept()
  public void freq(){
       for(int i=0;i<st.length();i++){
           f[i]=1;// inital value in array f
           for(int j=i+1;j<st.length();j++){
               if(c[i]==c[j]){
                   f[i]++;
                   c[j]='*';
               }//end of if
            }//end of for loop
       }//end of for loop
       System.out.println("The word is:"+st);
       System.out.println("The letter with their corresponding frequency are");
       for(int i=0;i<f.length;i++){
           if(c[i]!='*')
           System.out.println("Frequency of "+c[i]+" : "+f[i]);//Displaying the frequency
       }//end of for loop
  }//end of freq()
  public static void main(String args[]){
      StrFrequency ob=new StrFrequency();
      ob.accept();
      ob.freq();
  }//end of main
}//end of class