import java.util.*;
class Vowel{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the character: ");
        char c=sc.next().charAt(0);
        if("AEIOUaeiou".indexOf(c)>0)
        System.out.println("Vowel");
        else
        System.out.println("Not a vowel");
    }
}