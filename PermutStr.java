//Class explains the function of backtraking by an example of a program finding the permutation of the Strings
import java.util.*;
class PermutStr{
    public static void perMut(String str, String perm){
        if(str.length()==0){
        System.out.println(perm);
        return;
        }
        for(int i=0;i<str.length();i++){//Working of the Backtraking operation
            char ch=str.charAt(i);
            String newStr=(str.substring(0,i))+(str.substring(i+1));
            perMut(newStr,perm+ch);//Recursion
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String");
        String str=sc.nextLine();
        perMut(str,"");
    }
}