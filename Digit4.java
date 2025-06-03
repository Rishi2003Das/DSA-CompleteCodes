import java.util.*;
class Digit4{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int n=sc.nextInt();int c=0;int b=0;
        while(n>0){
            b=n%10;
            if(b==4)
            c++;
            n/=10;
        }
        System.out.println(c);
    }
}