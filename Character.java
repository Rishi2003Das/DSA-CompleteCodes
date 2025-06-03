import java.util.*;
class Character{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String: ");
        String s=sc.nextLine();
        int a=0;
        int d=0;
        int c=0;
        for(int i=0;i<s.length();i++){
            char z=s.charAt(i);
        if("QWERTYUIOPLKJHGFDSAZXCVBNMmnbvcxzasdfghjklpoiuytrewq".indexOf(z)>0)
        a++;
        else if("1234567890".indexOf(z)>0)
        d++;
        else
        c++;
    }
    System.out.println("No. of ALPHABETS: "+a);
    System.out.println("No. of DIGITS: "+d);
    System.out.println("No. of SPECIAL CHARACTERS: "+c);
}
}