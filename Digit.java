import java.util.*;
class Digit{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int n=sc.nextInt();int c=0;
        while(n>0){
            int b=n%10;
            c++;
            n/=10;
        }
        System.out.println("The number of digits: "+c);
    }
}